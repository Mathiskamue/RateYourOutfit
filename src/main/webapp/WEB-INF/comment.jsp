<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


//Hier können sich die Benutzer auf der Seite anmelden 
<template:base>
    
    <jsp:attribute name="title">
        
    </jsp:attribute>
    <jsp:attribute name="head">
        
    </jsp:attribute>
        
    
        
    <jsp:attribute name="main">
        
        <label for="kommentarRein">
            </label>
   
           <select name="type">
              <c:forEach items="${comment}" var="kommentar" >
                  <div class = "lol">
                      
                  </div>
                      <tr>
                          <c:out value=${kommentar.getText()}/>
                      </tr>
                  
              </c:forEach>
            </select>
            
   
    </jsp:attribute>
</template:base>
    