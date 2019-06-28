<%-- 
    Document   : modal-academia
    Created on : 05/06/2018, 21:40:14
    Author     : home
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="modal_academia" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modal_academia" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
        <form action="CadastraAcademia" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Cadastro de Academia</h4>
      </div>
      <div class="modal-body">
       <label>Nome: </label>
       <input type="text" name="txtnome" required="Preecha"/>
       <br/>
       <label>Endereço: </label>
       <input type="text" name="txtendereco" required="Preecha"/>
       <br/>
       <label>Login: </label>
       <input type="text" name="txtlogin" required="Preecha"/>
       <br/>
       <label>Senha: </label>
       <input type="password" name="txtsenha" required="Preecha"/>
       <br/>
       <label>Telefone: </label>
       <input type="text" name="txttelefone" required="Preecha"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Salvar Academia</button>
      </div>
        </form>    
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
