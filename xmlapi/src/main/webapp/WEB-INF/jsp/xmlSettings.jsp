<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xml Settings</title>
    <script src="js/jquery-3.1.1.js"></script>
</head>
<body>
XmlSettings<br/>
Style1<input type="radio" class="style-radio" name="style" value="style1"/>
Style2<input type="radio" class="style-radio" name="style" value="style2"/>
Style3<input type="radio" class="style-radio" name="style" value="style3"/>
<form action="/xmlConfiguration" method="post">
    Background color: <select name="backgroundColor" id="backgroundColor">
        <option value="aliceblue">Aliceblue</option>
        <option value="aqua">Aqua</option>
        <option value="coral">Coral</option>
</select><br/>
    Border color:
    <select name="borderColor" id="borderColor">
        <option value="blue">Blue</option>
        <option value="red">Red</option>
        <option value="yellow">Yellow</option>
    </select><br/>
    Border style:
    <select name="borderStyle" id="borderStyle">
        <option value="solid">Solid</option>
        <option value="dashed">Dashed</option>
    </select><br/>
    Border size:
    <select name="borderWidth" id="borderWidth">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select><br/>

    Font size:
    <input type="number" name="fontSize" id="fontSize"><br/>

    Font weight:
    <select name="fontWeight" id="fontWeight">
        <option value="normal">Normal</option>
        <option value="bold">Bold</option>
    </select><br/>

    Text align:
    <select name="textAlign" id="textAlign">
        <option value="left">Left</option>
        <option value="center">Center</option>
        <option value="right">Right</option>
    </select><br/>

    Color:
    <select name="color" id="color">
        <option value="black">Black</option>
        <option value="blue">Blue</option>
        <option value="red">Red</option>
        <option value="yellow">Yellow</option>
        <option value="gray">Gray</option>
    </select><br/>
    Hover color:
    <select name="hoverColor" id="hoverColor">
        <option value="black">Black</option>
        <option value="gray">Gray</option>
        <option value="purple">Purple</option>
    </select><br/>
    Background hover color:
    <select name="backgroundHoverColor" id="backgroundHoverColor">
        <option value="chocolate">Chocolate</option>
        <option value="lightslategrey">Lightslategrey</option>
        <option value="olive">Olive</option>
    </select><br/>
    <input type="submit">
</form>
</body>
<script>
    $(document).ready(function () {
        $('.style-radio').change(function () {
            var val = $('input[name=style]:checked').val();
            switch (val) {
                case "style1":
                    $('#backgroundColor').val('aliceblue');
                    $('#borderColor').val('blue');
                    $('#borderStyle').val('solid');
                    $('#borderWidth').val('1');
                    $('#fontSize').val('15');
                    $('#fontWeight').val('normal');
                    $('#textAlign').val('center');
                    $('#color').val('gray');
                    $('#hoverColor').val('black');
                    $('#backgroundHoverColor').val('olive');
                    break;
                case "style2":
                    $('#backgroundColor').val('aqua');
                    $('#borderColor').val('red');
                    $('#borderStyle').val('dashed');
                    $('#borderWidth').val('3');
                    $('#fontSize').val('16');
                    $('#fontWeight').val('bold');
                    $('#textAlign').val('right');
                    $('#color').val('blue');
                    $('#hoverColor').val('gray');
                    $('#backgroundHoverColor').val('chocolate');
                    break;
                case "style3":
                    $('#backgroundColor').val('coral');
                    $('#borderColor').val('blue');
                    $('#borderStyle').val('solid');
                    $('#borderWidth').val('2');
                    $('#fontSize').val('16');
                    $('#fontWeight').val('normal');
                    $('#textAlign').val('left');
                    $('#color').val('yellow');
                    $('#hoverColor').val('purple');
                    $('#backgroundHoverColor').val('lightslategrey');
                    break;

            }
        })
    })
</script>
</html>
