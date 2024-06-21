package com.sportfacility.security;



import com.sportfacility.model.Client;
import com.sportfacility.model.TokenType;
import com.sportfacility.model.User;
import com.sportfacility.repositories.UserRepository;
import com.sportfacility.service.ClientService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final ClientService clientService;


    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, JwtService jwtService, UserRepository userRepository, AuthenticationManager authenticationManager, RefreshTokenService refreshTokenService, ClientService clientService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
        this.clientService = clientService;
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DataIntegrityViolationException("Email is already in use");
        }
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        user = userRepository.save(user);
        var jwt = jwtService.generateToken(user);



        var client = new Client();
        client.setCin(request.getCin());
        client.setAdresse(request.getAdresse());
        client.setTelephone(request.getTelephone());
        client.setNom(request.getFirstname());
        client.setPrenom(request.getLastname());
        client.setEmail(request.getEmail());
        if(request.getRole().getName().equals("ROLE_USER"))
            System.out.println(request.getRole().getName());
                clientService.saveClient(client);

        var refreshToken = refreshTokenService.createRefreshToken(user.getId());

        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();

        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .email(user.getEmail())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .roles(roles)
                .tokenType( TokenType.BEARER.name())
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email   or password."));
        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());
        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .roles(roles)
                .email(user.getEmail())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .tokenType( TokenType.BEARER.name())
                .build();
    }
}
