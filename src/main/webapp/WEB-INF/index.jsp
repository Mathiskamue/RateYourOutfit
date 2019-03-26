<%-- 
    Document   : index
    Created on : 12.03.2019, 10:26:38
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<c:set var="base-url" value="<%=request.getContextPath()%>" />

<template:base>
    
    <jsp:attribute name="title">
        
    </jsp:attribute>
    <jsp:attribute name="head">
        
    </jsp:attribute>
        
    
        
    <jsp:attribute name="main">
        <form method="Post">
            <div class="row">
                    <h1 class="text" >RateYourOutfit</h1>
            </div>
            <div class="row">
                <div class="col-sm-3">
                    <p> Bereits registriert? </p>     
                    <button class="icon-login bu" type="submit">
                       LogIn
                    </button>
                     <p> Noch kein Mitglied, hier registrieren!</p>   
                    <button class="icon-login bu" type="submit">
                       Registrierung
                    </button>
                </div>  
            </div>
            
        </form>
    </jsp:attribute>
</template:base>
    
    
    
    