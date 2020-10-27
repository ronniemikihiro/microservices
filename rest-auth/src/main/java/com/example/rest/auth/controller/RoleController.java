package com.example.rest.auth.controller;

import com.example.rest.commons.entity.Role;
import com.example.rest.commons.repository.RoleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/role")
@Api(value = "Endpoints to manage role")
public class RoleController {

	private final RoleRepository roleRepository;

	@GetMapping
	@ApiOperation(value = "List all available roles")
	public ResponseEntity<Iterable<Role>> list() {
		return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
	}

}
