package com.example.xssdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReflectedXSSController {

    @GetMapping("/search")
    public String search(@RequestParam(name = "q", required = false, defaultValue = "") String query, Model model) {
        model.addAttribute("query", query); // Hiển thị trực tiếp => Reflected XSS
        return "search";
    }
}
