package com.example.blog.repositories;

import com.example.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findOneById(Integer commentId);

    ArrayList<Comment> findAllByPostId(Integer postId);

    void deleteByPostId(Integer postId);
}
