<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>


<form action="/subscribe" method="post">
    <%--@declare id="login"--%><%--@declare id="password"--%><%--@declare id="firstname"--%><%--@declare id="lastname"--%>
    <%--@declare id="numberofcreditcard"--%><label for="firstName">Last Name :</label>
    <h1> ${firstName}</h1>
    <br>
    <label for="lastName">Last Name : </label>
    <h1> ${lastName}</h1>
    <br>
    <label for="numberOfCreditCard">Credit Card : </label>
    <input name="numberOfCreditCard">
    <input type="submit" value="submit">
</form>

</body>
</html>