/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.dao;

import academiaweb.configuracaoSGBD.ConexaoBanco;
import academiaweb.entidades.Atividades;
import academiaweb.entidades.Personal;
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
public class PersonalDao {
    
    public boolean CadastraPersonal(Personal personal){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "INSERT INTO 04personal (04nome, 04data_nacs, 04telefone, 04cpf, 04sexo, 04salario, 0401id)"
                + " values (?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            smt.setString(1, personal.getNome());
            smt.setString(2, personal.getData_nasc());
            smt.setString(3, personal.getTelefolone());
            smt.setString(4, personal.getCpf());
            smt.setString(5, personal.getSexo());
            smt.setFloat(6, personal.getSalario());
            smt.setInt(7, personal.getChaveEstrageira());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }
    }

    public List ListarPersonal(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 04id,04nome,04telefone,04salario FROM 04personal WHERE 0401id=?";
        
        ResultSet rs;
        
               
        List<Personal> personalList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);      
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Personal personal = new Personal();
               personal.setId(rs.getInt("04id"));
               personal.setNome(rs.getString("04nome"));
               personal.setTelefolone(rs.getString("04telefone"));
               personal.setSalario(rs.getFloat("04salario"));
               
                
                //adicionando na lista
                personalList.add(personal);
            }
            
            stmt.close();
            con.close();
            
            return personalList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    
    public Personal EditarPersonal(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT * FROM 04personal WHERE 04id=?";
        
        ResultSet rs;
        
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
               Personal personal = new Personal();
               rs.next();
               personal.setId(rs.getInt("04id"));
               personal.setNome(rs.getString("04nome"));
               personal.setTelefolone(rs.getString("04telefone"));
               personal.setSalario(rs.getFloat("04salario"));
               personal.setData_nasc2(rs.getDate("04data_nacs"));
               personal.setCpf(rs.getString("04cpf"));
               personal.setSexo(rs.getString("04sexo"));
               
             
            stmt.close();
            con.close();
            
            return personal;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    public boolean EditarPersonal2(Personal personal){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "UPDATE 04personal SET 04nome = ?, 04data_nacs = ?, 04telefone = ?, 04cpf = ? , 04sexo = ?, 04salario = ? WHERE 04id=?";
        
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            smt.setString(1, personal.getNome());
            smt.setString(2, personal.getData_nasc());
            smt.setString(3, personal.getTelefolone());
            smt.setString(4, personal.getCpf());
            smt.setString(5, personal.getSexo());
            smt.setFloat(6, personal.getSalario());
            smt.setInt(7, personal.getId());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }
    }
    
    
    public boolean ExcluirEquipamento(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sqlDelete = "DELETE FROM 04personal WHERE 04id = ?";
							
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
    
    
     public List ListarPersonalAtividades(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 05nome FROM 05atividades where 0504id= ?";
        
        ResultSet rs;
        
               
        List<Atividades> personalList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);   
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Atividades at = new Atividades();
               at.setNome(rs.getString("05nome"));
               
               
                
                //adicionando na lista
                personalList.add(at);
            }
            
            stmt.close();
            con.close();
            
            return personalList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
}
