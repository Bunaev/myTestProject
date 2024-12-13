package com.javarush.module3.mytestproject.repository;

import com.javarush.module3.mytestproject.entity.Role;
import com.javarush.module3.mytestproject.entity.User;

import java.util.ArrayList;

public interface Repository {
    ArrayList<User> getUsers();

    void addUser(User user);

    User getUser(Long userId);

    void updateUser(Long userId, String name, String login, String password, Role role);

    Long getUserId(String login, String password);
}
