package com.example.communitysportsfacility.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "adminLogin"; // Make sure you have a login.html in your templates directory
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "adminDashboard"; // Make sure you have a dashboard.html in your templates directory
    }
}
