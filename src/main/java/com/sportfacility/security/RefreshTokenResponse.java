package com.sportfacility.security;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sportfacility.model.TokenType;

public class RefreshTokenResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("token_type")
    private String tokenType = TokenType.BEARER.name();

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String accessToken;
        private String refreshToken;
        private String tokenType = TokenType.BEARER.name();

        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public RefreshTokenResponse build() {
            RefreshTokenResponse response = new RefreshTokenResponse();
            response.accessToken = this.accessToken;
            response.refreshToken = this.refreshToken;
            response.tokenType = this.tokenType;
            return response;
        }
    }
}
