<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <a style="margin-left: 2px;" class="btn btn-info" href="/"> &lt; Go back</a>
</div>
<div class="container">
    <div class=" text-justify">

        <h3 class="font-weight-bold">Title: ${post.title}</h3>
        <div>
            <p>
                ${post.text}
            </p>
        </div>
    </div>
    <div>
        <footer class="blockquote-footer">Created by: ${post.author}</footer>

        <jsp:include page="fcomment.jsp"/>

    </div>


</div>
</body>
</html>
