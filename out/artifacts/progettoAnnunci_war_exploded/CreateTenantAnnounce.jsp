<%@ page import="bean.TenantAnnounceBean" %>
<%@ page import="entity.TenantAnnounce" %>
<%@ page import="control.ControllerTenantAnnounce" %>


<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 15/09/2019
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<jsp:useBean id="tab" scope="request" class="bean.TenantAnnounceBean" />

<%
    TenantAnnounceBean tenantAnnBean = (TenantAnnounceBean) session.getAttribute("bean");
    ControllerTenantAnnounce c2 = (ControllerTenantAnnounce) session.getAttribute("controller");
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>ANNUNCIO CERCASI</title>
</head>
<body class="nostroSito">

<div class="container">
    <form action="LoginPage.jsp" name="myform" method="POST">


        <! table class="table table-responsive">
        <tr>
            <td>Titolo Annuncio:</td>
            <td><input name="title" type="text"></td>
            <tr>Città:</tr>
            <tr><input name="password" type="password"></tr>
        </tr>
        <tr>
            <td>Città:</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr>
            <td colspan=2 align="center">
                <input name="login" type="submit"
                       id="login" value="login" class="btn btn-info">
            </td>
        </tr>
        </table-->
    </form>
</div>
</body>
</html>
