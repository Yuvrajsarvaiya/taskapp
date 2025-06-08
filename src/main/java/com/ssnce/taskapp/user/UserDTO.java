package com.ssnce.taskapp.user;

import java.time.LocalDate;


public class UserDTO {

    private String username;

    private String password;

    private String role;

    private LocalDate dob;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String role, LocalDate dob) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
