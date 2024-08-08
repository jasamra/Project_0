package com.revature.DAOs;

import com.revature.models.User;
import java.util.List;

public interface UserDAOInterface {
    List<User> getAllUsers();
    User getUserById(int id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}