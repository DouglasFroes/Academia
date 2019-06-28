<%-- 
    Document   : ErroUse
    Created on : 11/06/2018, 10:38:00
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
    
    <style>
        #bt{
            
                witch: 400px;
                margin-left: 400px;
                margin-rigth: auto;
                margin-top: 20px;
               }
    </style>
    
        <title>Home</title>
     
    </head>
    <body> 
        <div>
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
                    <a class="navbar-brand" href="${path}Index.jsp">Home</a>
                  </div>

                  <!-- Collect the nav links, forms, and other content for toggling -->
                  
                    
                      <div class="nav navbar-nav navbar-right">
                        <a href="${path}LoginJSP.jsp">
                            <input class="navbar-brand btn-primary" type="button" value="Login"/>
                           
                        </a>
                          <div class="col-md-4"/>
                          <div class="col-md-4"/>
                      </div>
                  </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
              </nav>
            
        </div>
        
         <div class="container">
            <nav class="nav navbar-brand"> 
        <p>Problema de altenticação</p>
            </nav>
        </div>
         </div>
    </body>
    <script type="text/javascript" src="${path}/jquery-3.3.1.min.js"></script>
     <script type="text/javascript" src="${path}/bootstrap/js/bootstrap.min.js"></script>
</html>
