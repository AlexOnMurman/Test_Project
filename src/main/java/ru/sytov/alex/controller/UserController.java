package ru.sytov.alex.controller;

import ru.sytov.alex.model.User;
import ru.sytov.alex.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by av.sitov on 10.03.2017.
 */
@Controller
public class UserController {
    private UserService userService;


    private  final int ROWS_ON_PAGE = 5;
    private  int count = 1;
    private  int currentPage = 1;
    private  String filteredName = "";


    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users/{currentPage}", method = RequestMethod.GET)
    public String listUsers(@PathVariable("currentPage") int page, Model model) {
        List<User> fullUserList = this.userService.listUsers();
        int offset = (page - 1) * ROWS_ON_PAGE;
        currentPage = page;
        List<User> pageUserList = this.userService.listUsersPages(offset, ROWS_ON_PAGE);
        count = this.userService.getUserPageCount(ROWS_ON_PAGE);
        model.addAttribute("user", new User());
        model.addAttribute("count", count);
        model.addAttribute("listUsers", pageUserList);
        model.addAttribute("filter", filteredName);

        return "users";

    }

    @RequestMapping(value = "users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getUserId() == 0) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        filteredName = "";

        return "redirect:/users/" + currentPage;
    }

    @RequestMapping("/remove/{userId}")
    public String removeUser(@PathVariable("userId") int userId) {
        this.userService.removeUser(userId);
        filteredName = "";
        count = this.userService.getUserPageCount(ROWS_ON_PAGE);
        if (count < currentPage) {
            currentPage = count;
        }

        return "redirect:/users/" + currentPage;
    }

    @RequestMapping("/edit/{userId}")
    public String editUser(@PathVariable("userId") int userId, Model model){
        model.addAttribute("user", this.userService.getUserById(userId));
        model.addAttribute("count", count);
        filteredName = "";
        model.addAttribute("listUsers", this.userService.listUsersPages((currentPage-1) * ROWS_ON_PAGE, ROWS_ON_PAGE ));

        return "users";
    }

    @RequestMapping(value ="/users/filter", method = RequestMethod.POST)
    public String filterUser(@ModelAttribute("userName") String filteredName, Model model){
        model.addAttribute("user", new User());
        model.addAttribute("filter", filteredName);
        this.filteredName = filteredName;
        if (!"".equals(filteredName)) {
            model.addAttribute("listUsers", this.userService.listFilterUsers(filteredName));
            return "users";
        } else {
            return "redirect:/users/" + currentPage;
        }
    }
}
