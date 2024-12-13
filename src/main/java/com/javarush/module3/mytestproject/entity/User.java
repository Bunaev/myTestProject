package com.javarush.module3.mytestproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

public class User {
    @Getter
    private Long id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String login;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private Role role;
    private static final AtomicLong counter = new AtomicLong(0);

    public User (String name, String login, String password) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.login = login;
        this.password = password;
    }
}

