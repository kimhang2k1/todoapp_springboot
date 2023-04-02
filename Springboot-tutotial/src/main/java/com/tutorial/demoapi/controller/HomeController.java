package com.tutorial.demoapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
     @GetMapping("/")
    public String getName(Model model) {
          model.addAttribute("name", "world 2");
          return "home";
     }

}
