package ru.senkot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.senkot.entities.User;
import ru.senkot.service.UserService;

import java.sql.SQLException;

@Controller
public class MainController {

    UserService userService = new UserService();

    @GetMapping("/list")
    public ModelAndView listGet() throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("users", userService.selectAllUser());

        return mav;
    }

    @GetMapping("/edit")
    public ModelAndView getEditUser(@ModelAttribute("id") int id) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");
        User user = userService.selectUser(id);
        mav.addObject("user", user);

        return mav;
    }

    @PostMapping("/edit")
    public ModelAndView postEditUser(@ModelAttribute("user") User user) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/list");
        userService.updateUser(user);

        return mav;
    }

    @GetMapping("/delete")
    public ModelAndView deleteUser(@ModelAttribute("id") int id) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/list");
        userService.deleteUser(id);

        return mav;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add");

        return mav;
    }

    @PostMapping("/add")
    public ModelAndView postAdd(@ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/list");
        userService.insertUser(user);

        return mav;
    }

}
