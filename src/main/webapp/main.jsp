<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <h2><bean:write name="news" property="title" /></h2>
    <h3><bean:write name="news" property="brief" /></h3>
    <h5><bean:write name="news" property="content" /></h5>
</body>
</html>