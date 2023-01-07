package com.example.springbootstoreprocedure.controller;

import com.example.springbootstoreprocedure.model.Post;
import com.example.springbootstoreprocedure.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String Index(Model model) {
        Iterable<Post> post = postService.getAll("GET");
        model.addAttribute("post",post);
        return "post/index";
    }
    @GetMapping("/create")
    public String Create(Model model) {
        Post post = new Post();
        model.addAttribute("post",post);
        return "post/create";
    }
    @PostMapping("/save")
    public String Save(@ModelAttribute("post") Post post) {

        Post obj = new Post();
        obj.Title = post.getTitle();
        obj.Body = post.getBody();
        postService.saveData(obj);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String Edit(@PathVariable Long id, Model model) {
        Post post = postService.getById("EDIT",id);
        model.addAttribute("post", post);
        return "post/edit";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute("post") Post post) {
        postService.updateData("UPDATE",post.getId(),post.getTitle(),post.getBody());
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable (value = "id") Long id) {
        postService.deleteById("DELETE",id);
        return "redirect:/";
    }
}
