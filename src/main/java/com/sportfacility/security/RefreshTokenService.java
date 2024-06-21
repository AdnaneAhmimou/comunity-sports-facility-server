package com.sportfacility.security;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(Long userId);

    RefreshToken verifyExpiration(RefreshToken token);

    RefreshTokenResponse generateNewToken(RefreshTokenRequest request);
}
