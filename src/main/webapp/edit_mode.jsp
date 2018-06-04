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
            <html:form action="/addUpNewsAct">
                <h4>
                    <medium>Add/Edit mode</medium>
                </h4>
                <hr>
                <html:messages id="err_password" property="message.date.err">
                    <div style="color:red">
                        <bean:write name="err_password" />
                    </div>
                </html:messages>
                <div>
                    Edit news date:
                </div>
                <html:textarea name="newsForm" property="date" cols="150" rows="1" style="width: 100%"/>
                <hr>
                <html:messages id="err_title" property="message.title.err">
                    <div style="color:red">
                        <bean:write name="err_title" />
                    </div>
                </html:messages>
                <div>
                    Edit news title:
                </div>
                <html:textarea name="newsForm" property="title" cols="150" rows="2" style="width: 100%"/>
                <hr>
                <html:messages id="err_brief" property="message.brief.err">
                    <div style="color:red">
                        <bean:write name="err_brief" />
                    </div>
                </html:messages>
                <div>
                    Edit news brief:
                </div>
                <html:textarea name="newsForm" property="brief" cols="150" rows="3" style="width: 100%"/>
                <hr>
                <html:messages id="err_content" property="message.content.err">
                    <div style="color:red">
                        <bean:write name="err_content" />
                    </div>
                </html:messages>
                <div>
                    Edit news content:
                </div>
                <html:textarea name="newsForm" property="content" cols="150" rows="20" style="width: 100%"/>

                <button type="submit" class="btn btn-primary" name="id" value=${newsForm.id}>Add/Edit news</button>
                <br><br>
            </html:form>

        </div>
    </div>
</div>

<footer class="container-fluid">
    <p align="center">KazTrulyNews</br>
        EPAM Systems &copy; 2018</p>
</footer>

</body>
</html>
