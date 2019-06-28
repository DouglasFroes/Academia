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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "AdicionarEquipamento", urlPatterns = {"/AdicionarEquipamento"})
public class AdicionarEquipamento extends HttpServlet {

 
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
            int id = (Integer)request.getSession().getAttribute("id");
            
            String nome = request.getParameter("txtnome");
            float valor = Float.parseFloat(request.getParameter("txtvalor"));
            String modelo = request.getParameter("txtmodelo");
            
           Equipamentos equipamento = new Equipamentos(nome, valor, modelo, id);
           EquipamentosDao equiDao = new EquipamentosDao();
           
           if(equiDao.CadastraEquipamento(equipamento)){
            out.println("cadastrado com sucesso!!!");
            response.sendRedirect("/AcademiaWeb/ListarEquipamento");
          }else{
               out.println("<h1>erro nao foi possivel realizar o cadastro</h1>");
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
