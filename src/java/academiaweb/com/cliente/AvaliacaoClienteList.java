/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.cliente;

import academiaweb.dao.AvaliadorDao;
import academiaweb.dao.ClienteDao;
import academiaweb.entidades.Avaliador;
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
@WebServlet(name = "AvaliacaoClienteList", urlPatterns = {"/AvaliacaoClienteList"})
public class AvaliacaoClienteList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (Integer)request.getSession().getAttribute("id");
        int idaca = (Integer)request.getSession().getAttribute("idAca");
        ClienteDao daoCliente = new ClienteDao();
        AvaliadorDao daoAva = new AvaliadorDao();
        
       // response.sendRedirect("Cliente/Atividades.jsp");
        List<Avaliador> lista = daoAva.ListraAvaliador(idaca);
       List<Ficha> ListFx = daoCliente.ListarAvaliacaoClietente(id);
        request.setAttribute("ListFx", ListFx);
        request.setAttribute("avalist", lista);
        RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/Cliente/Avaliacao.jsp");
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
