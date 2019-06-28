/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.cliente;

import academiaweb.dao.ClienteDao;
import academiaweb.entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "CadastraCliente", urlPatterns = {"/CadastraCliente"})
public class CadastraCliente extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int id = (Integer)request.getSession().getAttribute("id");
        String nome = request.getParameter("txtnome");
        String login = request.getParameter("txtlogin");
        String senha = request.getParameter("txtsenha");
        String cpf = request.getParameter("txtcpf");
        String telefone = request.getParameter("txttelefone");
        String endereco = request.getParameter("txtendereco");
        String data = request.getParameter("txtdata");
        String sexo = request.getParameter("txtsexo");
        Cliente cliente = new Cliente(login,senha,endereco,nome,cpf,telefone,data,sexo,id);
        ClienteDao daocliente = new ClienteDao();
        
        if(daocliente.CadastraCliente(cliente)){
             out.println("cadastrado com sucesso!!!");
             response.sendRedirect("/AcademiaWeb/ListarCliente");
            //response.sendRedirect("index");
        }else{
        out.println("erooo");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
