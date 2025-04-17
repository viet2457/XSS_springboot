package com.example.xssdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DOMXSSController {

    @GetMapping("/dom-xss")
    public String domXssPage() {
        return "dom-xss";
    }
}
