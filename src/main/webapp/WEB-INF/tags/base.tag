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
<html>
    <head>
        <meta charset="utf-8">
        
        <title>RateYourOutfit | ${title}</title>

        <jsp:invoke fragment="head"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" >
        
    </head>
    
    <body>
        <header>
            <!-- Navigation -->
            <section id="navigation" class="container-fluid">
                <div id="nav-item"class="row">
                        <a id="home"class="nav-link" href="/RateYourOutfit/index">Home</a>
                        <a id="upload" class="nav-link" href="/RateYourOutfit/upload">Upload</a>
                        <a id="login"class="nav-link" href="/RateYourOutfit/login">LogIn</a>
                        <a id="overview"class="nav-link" href="/RateYourOutfit/comment">Overview</a>
                </div>
            </section>
        </header>
        <!-- Hauptinhalt der Seite -->
        <main>    
            <h1>Willkommen bei RateYourOutfit :)</h1>
            <jsp:invoke fragment="main"/>
            
        </main>
    </body>
    <footer>
        
    </footer>
</html>
