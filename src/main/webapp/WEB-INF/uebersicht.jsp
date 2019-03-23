<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<template:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="head">
       <link rel="stylesheet" href="<c:url value="/css/uebersicht.css"/>" />
       <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    </jsp:attribute>

    

    <jsp:attribute name="main">
        <div class="container anzeige">
        <c:forEach items="${bildids}" var="bildid">
            <div class="einzeln">
                <div class="row uebersichtsrow">
                <div style="display: inline" class="col-md-6 username">Placeholder_Username</div>
                <div style="display: inline" class="col-md-6 sterne">PH_Bewertung</div>
                </div>
                    <img src="http://localhost:8080/RateYourOutfit/bild?id=${bildid.id}" class="images">
                <div class="row">
                    
                        <div class="col-md-12 beschreibungsdisplay" value="${bildid.beschreibung}">${bildid.beschreibung}</div>
                    
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <span class="sternebewertung"> 
                            <input type="radio" id="stern5" name="bewertung" value="5"><label for="stern5" title="5_Sterne">5 Sterne</label> 
                            <input type="radio" id="stern4" name="bewertung" value="4"><label for="stern4" title="4_Sterne">4 Sterne</label> 
                            <input type="radio" id="stern3" name="bewertung" value="3"><label for="stern3" title="3_Sterne">3 Sterne</label> 
                            <input type="radio" id="stern2" name="bewertung" value="2"><label for="stern2" title="2_Sterne">2 Sterne</label> 
                            <input type="radio" id="stern1" name="bewertung" value="1"><label for="stern1" title="1_Stern">1 Stern</label>
                        </span>
                    </div>    
                </div>
                <div class="row">
                    <div class="col-md-12 kommentardisplay"><b>PH_Username:</b> PH_Kommentar</div>
                </div>
                <div class="row">
                    <div class="col-md-12"><textarea maxlength="244" rows="2" class="tkommentar" placeholder="Schreibe einen Kommentar"></textarea></div>
                </div>
                <div class="row">
                    <div class="col-md-12"><button class="kommentarbtn" type="submit"><i class="fas fa-paper-plane"> Absenden</i></button></div>
                </div>
            </div>    
        </c:forEach>
        </div>
    </jsp:attribute>
</template:base>