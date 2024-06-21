package com.sportfacility.exceptions.SecurityException;

import java.time.Instant;

public class ErrorResponse {
    private int status;
    private String error;
    private Instant timestamp;
    private String message;
    private String path;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int status;
        private String error;
        private Instant timestamp;
        private String message;
        private String path;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse response = new ErrorResponse();
            response.status = this.status;
            response.error = this.error;
            response.timestamp = this.timestamp;
            response.message = this.message;
            response.path = this.path;
            return response;
        }
    }
}
