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
                    <input type="radio" id="stern5" name="bewertung1" value="5"><label for="stern5" title="5_Sterne">5 Sterne</label> 
                    <input type="radio" id="stern4" name="bewertung2" value="4"><label for="stern4" title="4_Sterne">4 Sterne</label> 
                    <input type="radio" id="stern3" name="bewertung3" value="3"><label for="stern3" title="3_Sterne">3 Sterne</label> 
                    <input type="radio" id="stern2" name="bewertung4" value="2"><label for="stern2" title="2_Sterne">2 Sterne</label> 
                    <input type="radio" id="stern1" name="bewertung5" value="1"><label for="stern1" title="1_Stern">1 Stern</label> 
                </span> 
            </p> 
            <button class="icon-login" type="submit">
                Bestätigen
            </button>
        </form>
        //Anzeigen aller Kommentare 
        <c:forEach items="${comment}" var="kommentar" >
            <div>
                <c:out value="${kommentar.getText()}"/>
            </div>
        </c:forEach>


    </jsp:attribute>
</template:base>
