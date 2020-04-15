package org.charlie.rapbattle.controllers;

import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.persistance.UserDao;
import org.charlie.rapbattle.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserServices userServices;
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET, value="/get")
    public String getUsers(Model model){
        model.addAttribute("users",userDao.findAll());
        return "get_users";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public String addUser(@ModelAttribute("user") User user) {
        userServices.addUser(user);

        return "redirect:/";
    }

    /**
     * Getters and Setters
     */

    public UserServices getUserServices() {
        return userServices;
    }

    @Autowired
    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
