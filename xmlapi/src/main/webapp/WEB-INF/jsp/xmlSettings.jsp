<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xml Settings</title>
</head>
<body>
XmlSettings<br/>
Style1<input type="radio" name="style" value="style1"/>
Style2<input type="radio" name="style" value="style2"/>
Style3<input type="radio" name="style" value="style3"/>
<form action="/xmlConfiguration" method="post">
    <input type="submit">
</form>
</body>
</html>
