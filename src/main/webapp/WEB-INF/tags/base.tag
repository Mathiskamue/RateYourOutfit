<%-- 
    Document   : base
    Created on : 12.03.2019, 10:35:40
    Author     : DEETMUMI
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@attribute name="message"%>
<%@attribute name="title"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="main" fragment="true"%>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">

        <title>RateYourOutfit | ${title}</title>
        <link rel="stylesheet" href="RateYourOutfit\src\main\webapp\style.css" />

        <jsp:invoke fragment="head"/>
    </head>
    <body>
        <!-- Hauptinhalt der Seite -->
        <main>    
            <h1>Hallo!</h1>
            <jsp:invoke fragment="main"/>
        </main>
    </body>
</html>