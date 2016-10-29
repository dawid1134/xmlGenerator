<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="webjars/bootstrap/3.3.6/css/bootstrap.css"/>
<html>
<head>
    <title>Title</title>
    <jsp:include page="utils.jsp"/>
    <script>
        function getAllXmlDownload() {
            $(location).attr('href', 'http://stackoverflow.com')
        }
    </script>
</head>
<body>
<form action="/selectAllData.xml">
    <input type="submit" value="getAllXml"/>
</form>
<form action="/selectAllIdFirstLastNames.xml">
    <input type="submit" value="getAllIdFirstLastNames"/>
</form>
<form action="/selectAllFirstLastNames.xml">
    <input type="submit" value="getAllFirstLastNames"/>
</form>
<form action="/selectAllFilteredByPhone.xml">
    Phone Number: <input type="text" name="phoneNumber">
    <input type="submit" value="selectAllFilteredByPhone"/>
</form>
<form action="/selectAllFilteredByFirstName.xml">
    First Name: <input type="text" name="firstName">
    <input type="submit" value="selectAllFilteredByFirstName"/>
</form>
<form action="/selectAllFilteredByLastName.xml">
    Last Name: <input type="text" name="lastName">
    <input type="submit" value="selectAllFilteredByLastName"/>
</form>
<form action="/selectAllDataLimited.xml">
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
    <input type="submit" value="selectAllDataLimited"/>
</form>
<form action="/selectAllFilteredByPhoneLimited.xml">
    Phone: <input type="text" name="phone">
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
    <input type="submit" value="selectAllFilteredByPhoneLimited"/>
</form>
<form action="/selectAllFilteredByFirstAndLastName.xml">
    First Name: <input type="text" name="firstName">
    Last Name: <input type="text" name="lastName">
    <input type="submit" value="selectAllFilteredByFirstAndLastName"/>
</form>
<form action="/selectAllIdFirstLastNameLimited.xml">
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
    <input type="submit" value="selectAllIdFirstLastNameLimited"/>
</form>
</body>
</html>
