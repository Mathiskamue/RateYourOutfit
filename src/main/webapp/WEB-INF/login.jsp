<%-- 
    Copyright © 2018 Dennis Schulmeister-Zimolong

    E-Mail: dhbw@windows3.de
    Webseite: https://www.wpvs.de/

    Dieser Quellcode ist lizenziert unter einer
    Creative Commons Namensnennung 4.0 International Lizenz.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


//Hier können sich die Benutzer auf der Seite anmelden 
<template:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="head">
        <%-- <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />--%>
    </jsp:attribute>

    

    <jsp:attribute name="main">
        <div class="container">
            <%--<form action="j_security_check" method="post" class="stacked">--%>
            <form method="POST">
                <div class="column">
                    <%-- Eingabefelder --%>
                    <label for="r_username">
                        Benutzername:
                        <span class="required">*</span>
                    </label>
                    <input type="text" name="r_username">

                    <label for="password">
                        Passwort:
                        <span class="required">*</span>
                    </label>
                    <input type="password" name="r_password">

                    <%-- Button zum Abschicken --%>
                    <button class="icon-login" type="submit">
                        Einloggen
                    </button>
                </div>
            </form>
        </div>
    </jsp:attribute>
</template:base>