/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.cliente;

import academiaweb.dao.AtividadesDao;
import academiaweb.dao.ClienteDao;
import academiaweb.entidades.Atividades;
import academiaweb.entidades.Boleto;
import academiaweb.entidades.Cliente;
import academiaweb.entidades.Ficha;
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
@WebServlet(name = "VisualizarCliente", urlPatterns = {"/VisualizarCliente"})
public class VisualizarCliente extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCle =  Integer.parseInt(request.getParameter("idest"));
        ClienteDao daoClie = new ClienteDao();
        AtividadesDao daoActv = new AtividadesDao();
        Cliente clie = daoClie.EditarCliente(idCle);
        List<Boleto> lt1 = daoClie.ListarBoletoClietente(idCle);
        List<Ficha> lt2 = daoClie.ListarAvaliacaoClietente(idCle);
        List<Atividades> lt3 = daoActv.ListarAtividadesClietente(idCle);
       
       request.setAttribute("cliente", clie);
       request.setAttribute("list1", lt1);
       request.setAttribute("list2", lt2);
       request.setAttribute("list3", lt3);
       
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Cliente/VisualizarCliente.jsp");
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
        //processRequest(request, response);
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
