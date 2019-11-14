package com.example.blog.model;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment implements Comparable<Comment> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMM_SEQ")
    @SequenceGenerator(sequenceName = "comment_seq", allocationSize = 1, name = "COMM_SEQ")
    @Column(name = "comment_id")
    private Integer id;
    @Column(name = "creation_date")
    private Date creation_date;
    @Column(name = "author")
    private String author;
    @Column(name = "text")
    private String text;
    @Column(name = "post_id")
    private Integer postId;

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creation_date;
    }

    public void setCreationDate(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "{" +
                " id=" + id +
                "; creationDate=" + creation_date +
                "; author=" + author +
                "; text=" + text +
                "; }";
    }

    @Override
    public int compareTo(Comment comment2) {
        if (getCreationDate() == null || comment2.getCreationDate() == null)
            return -1;
        if (getCreationDate().before(comment2.getCreationDate()))
            return 1;
        if (getCreationDate().after(comment2.getCreationDate()))
            return -1;
        return 0;
    }
}

