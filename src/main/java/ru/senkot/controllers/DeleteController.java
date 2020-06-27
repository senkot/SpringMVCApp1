package ru.senkot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.senkot.model.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class DeleteController {

    @GetMapping("/delete")
    public String deleteUser(HttpServletRequest request, RedirectAttributes ra) {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            UserDAO.getInstance().deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/list";
    }

}
