<%-- 
    Copyright © 2018 Dennis Schulmeister-Zimolong

    E-Mail: dhbw@windows3.de
    Webseite: https://www.wpvs.de/

    Dieser Quellcode ist lizenziert unter einer
    Creative Commons Namensnennung 4.0 International Lizenz.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%

    session = request.getSession();
    String username = request.getParameter("j_username");
    session.setAttribute("session_username", username);
%>

<template:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="main">
        

        <div class="container">
            <form action="j_security_check" method="get" class="stacked">
                
                    <div class="row">
                        <div class="col-sm-3">
                        </div>
                        <div class="col-sm-5 kasten">
                            <p></p>
                            <p></p>
                            <b class="kursiv"> RateYourOutfit </b>
                            <p></p>
                        <div class="row">
                            <div class="col-sm-3 login"> 
                            <%-- Eingabefelder --%>
                            <label for="j_username">
                            <b>Benutzername:</b>
                            </label>
                            </div>
                            <div class="col-sm-3">
                            <input class="suche" type="text" name="j_username" placeholder="Benutzername...">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3 login"> 
                            <label for="j_password">
                                <b>Passwort: </b>
                            </label> 
                            </div>
                            <div class="col-sm-3">
                                <input class="suche" type="password" name="j_password" placeholder="Passwort...">
                            </div>
                        </div>
                        <div class="row">
                          <div class="col-sm-1 login">
                        <%-- Button zum Abschicken --%>
                        <button class="icon-login bu " type="submit">
                            Einloggen
                        </button> 
                            </div>
                            </div>
                        <p> </p>
                        <div class="row">
                                <div class="col-sm-1 login">
                        <%-- Button zum Abschicken --%>
                        <a href="/RateYourOutfit/signup/" class="button">Registrieren</a>
                            </div>
                            </div>
                        <p></p>
                        </div>
                        <div class="col-sm-4">
                        </div>
                    </div>
                </form>
            

        </div>

    </jsp:attribute>
</template:base>
