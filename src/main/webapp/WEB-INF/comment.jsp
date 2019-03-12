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


        <c:forEach items="${comment}" var="kommentar" >
            <div>

                <c:out value="${kommentar.getText()}"/>

            </div>
        </c:forEach>
    </jsp:attribute>
</template:base>
