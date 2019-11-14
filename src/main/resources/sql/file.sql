
drop table posts;
drop table comments;

CREATE TABLE posts (post_id number(4) not null,
title varchar(30) not null,
text varchar(100) not null,
author varchar(30) not null);

CREATE TABLE comments (
   comment_id INT NOT NULL,
  creation_date DATE NOT NULL,
  author VARCHAR(30) NOT NULL,
  text VARCHAR(250) NOT NULL,
  post_id INT NOT NULL
);


ALTER TABLE posts
ADD CONSTRAINT post_pk PRIMARY KEY (post_id);

ALTER TABLE comments
ADD CONSTRAINT comments_pk PRIMARY KEY (comment_id);

drop sequence customer_seq ;
CREATE SEQUENCE post_seq START WITH 1;
CREATE SEQUENCE comment_seq START WITH 1;

commit;