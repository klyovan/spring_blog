package com.example.blog.controller;

import com.example.blog.configuration.WebMvcConfig;
import com.example.blog.model.Comment;
import com.example.blog.model.Post;
import com.example.blog.service.CommentService;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    WebMvcConfig webMvcConfig = new WebMvcConfig();


    @RequestMapping(value = "/formPost", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
        Post post = new Post();
        String textCreate = "Create";
        model.addAttribute("title", textCreate);
        model.addAttribute("post", post);
        return "postform";
    }

    @RequestMapping(value = "/formUpdatePost/{id}", method = RequestMethod.GET)
    public String showFormForUpdate(@PathVariable Integer id, Model model) {
        Post post = postService.getPost(id);
        String textUpdate = "Update";
        model.addAttribute("title", textUpdate);
        model.addAttribute("post", post);
        return "postform";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);

        return "redirect:/";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable Integer id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        ArrayList<Comment> comments = commentService.getAllCommentsForPost(id);
        Collections.sort(comments);
        model.addAttribute("comments", comments);
        return "fpost";
    }

    @RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllPosts(Model theModel) {
        List<Post> posts = postService.getAllPosts();
        theModel.addAttribute("posts", posts);
        return "index";
    }


}





