package ru.senkot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.senkot.entities.User;
import ru.senkot.model.UserDAO;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ListController {

    List<User> users = null;

    @GetMapping("/list")
    public ModelAndView modelAndView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        try {
            users = UserDAO.getInstance().selectAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mav.addObject("users", users);

        return mav;
    }

}
