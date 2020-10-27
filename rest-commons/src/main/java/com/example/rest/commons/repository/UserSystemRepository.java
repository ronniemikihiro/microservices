package com.example.rest.commons.repository;

import com.example.rest.commons.entity.UserSystem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRepository extends PagingAndSortingRepository<UserSystem, Long> {

    UserSystem findByEmail(String email);

}
