package ru.sytov.alex.dao;

import ru.sytov.alex.model.User;

import java.util.List;

/**
 * Created by av.sitov on 10.03.2017.
 */
public interface UserDao {

    public void addUser(User newUser);

    public void updateUser(User updatedUser);

    public void removeUser(int removedUserId);

    public User getUserById(int userId);

    public List<User> listUser();

    public List<User> listFilterUser(String matchesName);

    public List<User> listUserPage(int begin, int num);
}
