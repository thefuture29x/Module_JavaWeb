<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 3/28/2022 AD
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Edit User</title>
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
    <c:if test="${user_edit.getId() == 0}">
        <h2>Create New User</h2>
    </c:if>
    <c:if test="${user_edit.getId() != 0}">
        <h2>Edit User</h2>
    </c:if>

    <form action="exercises-a" enctype="multipart/form-data" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Name User</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" value="${user_edit.getName()}" required/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Address</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="address"  value="${user_edit.getAddress()}" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Age</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="age"  value="${user_edit.getAge()}" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Phone</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="phone"  value="${user_edit.getPhone()}" required>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Image</label>
            <div class="col-sm-2" >
                <img src="images/${user_edit.getImage()}" style="height: 150px;width: 150px;" id="thumbnail" alt="Image Product" >
            </div>
            <div class="col-sm-8">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="image" value="image" name="image"
                           accept="image/png,image/jpeg" aria-describedby="inputGroupFileAddon01">
                    <label class="custom-file-label" for="image">Choose file</label>
                    <input type="hidden" name="old_image" value="${user_edit.getImage()}">

                </div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Position</label>
            <div class="col-sm-10">

                <select class="form-control" id="id_position" name="id_position">
                    <c:if test="${empty user.id_position}">
                        <c:forEach var="item" items="${listPosition}">
                            <option value="${item.id}">${item.position}</option>
                        </c:forEach>
                    </c:if>
                    <c:if test="${not empty user.id_position}">
                        <c:forEach var="item" items="${listPosition}">
                            <option value="${item.id}"
                                    <c:if test="${item.id == user.id_position}"> selected="selected"</c:if>>
                                    ${item.position}</option>
                        </c:forEach>
                    </c:if>
                </select>
<%--                <input type="text" class="form-control" name="id_position"  value="${user_edit.getId_position()}" required>--%>
            </div>
        </div>

        <button type="submit" class="btn btn-primary" value="${user_edit.getId()}" name="id_user_update" >Add</button>

    </form>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
<script>
    $('#image').change(function() {
        showImageThumbnail(this);
    });
    function showImageThumbnail(fileInput) {
        file = fileInput.files[0];
        reader = new FileReader();

        reader.onload = function(e) {
            $('#thumbnail').attr('src', e.target.result);
        };

        reader.readAsDataURL(file);
    }
</script>
</html>
