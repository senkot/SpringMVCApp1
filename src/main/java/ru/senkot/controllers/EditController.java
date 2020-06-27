package ru.senkot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.senkot.entities.User;
import ru.senkot.model.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class EditController {
    User user = null;

    @GetMapping("/edit")
    public ModelAndView getEditUser(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            user = UserDAO.getInstance().selectUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mav.addObject("user", user);

        return mav;
    }

    @PostMapping("/edit")
    public String postEditUser(HttpServletRequest request, RedirectAttributes ra) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User upUser = new User(id, name, email, country);

        try {
            UserDAO.getInstance().updateUser(upUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/list";
    }
}
