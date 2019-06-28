<%-- 
    Document   : InicioADM
    Created on : 28/05/2018, 11:20:06
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
        <title>inicio</title>
        <style>
            .fullscreen_bg {
                    position: fixed;
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
                <div role="separator"/>
                <div class="container-fluid" >
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
                  <div role="separator"/>
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
                    <div class="col-md-4"/>
                    <div class="col-md-4"/>
                  </div>

                    <div role="separator"/>
                </div><!-- /.container-fluid -->
              </nav>        
        </div>  
        
       
        <h1><p></p></h1>
        
            <br><br><br><br><br><br>
    
            <div class="container">
                <label>
                    Seja Bem Vindo  ao Nosso Sate
                </label>
            
            </div>    
       </div>
                     
    </body>
    <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
