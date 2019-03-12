<%-- 
    Document   : upload
    Created on : 12.03.2019, 10:22:14
    Author     : mathi
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Picture-Upload</title>
    </head>
    <body>
        <h1>Hier kannst du dein Bild hochladen!</h1>
        <form method="POST" enctype="multipart/form-data">
                <input type="text" name="beschreibung" placeholder="Dein Text" value="${bild_form.beschreibung}"/>
                <input type="file" name="picture" />
                <button type="submit">Abschicken</button>
        </form>
    </body>
</html>