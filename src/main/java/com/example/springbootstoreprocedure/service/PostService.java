package com.example.springbootstoreprocedure.service;

import com.example.springbootstoreprocedure.model.Post;
import com.example.springbootstoreprocedure.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository repo;
    public List<Post> getAll(String cmd){
        return repo.getAll(cmd);
    }
    public Post getById(String cmd, Long id) {
         Post optional = repo.editPost(cmd,id);
        return optional;
    }
    public void saveData(Post post) {
        repo.savePost("INSERT", post.getTitle(), post.getBody());
    }
    public void updateData(String cmd,Long id, String title, String body) {
        this.repo.updatePost(cmd, id, title, body);
    }
    public void deleteById(String cmd,Long id) {
        this.repo.deletePost(cmd, id);
    }
}
