package com.letcode.SecureBankSystem;

import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepository;
import com.letcode.SecureBankSystem.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecureBankSystemApplicationTests {


    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Test
    public void whenUserPasswordIsLargerThan8Digit_thenSuccess() {
        //arange
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("Thaer");
        userEntity1.setPassword("1234ee56878");

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setName("Abd");
        userEntity2.setPassword("856413279ert");

        UserEntity userEntity3 = new UserEntity();
        userEntity3.setName("sara");
        userEntity3.setPassword("123");

        List<UserEntity> moksUserEntities = Arrays.asList(userEntity1, userEntity2, userEntity3);
        Mockito.when(userRepository.findAll()).thenReturn(moksUserEntities);
        // mockito do a copy

        //Act
        List<String> usersWithStrongPassword = userService.getAllUsersWithStrongPassword();

        //Assert
        List<String> expectedUsersWithStrongPassword = Arrays.asList("Thaer","Abd");
        assertEquals(expectedUsersWithStrongPassword , usersWithStrongPassword);

    }

}
