package ru.senkot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.senkot.entities.User;
import ru.senkot.model.UserDAO;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddController {

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String postAdd(HttpServletRequest request, RedirectAttributes ra) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);

        UserDAO.getInstance().insertUser(user);

        return "redirect:/list";
    }
}
