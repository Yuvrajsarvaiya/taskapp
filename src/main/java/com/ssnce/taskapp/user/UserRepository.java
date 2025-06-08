package com.ssnce.taskapp.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class UserRepository {
    private List<User> usersDb = new ArrayList<>();

    public User save(User user) {
        usersDb.add(user);
        return user;
    }

    public Optional<User> findByUserName(String username) {
        Stream<User> foundUser = usersDb.stream().filter((user -> Objects.equals(user.getUsername(), username)));
        return foundUser.findFirst();
    }

    public List<User> getAll() {
        return usersDb;
    }
}
