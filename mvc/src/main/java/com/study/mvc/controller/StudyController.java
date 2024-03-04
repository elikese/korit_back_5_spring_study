package com.study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudyController {

    @GetMapping("/hello")
    public ModelAndView helloPage(Model model) {
        model.addAttribute("name", "박화목");
        return new ModelAndView("hello");
    }

    @GetMapping("/test")
    public String testPage(Model model) {
        model.addAttribute("age",33);
        return "test";
    }
}