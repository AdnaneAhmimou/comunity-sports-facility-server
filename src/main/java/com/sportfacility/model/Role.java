package com.sportfacility.model;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.sportfacility.model.Privilege.*;

@Getter
public enum Role {
    ADMIN(
            Set.of(READ_PRIVILEGE,WRITE_PRIVILEGE,UPDATE_PRIVILEGE,DELETE_PRIVILEGE)
    ),
    USER(
            Set.of(READ_PRIVILEGE)
    );

    private final Set<Privilege> privileges;

    Role(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getName() {
        return name();
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public List<SimpleGrantedAuthority> getAuthorities(){
        List<SimpleGrantedAuthority> authorities = getPrivileges()
                .stream()
                .map(privilege -> new SimpleGrantedAuthority(privilege.name()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}