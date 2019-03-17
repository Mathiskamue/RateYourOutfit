<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


//Hier können sich die Benutzer auf der Seite anmelden 
<template:base>

    <jsp:attribute name="title">

    </jsp:attribute>
    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/comment.css"/>" />
    </jsp:attribute>



    <jsp:attribute name="main">

        <form method="POST">
            <p>
                <input type="text" name="kommentarRein">
            </p>
            <p> 
                <span class="sternebewertung"> 
                    <%--      <button type="submit" name="bewertung" value="1"></button>
                    <button type="submit" name="bewertung" value="2"></button>
                    <button type="submit" name="bewertung" value="3"></button>
                    <button type="submit" name="bewertung" value="4"></button>
                    <button type="submit" name="bewertung" value="5"></button>                 --%>

                    <input type="radio" id="stern5" name="bewertung" value="5"><label for="stern5" title="5_Sterne">5 Sterne</label> 
                    <input type="radio" id="stern4" name="bewertung" value="4"><label for="stern4" title="4_Sterne">4 Sterne</label> 
                    <input type="radio" id="stern3" name="bewertung" value="3"><label for="stern3" title="3_Sterne">3 Sterne</label> 
                    <input type="radio" id="stern2" name="bewertung" value="2"><label for="stern2" title="2_Sterne">2 Sterne</label> 
                    <input type="radio" id="stern1" name="bewertung" value="1"><label for="stern1" title="1_Stern">1 Stern</label> <
                </span> 
            </p> 
            <button class="icon-login" type="submit">
                Bestätigen
            </button>
        </form>
        //Anzeigen aller Kommentare 
        <c:forEach items="${findText}" var="kommentar" >
            <div  class="kommentare">
                <tr>
                    <td >
                        <c:out value="${kommentar.getText()}"/>
                    </td>

                </tr>
            </div>
        </c:forEach>   


    </jsp:attribute>
</template:base>
