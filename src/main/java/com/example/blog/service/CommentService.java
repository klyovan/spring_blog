package com.example.blog.service;


import com.example.blog.model.Comment;
import com.example.blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class CommentService {
    private static final String DEFAULT_CREATOR_NAME = "Anonymous";

    @Autowired
    private CommentRepository commentRepository;

    public void saveCommentToPost(Comment comment) {
        final Integer commentId = comment.getId();
        comment.setId(commentId);
        comment.setCreationDate(new Date());
        if (comment.getAuthor().trim().equals(""))
            comment.setAuthor(DEFAULT_CREATOR_NAME);
        commentRepository.save(comment);
    }

    public void deleteAllCommentsFromPost(Integer postId) {
        commentRepository.deleteByPostId(postId);
    }

    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

    public ArrayList<Comment> getAllCommentsForPost(Integer postId) {
        return commentRepository.findAllByPostId(postId);
    }

    public Comment getComment(Integer commentId) {
        return commentRepository.findOneById(commentId);
    }
}
