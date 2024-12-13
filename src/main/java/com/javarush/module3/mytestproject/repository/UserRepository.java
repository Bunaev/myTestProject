package com.javarush.module3.mytestproject.repository;

import com.javarush.module3.mytestproject.entity.Role;
import com.javarush.module3.mytestproject.entity.User;
import lombok.Getter;

import java.util.ArrayList;

public class UserRepository implements Repository {
    @Getter
    private static final ArrayList<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("Администратор", "admin", "admin"));
        users.get(0).setRole(Role.ADMIN);
    }
    @Override
    public void addUser(User user) {
        users.add(user);
    }
    @Override
    public User getUser(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
    @Override
    public void updateUser(Long id, String name, String login, String password, Role role) {
        for (User user : users) {
            if (user.getId().equals(id)){
                user.setName(name);
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(role);
            }
        }
    }
    @Override
    public Long getUserId(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        return null;
    }
}
