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
        <section id="navigation" class="container-fluid">

            <div  id="nav-item" class="row tab">
                <div class="col-sm-6">
                    <ul class="nav nav-pills nav-justified">
                        <li> <a href="<c:url value="/app/uebersicht/"/>">Übersicht</a></li>
                        <li> <a href="<c:url value="/app/upload/"/>">Upload</a></li>
                        <li> <a href="<c:url value="/logout/"/>">Logout</a></li>

                    </ul>
                </div>
                <div class="col-sm-3"></div>
                <div class="col-sm-1">
                    <p>Scorepunktzahl</p>
                </div>
                <div class="col-sm-1">
                    <p>Profilname</p>
                    <c:out value="${session_username}"></c:out>
                    </div>
                </div>
            </section>
    </jsp:attribute>



    <jsp:attribute name="main">

        <div class="container anzeige">
            <c:forEach items="${bildids}" var="bildid">

                <div class="einzeln">
                    <div class="row uebersichtsrow">
                        <div style="display: inline" class="col-md-6 username">Placeholder_Username</div>
                        <div style="display: inline" class="col-md-6 sterne">PH_Bewertung</div>
                    </div>
                    <img src="https://localhost:8443/RateYourOutfit/app/bild?id=${bildid.id}" class="images">
                    <div class="row">

                        <div class="col-md-12 beschreibungsdisplay" value="${bildid.beschreibung}">${bildid.beschreibung}</div>

                    </div>
                    <div class="row">
                        <div class="col-md-1"><form method="POST"><button class="bewerte1" name="bewertung5" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                        <div class="col-md-1"><form method="POST"><button class="bewerte2" name="bewertung4" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                        <div class="col-md-1"><form method="POST"><button class="bewerte3" name="bewertung3" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                        <div class="col-md-1"><form method="POST"><button class="bewerte4" name="bewertung2" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>
                        <div class="col-md-1"><form method="POST"><button class="bewerte5" name="bewertung1" type="submit" value="${bildid.id}"><i class="fas fa-star"></i></button></form></div>

                    </div>
                    <c:forEach items="${kommentare}" var="kommentar">
                        <div class="row">
                            <div  class="col-md-12 kommentardisplay text"><b>${kommentar.id}</div>
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
