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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "EditarCliente", urlPatterns = {"/EditarCliente"})
public class EditarCliente extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int Clieid =  Integer.parseInt(request.getParameter("Clieid"));
       ClienteDao daoClie = new ClienteDao();
       Cliente clie = daoClie.EditarCliente(Clieid);
       
      request.setAttribute("cliente", clie);
       
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Cliente/EditarCliente.jsp");
       rd.forward(request, response);
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
       int idC =  Integer.parseInt(request.getParameter("idC"));
       String nomeP = request.getParameter("txtnome");
       String login = request.getParameter("txtlogin");
       String senha = request.getParameter("txtsenha");
       String endereco = request.getParameter("txtendereco");
       String cpf = request.getParameter("txtcpf");
       String telefone = request.getParameter("txttelefone");
       String data = request.getParameter("txtdata");
       String sexo = request.getParameter("txtsexo");
       ClienteDao daoClie = new ClienteDao();
       Cliente clie = new Cliente(login, senha, endereco, idC, nomeP, cpf, telefone, data, sexo);
       
       if(daoClie.EditarCliente2(clie)){
           response.sendRedirect("/AcademiaWeb/ListarCliente");
       }else{
       request.setAttribute("cliente", clie);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Cliente/EditarCliente.jsp");
        rd.forward(request, response);
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
