<%-- 
    Document   : index
    Created on : 12.03.2019, 10:26:38
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


//Hier können sich die Benutzer auf der Seite anmelden 
<template:base>
    
 <jsp:attribute name="title">
 <jsp:attribute name="head">
   <a href="<c:url value="/login"/>">Registrieren</a>      
  <jsp:attribute name="menu">
            
   <jsp:attribute name="content">
  
 </jsp:attribute>      
 </jsp:attribute>                
 </jsp:attribute>
</template:base>
    
    
    
    