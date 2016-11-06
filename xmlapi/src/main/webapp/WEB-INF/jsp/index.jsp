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
    <input type="submit" value="selectAllFilteredByPhone"/>
    Phone Number: <input type="text" name="phoneNumber">
</form>
<form action="/selectAllFilteredByFirstName.xml">
    <input type="submit" value="selectAllFilteredByFirstName"/>
    First Name: <input type="text" name="firstName">
</form>
<form action="/selectAllFilteredByLastName.xml">
    <input type="submit" value="selectAllFilteredByLastName"/>
    Last Name: <input type="text" name="lastName">
</form>
<form action="/selectAllDataLimited.xml">
    <input type="submit" value="selectAllDataLimited"/>
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
</form>
<form action="/selectAllFilteredByPhoneLimited.xml">
    <input type="submit" value="selectAllFilteredByPhoneLimited"/>
    Phone: <input type="text" name="phone">
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
</form>
<form action="/selectAllFilteredByFirstAndLastName.xml">
    <input type="submit" value="selectAllFilteredByFirstAndLastName"/>
    First Name: <input type="text" name="firstName">
    Last Name: <input type="text" name="lastName">

</form>
<form action="/selectAllIdFirstLastNameLimited.xml">
    <input type="submit" value="selectAllIdFirstLastNameLimited"/>
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
</form>
</body>
</html>
