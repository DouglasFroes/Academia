<%-- 
    Document   : IditarPersonal
    Created on : 04/06/2018, 14:40:22
    Author     : Douglas
--%>

<%@page import="academiaweb.entidades.Personal"%>
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
        <title>Atualizar Personal</title>
        <style>
            .fullscreen_bg {
                    position: absolute;
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
        
        
        <%
            Personal pers = (Personal)request.getAttribute("personal");
        %>
        <div class="container">
            <form action="${path}/EditarPersonal" method="POST" class="form-inline">
               <div class="modal-header">
                    <h2 class="modal-title" style="color: cornsilk">
                        <center>Editar Personal</center>
                    </h2>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="idP" value="<%=pers.getId()%>" /> 
                    <br>
                    <label style="color: cornsilk">
                        Nome:
                    </label>
                    <input type="text" name="txtnome" value="<%=pers.getNome()%>" required="Preecha"/><br><br>
                    <label style="color: cornsilk">
                        Telefone:
                    </label>
                    <input type="text" name="txttelefone" value="<%=pers.getTelefolone()%>" required="Preecha"/><br><br>
                    <label style="color: cornsilk">
                        CPF:
                    </label>
                    <input type="text" name="txtcpf" value="<%=pers.getCpf()%>" required="Preecha"/><br><br>
                    <label style="color: cornsilk">
                        Salario:
                    </label>
                    <input type="text" name="txtsalario" value="<%=pers.getSalario()%>" required="Preecha"/><br><br>
                    <label style="color: cornsilk">
                        Data Nasc:
                    </label>
                    <input type="date" name="txtdata" value="<%=pers.getData_nasc()%>" required="Preecha"/><br><br>
                    <label style="color: cornsilk">
                        Sexo:
                    </label>
                    <select name="txtsexo">
                        <option><%=pers.getSexo()%></option>
                        <option>Masculono</option>
                        <option>Femenino</option>
                    </select><br><br>
                </div>
                <div class="modal-footer">
                    <a href="${path}/ListarPersonal">
                        <button type="button" class="btn btn-default" style="width: 40%">
                               Cancelar    
                        </button>
                    </a>
                    <button class="btn btn-success" type="submit" style="width: 50%">
                        Editar
                    </button>
                </div>
            </form>
        </div>
        </div>
    </body>
    <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
