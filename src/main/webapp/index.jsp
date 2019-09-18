<%--
  Created by IntelliJ IDEA.
  User: SarojThapa
  Date: 9/17/2019
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
    <h1>The Number Quiz</h1> <br />
    <p>Your current score is 0.</p> <br />
    <p>Guess the next number in the next Sequence</p>

    <p>3, 1, 4, 1, 5</p>
    <form action="next" method="post">
    <p>Your answer:</p> <input type="text" name="answer">
    <br />
    <input type="submit" value="Submit">
    </form>
</body>
</html>
