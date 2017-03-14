package ru.sytov.alex.model;

import org.hibernate.annotations.Filter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by av.sitov on 10.03.2017.
 */
@Entity
@Table(name = "User")
public class User {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userId;

        @Column(name = "name")
        private String userName;

        @Column(name = "age")
        private int userAge;

        @Column(name = "isAdmin")
        private boolean isUserAdmin;

        @Column(name = "createdDate")
        private Date userCreatedDate;

    public boolean isUserAdmin() {
        return isUserAdmin;
    }

    public void setUserAdmin(boolean userAdmin) {
        isUserAdmin = userAdmin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean getIsUserAdmin() {
        return isUserAdmin;
    }

    public void setIsUserAdmin(boolean userAdmin) {
        isUserAdmin = userAdmin;
    }

    public Date getUserCreatedDate() {
        return userCreatedDate;
    }

    public void setUserCreatedDate(Date userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", isUserAdmin=" + isUserAdmin +
                ", userCreatedDate=" + userCreatedDate +
                '}';
    }
}
