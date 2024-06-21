package com.sportfacility.security;

public class AuthenticationRequest {
    private String email;
    private String password;


    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String password;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public AuthenticationRequest build() {
            AuthenticationRequest request = new AuthenticationRequest();
            request.email = this.email;
            request.password = this.password;
            return request;
        }
    }
}
