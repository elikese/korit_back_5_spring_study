package com.study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudyController {

    // MVC 패턴
    @GetMapping("/hello")
    public ModelAndView helloPage() {
        Map<String, Object> model = new HashMap<>();
        model.put("name1", "피카츄");
        model.put("name2", "라이츄");
        model.put("name3", "파이리");
        return new ModelAndView("hello", model);
    }

    // REST
    @GetMapping("/test")
    @ResponseBody // @RespnseBody가 붙으면, viewname을 리턴하는게 아니고, data만 리턴해줌 -> CSR 아님.
    public Map<String, Object> testPage(Model model) {
        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 33);
        testObj.put("피카츄1", 55);
        testObj.put("피카츄2", model);
        return testObj;
    }

}