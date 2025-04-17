package com.example.xssdemo.controllers;

import com.example.xssdemo.model.Comment;
import com.example.xssdemo.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public String showComments(Model model) {
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @PostMapping
    public String addComment(@RequestParam("content") String content) {
        commentRepository.save(new Comment(null, content)); // Không escape dữ liệu => Stored XSS
        return "redirect:/comments";
    }
}
