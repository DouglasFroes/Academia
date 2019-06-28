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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "AdiciionarAvaliador", urlPatterns = {"/AdiciionarAvaliador"})
public class AdiciionarAvaliador extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
       
       
       int id =(Integer)request.getSession().getAttribute("id");
       
       String nome = request.getParameter("txtnome");
       String cpf = request.getParameter("txtcpf");
       String telefone = request.getParameter("txttelefone");
       String data_nasc = request.getParameter("txtdatanasc");
       String sexo = request.getParameter("txtsexo");
       
       Avaliador avaliador = new Avaliador(nome, cpf, telefone, data_nasc, sexo, id);
       AvaliadorDao daoAvaliador= new AvaliadorDao();
       
       if(daoAvaliador.CadastraAvaliador(avaliador)){
           out.println("cadastrado com sucesso!!!");
           response.sendRedirect("/AcademiaWeb/ListarAvaliador");
       }else{
        out.println("erro!!"+id);
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
