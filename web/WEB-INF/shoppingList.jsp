<%-- 
    Document   : shoppingList
    Created on : Jun 21, 2022, 10:34:00 AM
    Author     : barab
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <body>
        <h1>Shopping List</h1>

        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>

        <h2>List</h2>
        <form method="get" action="">
            <label>Add Item:</label>
            <input type="text" name="item" value="${shop_Item}"/>
            <input type="submit" name="action" value="Add">

            <ul>
                <c:forEach var="i" items="${shoppingItems}">
                    <li><input type="radio" name="shoppingItem" value="${i}">
                        <label>${i}</label>                            
                    </li>
                </c:forEach>            
            </ul>

            <input type="submit" name="action" value="Delete">
        </form>
    </body>
</html>
