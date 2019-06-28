package academiaweb.com.personal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import academiaweb.dao.AtividadesDao;
import academiaweb.dao.PersonalDao;
import academiaweb.entidades.Atividades;
import academiaweb.entidades.Personal;
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
@WebServlet(urlPatterns = {"/VisualizarPersonal"})
public class VisualizarPersonal extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int persid =  Integer.parseInt(request.getParameter("persid"));
       PersonalDao daops = new PersonalDao();
       Personal ps = daops.EditarPersonal(persid);
       List<String> lt = daops.ListarPersonalAtividades(persid);
       
       request.setAttribute("personal", ps);
       request.setAttribute("listat", lt);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Personal/VisualizarPersonal.jsp");
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
        PrintWriter out = response.getWriter();
       int persid =  Integer.parseInt(request.getParameter("idPe"));
       String nomeA = request.getParameter("txtnome");
       PersonalDao daops = new PersonalDao();
       Personal ps = daops.EditarPersonal(persid);
       
       
       Atividades at = new Atividades(nomeA, persid);
       
     
       AtividadesDao daoActiv = new AtividadesDao();
        if(daoActiv.cadastraAtividade(at)){
            List<String> lt = daops.ListarPersonalAtividades(persid);
       request.setAttribute("personal", ps);
       request.setAttribute("listat", lt);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Personal/VisualizarPersonal.jsp");
       rd.forward(request, response);
        }else{
             out.println("erro");
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
