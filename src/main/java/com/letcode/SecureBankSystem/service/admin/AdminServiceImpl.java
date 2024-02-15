package com.letcode.SecureBankSystem.service.admin;

import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{
    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
