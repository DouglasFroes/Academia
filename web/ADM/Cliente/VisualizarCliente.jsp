<%-- 
    Document   : VisualizarCliente
    Created on : 05/06/2018, 21:47:56
    Author     : Douglas
--%>

<%@page import="academiaweb.entidades.Boleto"%>
<%@page import="academiaweb.entidades.Ficha"%>
<%@page import="academiaweb.entidades.Atividades"%>
<%@page import="java.util.List"%>
<%@page import="academiaweb.entidades.Cliente"%>
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
        <title>Cliente</title>
        <style>
            .fullscreen_bg {
                    position: fixel;
                    top: 0;
                    right: 0;
                    bottom: 0;
                    left: 0;
                    background-size: cover;
                    background-position: 50% 50%;
                    background-image: url('https://i2.wp.com/barbaradoblog.com/wp-content/uploads/2016/10/academia-no-rio-de-janeiro-pre%C3%A7os.jpg?resize=1000%2C665');
                    background-repeat:repeat;
                  }
        </style>
    </head>
    <body>
        <div class="fullscreen_bg">
         <div>
            <nav class="navbar navbar-inverse">
                
                <div class="container-fluid">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                      <lu class="nav navbar-nav">
                      <li class="dropdown">
                          <div class="navbar-brand" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Academia ${nome}</div>
                      <ul class="dropdown-menu">
                          <li><a href="${path}/SairLogin?sair=true">Sair</a></li>
                        </ul>
                      </lu>
                  </div>
                  <div class="nav navbar-nav navbar-right" >
                   <button  type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${path}/ListarPersonal">
                        Personal
                    </a>
                    <a class="navbar-brand" href="${path}/ListarAvaliador">
                        Avaliador
                    </a>
                    <a class="navbar-brand" href="${path}/ListarEquipamento">
                        Equipamento
                    </a>
                    <a class="navbar-brand" href="${path}/ListarCliente">
                        Clientes
                    </a>
                    <a class="navbar-brand" href="${path}/ADM/Cliente/CadastraClienteJSP.jsp">
                     Cadastra cliente
                    </a>
                    <!-- /Espaço -->
                    <div class="col-md-4"></div>
                    <div class="col-md-4"/></div>
                  </div>

                    
                </div><!-- /.container-fluid -->
              </nav>        
            </div> 
    <br><br>
        <%
            Cliente clie = (Cliente)request.getAttribute("cliente");
        %>
         <hr />
        <h1><p>Cliente<br></p></h1>
        
        <div class="container">
            <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <tr bgcolor="#BDB76B">
                <td style="width: 20%">Nome</td>
                <td style="width: 10%">Login</td>
                <td style="width: 10%">Senha</td>
                <td style="width: 10%">Data nasc.</td>
                <td style="width: 10%">Telefone</td>
                <td style="width: 10%">CPF</td>
                <td style="width: 20%">Endereço</td>
                <td style="width: 10%">Sexo</td>
            </tr>
           <tr bgcolor="#7DB76B">
                <td><%=clie.getNome()%></td>
                <td><%=clie.getLogin()%></td>
                <td><%=clie.getSenha()%></td>
                <td><%=clie.getData_nasc()%></td>
                <td><%=clie.getTelefolone()%></td>
                <td><%=clie.getCpf()%></td>
                <td><%=clie.getEndereco()%></td>
                <td><%=clie.getSexo()%></td>
        </tr>
        </table>
        </div>
        
        <br><hr><br>
        
        <div class="container">[
        <h1><p>Listar de avaliacao de <%=clie.getNome()%><br></p></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <tr bgcolor="#DAB06F">
                <td style="width: 20%">Peso</td>
                <td style="width: 20%">Data da Avaliacao</td>
                <td style="width: 20%">Avaliador</td>
            </tr>
            <c:forEach var="fx"  items="${list2}">
         <tr class="active">
           <td>${fx.peso}</td>
           <td>${fx.data}</td>
           <td>${fx.nome}</td>
         </tr>
            </c:forEach>
        </table>
        </div>
        
        <br><hr><br>
        
        <div class="container">
        <h1><p>Listar de boletos de <%=clie.getNome()%><br></p></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <tr bgcolor="#DAB06F">
                <td style="width: 20%">Valor</td>
                <td style="width: 20%">Data de verncimento</td>
                <td style="width: 20%">Status</td>
            </tr>
            <c:forEach var="BL" items="${list1}">
         <tr class="active">
           <td>${BL.valor}</td>
           <td>${BL.data}</td>
           <td>${BL.status}</td>
          </tr>
        </c:forEach>
        </table>
        </div>
        
        <br><hr><br>
        
        <div class="container">
        <h1><p>Listar de Atividades de <%=clie.getNome()%><br></p></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <tr bgcolor="#DAB06F">
                <td style="width: 20%">Atividade</td>
                <td style="width: 20%">Personal</td>
            </tr>
            <c:forEach var="actv" items="${list3}">
         <tr class="active">
           <td>${actv.nome}</td>
           <td>${actv.personal}</td>
        </tr>
            </c:forEach>
        </table>
        </div>
        <br><br><br><br>
        </div>
    </body>
     <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
     <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
