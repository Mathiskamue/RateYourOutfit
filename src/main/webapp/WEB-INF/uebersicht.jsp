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
                    <div class="col-md-1"><form method="POST"><button class="bewerte1" name="bewertung5" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                    <div class="col-md-1"><form method="POST"><button class="bewerte2" name="bewertung4" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                    <div class="col-md-1"><form method="POST"><button class="bewerte3" name="bewertung3" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                    <div class="col-md-1"><form method="POST"><button class="bewerte4" name="bewertung2" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                    <div class="col-md-1"><form method="POST"><button class="bewerte5" name="bewertung1" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                    
                   
                    <!--<div class="col-md-12">
                        
                        <span class="sternebewertung"> 
                            
                            <input type="submit" id="stern5" name="" value="${bildid.id}"><label for="stern5" title="5_Sterne" value="${bildid.id}">5 Sterne</label> </form>
                            <input type="submit" id="stern4" name="bewertung4" value="${bildid.id}"><label for="stern4" title="4_Sterne" value="${bildid.id}">4 Sterne</label> 
                            <input type="submit" id="stern3" name="bewertung3" value="${bildid.id}"><label for="stern3" title="3_Sterne" value="${bildid.id}">3 Sterne</label> 
                            <input type="submit" id="stern2" name="bewertung2" value="${bildid.id}"><label for="stern2" title="2_Sterne" value="${bildid.id}">2 Sterne</label> 
                            <input type="submit" id="stern1" name="bewertung1" value="${bildid.id}"><label for="stern1" title="1_Stern" value="${bildid.id}">1 Stern</label>
                           
                        </span>
                        
                    </div>  -->
                    
                </div>
                <c:forEach items="${kommentare}" var="kommentar">
                <div class="row">
                    <div  class="col-md-12 kommentardisplay text"><b>testestest</div>
                </div>
                </c:forEach>
               
                <div class="row">
                    <div class="col-md-12"><textarea maxlength="244" rows="2" name="kommentar${bildid.id}" class="tkommentar" placeholder="Schreibe einen Kommentar"></textarea></div>
                </div>
                <div class="row">
                    <form method="POST">
                    <div class="col-md-12"><button class="kommentarbtn" name="sendebtn" type="submit" value="${bildid.id}"><i class="fas fa-paper-plane text"> Absenden</i></button></div>
                    </form>
                </div>
            </div>   
            

        </c:forEach>
        </div>
    </jsp:attribute>
</template:base>