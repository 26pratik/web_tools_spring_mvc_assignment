
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shopping Site</title>
</head>
</head>
<body>
        <div  style=" width: 100%; text-align: center ">
            <h3>Items Menu</h3>
            <form method="post" action="${pageContext.request.contextPath}/shopping.htm">
                <input type="submit" value="Book" name="btnClicked"/>
                <input type="submit" value="Music" name="btnClicked"/>
                <input type="submit" value="Computer" name="btnClicked"/>
            </form>
        </div>

            <div style=" width: 100%; text-align: center ">
                <form method="post" action="${pageContext.request.contextPath}/shopping.htm">
                    <c:forEach var="mov" items="${sessionScope.visibleArray}">
                        <input type="radio" name="check" value="${mov}">
                        <c:out value="${mov}" /><br>
                    </c:forEach>
                    <c:if test = "${sessionScope.visibleArray.size() < 1}">
                        <h2> Please add items to your cart from Home Page.</h2>
                    </c:if>
                    <br>
                    <div style="text-align: center">
                        <c:if test = "${sessionScope.visibleArray.size() > 0}">
                        <input type="submit" value="ADD TO CART">
                        </c:if>
                    </div>
                </form>
            <div>
                <h3 style="text-align: center;"><a href="${pageContext.request.contextPath}/cartview.htm">View Cart</a></h3><br>
            </div>                    
        </div>
</body>
</html>
