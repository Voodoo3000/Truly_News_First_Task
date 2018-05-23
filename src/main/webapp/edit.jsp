<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<html:form action="/update">
<div style="padding:32px">
    <div>
        Edit news title:
    </div>
        <html:textarea name="news" property="title" cols="200" rows="2"/>
    <div>
        Edit news brief:
    </div>
        <html:textarea name="news" property="brief" cols="200" rows="3"/>
    <div>
        Edit news content:
    </div>
        <html:textarea name="news" property="content" cols="200" rows="20"/>

    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <html:submit>submit</html:submit>
        </div>
        <html:reset>reset</html:reset>
    </div>

    </html:form>
</body>
</html>
