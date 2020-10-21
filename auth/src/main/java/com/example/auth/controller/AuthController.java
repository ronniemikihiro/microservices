package com.example.auth.controller;

import com.example.auth.entity.UserSystem;
import com.example.auth.service.UserSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Endpoints to manage user system")
public class AuthController {

	private final UserSystemService userSystemService;

	@GetMapping(value = "/listAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "List all available user systems", response = UserSystem[].class)
	public ResponseEntity<Iterable<UserSystem>> list(Pageable pageable) {
		return new ResponseEntity<>(userSystemService.list(pageable), HttpStatus.OK);
	}
}
