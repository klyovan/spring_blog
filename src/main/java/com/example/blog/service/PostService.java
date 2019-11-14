package com.example.blog.service;


import com.example.blog.model.Post;
import com.example.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {


    @Autowired
    private PostRepository postRepository;

    public void savePost(Post post) {
        final Integer postId = post.getId();
        post.setId(postId);

        postRepository.save(post);
    }

    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }

    public Post getPost(Integer postId) {
        return postRepository.findOneById(postId);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
