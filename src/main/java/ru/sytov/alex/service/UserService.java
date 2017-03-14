package ru.sytov.alex.service;

import ru.sytov.alex.model.User;

import java.util.List;

/**
 * Created by av.sitov on 10.03.2017.
 */
public interface UserService {
    public void addUser(User newUser);

    public void updateUser(User updatedUser);

    public void removeUser(int removedUserId);

    public User getUserById(int userId);

    public List<User> listUsers();

    public List<User> listUsersPages(int begin, int num);

    public int getUserPageCount(int countOnPage);

    public List<User> listFilterUsers(String matchedName);
}
