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
@WebServlet(name = "EditarAvaliador", urlPatterns = {"/EditarAvaliador"})
public class EditarAvaliador extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int Avaid =  Integer.parseInt(request.getParameter("Avaid"));
       AvaliadorDao daoava = new AvaliadorDao();
       Avaliador ava = daoava.EditarAvaliador(Avaid);
       
       request.setAttribute("avaliador", ava);
       
       RequestDispatcher rd = request.getRequestDispatcher("ADM/Avaliador/EditarAvaliador.jsp");
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
       int idA =  Integer.parseInt(request.getParameter("idA"));
       
       String nomeP = request.getParameter("txtnome");
       String cpf = request.getParameter("txtcpf");
       String telefone = request.getParameter("txttelefone");
       String data = request.getParameter("txtdata");
       String sexo = request.getParameter("txtsexo");
       AvaliadorDao daoAva =new AvaliadorDao();
        Avaliador ava = new Avaliador(idA, nomeP, cpf, telefone, data, sexo);
       
       if(daoAva.EditarPersonal2(ava)){
           response.sendRedirect("/AcademiaWeb/ListarAvaliador");
       }else{
       request.setAttribute("avaliador", ava);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Avaliadorl/EditarAvaliador.jsp");
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
