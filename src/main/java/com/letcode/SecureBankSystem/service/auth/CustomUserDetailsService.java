package com.letcode.SecureBankSystem.service.auth;

import com.letcode.SecureBankSystem.bo.customUserDetails.CustomUserDetails;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return buildCustomUserDetailsOfUsername(s);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private CustomUserDetails buildCustomUserDetailsOfUsername(String username) throws NotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow();
        if (user == null){
            throw new NotFoundException("User not found");
        }
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setId((user.getId()));
        userDetails.setUserName(user.getUsername());
        userDetails.setPassword(user.getPassword());
        userDetails.setRole(user.getRole().getTitle().name());

        return userDetails;
    }
}
