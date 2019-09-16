<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ page import=" control.ControllerLogin"%>

<!-- Si dichiara la variabile loginBean e istanzia un oggetto LoginBean -->
<jsp:useBean id="loginBean" scope="request"
             class="bean.UserBean"/>

<!-- Mappa automaticamente tutti gli attributi dell'oggetto loginBean e le proprietà JSP -->
<jsp:setProperty name="loginBean" property="*"/>
<%! String s1 = ""; %>
<%! String s2 = ""; %>


<!--istruzioni java -->

<%

    //passo s1 e s2 a RiassuntoLogin


    if (request.getParameter("id") != null) {

        s1 = request.getParameter("id");
        System.out.println("s1 =" + s1);
        session.setAttribute("id",s1);

        s2 = request.getParameter("password");
        System.out.println("s2 = " + s2);
        session.setAttribute("password",s2);

        loginBean.setId(s1);
        loginBean.setPassword(s2);

        if (ControllerLogin.validateLoginWeb(loginBean) > 0) {
            %>
            <!-- Passa il controllo alla nuova pagina -->
            <jsp:forward page="RiassuntoLogin.jsp"/>	<!-- inizia con jsp e non è istruz java-->
            <%
        } else {
            %>
            <p style="text-color:red;">Dati errati</p>
            <%
        }
    } else {
        %>
        <p class="text-info">Accesso non effettuato</p>
        <%
    }
%>

<!-- HTML 5 -->
<!DOCTYPE html>
<html>
<!-- Container tag for title, style, meta-information, linked resources or scripts -->
<head>
    <!-- Browser title bar, favorites, name for search engines -->
    <title>Login page</title>
    <!-- info about content, e.g.: content type, keywords, charset or description -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- linked CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="libs/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="nostroSito">


<div class="container">
    <form action="LoginPage.jsp" name="myform" method="POST">
<%--
        <div class="row">
            <div class="col-lg-4 form-group">
                <label for="id">Username</label>
                <input id="id" name="id" type="text">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 form-group">
                <label for="password">Password</label>
                <input id="password" name="password" type="password">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 text-center">
                <input name="login" type="submit"
                       id="login" value="login" class="btn btn-info">
                <input name="reset" type="reset"
                       id="reset" class="btn btn-warning">
            </div>
        </div>
--%>
        <! table class="table table-responsive">
            <tr>
                <td>Username:</td>
                <td><input name="username" type="text"></td>
            </tr>
            <tr>
                <td>Password:</td>
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