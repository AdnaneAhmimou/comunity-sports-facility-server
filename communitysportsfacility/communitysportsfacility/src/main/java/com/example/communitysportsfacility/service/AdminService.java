//package com.example.communitysportsfacility.service;
//
//import com.example.communitysportsfacility.entity.Admin;
//import com.example.communitysportsfacility.repository.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminService implements UserDetailsService {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin admin = adminRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));
//        UserBuilder builder = User.withUsername(username);
//        builder.password(admin.getPassword());
//        builder.roles("ADMIN");
//        return builder.build();
//    }
//}
package com.example.communitysportsfacility.service;

import com.example.communitysportsfacility.entity.Admin;
import com.example.communitysportsfacility.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // Create a new admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Retrieve all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Retrieve an admin by ID
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    // Update an admin

    // Delete an admin
    public void deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        adminRepository.delete(admin);
    }
}
