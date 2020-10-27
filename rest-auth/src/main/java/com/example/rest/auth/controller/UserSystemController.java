package com.example.rest.auth.controller;

import com.example.rest.commons.entity.UserSystem;
import com.example.rest.commons.service.UserSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/user-system")
@Api(value = "Endpoints to manage user system")
public class UserSystemController {

	private final UserSystemService userSystemService;

	@GetMapping
	@ApiOperation(value = "List all available user systems with pages")
	public Page<UserSystem> list(
			@RequestParam(value = "page", defaultValue = "0")  Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		final Sort sort = Sort.by(Sort.Direction.ASC, "name");
		final PageRequest pageRequest = PageRequest.of(page, size, sort);
		return userSystemService.findAll(pageRequest);
	}

	@GetMapping("{id}")
	@ApiOperation("Find user system for your id")
	public ResponseEntity<UserSystem> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userSystemService.findById(id));
	}

	@PostMapping
	@ApiOperation(value = "Create new user system")
	public ResponseEntity<UserSystem> create(@RequestBody UserSystem userSystem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userSystemService.save(userSystem));
	}

	@PutMapping
	@ApiOperation("Update user system")
	public ResponseEntity<UserSystem> update(@RequestBody UserSystem userSystem) {
		return ResponseEntity.ok().body(userSystemService.save(userSystem));
	}

	@DeleteMapping("{id}")
	@ApiOperation("Delete user system")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userSystemService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
