package com.example.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Admin;
import com.example.repository.AdminRepository;

@Service
public class AdminService {

	private final AdminRepository adminRepository;

	// Inject the dependencies using constructor
	// -------------------------------------------------------------------
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	// Implementation of the function to login for the admin
	// -------------------------------------------------------------------

	public ResponseEntity<String> loginAdminService(Admin loginRequest) {
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();
		Optional<Admin> customerSupport = adminRepository.findByUsernameAndPassword(username, password);
		if (customerSupport.isPresent()) {
			return ResponseEntity.ok("Admin logged in successfully!");
		} else {
			return ResponseEntity.badRequest().body("Invalid username or password");
		}
	}

}
