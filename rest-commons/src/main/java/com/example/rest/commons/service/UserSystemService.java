package com.example.rest.commons.service;

import com.example.rest.commons.repository.UserSystemRepository;
import com.example.rest.commons.entity.UserSystem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserSystemService {

	private final UserSystemRepository userSystemRepository;
	
	public UserSystem findByEmail(String email) {
		return userSystemRepository.findByEmail(email);
	}

	public Page<UserSystem> findAll(Pageable pageable) {
		return userSystemRepository.findAll(pageable);
	}

	public UserSystem findById(Long id) {
		Optional<UserSystem> user = userSystemRepository.findById(id);
		return user.orElseThrow(() -> new RuntimeException("User System not found!"));
	}

	public UserSystem save(UserSystem userSystem) {
		return userSystemRepository.save(userSystem);
	}

	public void delete(Long id) {
		final Optional<UserSystem> userSystem = userSystemRepository.findById(id);
		userSystem.map(u -> {
			userSystemRepository.delete(u);
			return Void.TYPE;
		}).orElseThrow(() -> new RuntimeException("User System not found!"));
	}

}
