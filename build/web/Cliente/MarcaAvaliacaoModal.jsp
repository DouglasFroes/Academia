<%-- 
    Document   : MarcaAvaliaçaoModal
    Created on : 06/06/2018, 21:08:23
    Author     : Douglas
--%>
<%@page import="academiaweb.entidades.Avaliador"%>
<%@page import="java.util.List"%>
<%@page import="academiaweb.dao.AvaliadorDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="MarcaAvaliacaoModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
        <form action="http://localhost:8080/AcademiaWeb/MarcaAvalivaoCliente" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Marca Avalição</h4>
      </div>
      <div class="modal-body">
          
       <label>Peso: </label>
       <input type="text" name="txtpeso" required="Preecha"/>
       <br/>
       <label>Altura: </label>
       <input type="text" name="txtaltura" required="Preecha"/>
       <br/>
       <label>Data: </label>
       <input type="date" name="txtdata" required="Preecha"/>
       <br/>
       <select name="txtavaliador">
        <c:forEach var="ava" items="${avalist}">
        <option value="${ava.id}">${ava.nome}</option>
        </c:forEach>
       </select>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Marca consulta</button>
      </div>
        </form>    
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

