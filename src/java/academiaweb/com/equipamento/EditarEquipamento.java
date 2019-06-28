/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.equipamento;

import academiaweb.dao.EquipamentosDao;
import academiaweb.entidades.Equipamentos;
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
@WebServlet(name = "EditarEquipamento", urlPatterns = {"/EditarEquipamento"})
public class EditarEquipamento extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       int Eqid =  Integer.parseInt(request.getParameter("Eqid"));
       
       EquipamentosDao daoEq = new EquipamentosDao();
       
       Equipamentos eq = daoEq.EditarEquipamento(Eqid);
       
       request.setAttribute("Equipamento", eq);
       
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Equipamento/EditarEquipamento.jsp");
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
       
       int idEq =  Integer.parseInt(request.getParameter("idE"));
       
       String nomeP = request.getParameter("txtnome");
       String modelo = request.getParameter("txtmodelo");
       Float valor = Float.parseFloat(request.getParameter("txtvalor"));
       
       EquipamentosDao daoEq =new EquipamentosDao();
        Equipamentos eq = new Equipamentos(idEq, nomeP, valor ,modelo);
       
       if(daoEq.EditarCliente2(eq)){
           response.sendRedirect("/AcademiaWeb/ListarEquipamento");
       }else{
       request.setAttribute("equipamento", eq);
       RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/Equipamentto/EditarEquipamento.jsp");
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

