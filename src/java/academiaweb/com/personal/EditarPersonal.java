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
@WebServlet(name = "EditarPersonal", urlPatterns = {"/EditarPersonal"})
public class EditarPersonal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int persid =  Integer.parseInt(request.getParameter("persid"));
       PersonalDao daops = new PersonalDao();
       Personal ps = daops.EditarPersonal(persid);
       
       request.setAttribute("personal", ps);
       
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Personal/EditarPersonal.jsp");
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
       int idP =  Integer.parseInt(request.getParameter("idP"));
       String nomeP = request.getParameter("txtnome");
       String cpf = request.getParameter("txtcpf");
       String telefone = request.getParameter("txttelefone");
       String data = request.getParameter("txtdata");
       float salario = Float.parseFloat(request.getParameter("txtsalario"));
       String sexo = request.getParameter("txtsexo");
       PersonalDao daops = new PersonalDao();
       Personal ps = new Personal(salario, idP, nomeP, cpf, telefone, data, sexo);
       
       if(daops.EditarPersonal2(ps)){
           response.sendRedirect("/AcademiaWeb/ListarPersonal");
       }else{
       request.setAttribute("personal", ps);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Personal/EditarPersonal.jsp");
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
