/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.com.autenticacao;

import academiaweb.dao.AutenticarDao;
import academiaweb.entidades.InformaçoesUsuario;
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
@WebServlet(name = "Autenticacao", urlPatterns = {"/Autenticacao"})
public class Autenticacao extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("txtlogin");
        String senha = request.getParameter("txtsenha");
        
        InformaçoesUsuario use =new InformaçoesUsuario(login, senha);
        AutenticarDao daoAtenticar = new AutenticarDao();
        InformaçoesUsuario user1 = daoAtenticar.autenticar01(use);
        InformaçoesUsuario user2 = daoAtenticar.autenticar02(use);
        if(user1!=null){
            //response.sendRedirect("ADM/InicioADM.jsp");
            request.getSession().setAttribute("nome", user1.getNome());
            request.getSession().setAttribute("id", user1.getId());
            RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/ADM/InicioADM.jsp");
            rd.forward(request, response);
        }else if(user2!=null){
            request.getSession().setAttribute("nome", user2.getNome());
            request.getSession().setAttribute("id", user2.getId());
            request.getSession().setAttribute("idAca", user2.getIdaca());
            RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/Cliente/InicoClieteJSP.jsp");
            rd.forward(request, response);
            // response.sendRedirect("Cliente/InicoClieteJSP.jsp");
        }else{
            request.setAttribute("inf", "Nâo foi possivel fazer login.");
            RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher("/LoginJSP.jsp");
            rd.forward(request, response);
       // response.sendRedirect("LoginJSP.jsp?inf=Nâo foi possivel fazer login.");
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
