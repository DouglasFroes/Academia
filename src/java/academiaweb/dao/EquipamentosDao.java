/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.dao;

import academiaweb.configuracaoSGBD.ConexaoBanco;
import academiaweb.entidades.Equipamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class EquipamentosDao {
    
    public boolean CadastraEquipamento(Equipamentos equipamento){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "INSERT INTO 03equipamentos (03nome, 03valor, 03modelo, 0301id)"
                + "values (?,?,?,?)";
        try{
            PreparedStatement smt  = con.prepareStatement(sql);
            smt.setString(1, equipamento.getNome());
            smt.setFloat(2, equipamento.getValor());
            smt.setString(3, equipamento.getModelo());
            smt.setInt(4, equipamento.getChaveEstrageira());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
        }catch(SQLException ex){
            System.out.println("erro"+ex);
            return false;
        }
    }
    
     public List ListarEquipamento(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT * FROM 03equipamentos WHERE 0301id=?";
        
        ResultSet rs;
        
               
        List<Equipamentos> equipamentoList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Equipamentos equipamento = new Equipamentos();
               equipamento.setId(rs.getInt("03id"));
               equipamento.setNome(rs.getString("03nome"));
               equipamento.setValor(rs.getFloat("03valor"));
               equipamento.setModelo(rs.getString("03modelo"));
               
                
                //adicionando na lista
                equipamentoList.add(equipamento);
            }
            
            stmt.close();
            con.close();
            
            return equipamentoList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
     
      public boolean ExcluirEquipamento(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sqlDelete = "DELETE FROM 03equipamentos WHERE 03id = ?";
							
	try {
        PreparedStatement pstm = con.prepareStatement(sqlDelete);
	pstm.setInt(1, id);
	
        pstm.execute();          
        pstm.close();
            
        return true;
            
        } catch (SQLException ex) {
            System.out.println("Nao foi possível excluir: " + ex.getMessage());
            return false;
        }
       }
    
          public Equipamentos EditarEquipamento(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT * FROM 03equipamentos WHERE 03id=?";
        
        ResultSet rs;
        
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
               Equipamentos eq = new Equipamentos();
               rs.next();
               eq.setId(rs.getInt("03id"));
               eq.setNome(rs.getString("03nome"));
               eq.setValor(rs.getFloat("03valor"));
               eq.setModelo(rs.getString("03modelo"));
               
            stmt.close();
            con.close();
            
            return eq;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    public boolean EditarCliente2(Equipamentos eq){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "UPDATE 03equipamentos SET 03nome = ?, 03valor = ?, 03modelo = ? WHERE 03id = ?";
        
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
             smt.setString(1, eq.getNome());
            smt.setFloat(2, eq.getValor());
            smt.setString(3, eq.getModelo());
            smt.setInt(4, eq.getId());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }
    }
      
}
