package com.ssnce.taskapp.user.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    @Min(value = 6, message = "must be at least 6 characters long")
    @Max(value = 20, message = "must not be more than 20 characters long")
    private String username;

    @Size(min = 6, max = 15, message = "Must be between 6 characters to 15 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters and include an uppercase letter, a lowercase letter, a digit, and a special character"
    )
    private String password;

    @NotBlank(message = "role must not be empty")
    @Pattern(regexp = "^(USER|ADMIN)$", message = "Role must be either USER or ADMIN")
    private String role;

    private LocalDate dob;
}

