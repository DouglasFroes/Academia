/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.Avaliador;

import academiaweb.dao.AvaliadorDao;
import academiaweb.entidades.Avaliador;
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
@WebServlet(name = "ListarAvaliador", urlPatterns = {"/ListarAvaliador"})
public class ListarAvaliador extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id =(Integer)request.getSession().getAttribute("id");
        AvaliadorDao daoAvaliador = new AvaliadorDao();
        
        if(request.getParameter("idest")!=null){
            daoAvaliador.ExcluirAvaliador(Integer.parseInt(request.getParameter("idest")));
        }
        
       
        List<Avaliador> listarA = daoAvaliador.ListraAvaliador(id);
        request.setAttribute("Alistar", listarA);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Avaliador/Avaliador.jsp");
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
