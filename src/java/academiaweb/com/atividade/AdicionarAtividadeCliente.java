/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.atividade;

import academiaweb.dao.AtividadesDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "AdicionarAtividadeCliente", urlPatterns = {"/AdicionarAtividadeCliente"})
public class AdicionarAtividadeCliente extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int id = (Integer)request.getSession().getAttribute("id");

        int id_ativ = Integer.parseInt(request.getParameter("idActv"));
       
        
        AtividadesDao daoActv = new AtividadesDao();
        if(daoActv.CadastraAtividadeCliente(id, id_ativ)){
                response.sendRedirect("/AcademiaWeb/ListarAtividadesCliente");
        }else{
            out.println("erro, nao foi possivel adivionar ativade:"+id+": " +id_ativ);
        }
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

        int id_ativ = Integer.parseInt(request.getParameter("idActv"));
       
        
        AtividadesDao daoActv = new AtividadesDao();
        if(daoActv.CadastraAtividadeCliente(id, id_ativ)){
                response.sendRedirect("/ListarAtividadesCliente");
        }else{
            out.println("erro, nao foi possivel adivionar ativade:"+id+": " +id_ativ);
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
