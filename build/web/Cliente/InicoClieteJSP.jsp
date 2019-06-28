<%-- 
    Document   : InicoClieteJSP
    Created on : 28/05/2018, 11:18:52
    Author     : Douglas
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set value="${pageContext.request.contextPath}" var="path" scope="request"/>
        <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.css" >
        <style  type="text/css">
            @import uri("${path}/bootstrap/css/bootstrap.min.css");
            @import uri("${path}/bootstrap/css/bootstrap-theme.min.css");
        </style>
        <title>Home</title>
        <style>
            .fullscreen_bg {
                    position: fixed;
                    top: 0;
                    right: 0;
                    bottom: 0;
                    left: 0;
                    background-size: cover;
                    background-position: 50% 50%;
                    background-image: url('http://performanceacademia.com.br/wp-content/uploads/2018/04/xfitness-background.jpg.pagespeed.ic_.gPLL9SM3lK-1024x639.jpg');
                    background-repeat:repeat;
                  }
        </style>
    </head>
    <body>
        <div class="fullscreen_bg">
            <jsp:include page="Navbar.jsp"/>
            <div class="container center-block">
                <center>
                    <h1 style="color: seashell">Seja bem vindo ${nome}</h1>
                </center>
            </div>
        
        </div>
    </body>
    <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
