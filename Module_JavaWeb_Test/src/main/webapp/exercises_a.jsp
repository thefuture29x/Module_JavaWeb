<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 3/28/2022 AD
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="<c:url value ='/css/style.css'/>" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <c:if test="${not empty messageResponse}">
        <div class="alert alert-${alert}" role="alert" align="center">
                ${messageResponse}
        </div>
    </c:if>
    <h2>List User</h2>
    <form action="exercises-a">
        <button type="submit" class="btn btn-success" value="1" name="id_user_create" >Create new User</button>
    </form>

    <table class="table table-striped" style="padding: 25px;">
        <thead>
        <tr>

            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Age</th>
            <th scope="col">Phone</th>
            <th scope="col">Image</th>
            <th scope="col">Position</th>
            <th scope="col" colspan="2">Tools</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>

                <td>${user.name}</td>
                <td>${user.address}</td>
                <td>${user.age}</td>
                <td>${user.phone}</td>
                <td class="images-cart"><img src="images/${user.image}" style="height: 75px;width: 75px;"></td>
                <td>
                    <c:if test="${not empty user.id_position}">
                        <c:forEach var="item" items="${listPosition}">
                            <c:if test="${item.id == user.id_position}">
                                ${item.position}
                            </c:if>
                        </c:forEach>
                    </c:if>
                </td>
                <td>
                    <form action="exercises-a">
                        <button type="submit" class="btn btn-primary" value="${user.id}" name="id_user_edit" >Edit</button>
                    </form>
                </td>
                <td>
                    <form action="exercises-a">
                        <button type="submit" class="btn btn-danger" value="${user.id}" name="id_user_delete" >Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
