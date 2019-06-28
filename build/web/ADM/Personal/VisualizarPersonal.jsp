<%-- 
    Document   : Visualizar
    Created on : 05/06/2018, 00:57:10
    Author     : Douglas
--%>

<%@page import="academiaweb.entidades.Personal"%>
<%@page import="academiaweb.entidades.Atividades"%>
<%@page import="java.util.List"%>
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
        <title>Visualizar Personal</title>
        <style>
            .fullscreen_bg {
                    position: fidex;
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
                    <a class="navbar-brand" href="${path}/ADM/Cliente/CadastraClienteJSP">
                     Cadastra cliente
                    </a>
                    <!-- /Espaço -->
                    <div class="col-md-4"></div>
                    <div class="col-md-4"/></div>
                  </div>

                    
                </div><!-- /.container-fluid -->
              </nav>        
            </div> 
        
            <br><hr/><br>
        <%
            Personal ps = (Personal)request.getAttribute("personal");
        %>
        <div class="container">
        <h1><p>Persona<br></p></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <tr bgcolor="#BDB76B">
                <td>Nome</td>
                <td>Data nasc.</td>
                <td>Telefone</td>
                <td>CPF</td>
                <td>Salario</td>
                <td>Sexo</td>
            </tr >
           <tr bgcolor="#3DB700">
                <td><%=ps.getNome()%></td>
                <td><%=ps.getData_nasc()%></td>
                <td><%=ps.getTelefolone()%></td>
                <td><%=ps.getCpf()%></td>
                <td><%=ps.getSalario()%></td>
                <td><%=ps.getSexo()%></td>
        </tr>
        </table>
        </div>
        
        <br><hr/><br>
        
        <div class="container">
        <h1><p>Atividades Adiministradas<br></p></h1>
        
        <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
            <thead>
                <tr bgcolor="#BDB76B">
                    <td>Atividades</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="at" items="${listat}">
                <tr class="active">
                   <td>${at.nome}</td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr class="active">
                    <td >Personal Cadastrados :
                        <span id=>${listat.size()}</span>
                    </td>
                </tr>
                <tr>
                    <td class="active">
                        <form class="form-signin" action="${path}/VisualizarPersonal" method="POST">
                            <input type="hidden" name="idPe" value="<%=ps.getId()%>" />
                            <input type="text" name="txtnome" value="" placeholder="Adicionar Atividade" class="form-control"/>
                            <input type="submit" value="Adicionar"  class="btn btn-group-justified btn-success"/>
                        </form>
                    </td>
                </tr>
            </tfoot>
        </table>
        </div>
        <br><br><br><br>
        </div>
                    
    </body>
    <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
