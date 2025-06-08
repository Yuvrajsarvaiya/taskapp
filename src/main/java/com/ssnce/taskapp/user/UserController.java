package com.ssnce.taskapp.user;

import com.ssnce.taskapp.user.dto.RegisterUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// POST /api/user/register
// POST /api/user/login
// GET /api/user/me

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public  UserController(UserService userService) {
        this.userService = userService;
    }

//   GET /api/user
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }


    // POST /api/user/register
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterUserDto registerDto) {
        User newUser = User.builder().
                username(registerDto.getUsername())
                .password(registerDto.getPassword())
                    .dob(registerDto.getDob())
                .role(registerDto.getRole())
                .build();
        User user = userService.register(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
