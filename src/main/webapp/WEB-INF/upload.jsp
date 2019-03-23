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
    </jsp:attribute>
    <jsp:attribute name="main">
        <div class="ueberschrift1">Hier kannst du dein Bild hochladen!</div>
        <br>
        <form method="POST" enctype="multipart/form-data">
           
            <div class="hochladen">
                <input type="file" name="picture" class="upload" />
                <div class="hochladbtn"><button class="anzeigebtn" type="submit" name="hochladen" value="hochladen">Bild anzeigen</button></div> 
            </div>
            
            
        
        
        <c:if test="${bild_form.id != 0}">
            <div class="bildtest">
                <br>
                <div>So würde dein Bild später angezeigt werden:</div>
                <img src="http://localhost:8080/RateYourOutfit/bild?id=${bild_form.id}" class="image">
                <br>
                <input class="textinput" type="text" name="beschreibung" placeholder="Dein Text" value="${bild_form.beschreibung}" maxlength="244" class="beschreibung"> 
                <textarea class="test" name="textarea" placeholder="Deine Beschreibung" maxlength="244"></textarea>
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