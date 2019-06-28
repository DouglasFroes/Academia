<%-- 
    Document   : AdicionarCliente
    Created on : 25/05/2018, 20:26:44
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
        <title>Cadastro de cliete</title>
        <style>
            .form-login {
                    background-color: #CAF00D;
                    padding-top: 10px;
                    padding-bottom: 20px;
                    padding-left: 50px;
                    padding-right: 50px;
                    border-radius: 20px;
                    border-color:#d2d2d2;
                    border-width: 15px;
                    box-shadow:1px 2px 0 #cfcfcf;
                }
                .container {
                    padding: 20px;
                    position: fixed;
                        }
                .form-control {
                     border-radius: 10px;
                    }
                .wrapper {
                   text-align: center;
                    }
                body {
                    padding-top: 0px;
                    padding-bottom: 40px;
                    background-color: #eee;
                }    
            .fullscreen_bg {
                    position: absolute;
                    top: 0;
                    right: 0;
                    bottom: 0;
                    left: 0;
                    background-size: cover;
                    background-position: 50% 50%;
                    background-image: url('https://image.freepik.com/fotos-gratis/menina-sentada-em-fitball-na-academia_23-2147688105.jpg');
                    background-repeat:repeat;
                  }
        </style>
    </head>
    <body>
         <% 
          String nome = "nome";// (String)request.getParameter("nome");
          int id =1;// Integer.parseInt(request.getParameter("id"));
         %>
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
                          <div class="navbar-brand" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Academia <%=nome%></div>
                      <ul class="dropdown-menu">
                          <li><a href="http://localhost:8080/AcademiaWeb/Index.jsp">Sair</a></li>
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
                    <a class="navbar-brand" href="http://localhost:8080/AcademiaWeb/ListarPersonal?nome=<%=nome%>&id=<%=id%>">
                        Personal
                    </a>
                    <a class="navbar-brand" href="http://localhost:8080/AcademiaWeb/ListarAvaliador?nome=<%=nome%>&id=<%=id%>">
                        Avaliador
                    </a>
                    <a class="navbar-brand" href="http://localhost:8080/AcademiaWeb/ListarEquipamento?nome=<%=nome%>&id=<%=id%>">
                        Equipamento
                    </a>
                    <a class="navbar-brand" href="http://localhost:8080/AcademiaWeb/ListarCliente?nome=<%=nome%>&id=<%=id%>">
                        Clientes
                    </a>
                    <a class="navbar-brand" href="http://localhost:8080/AcademiaWeb/ADM/Cliente/CadastraClienteJSP.jsp?nome=<%=nome%>&id=<%=id%>">
                     Cadastra cliente
                    </a>
                    <!-- /Espaço -->
                    <div class="col-md-4"></div>
                    <div class="col-md-4"/></div>
                  </div>

                    
                </div><!-- /.container-fluid -->
              </nav>        
            </div>
          
           <div class="container">
              <div class="row">
                <div class="col-md-offset-5 col-md-3">
                    <form class="form-login" action="http://localhost:8080/AcademiaWeb/CadastraCliente" method="POST">
                        <h4>Cadastro de Cliente</h4>
                        <input type="hidden" name="nome" value="${nome}" />
                        <input type="hidden" name="id" value="${id}" />
            Nome: <input  type="text" name="txtnome" required="Preecha" class="form-control input-sm chat-input" />
            Login: <input type="text" name="txtlogin" required="Preecha" class="form-control input-sm chat-input" />
            Senha: <input type="password" name="txtsenha" required="Preecha" class="form-control input-sm chat-input" />
            CPF: <input type="text" name="txtcpf" required="Preecha" class="form-control input-sm chat-input" />
            Telefone: <input type="text" name="txttelefone" required="Preecha" class="form-control input-sm chat-input" />
            Endereço: <input type="text" name="txtendereco" required="Preecha" class="form-control input-sm chat-input" />
            Data Nasc:<input type="date" name="txtdata" required="Preecha" class="form-control input-sm chat-input"/>
            Sexo:<select name="txtsexo" class="form-control input-sm chat-input">
                    <option>Masculino</option>
                    <option>Femenino</option>
                </select><br><br>
                
                  
            <input type="submit" value="Cadastra" class="btn btn-primary btn-md" /><br>
                
        </form> 
                </div>
              </div>
           </div>
        </div>
    </body>
     <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
     <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
