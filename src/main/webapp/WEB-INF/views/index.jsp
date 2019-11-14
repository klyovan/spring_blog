<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="panel panel-info">
    <div class="panel-body">
        <div style="margin-left: 800px">
            <a class="btn btn-primary" href="/formPost">Add new post</a>
        </div>
        <table class="table table-striped table-bordered">
            <tr>
                <th>Author</th>
                <th>Post</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempPost" items="${posts}">
                <tr>
                    <td>${tempPost.author}</td>
                    <td style="max-width: 35%" >
                        <div class="text-truncate d-block" style="width: 20rem">
                                ${tempPost.text}
                        </div>
                        <div>
                            <a class="btn btn-success btn-sm" href="/post/${tempPost.id}">View full post</a>
                        </div>

                    </td>
                    <td>
                        <a class="btn btn-danger btn-sm" href="/post/delete/${tempPost.id}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                        <a class="btn btn-warning btn-sm" href="/formUpdatePost/${tempPost.id}">Update</a>
                    </td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>