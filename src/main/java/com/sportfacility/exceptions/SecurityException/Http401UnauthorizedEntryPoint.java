package com.sportfacility.exceptions.SecurityException;//package com.example.invoice.Exceptions.SecurityException;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.time.Instant;
//
//
//@Component @Slf4j
//public class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
//            throws IOException, ServletException {
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//        ErrorResponse body = ErrorResponse.builder()
//                .status(HttpServletResponse.SC_UNAUTHORIZED)
//                .error("Unauthorized")
//                .timestamp(Instant.now())
//                .message(authException.getMessage())
//                .path(request.getServletPath())
//                .build();
//        final ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
//        mapper.writeValue(response.getOutputStream(), body);
//    }
//}
