<%-- 
    Document   : Avaliação
    Created on : 01/06/2018, 19:23:53
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
                    position: absolute;
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
            
        <br><br>
       
        <div class="container">
        <hr />
        <h1 style="color: seashell">Listar de avaliacao de ${nome}<br></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <thead>
                <tr bgcolor="#DAB06F">
                <td style="width: 20%">Altura</td>
                <td style="width: 20%">Peso</td>
                <td style="width: 20%">Data da Avaliacao</td>
                <td style="width: 20%">Avaliador</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="fx" items="${ListFx}">
                    <tr class="active">
                  <td>${fx.altura}</td>
                  <td>${fx.peso}</td>
                  <td>${fx.data}</td>
                  <td>${fx.nome}</td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr class="active">
                    <td colspan="2">
                        Quantidade de Avaliação:
                            <span >${ListFx.size()}</span>
                    </td>
                    <td colspan="2">
                       <jsp:include page="MarcaAvaliacaoModal.jsp"/>
                       <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#MarcaAvaliacaoModal">
                            Marca Avalição
                       </button>
                    </td>
                </tr>
            </tfoot>
        </table>
        <br>
        </div>
           
        <br><br>
        
        </div>
    </body>
    <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
     <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>

