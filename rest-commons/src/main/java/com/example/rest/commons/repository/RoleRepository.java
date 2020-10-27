package com.example.rest.commons.repository;

import com.example.rest.commons.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Role findByDescription(String description);
}
