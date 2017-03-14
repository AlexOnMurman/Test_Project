package ru.sytov.alex.dao;

import ru.sytov.alex.model.User;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by av.sitov on 10.03.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public void addUser(User newUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(newUser);
        logger.info("User successfully saved. User details: " + newUser);

    }

    @Override
    public void updateUser(User updatedUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(updatedUser);
        logger.info("User successfully updated. User details: " + updatedUser);
    }

    @Override
    public void removeUser(int removedUserId) {
        Session session = this.sessionFactory.getCurrentSession();
        User removedUser = (User) session.load(User.class, new Integer(removedUserId));

        if (removedUser != null){
            session.delete(removedUser);
        }
        logger.info("User successfully removed. User details: " + removedUser);
    }

    @Override
    public User getUserById(int userId) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(userId));
        logger.info("User successfully loaded. User details: " + user);


        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> listUsers = session.createQuery("from User").list();

        logger.info("Getting full user list");
        for(User user: listUsers){
            logger.info("User list: " + user);
        }

        return listUsers;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUserPage(int begin, int num) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> listUsers = session.createQuery("from User").setFirstResult(begin).setMaxResults(num).list();

        logger.info("Getting page limit " + begin + ", " + num);
        for(User user: listUsers){
            logger.info("Page user list: " + user);
        }
        return listUsers;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listFilterUser(String matchesName) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> listUsers = session.createQuery("from User where name like :matchesName ").setParameter("matchesName", "%" + matchesName + "%").list();

        logger.info("Getting filtered user list like %" + matchesName + "%");
        for(User user: listUsers){
            logger.info("Filter user list: " + user);
        }
        return listUsers;
    }

}
