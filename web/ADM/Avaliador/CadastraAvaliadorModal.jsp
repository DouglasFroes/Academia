<%-- 
    Document   : cadastraAvaliador
    Created on : 26/05/2018, 13:51:31
    Author     : Douglas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="modal-Avaliador" class="modal fade" data-backdrop="static" tabindex="-1" role="dialog" >
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
        <form action="${path}/AdiciionarAvaliador" method="POST">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Cadastro de Avaliador</h4>
            </div>
            <div class="modal-body">
                <label>Nome:</label>
                <input type="text" name="txtnome" value="" required="Preecha"/><br><br>
          
                <label>CPF:</label>
                <input type="txt" name="txtcpf" value="" required="Preecha"/><br><br>
            
                <label>Telefone:</label>
                <input type="text" name="txttelefone" value="" required="Preecha"/><br><br>
            
                <label>Data de Nasc:</label>
                <input type="date" name="txtdatanasc" value="" required="Preecha"/><br><br>
            
                <label>Sexo:</label>
                <select name="txtsexo">
                    <option>Masculino</option>
                    <option>Femenino</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>               
                <button type="submit" class="btn btn-primary">Cadastra</button>
            </div>
        </form>
     </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>