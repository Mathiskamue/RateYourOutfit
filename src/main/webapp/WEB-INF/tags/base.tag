<%-- 
    Document   : base
    Created on : 12.03.2019, 10:35:40
    Author     : DEETMUMI
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@attribute name="title"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="main" fragment="true"%>

<%-- any content can be specified here e.g.: --%>

<!DOCTYPE html>
<html >
    <head>
        <meta charset="utf-8">
        
        <title>RateYourOutfit | ${title}</title>

        <jsp:invoke fragment="head"/>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" >
        
    </head>
    
    <body id="background" >
        <header>
          
        </header>
        <!-- Hauptinhalt der Seite -->
        <main>  
           
            <jsp:invoke fragment="main"/>
            
        </main>
        <footer>
        
        </footer>
    </body>
    
</html>
