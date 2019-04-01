<%-- 
    Document   : upload
    Created on : 12.03.2019, 10:22:14
    Author     : mathis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Upload
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/upload2.css"/>" />
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
                    Profilname</p>
                    <p> <c:out value="${session_username}"></c:out></p>
                    </div>
                </div>
            </section>
    </jsp:attribute>
    <jsp:attribute name="main">
        <div class="ueberschrift1">Hier kannst du dein Bild hochladen!</div>
        <br>
        <form method="POST" enctype="multipart/form-data">
            <%-- CSRF-Token --%>
            <input type="hidden" name="csrf_token" value="${csrf_token}">
            <div class="hochladen">
                <input type="file" name="picture" class="upload" />
                <div class="hochladbtn"><button class="anzeigebtn" type="submit" name="hochladen" value="hochladen">Bild anzeigen</button></div> 
            </div>




            <c:if test="${bild_form.id != 0}">
                <div class="bildtest">
                    <br>
                    <div>So würde dein Bild später angezeigt werden:</div>
                    <img src="https://localhost:8443/RateYourOutfit/app/bild?id=${bild_form.id}" class="image">
                    <br>

                    <textarea class="textarea" name="textarea" placeholder="Deine Beschreibung" maxlength="244" rows="3"></textarea>
                    <br>
                    <button type="submit" name="abschicken" value="testen">Abschicken</button>  
                    <div>
                    </c:if>

                    <c:if test="${!empty bild_form.errors}">
                        <ul class="errors">
                            <c:forEach items="${bild_form.errors}" var="error">
                                <li>${error}</li>
                                </c:forEach>
                        </ul>
                    </c:if>
                    </form>



                </jsp:attribute>
            </template:base>