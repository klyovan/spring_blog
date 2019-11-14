<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Post from</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="justify-content-md-center">
        <h1>${title} your comment</h1>
    </div>

    <form:form action="/comment" class="form" method="POST" modelAttribute="comment">
        <form:hidden path="id"/>
        <form:hidden path="postId"/>
    <div class="form-group">
        <label for="author">Name</label>
        <form:input required="required" path="author" class="form-control" placeholder="Enter creator name"
                    value="${comment.author}"/>
        <div class="form-group">
            <label for="text">Comment</label>
            <form:textarea required="required" path="text" class="form-control" placeholder="Comment's text" rows="8"
                           value="${comment.text}"/>
        </div>
        <div>
            <form:button class="btn btn-primary">${title}</form:button>
        </div>
        </form:form>
    </div>
</body>
</html>