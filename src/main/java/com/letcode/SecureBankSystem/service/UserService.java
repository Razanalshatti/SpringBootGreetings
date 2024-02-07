package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;

public interface UserService {

    void saveUser(CreateUserRequest createUserRequest);

    void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserStatusRequest);

}
