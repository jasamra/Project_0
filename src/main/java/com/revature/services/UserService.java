package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.DAOs.UserDAOInterface;
import com.revature.models.User;

import java.util.List;

public class UserService {
    private UserDAOInterface userDAO = new UserDAO();

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
