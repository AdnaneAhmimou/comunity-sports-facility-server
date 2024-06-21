package com.sportfacility.exceptions.SecurityException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class Http403ForbiddenEntryPoint implements AuthenticationEntryPoint {

    private static final Log logger = LogFactory.getLog(Http403ForbiddenEntryPoint.class);

    /**
     * Always returns a 403 error code to the client.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
            throws IOException {
        logger.debug("Pre-authenticated entry point called. Rejecting access");
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    }

}
