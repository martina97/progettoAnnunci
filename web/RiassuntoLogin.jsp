<!DOCTYPE html>
<html>
<%
    String s1 = String.valueOf(session.getAttribute("id"));
    String s2 = String.valueOf(session.getAttribute("password"));


%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OK</title>
</head>
<body>
Login effettuato


<p>
    s1=    <%=s1 %>

</p>

<p>
    s2= <%=s2 %>

</p>
</body>
</html>