package com.letcode.SecureBankSystem.controller.userController;

import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.letcode.SecureBankSystem.service.suggestion.GuestSuggestionService;
import com.letcode.SecureBankSystem.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    private final GuestSuggestionService suggestionService;
    public UserController(UserService userService, GuestSuggestionService suggestionService) {
        this.userService = userService;
        this.suggestionService = suggestionService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.saveUser(createUserRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User Created Successfully!!");
    }
    @PutMapping("/update-user-status")
public ResponseEntity<String> UpdateUser(@RequestParam Long userId,@RequestBody UpdateUserStatusRequest updateUserStatusRequest){
        try{
            userService.updateUserStatus(userId,updateUserStatusRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    return ResponseEntity.ok("User Updated Successfully!!");

}

}
