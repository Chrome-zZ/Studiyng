<%--
  Created by IntelliJ IDEA.
  User: Al
  Date: 3/22/2021
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
<%@ page import="somePackage.Cart" %>
    <% Cart cart = (Cart) session.getAttribute("cart"); %>

<p> Name: <%= cart.getName() %> </p>
<p> Q-ty: <%= cart.getQuantity() %> </p>
</body>
</html>
