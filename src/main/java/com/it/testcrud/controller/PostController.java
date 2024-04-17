package com.it.testcrud.controller;

import com.it.testcrud.entity.Post;
import com.it.testcrud.repository.PostRepository;
import com.it.testcrud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {
  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostService postService;


  @GetMapping("/create")
  public String createPost(Model model) {
    model.addAttribute("post", new Post());
    return "create";
  }

  @PostMapping("/submit")
  public String submitForm(@ModelAttribute("post") Post post) {
    postRepository.save(post);
    return "redirect:/post/read/" + post.getId();
  }

  @GetMapping("/read/{postId}")
  public String readPost(@PathVariable Long postId, Model model) {
    Post post = postRepository.findById(postId).orElse(null);

    model.addAttribute("post", post);
    return "read";
  }

  @GetMapping("/update")
  public String updatePost(Model model) {
    return "update";
  }
}
