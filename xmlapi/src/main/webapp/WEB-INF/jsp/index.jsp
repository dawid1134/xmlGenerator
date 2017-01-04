<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.1.1.js"></script>
</head>
<body>
<script>
    $(document).ready(function () {
        $('.type-radio').click(function () {
            var type = $('input[class=type-radio]:checked').val();
            $.ajax({
                    url : "${pageContext.request.contextPath}/setType?type="+type
            });
        })
    })
</script>
<form action="/selectAllData">
    <input type="submit" value="getAllXml"/>
</form>
<form action="/selectAllIdFirstLastNames">
    <input type="submit" value="getAllIdFirstLastNames"/>
</form>
<form action="/selectAllFirstLastNames">
    <input type="submit" value="getAllFirstLastNames"/>
</form>
<form action="/selectAllFilteredByPhone">
    <input type="submit" value="selectAllFilteredByPhone"/>
    Phone Number: <input type="text" name="phoneNumber">
</form>
<form action="/selectAllFilteredByFirstName">
    <input type="submit" value="selectAllFilteredByFirstName"/>
    First Name: <input type="text" name="firstName">
</form>
<form action="/selectAllFilteredByLastName">
    <input type="submit" value="selectAllFilteredByLastName"/>
    Last Name: <input type="text" name="lastName">
</form>
<form action="/selectAllDataLimited">
    <input type="submit" value="selectAllDataLimited"/>
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
</form>
<form action="/selectAllFilteredByPhoneLimited">
    <input type="submit" value="selectAllFilteredByPhoneLimited"/>
    Phone: <input type="text" name="phone">
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
</form>
<form action="/selectAllFilteredByFirstAndLastName">
    <input type="submit" value="selectAllFilteredByFirstAndLastName"/>
    First Name: <input type="text" name="firstName">
    Last Name: <input type="text" name="lastName">

</form>
<form action="/selectAllIdFirstLastNameLimited">
    <input type="submit" value="selectAllIdFirstLastNameLimited"/>
    Limit: <input type="text" name="limit">
    Offset: <input type="text" name="offset">
</form>
<div>
    XML:<input type="radio" name="type" checked value="XML" id="XML" class="type-radio"/>
    JSON:<input type="radio" name="type" value="JSON" class="type-radio"/>
    YAML:<input type="radio" name="type" value="YAML" class="type-radio"/>
    OGDL:<input type="radio" name="type" value="OGDL" class="type-radio"/>
</div>
</body>
</html>
