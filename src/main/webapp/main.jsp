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
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
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
                <li class="active"><a href="#section1">Recent</a></li>
                <li><a href="#section2">Politics</a></li>
                <li><a href="#section3">Incidents</a></li>
                <li><a href="#section3">Life</a></li>
            </ul>
        </div>
        <br>
        <div style="float:right;padding-right:16px;">
            <a href="/TrulyNews/edit_mode.jsp" type="button" class="btn btn-success">Add News</a>
        </div>
        <div class="col-sm-9">
            <logic:iterate name="newsTitle" id="newsId">
                <html:form action="/openSelectedNews">
                    <bean:define id="news" name="newsId" property="value"/>
                    <h4>
                        <small>RECENT POSTS</small>
                    </h4>
                    <hr>
                    <div style="float:right;padding-right:16px;">
                        <div class="checkbox-primary">
                            <label><input type="checkbox" id="newsId.value.id"  value="newsId.value.id"></label>
                        </div>
                    </div>
                    <h2><bean:write name="news" property="title"/></h2>
                    <h5><span class="glyphicon glyphicon-time"></span> <bean:write name="news" property="date"/>
                    </h5>
                    <h5><span class="label label-danger">Incidents</span> <span
                            class="label label-primary">Cataclysms</span>
                    </h5><br>
                    <h5><bean:write name="news" property="brief"/></h5>
                    <button type="submit" class="btn btn-info" name="id" value=${newsId.value.id}>Read more</button>
                    <br><br>
                </html:form>
            </logic:iterate>
            <hr>
        </div>
    </div>
</div>

<footer class="container-fluid">
    <p align="center">KazTrulyNews</br>
        EPAM Systems &copy; 2018</p>
</footer>

<script>
    function deleteSelectedNews() {
        for (var i = 0; i < newsTitle.length; i++) {
            var checkbox = document.getElementById(newsId.value.id);
            if (checkbox.checked){
                checkedBoxesList.put(newsId.value.id);
            }
        }

    }
</script>

</body>
</html>
