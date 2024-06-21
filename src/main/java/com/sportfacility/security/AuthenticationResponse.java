package com.sportfacility.security;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AuthenticationResponse {
    private Long id;
    private String email;
    private List<String> roles;
    private String accessToken;
    private String refreshToken;
    private String tokenType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String email;
        private List<String> roles;
        private String accessToken;
        private String refreshToken;
        private String tokenType;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder roles(List<String> roles) {
            this.roles = roles;
            return this;
        }

        @JsonProperty("access_token")
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        @JsonProperty("refresh_token")
        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        @JsonProperty("token_type")
        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public AuthenticationResponse build() {
            AuthenticationResponse response = new AuthenticationResponse();
            response.id = this.id;
            response.email = this.email;
            response.roles = this.roles;
            response.accessToken = this.accessToken;
            response.refreshToken = this.refreshToken;
            response.tokenType = this.tokenType;
            return response;
        }
    }
}
