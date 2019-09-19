
<!DOCTYPE html>
<html>
<%
    String s1 = String.valueOf(session.getAttribute("id"));
    String s2 = String.valueOf(session.getAttribute("password"));
    String s3 = String.valueOf(session.getAttribute("userType"));
    session.setAttribute("idUser",s3);

    if(s3.equals("2")){
%>
<p>Login effettuato!</p>
<%
    }
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OK</title>
</head>
<body class="menu">

<h3>Menu Locatario</h3>

<table style="width:100%">
    <tr>
        <th><button>VISUALIZZA BACHECA</button></th>
    </tr>
    <tr>
        <th><input name="publishBtn" id="publishBtn" type="button" value="CREA NUOVO ANNUNCIO" class="btn btn-info"  onclick="window.location='CreateTenantAnnounce.jsp'"></th>


</table>

<script type="text/javascript">
    function openPage(pageURL)
    {
        window.location.href = pageURL;
    }
</script>
<%--<jsp:forward page="CreateTenantAnnounce.jsp"/>--%>

</body>
</html>
