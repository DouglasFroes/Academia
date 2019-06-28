<%-- 
    Document   : Navbar
    Created on : 10/06/2018, 21:55:10
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                          <div class="navbar-brand" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario: ${nome}</div>
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
                    
                    <a class="navbar-brand" href="${path}/Cliente/InicoClieteJSP.jsp">
                        Home
                    </a>
                    <a class="navbar-brand" href="${path}/ListarAtividadesCliente">
                        Atividades
                    </a>
                    <a class="navbar-brand" href="${path}/BoletoClienteList">
                        Boleto
                    </a>
                    <a class="navbar-brand" href="${path}/AvaliacaoClienteList">
                        Avaliação
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