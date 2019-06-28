<%-- 
    Document   : tab-clientes
    Created on : 06/06/2018, 23:40:09
    Author     : home
--%>
<%@page  import="academiaweb.entidades.Cliente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<table class="table table-haver table-condensed table-striped table-bordered" >
    <thead>
            <tr>
                   
                    <td style="width: 30%">Nome</td>
                    <td style="width: 9%">Login</td>
                    <td style="width: 9%">Senha</td>
                    <td style="width: 10%">Telefone</td>
                    <td style="width: 15%">Data Nascimento</td>
                    <td style="width: 10%">Cpf</td>
                    <td style="width: 10%">Endereço</td>
                    <td style="width: 10%">Sexo</td>
                    <td style="width: 10%">Editar</td>
                    <td style="width: 10%">Deletar</td>
            </tr>
    </thead>
    <tbody>
        <c:forEach items="${listaClientes}" var="cl">
            <tr data-id="${clientes.id_clientes}">
                <td>${cl.nome}</td>
                <td>${cl.login}</td>
                <td>${cl.senha}</td>
                <td>${cl.telefone}</td>
                <td> <fmt:formatDate pattern="dd/MM/yyyy" value="${cl.dataNascimento.time}"/> </td>
                <td>${cl.cpf}</td>
                <td>${cl.endereco}</td>
                <td>${cl.sexo}</td>
                
                <td> <button type="button" class="btn btn-primary" >Editar</button></td>
                <td><button type="button" class="btn btn-warning">Deletar</button></td>
            </tr>
        </c:forEach>


    </tbody>
    <tfoot>
            <tr>
                    <td colspan="10">Clientes Cadastrados :
                            <span id=>${listaClientes.size()}</span></td>
            </tr>
            <tr>
                    <td colspan="10">
                            <button type="button" class="btn btn-primary"
                                    data-toggle="modal" data-target="#modal-cliente">Cadastrar Cliente</button>
                    </td>
            </tr>
    </tfoot>
</table>
