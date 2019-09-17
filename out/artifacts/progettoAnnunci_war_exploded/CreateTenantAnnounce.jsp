<%@ page import="bean.TenantAnnounceBean" %>
<%@ page import="entity.TenantAnnounce" %>
<%@ page import="control.ControllerTenantAnnounce" %>
<%@ page import="java.time.LocalDate" %>


<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 15/09/2019
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<jsp:useBean id="tab" scope="request" class="bean.TenantAnnounceBean" />

<jsp:setProperty name="tab" property="*"/>

<%! String s1 = ""; %>  <%-- title --%>
<%! String s2 = ""; %>  <%-- idUser --%>
<%! String s3 = ""; %>  <%-- city --%>
<%! int s4 = 0; %>      <%-- room --%>
<%! int s5 = 0; %>      <%-- people --%>
<%! int s6 = 0; %>      <%-- bath --%>
<%! LocalDate s7 = null; %>     <%-- dateArr --%>
<%! LocalDate s8 = null; %>     <%-- dateDep --%>
<%! String s9 = ""; %>      <%-- wifi --%>
<%! String s10 = ""; %>     <%-- garden --%>
<%! String s11= ""; %>      <%-- animals --%>
<%! String s12 = ""; %>     <%-- airConditioning --%>
<%! String s13= ""; %>      <%-- parking --%>

<!DOCTYPE html>
<html>

<body class="CreateTenantAnnounce">
<form action="CreateTenantAnnounce.jsp" name="CreateTenantAnnounce.jsp" method="POST">

<h2>Annuncio Cercasi</h2>

<table style="width:50%">

    <tr>
        <td>Titolo Annuncio: </td>
        <td><input name="title" type="text"></td>
        <%s1 = request.getParameter("title");
                tab.setTitle(s1);
        %>
    </tr>
    <tr>
        <td>Città:</td>
        <td><input name="city" type="text"></td>
        <%tab.setCity(request.getParameter("city"));%>
        <td>Id Utente:</td>
        <td><Label name="idUser" type="text"> </td>
        <%tab.setName(request.getParameter("idUser"));%>
    </tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr>

        <td>Numero stanze:</td>
        <td><input name="room" type="int"></td>

        <%s4= Integer.parseInt(request.getParameter("room"));%>
        <%tab.setRoom((int)s4);%>
        <td>Arrivo:</td>
        <td><p> <input name="dateArr" type="date" id="dateArr"></p></td>
        <%tab.setDateArr(LocalDate.parse(request.getParameter("dateArr")));%>

    </tr>


    <tr>
        <td>Numero persone:</td>
        <td><input name="people" type="text"></td>
        <%tab.setPeople(Integer.parseInt(request.getParameter("people")));%>

        <td>Partenza:</td>
        <td><p> <input name="dateDep" type="date" id="dateDep"></p></td>
        <%tab.setDateDep(LocalDate.parse(request.getParameter("dateDep")));%>

        <td>  <input name="okBtn" type="submit" id="okBtn" value="ok" class="btn btn-info"> </td>
    </tr>

    <tr>
        <td>Numero bagni:</td>
        <td><input name="bath" type="text"></td>
        <%tab.setBath(Integer.parseInt(request.getParameter("bath")));%>
    </tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr>
        <td>Ulteriori Servizi</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="wifi" value="Wifi"> Wifi<br></td>
        <%tab.setWifi(request.getParameter("wifi"));%>
        <td><input type="checkbox" name="animals" value="animals"> Animali Ammessi<br></td>
        <%tab.setAnimals(request.getParameter("animals"));%>
        <td><input type="checkbox" name="parking" value="parking"> Parcheggio<br></td>
        <%tab.setParking(request.getParameter("parking"));%>

    </tr>
    <tr>
        <td><input type="checkbox" name="garden" value="Giardino"> Giardino<br></td>
        <%tab.setGarden(request.getParameter("garden"));%>
        <td><input type="checkbox" name="airConditionig" value="Aria Condizionata"> Aria Condizionata<br></td>
        <%tab.setAirConditioning(request.getParameter("airConditioning"));%>
    </tr>

</table>
</body>
</html>
