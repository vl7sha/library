package ru.shabaev.zhezha.spring.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/home")
    public String librarianHome(){
        return "home";
    }
}
