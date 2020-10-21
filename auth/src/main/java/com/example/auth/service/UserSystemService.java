package com.example.auth.service;

import com.example.auth.entity.UserSystem;
import com.example.auth.repository.UserSystemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserSystemService implements UserDetailsService {

	private final UserSystemRepository userSystemRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return findByEmail(email);
	}

	public UserSystem findByEmail(String email) throws UsernameNotFoundException {
		final UserSystem usuario = userSystemRepository.findByEmail(email);
		if(usuario == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return usuario;
	}

	public Iterable<UserSystem> list(Pageable pageable) {
		return userSystemRepository.findAll(pageable);
	}

}
