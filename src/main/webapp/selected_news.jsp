<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="input" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>TrulyNews</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="static/css/page-style.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav">
            <a title="TrulyNews" href='<c:url value="/newsAction.do?method=openMainPage"/>'>
                <img height="130px" src="static/pics/truly.png">
            </a>
            <hr>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#section1">Home</a></li>
                <li><a href="#section2">Friends</a></li>
                <li><a href="#section3">Family</a></li>
                <li><a href="#section3">Photos</a></li>
            </ul>
            <br>
        </div>

        <div class="col-sm-9">
            <html:form action="/newsAction?method=openEditNewsPage">
                <h4>
                    <small>RECENT POSTS</small>
                </h4>
                <hr>
                <h2>${newsForm.title}</h2>
                <h5><span class="glyphicon glyphicon-time"></span> ${newsForm.date}
                </h5>
                <h5><span class="label label-danger">Incidents</span> <span
                        class="label label-primary">Cataclysms</span>
                </h5><br>
                <h5>${newsForm.content}</h5>
                <div style="float:left;padding-right:8px;">
                    <button type="submit" class="btn btn-primary" name="id" value=${newsForm.id}>Edit mode</button>
                </div>
            </html:form>
            <html:form action="/newsAction?method=deleteNews">
                <button type="submit" class="btn btn-danger" name="id" value=${newsForm.id}>Delete</button>
            </html:form>
            <hr>
            <html:form action="/addUpCommAct">
                <div class="form-group">
                    <html:hidden property="id" value="${newsForm.id}"/>
                    <h4>Enter your login-email:</h4>
                    <html:textarea name="newsForm" property="commentAuthor" rows="1" style="width: 33%; border-radius: 3px"/>
                    <h4>Leave a Comment:</h4>
                    <html:textarea name="newsForm" property="commentContent" rows="3" style="width: 100%; border-radius: 3px"/>
                </div>
                <button type="submit" class="btn btn-success" >Submit</button>
            </html:form>
            <hr>
            <logic:iterate name="newsForm" property="formComments" id="comment">
                <h5>${comment.commentAuthor}</h5>
                <h6><span class="glyphicon glyphicon-time"></span>${comment.commentDate}</h6>
                <h4>${comment.commentContent}</h4>
                <br>
            </logic:iterate>
        </div>
    </div>
</div>

<footer class="container-fluid">
    <p align="center">KazTrulyNews</br>
        EPAM Systems &copy; 2018</p>
</footer>

</body>
</html>
