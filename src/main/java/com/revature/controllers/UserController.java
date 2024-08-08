package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public Handler getAllUsers = ctx -> {
        List<User> users = userService.getAllUsers();
        ctx.json(users);
    };

    public Handler getUserById = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        User user = userService.getUserById(id);
        if (user != null) {
            ctx.json(user);
        } else {
            ctx.status(404);
        }
    };

    public Handler createUser = ctx -> {
        User user = ctx.bodyAsClass(User.class);
        userService.insertUser(user);
        ctx.status(201);
    };

    public Handler updateUser = ctx -> {
        User user = ctx.bodyAsClass(User.class);
        userService.updateUser(user);
        ctx.status(204);
    };

    public Handler deleteUser = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        userService.deleteUser(id);
        ctx.status(204);
    };
}
