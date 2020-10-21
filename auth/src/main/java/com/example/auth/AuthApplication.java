package com.example.auth;

import com.example.auth.entity.Role;
import com.example.auth.entity.UserSystem;
import com.example.auth.repository.RoleRepository;
import com.example.auth.repository.UserSystemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserSystemRepository userSystemRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(userSystemRepository, roleRepository, passwordEncoder);
		};
	}

	private void initUsers(UserSystemRepository userSystemRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
		
		Role role = roleRepository.findByDescription("Admin");

		if (role == null) {
			role = Role.builder()
					.description("Admin")
					.build();

			role = roleRepository.save(role);
		}

		UserSystem userSystem = userSystemRepository.findByEmail("ronnie.lopes@esales.com.br");

		if(userSystem == null) {
			userSystem = UserSystem.builder()
					.name("ronnie")
					.email("ronnie.lopes@esales.com.br")
					.password(passwordEncoder.encode("@123"))
					.roles(Arrays.asList(role))
					.build();

			userSystemRepository.save(userSystem);
		}
	}

}
