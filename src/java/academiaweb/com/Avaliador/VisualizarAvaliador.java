/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.Avaliador;

import academiaweb.dao.AvaliadorDao;
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
@WebServlet(name = "VisualizarAvaliador", urlPatterns = {"/VisualizarAvaliador"})
public class VisualizarAvaliador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       int idava =  Integer.parseInt(request.getParameter("idava"));
       AvaliadorDao daoAva = new AvaliadorDao();
       Avaliador ava = daoAva.EditarAvaliador(idava);
       List <Ficha> lt = daoAva.ListraConsutas(idava);
       
       request.setAttribute("avaliador", ava);
       request.setAttribute("listCon", lt);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Avaliador/VisualizarAvaliador.jsp");
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
