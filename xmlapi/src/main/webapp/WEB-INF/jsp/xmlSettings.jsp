<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xml Settings</title>
    <script src="js/jquery-3.1.1.js"></script>
</head>
<script>
    $(document).ready(function () {
        $('#style').click(function () {
            var val = $('input[name=style]:checked').val();
            switch(val){
                case "style1":
                    $('#backgroundColor').val('aqua');
                    break;
                case "style2":
                    break;
                case "style3":
                    break;

            }
        })
    })
</script>
<body>
XmlSettings<br/>
Style1<input type="radio" name="style" value="style1"/>
Style2<input type="radio" name="style" value="style2"/>
Style3<input type="radio" name="style" value="style3"/>
<form action="/xmlConfiguration" method="post">
    Color: <select name="backgroundColor">
        <option value="aliceblue">Aliceblue</option>
        <option value="aqua">Aqua</option>
        <option value="coral">Coral</option>
</select><br/>
    Border color:
    <select name="borderColor">
        <option value="blue">Blue</option>
        <option value="red">Red</option>
        <option value="yellow">Yellow</option>
    </select><br/>
    Border style:
    <select name="borderStyle">
        <option value="solid">Solid</option>
        <option value="dashed">Dashed</option>
    </select><br/>
    Border size:
    <select name="borderSize">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select><br/>

    Font size:
    <input type="number" name="fontSize"><br/>

    Font weight:
    <select name="fontWeight">
        <option value="normal">Normal</option>
        <option value="bold">Bold</option>
    </select><br/>

    Text align:
    <select name="textAlign">
        <option value="left">Left</option>
        <option value="center">Center</option>
        <option value="right">Right</option>
    </select><br/>

    Color:
    <select name="color">
        <option value="blue">Blue</option>
        <option value="red">Red</option>
        <option value="yellow">Yellow</option>
    </select><br/>
    Hover color:
    <select name="hoverColor">
        <option value="black">Black</option>
        <option value="gray">Gray</option>
        <option value="purple">Purple</option>
    </select><br/>
    Background hover color:
    <select name="backgroundHoverColor">
        <option value="chocolate">Blue</option>
        <option value="lightslategrey">Lightslategrey</option>
        <option value="olive">Olive</option>
    </select><br/>
    <input type="submit">
</form>
</body>
</html>
