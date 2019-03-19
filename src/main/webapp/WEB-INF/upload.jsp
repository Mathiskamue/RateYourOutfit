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
       
    </jsp:attribute>
    <jsp:attribute name="main">
        <h1>Hier kannst du dein Bild hochladen!</h1>
        <form method="POST" enctype="multipart/form-data">
           
            
            <input type="file" name="picture" />
            
            <button type="submit" name="hochladen" value="hochladen">Bild Hochladen</button>
            <br>
            
        
        
        <c:if test="${bild_form.id != 0}">
                <img src="http://localhost:8080/RateYourOutfit/bild?id=${bild_form.id}" class="images">
                <br>
                <input type="text" name="beschreibung" placeholder="Dein Text" value="${bild_form.beschreibung}" maxlength="244"/>
                <br>
                <button type="submit" name="abschicken" value="testen">Abschicken</button>
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