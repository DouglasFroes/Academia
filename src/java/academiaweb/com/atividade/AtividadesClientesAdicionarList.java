/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.atividade;

import academiaweb.dao.AtividadesDao;
import academiaweb.entidades.Atividades;
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
@WebServlet(name = "AtividadesClientesAdicionarList", urlPatterns = {"/AtividadesClientesAdicionarList"})
public class AtividadesClientesAdicionarList extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       AtividadesDao daoActv = new AtividadesDao();
       
          int id = (Integer)request.getSession().getAttribute("id");

       
        List<Atividades> ACList = daoActv.ListarAdicionarAtividadesClietente(id);
        request.setAttribute("List", ACList);
        RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/Cliente/AdicionarAtividade.jsp");
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
         AtividadesDao daoActv = new AtividadesDao();
          int id = (Integer)request.getSession().getAttribute("id");

       
        List<Atividades> ACList = daoActv.ListarAdicionarAtividadesClietente(id);
        request.setAttribute("ListAC", ACList);
        RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/Cliente/AdicionarAtividade.jsp");
        rd.forward(request, response);
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
