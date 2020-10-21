package com.example.auth.repository;

import com.example.auth.entity.UserSystem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends PagingAndSortingRepository<UserSystem, Long> {

    UserSystem findByEmail(String email);

}
