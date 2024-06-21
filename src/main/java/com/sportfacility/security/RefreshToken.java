package com.sportfacility.security;

import com.sportfacility.model.User;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

    public boolean revoked;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private User user;
        private String token;
        private Instant expiryDate;
        private boolean revoked;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder expiryDate(Instant expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder revoked(boolean revoked) {
            this.revoked = revoked;
            return this;
        }

        public RefreshToken build() {
            RefreshToken refreshToken = new RefreshToken();
            refreshToken.id = this.id;
            refreshToken.user = this.user;
            refreshToken.token = this.token;
            refreshToken.expiryDate = this.expiryDate;
            refreshToken.revoked = this.revoked;
            return refreshToken;
        }
    }
}
