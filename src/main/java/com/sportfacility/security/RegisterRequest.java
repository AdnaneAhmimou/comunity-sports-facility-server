package com.sportfacility.security;

import com.sportfacility.annotation.StrongPassword;
import com.sportfacility.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequest {

    @NotBlank(message = "firstname is required")
    private String firstname;
    @NotBlank(message = "lastname is required")
    private String lastname;
    @NotBlank(message = "email is required")
    @Email(message = "email format is not valid")
    private String email;
    @NotBlank(message = "password is required")
    @StrongPassword
    private String password;
    @NotNull
    private Role role;


    private String adresse;


    private String cin;

    private String telephone;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public @NotBlank(message = "firstname is required") String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotBlank(message = "firstname is required") String firstname) {
        this.firstname = firstname;
    }

    public @NotBlank(message = "email is required") @Email(message = "email format is not valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email is required") @Email(message = "email format is not valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "lastname is required") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank(message = "lastname is required") String lastname) {
        this.lastname = lastname;
    }

    public @NotBlank(message = "password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "password is required") String password) {
        this.password = password;
    }

    public @NotNull Role getRole() {
        return role;
    }

    public void setRole(@NotNull Role role) {
        this.role = role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Role role;
        private String adresse;
        private String cin;
        private String telephone;

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder adresse(String adresse) {
            this.adresse = adresse;
            return this;
        }

        public Builder cin(String cin) {
            this.cin = cin;
            return this;
        }

        public Builder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public RegisterRequest build() {
            RegisterRequest request = new RegisterRequest();
            request.firstname = this.firstname;
            request.lastname = this.lastname;
            request.email = this.email;
            request.password = this.password;
            request.role = this.role;
            request.adresse = this.adresse;
            request.cin = this.cin;
            request.telephone = this.telephone;
            return request;
        }
    }
}
