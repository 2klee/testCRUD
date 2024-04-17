package com.it.testcrud.service;

import com.it.testcrud.entity.Post;
import com.it.testcrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
  @Autowired
  private PostRepository postRepository;

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Post createPost(Post post) {
    return postRepository.save(post);
  }

}
