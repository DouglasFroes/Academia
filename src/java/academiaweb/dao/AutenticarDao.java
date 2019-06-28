package academiaweb.dao;


import academiaweb.configuracaoSGBD.ConexaoBanco;
import academiaweb.entidades.InformaçoesUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas
 */
public class AutenticarDao {
    
    public InformaçoesUsuario autenticar01(InformaçoesUsuario use){
        Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 01id,01nome FROM 01academia WHERE 01login=? and 01senha=?";
       ResultSet rs;
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, use.getLogin());
            smt.setString(2, use.getSenha());
            
            rs = smt.executeQuery();
            rs.next();
            
            use.setNome(rs.getString("01nome"));
            use.setId(rs.getInt("01id"));
            
            //rs.close();
            smt.close();
            con.close();
            return use;
        }catch(SQLException ex){
            System.out.println("erro:"+ex);
            return null;
        }
        
    }
    
    public InformaçoesUsuario autenticar02(InformaçoesUsuario use){
        Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 02id,02nome, 01id FROM 02cliente, 01academia WHERE 02login=? and 02senha=? and 0201id=01id";
        ResultSet rs;
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, use.getLogin());
            smt.setString(2, use.getSenha());
            
            rs = smt.executeQuery();
            rs.next();
            
            use.setNome(rs.getString("02nome"));
            use.setId(rs.getInt("02id"));
            use.setId(rs.getInt("01id"));
            
            smt.close();
            con.close();
            return use;
        }catch(SQLException ex){
            System.out.println("erro:"+ex);
            return null;
        }
        
    }
}
