<%-- 
    Document   : Cliente
    Created on : 28/05/2018, 17:56:50
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
        <title>JSP Page</title>
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
                  <div class="navbar-header">
                      <form class="navbar-form navbar-left" action="http://localhost:8080/AcademiaWeb/BuscarCliente" method="POST">
                        <div class="form-group">
                            <input class="form-control" type="text" name="txtnome" required="preencha" placeholder="Nome cliente"/>
                        </div>
                        <button type="submit" class="btn btn-default" >Buscar</button>
                    </form>
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
        
        
         <%
            if(request.getParameter("busc")!=null){
        out.println(request.getParameter("busc"));}
       %>

        
        <hr />
        <div class="container">
            <h1><p>Listar de Clientes Cadastrados<br></p></h1>
        </div>
        <div class="container">
            <table class="table table-dark table-bordered table-hover" style='border-color:blue;border-width: 1px; border-style: solid;'>
                <thead>
                    <tr bgcolor="#BDB76B">
                        <td style="width: 30%">Nome</td>
                        <td style="width: 20%">Telefone</td>
                        <td style="width: 10%">Editar</td>
                        <td style="width: 10%">Apagar</td>
                        <td style="width: 10%">Visualizar</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${Clistar}">
                    <tr class="active">
                       <td>${cliente.nome}</td>
                       <td>${cliente.telefolone}</td>
                       <td><a href="${path}/EditarCliente?Clieid=${cliente.id}">
                               <input class="btn btn-primary" type="button" value="Editar" />
                           </a>
                       </td>
                       <td><a href="${path}/ListarCliente?idest=${cliente.id}">
                               <input class="btn btn-danger" type="button" value="Apagar" />
                           </a>
                       </td>
                       <td><a href="${path}/VisualizarCliente?idest=${cliente.id}">
                               <input class="btn btn-info" type="button" value="Visualizar" />
                           </a></td>
                    </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr class="active">
                        <td colspan="5">Clientes Cadastrados :
                            <span id=>${Clistar.size()}</span>
                        </td>
                    </tr>
                </tfoot>

            </table>
            <br><br>
        </div>
         
        
    </body>
    <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
