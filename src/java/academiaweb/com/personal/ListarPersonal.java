/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.personal;

import academiaweb.dao.PersonalDao;
import academiaweb.entidades.Personal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ListarPersonal", urlPatterns = {"/ListarPersonal"})
public class ListarPersonal extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PersonalDao daoPersonal =new PersonalDao();
        int id = (Integer)request.getSession().getAttribute("id");
        
        if(request.getParameter("idapgar")!=null){
            daoPersonal.ExcluirEquipamento(Integer.parseInt(request.getParameter("idapgar")));
        }
        
        List<Personal> listarP= daoPersonal.ListarPersonal(id);
        request.setAttribute("Plistar", listarP);
        RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Personal/Personal.jsp");
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
