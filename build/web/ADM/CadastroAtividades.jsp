<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : CadastroAtividades
    Created on : 26/05/2018, 21:51:26
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Atividade</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br><br><br>
        <div style="position: absolute; left: 200px;">
        <form action="AdicionarAtividade" method="POST">
            Nome:<input type="text" name="txtnome" value="" required="Preecha"/>
            <br><br>
            personal:
            <input type="submit" value="Cadastra" />
            <input type="hidden">
            <select name="f">
               for{
               <option></option>
                }
            </select>
        </form>
    </div>
                
    </body>
</html>
