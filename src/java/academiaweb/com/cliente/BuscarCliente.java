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
import java.util.List;
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
@WebServlet(name = "BuscarCliente", urlPatterns = {"/BuscarCliente"})
public class BuscarCliente extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out= response.getWriter();

        
  
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
        PrintWriter out= response.getWriter();
        String nomeC = request.getParameter("txtnome");
        int id = (Integer)request.getSession().getAttribute("id");
        
        ClienteDao daoCliente = new ClienteDao();
             List<Cliente> clienteList =  daoCliente.BuscaCliente(nomeC);
        
        if(clienteList.isEmpty()){
            List<Cliente> listarC= daoCliente.ListarCliente(id);
        request.setAttribute("Clistar", listarC);
        RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Cliente/Cliente.jsp?busc=Nao encontrado");
        rd.forward(request, response);
           // response.sendRedirect("ADM/Cliente/Cliente.jsp?busc=Nao encontrado");
        }else{
            //response.sendRedirect("ADM/Cliente/oi.jsp?busc=fescura");
        request.setAttribute("Clistar", clienteList);
        RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Cliente/Cliente.jsp");
        rd.forward(request, response);
        }
        // String nome = request.getParameter("txtnome");
//        
//        ClienteDao daoCliente = new ClienteDao();
//        
//        List<Cliente> listarC= daoCliente.ListarCliente();
//        request.setAttribute("Clistar", listarC);
//        RequestDispatcher rd = request.getRequestDispatcher("ADM/Cliente/BuscarCliente.jsp");
//        rd.forward(request, response);       
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
