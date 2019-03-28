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
            <!-- Navigation -->
            <section id="navigation" class="container-fluid">
                
                <div id="nav-item" class="row tab">
                    <div class="col-sm-6">
                        <ul class="nav nav-pills nav-justified">
                            <li><a href="/RateYourOutfit/">Home</a></li>
                            <li><a href="/RateYourOutfit/upload">Upload</a></li>
                            <li><a href="/RateYourOutfit/uebersicht">Overview</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-2"></div>
                    <div class="col-sm-2">
                        <ul class="nav nav-pills nav-justified">
                            <li><li><a href="/RateYourOutfit/login">LogIn</a></li></li>
                        </ul>
                             
                    </div>
                    <div class="col-sm-2">
                         <p class="weiß" >Profilname | Scorepunktzahl</p>
                    </div>
                </div>
            </section>
        </header>
        <!-- Hauptinhalt der Seite -->
        <main>  
            
            
            <jsp:invoke fragment="main"/>
            
        </main>
        <footer>
        
        </footer>
    </body>
    
</html>
