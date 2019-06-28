<%-- 
    Document   : ListarAtividade
    Created on : 28/05/2018, 12:12:30
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
        <title>Atividades</title>
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
         <hr />
         <div class="container">
        <h1 style="color: seashell">Listar de Atividades de ${nome}<br></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <thead>
                <tr bgcolor="#DAB06F">
                    <td style="width: 20%">Atividade</td>
                    <td style="width: 20%">Personal</td>
                    <td style="width: 10%">Cancelar</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="ativ" items="${ListAC}" >
                <tr class="active">
                  <td>${ativ.nome}</td>
                  <td>${ativ.personal}</td> <td>
                      <a href="${path}/ListarAtividadesCliente?idAp=${ativ.id}"> 
                          <input class="btn btn-danger" type="button" value="Cancelar" />
                      </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr class="active">
                    <td>
                        Quantidade de Atividades:
                            <span >${ListAC.size()}</span>
                    </td>
                    <td colspan="2">
                        <a class="btn bg-primary btn-group-justified" href="${path}/AtividadesClientesAdicionarList"> 
                            <center>Adicionar Atividade</center>
                        </a>
                    </td>
                </tr>
            </tfoot>
        </table>
        </div>
        <br><br>
        <div class="container">
            
        </div>
        </div>
    </body>
     <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
