package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.util.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByStatus(Status status);

    Optional<UserEntity>  findByUsername(String username);
}
