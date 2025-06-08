package com.ssnce.taskapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<User> register(@RequestBody UserDTO userDTO) {
        User user = userService.register(new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getDob())
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
