package ru.senkot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.senkot.entities.User;
import java.util.List;

@Controller
@Scope("request")
public class ListController {

    @Autowired
    List<User> selectAllUser;

    @GetMapping("/list")
    public ModelAndView listGet() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("list");
        mav.addObject("users", selectAllUser);

        return mav;
    }

}
