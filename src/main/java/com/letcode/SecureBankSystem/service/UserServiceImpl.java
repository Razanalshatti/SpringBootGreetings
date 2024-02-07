package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.util.enums.Status;
import com.letcode.SecureBankSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.letcode.SecureBankSystem.util.enums.Status.INACTIVE;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; //dependency injection

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);

    }

    @Override
    public void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserStatusRequest) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow();
        if(!updateUserStatusRequest.getStatus().equals("ACTIVE") && !updateUserStatusRequest.getStatus().equals("INACTIVE")) {
            throw new IllegalArgumentException("The status should be ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserStatusRequest.getStatus()));
        userRepository.save(userEntity);
    }

}
