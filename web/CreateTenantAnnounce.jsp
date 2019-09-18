<%@ page import="bean.TenantAnnounceBean" %>
<%@ page import="entity.TenantAnnounce" %>
<%@ page import="control.ControllerTenantAnnounce" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="dao.DBFunctions" %>


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

<%! boolean res = false; %>  <%-- title --%>
<%! String s2 = ""; %>  <%-- idUser --%>
<%! String s3 = ""; %>  <%-- city --%>
<%! int s4 = 0; %>      <%-- room --%>
<%! int s5 = 0; %>      <%-- people --%>
<%! int s6 = 0;%>      <%-- bath --%>
<%-- <%! String s7 ="" ; %>     <%-- dateArr --%>
<%--- <%! String s8 = ""; %>     <%-- dateDep --%>
<%! String s9 = ""; %>      <%-- wifi --%>
<%! String s10 = ""; %>     <%-- garden --%>
<%! String s11= ""; %>      <%-- animals --%>
<%! String s12 = ""; %>     <%-- airConditioning --%>
<%! String s13= ""; %>      <%-- parking --%>


<%
    if (request.getParameter("title") != null) {
        if (request.getParameter("okBtn") != null) {
           /* s1 = request.getParameter("title");
            //tab.setTitle(s1);
            System.out.println(tab.getTitle());
            s2 = request.getParameter("idUser");
            tab.setName(s2);
            s3 = request.getParameter("city");
            tab.setCity(s3);
            s4 = Integer.parseInt(request.getParameter("room"));
            tab.setRoom(s4);
            s5 = Integer.parseInt(request.getParameter("people"));
            tab.setPeople(s5);
            s6 = Integer.parseInt(request.getParameter("bath"));
            tab.setBath(s6);
            //s7 = request.getParameter("dateArr");
            //tab.setDateArr(LocalDate.parse(s7));
            //s8 = request.getParameter("dateDep");
            //tab.setDateDep(LocalDate.parse(s8));
            s9 = request.getParameter("wifi");
            tab.setWifi(s9);
            s10 = request.getParameter("garden");
            tab.setGarden(s10);
            s11 = request.getParameter("animals");
            tab.setAnimals(s11);
            s12 = request.getParameter("airConditioning");
            tab.setAirConditioning(s12);
            s13 = request.getParameter("parking");
            tab.setParking(s13); */
           if(tab.getWifi() == null) {
               tab.setWifi("no"); }
           else {
               tab.setWifi("s1");
           }

            if(tab.getGarden() == null) {
                tab.setGarden("no"); }
            else {
                tab.setGarden("s1");
            }
            if(tab.getAnimals() == null) {
                tab.setAnimals("no"); }
            else {
                tab.setAnimals("s1");
            }
            if(tab.getAirConditioning() == null) {
                tab.setAirConditioning("no"); }
            else {
                tab.setAirConditioning("s1");
            }
            if(tab.getParking() == null) {
                tab.setParking("no"); }
            else {
                tab.setParking("s1");
            }

            tab.setDateArr(LocalDate.parse(request.getParameter("arr")));
            tab.setDateDep(LocalDate.parse(request.getParameter("dep")));

            System.out.println((tab.getWifi()));
            System.out.println((tab.getDateArr()));

          //  ControllerTenantAnnounce cta = new ControllerTenantAnnounce();
            //cta.createTenantAnnounce(tab);

            TenantAnnounce ta = new TenantAnnounce(
                    tab.getTitle(), tab.getName(), tab.getCity(),
                    tab.getRoom(), tab.getPeople(), tab.getBath(),
                    tab.getDateArr(), tab.getDateDep(), tab.getWifi(),
                    tab.getGarden(), tab.getAnimals(), tab.getAirConditioning(), tab.getParking());

            DBFunctions dbf = new DBFunctions();
           res = dbf.insertNewTenantAnnounce(ta);
           if(res == true) {

            %>
            <!-- Passa il controllo alla nuova pagina -->
            <jsp:forward page="PubblicazioneAnnuncio.jsp"/>	<!-- inizia con jsp e non è istruz java-->
            <%
            } else {
            %>
            <p style="text-color:red;">L'inserimento nel Database del tuo annuncio non è andato a buon fine!</p>
            <%
           }
        }
    }
    %>

<!DOCTYPE html>
<html>

<body class="CreateTenantAnnounce">
<form action="CreateTenantAnnounce.jsp" name="CreateTenantAnnounce.jsp" method="POST">

<h2>Annuncio Cercasi</h2>

<table style="width:50%">

    <tr>
        <td>Titolo Annuncio: </td>
        <td><input name="title" type="text"></td>
    </tr>

    <tr>
        <td>Città:</td>
        <td><input name="city" type="text"></td>
       <%--  <%tab.setCity(request.getParameter("city"));%> --%>
        <td>Id Utente:</td>
        <td><Label name="idUser" type="text"> </Label></td>
        <%-- <%tab.setName(request.getParameter("idUser"));%> --%>
    </tr>

    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr>

        <td>Numero stanze:</td>
        <td><input name="room" type="int"></td>

        <%-- <%s4= Integer.parseInt(request.getParameter("room"));%> --%>
       <%-- <%tab.setRoom((int)s4);%> --%>
         <td>Arrivo:</td>
        <%--<td><input name="dateArr" type="text"> </td>--%>
        <td><p> <input name="arr" type="date" id="arr"></p></td>
       <%-- <%tab.setDateArr(LocalDate.parse(request.getParameter("dateArr")));%> --%>

    </tr>


    <tr>
        <td>Numero persone:</td>
        <td><input name="people" type="text"></td>
        <%-- <%tab.setPeople(Integer.parseInt(request.getParameter("people")));%> --%>

         <td>Partenza:</td>

          <td><p> <input name="dep" type="date" id="dep"></p></td>
         <%-- <%tab.setDateDep(LocalDate.parse(request.getParameter("dateDep")));%> --%>

        <td>  <input name="okBtn" type="submit" id="okBtn" value="Pubblica annuncio" class="btn btn-info"> </td>
    </tr>

    <tr>
        <td>Numero bagni:</td>
        <td><input name="bath" type="text"></td>
        <%-- <%tab.setBath(Integer.parseInt(request.getParameter("bath")));%> --%>
    </tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr>
        <td>Ulteriori Servizi</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="wifi" value="Wifi"> Wifi<br></td>
        <%-- <%tab.setWifi(request.getParameter("wifi"));%> --%>
        <td><input type="checkbox" name="animals" value="animals"> Animali Ammessi<br></td>
        <%-- <%tab.setAnimals(request.getParameter("animals"));%> --%>
        <td><input type="checkbox" name="parking" value="parking"> Parcheggio<br></td>
<%-- <%tab.setParking(request.getParameter("parking"));%>--%>

        </tr>
        <tr>
        <td><input type="checkbox" name="garden" value="Giardino"> Giardino<br></td>
        <%--<%tab.setGarden(request.getParameter("garden"));%>--%>
        <td><input type="checkbox" name="airConditionig" value="Aria Condizionata"> Aria Condizionata<br></td>
        <%--<%tab.setAirConditioning(request.getParameter("airConditioning"));%>--%>
        </tr>
</table>
</form>
</body>
</html>
