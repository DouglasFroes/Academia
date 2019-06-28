/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.cliente;

import academiaweb.dao.AvaliadorDao;
import academiaweb.entidades.Ficha;
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
@WebServlet(name = "MarcaAvalivaoCliente", urlPatterns = {"/MarcaAvalivaoCliente"})
public class MarcaAvalivaoCliente extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
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
        int idava = Integer.parseInt(request.getParameter("txtavaliador"));
        float peso = Float.parseFloat(request.getParameter("txtpeso"));
        float altura = Float.parseFloat(request.getParameter("txtaltura"));
        String data = request.getParameter("txtdata");
        Ficha fx = new Ficha(id, altura, peso, data, idava);
        
        AvaliadorDao daoAva = new AvaliadorDao();
        
        if(daoAva.AdicionarAvalicaoClinete(fx)){
           response.sendRedirect("/AcademiaWeb/AvaliacaoClienteList");
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
