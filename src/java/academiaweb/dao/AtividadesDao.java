/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.dao;

import academiaweb.configuracaoSGBD.ConexaoBanco;
import academiaweb.entidades.Atividades;
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
public class AtividadesDao {
    public boolean cadastraAtividade(Atividades activ){
      Connection con = new ConexaoBanco().getConexao();
        
        String sql = "INSERT INTO 05atividades (05nome,0504id)"
                + " values (?,?)";
        int d=1;
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            smt.setString(1, activ.getNome());
            smt.setInt(2, activ.getChaveestrageira());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }  
    }
    
     public boolean CadastraAtividadeCliente(int id, int idActv){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "INSERT INTO 08atividadesclientes (0802id, 0805id)"
                + " values (?,?)";
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            
            smt.setInt(1, id);
            smt.setInt(2, idActv);
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }
        
    }
    
    public List ListarAtividades(){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 04nome,05nome FROM 04personal, 05atividades WHERE 0504id = 04id";
        
        ResultSet rs;
        
               
        List<Atividades> actClentList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);            
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Atividades actvCle = new Atividades();
               actvCle.setPersonal(rs.getString("04nome"));
               actvCle.setNome(rs.getString("05nome"));
               
                
                //adicionando na lista
               actClentList.add(actvCle);
            }
            
            stmt.close();
            con.close();
            
            return actClentList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    
    public List ListarAtividadesClietente(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 08id, 04nome, 05nome FROM 04personal, 05atividades, 08atividadesclientes WHERE 0802id = ? and 0805id=05id and 0504id = 04id";
        
         ResultSet rs;
        
               
        List<Atividades> actClentList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Atividades actvCle = new Atividades();
               actvCle.setId(rs.getInt("08id"));
               actvCle.setPersonal(rs.getString("04nome"));
               actvCle.setNome(rs.getString("05nome"));
               
                
                //adicionando na lista
               actClentList.add(actvCle);
            }
            
            stmt.close();
            con.close();
            
            return actClentList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    
     public List ListarAdicionarAtividadesClietente(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 04nome, 05nome, 05id FROM 04personal, 05atividades WHERE 0504id = 04id";
        
         ResultSet rs;
        
               
        List<Atividades> actClentList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Atividades actvCle = new Atividades();
               actvCle.setPersonal(rs.getString("04nome"));
               actvCle.setNome(rs.getString("05nome"));
               actvCle.setChaveestrageira(rs.getInt("05id"));
               
                
                //adicionando na lista
               actClentList.add(actvCle);
            }
            
            stmt.close();
            con.close();
            
            return actClentList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        
        }
     }
        
        public boolean ExcluirClineteAtividade(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sqlDelete = "DELETE FROM 08atividadesclientes WHERE 08id = ?";
							
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
    
        
    
     
}
