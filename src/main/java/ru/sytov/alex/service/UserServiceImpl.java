package ru.sytov.alex.service;

import ru.sytov.alex.model.User;
import ru.sytov.alex.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * Created by av.sitov on 10.03.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private static final int PAGE_SIZE = 5;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User newUser) {
        this.userDao.addUser(newUser);
    }

    @Override
    @Transactional
    public void updateUser(User updatedUser) {
        this.userDao.updateUser(updatedUser);
    }

    @Override
    @Transactional
    public void removeUser(int removedUserId) {
        this.userDao.removeUser(removedUserId);
    }

    @Override
    @Transactional
    public User getUserById(int userId) {
        return this.userDao.getUserById(userId);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUser();
    }

    @Override
    @Transactional
    public List<User> listUsersPages(int begin, int num) {
        return this.userDao.listUserPage(begin, num);
    }

    @Override
    @Transactional
    public List<User> listFilterUsers(String matchedName) {
        return this.userDao.listFilterUser(matchedName);
    }

    @Override
    @Transactional
    public int getUserPageCount(int countOnPage) {
        int totalUserCount = this.userDao.listUser().size();
        if (totalUserCount < countOnPage) {
            return 1;
        } else {
            return totalUserCount / countOnPage + (totalUserCount % countOnPage == 0 ? 0 : 1);
        }
    }
}
