package com.javarush.module3.mytestproject.model;

import com.javarush.module3.mytestproject.entity.Role;
import com.javarush.module3.mytestproject.entity.User;
import com.javarush.module3.mytestproject.repository.Repository;
import com.javarush.module3.mytestproject.repository.UserRepository;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@NoArgsConstructor
public class UserService implements Repository {
    private final UserRepository userRepository = new UserRepository();
    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public Boolean authorize(String login, String password) {
        for (User user : userRepository.getUsers()) {
            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
@Override
    public ArrayList<User> getUsers() {
        return userRepository.getUsers();
    }
@Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }
    @Override

    public User getUser(Long userId) {
        return userRepository.getUser(userId);
    }
    @Override

    public void updateUser(Long userId, String name, String login, String password, Role role) {
        userRepository.updateUser(userId, name, login, password, role);
    }
    @Override

    public Long getUserId(String login, String password) {
        return userRepository.getUserId(login, password);
    }
}
