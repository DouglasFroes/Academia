<%-- 
    Document   : CadastraEquipamento
    Created on : 26/05/2018, 13:58:49
    Author     : Douglas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="modal-Equipamento" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
        <form action="${path}/AdicionarEquipamento" method="POST">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Cadastro de Equipamento</h4>
            </div>
            <div class="modal-body">
                <label>Nome:</label>
                <input type="text" name="txtnome" required="Preecha"/><br>
                <label>Valor:</label>
                <input type="text" name="txtvalor" required="Preecha"/><br>
                <label>Modelo:</label>
                <input type="text" name="txtmodelo" required="Preecha"/><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>               
                <button type="submit" class="btn btn-primary">Cadastra</button>
            </div>
        </form>
    </div>
  </div>
</div>