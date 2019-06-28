/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.configuracaoSGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Home
 */
public class ConexaoBanco{
    
    public Connection getConexao(){
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://localhost/dbacademia","root", "0000");
        }catch(ClassNotFoundException ex){
                System.out.println("Erro na Mapeamento do Drivers mysql  !"+ex.getMessage());
        }catch(SQLException ex){
            System.out.println("Erro na conexao do Banco "+ex.getMessage());
            
        }
        
        return null;
    }
}
