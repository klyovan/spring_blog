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
        <h1>${title} your post</h1>
    </div>

    <form:form action="/post" class="form" method="POST" modelAttribute="post">
        <form:hidden path="id"/>

        <div class="form-group">
            <label for="title">Title</label>
            <form:input required="required" path="title" class="form-control" placeholder="Enter title"/>
        </div>
        <div class="form-group">
            <label for="text">Post</label>
            <form:textarea path="text" class="form-control" placeholder="Enter text" rows="8"/>
        </div>
        <div class="form-group">
            <label for="author">Author</label>
            <form:input required="required" path="author" class="form-control" placeholder="Enter author`s name"/>
        </div>
        <div>
            <form:button class="btn btn-success">${title}</form:button>
        </div>
    </form:form>
</div>
</body>
</html>
