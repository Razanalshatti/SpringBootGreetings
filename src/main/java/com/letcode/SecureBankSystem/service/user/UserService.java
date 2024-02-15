package com.letcode.SecureBankSystem.service.user;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;

import java.util.List;

public interface UserService {

    void saveUser(CreateUserRequest createUserRequest);

    void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserStatusRequest);


    List<String> getAllUsersWithStrongPassword();

    List<String> getALlUsersWithStrongPassword();
}
