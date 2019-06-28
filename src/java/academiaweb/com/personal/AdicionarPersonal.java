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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "AdicionarPersonal", urlPatterns = {"/AdicionarPersonal"})
public class AdicionarPersonal extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
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
        int id = (Integer)request.getSession().getAttribute("id");
        String nome = request.getParameter("txtnome");
        float salario = Float.parseFloat(request.getParameter("txtsalario"));
        String cpf = request.getParameter("txtcpf");
        String telefone = request.getParameter("txttelefone");
        String data = request.getParameter("txtdata");
        String sexo = request.getParameter("txtsexo");
        
        Personal personal = new Personal(salario, nome, cpf, telefone, data, sexo,id);
        PersonalDao daoPersonal = new PersonalDao();
        
        if(daoPersonal.CadastraPersonal(personal)){
            out.println("cadastrado com sucesso!!!");
           response.sendRedirect("/AcademiaWeb/ListarPersonal");
         }else{
            out.println("errooo");
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
