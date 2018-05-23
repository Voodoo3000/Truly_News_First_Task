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
            <h4>TrulyNews</h4>
            <a title="TrulyNews" href='<c:url value="/main.do"/>'>
                <img src="static/pics/reporter.jpg">
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
            <html:form action="/openEditMode">
                <h4>
                    <small>RECENT POSTS</small>
                </h4>
                <hr>
                <h2><bean:write name="news" property="title"/></h2>
                <h5><span class="glyphicon glyphicon-time"></span> <bean:write name="news" property="date"/>
                </h5>
                <h5><span class="label label-danger">Incidents</span> <span
                        class="label label-primary">Cataclysms</span>
                </h5><br>
                <h5><bean:write name="news" property="content"/></h5>
                <div style="float:left;padding-right:8px;">
                    <button type="submit" class="btn btn-primary" name="id" value=${news.id}>Edit mode</button>
                </div>
            </html:form>
            <html:form action="/deleteNews">
                <button type="submit" class="btn btn-danger" name="id" value=${news.id}>Delete</button>
            </html:form>

            <hr>

            <h4>Leave a Comment:</h4>
            <form role="form">
                <div class="form-group">
                    <textarea class="form-control" rows="3" required></textarea>
                </div>
                <button type="submit" class="btn btn-success">Submit</button>
            </form>

        </div>
    </div>
</div>

<footer class="container-fluid">
    <p align="center">KazTrulyNews</br>
        EPAM Systems &copy; 2018</p>
</footer>

</body>
</html>
