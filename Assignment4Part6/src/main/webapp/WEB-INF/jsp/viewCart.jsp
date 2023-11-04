
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shopping Cart</title>
</head>
<body>

    <div style="text-align: center">
    <c:if test = "${sessionScope.cartItems.size() > 0}">
        <h2 style="text-align: center">Cart Items:</h2>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/shopping.htm">

        <div style="text-align: center">
            <c:forEach var="mov" items="${sessionScope.cartItems}">
                <input  type="radio" name="checkDel" value="${mov}" />
                <c:out value="${mov}" /><br>
            </c:forEach>

            <c:if test = "${sessionScope.cartItems.size() < 1 || sessionScope.cartItems == null}">
                <h3> Please add items to your cart from Home Page.</h3>
            </c:if>
        </div> <br>
        <div style="text-align: center">
            <c:if test = "${sessionScope.cartItems.size() > 0}">
                <input type="submit" value="Delete Item">
            </c:if>
        </div>
    </form>
    <div style="text-align: center">
        <h2><a href="${pageContext.request.contextPath}/">Go back to home page</a><br></h2>
    </div>

</div>
</body>
</html>
