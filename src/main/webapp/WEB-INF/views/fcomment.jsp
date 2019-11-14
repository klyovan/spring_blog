<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="margin-top: 50px">
    <a class="btn btn-success" href="/formComment/${post.id}">+ Add comment</a>
</div>
<div class="panel panel-info">
    <div class="panel-body">
        <c:choose>
            <c:when test="${comments.size() >= 1}">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Comment</th>
                        <th>Time</th>
                        <th>Action</th>
                    </tr>


                    <c:forEach var="tempComment" items="${comments}">
                        <tr>
                            <td>${tempComment.author}</td>
                            <td style="max-width: 35%">${tempComment.text}</td>
                            <td>${tempComment.creationDate}</td>
                            <td>
                                <a class="btn btn-danger btn-sm" href="/formUpdateComment/${post.id}/${tempComment.id}">Update</a>
                                <a class="btn btn-info btn-sm" href="/comment/delete/${tempComment.id}"
                                   onclick="if (!(confirm('Are you sure you want to delete this comment?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table
            </c:when>
            <c:otherwise>

                <h5>No comments yet</h5>
            </c:otherwise>
        </c:choose>
    </div>
</div>