package com.it.testcrud.controller;

import com.it.testcrud.entity.Post;
import com.it.testcrud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
  @Autowired
  private PostService postService;

  @GetMapping("/")
  public String index(Model model) {
    List<Post> posts = postService.getAllPosts();

    model.addAttribute("posts", posts);
    return "index";
  }

}
