<%-- 
    Document   : CadastraPersonal
    Created on : 26/05/2018, 20:38:23
    Author     : Douglas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="modal-cadastrapersonal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
        <form action="${path}/AdicionarPersonal" method="POST">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Cadastro de Personal</h4>
            </div>
            <div class="modal-body">
                <label>Nome:</label>
                <input type="text" name="txtnome" value="" required="Preecha"/>
            </div>
            <div class="modal-body">
                <label>CPF:</label>
                <input type="text" name="txtcpf" value="" required="Preecha"/>
            </div>
            <div class="modal-body">
                <label>Data Nasc:</label>
                <input type="date" name="txtdata" required="Preecha"/>
            </div>
            <div class="modal-body">
                <label>Salario:</label>
                <input type="text" name="txtsalario" value="" required="Preecha"/>
            </div>
            <div class="modal-body">
                <label>Telefone:</label>
                <input type="text" name="txttelefone" value="" required="Preecha"/>
            </div>
            <div class="modal-body">
                <label>Sexo:</label>
                <select name="txtsexo">
                    <option>Masculino</option>
                    <option>Femenino</option>
                </select>
            </div>
             <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-default" />Cadastra</button>
             </div>
      </form>
    </div>
  </div>
</div>