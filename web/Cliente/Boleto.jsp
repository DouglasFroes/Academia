<%-- 
    Document   : Boleto
    Created on : 01/06/2018, 19:23:14
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
        <title>Boleto</title>
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
         
            <div class="container">
        <hr />
        <h1 style="color: seashell">Listar de boletos de ${nome}<br></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <thead>
                <tr bgcolor="#DAB06F">
                    <td style="width: 20%">Valor</td>
                    <td style="width: 20%">Data de verncimento</td>
                    <td style="width: 20%">Status</td>
                    <td style="width: 10%">Imprime</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="blt" items="${ListBL}">
                    <tr class="active">
                  <td>${blt.valor}</td>
                  <td>${blt.data}</td>
                  <td>${blt.status}</td>
                  <td><a href=""><input class="btn btn-primary" type="button" value="Imprime" /></a></td>
                </tr>
               </c:forEach>
            </tbody>
        </table>
        <br><br>
        
        </div>
        </div>
    </body>
</html>
        