package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.RoleEntity;
import com.letcode.SecureBankSystem.util.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query(value = "SELECT * FROM role r where r.title= : title",nativeQuery = true)
    RoleEntity findByTitle(Roles title);
}
