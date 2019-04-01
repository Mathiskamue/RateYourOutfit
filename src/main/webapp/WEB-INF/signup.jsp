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

<c:set var="base_url" value="<%=request.getContextPath()%>" />

<template:base>
    <jsp:attribute name="title">
        Registrierung
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="main">
        
    
        <div class="container">
            <form method="post" class="stacked">
                <div class="column">
                    <%-- CSRF-Token --%>
                    <input type="hidden" name="csrf_token" value="${csrf_token}">
                    
                    <div class="row">
                        <div class="col-sm-3">
                        </div>
                        <div class="col-sm-5 kasten">
                            <p></p>
                            <p></p>
                            <b class="kursiv"> RateYourOutfit </b>
                            <p></p>
                            <div class="row">
                             <div class="col-sm-4 login"> 
                                 <%-- Eingabefelder --%>
                                <label for="signup_username">
                                    <b>Benutzername:</b>
                                </label>
                             </div>
                                <div class="col-sm-3">
                                    <input class="suche" type="text" name="signup_username" value="${signup_form.values["signup_username"][0]}" placeholder="Benutzername...">
                                </div>
                            </div>
                            <div class="row">
                              <div class="col-sm-4 login"> 
                                 <%-- Eingabefelder --%>
                                <label for="signup_password1">
                                      <b>Passwort: <dfn title="Das Passwort muss mindestens sechs Zeichen beinhalten!"> &#9432 </dfn> </b>
                                </label>
                              </div>
                                <div class="col-sm-3">
                                    <input class="suche" type="password" name="signup_password1" value="${signup_form.values["signup_password1"][0]}" placeholder="Passwort..." >
                                </div>
                            </div>
                            
                            <div class="row">
                              <div class="col-sm-4 login"> 
                                 <%-- Eingabefelder --%>
                                <label for="signup_password2">
                                    <b>Passwort (wdh.): <dfn title="Das Passwort muss mindestens sechs Zeichen beinhalten!"> &#9432 </dfn></b>
                                </label>
                              </div>
                                <div class="col-sm-3">
                                    <input class="suche" type="password" name="signup_password2" value="${signup_form.values["signup_password2"][0]}" placeholder="Passwort wdl...">
                                </div>
                               
                            </div>
                            <div class="row">
                                <div class="col-sm-1 login">
                                    <button class="icon-pencil bu" type="submit">
                                        Registrieren
                                    </button>
                                </div>
                            </div>
                            <p> </p>
                            <div class="row">
                                <div class="menuitem col-sm-5 login">
                                    <p class="text">Zurück zum <a id="farbe" href="<c:url value="/logout/"/>">LogIn</a></p>
                                </div>
                            </div>
                        </div>
                    </div>

                <%-- Fehlermeldungen --%>
                <c:if test="${!empty signup_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${signup_form.errors}" var="error">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </c:if>
            </form>
        </div>
    </jsp:attribute>
</template:base>