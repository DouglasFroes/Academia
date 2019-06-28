/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.dao;

import academiaweb.entidades.Avaliador;
import academiaweb.configuracaoSGBD.ConexaoBanco;
import academiaweb.entidades.Atividades;
import academiaweb.entidades.Ficha;
import academiaweb.entidades.InformaçoesUsuario;
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
public class AvaliadorDao {
    public boolean CadastraAvaliador(Avaliador avaliar){
        Connection con = new ConexaoBanco().getConexao();
        InformaçoesUsuario use = new InformaçoesUsuario();
        String sql = "INSERT INTO 06avaliador (06nome, 06telefone, 06data_nasc, 06cpf, 06sexo, 0601id)"
                + " values (?,?,?,?,?,?)";
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            smt.setString(1, avaliar.getNome());
            smt.setString(2, avaliar.getTelefolone());
            smt.setString(3, avaliar.getData_nasc());
            smt.setString(4, avaliar.getCpf());
            smt.setString(5, avaliar.getSexo());
            smt.setInt(6, avaliar.getChaveEstrageira());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }
        
    }

    public List ListraAvaliador(int id){
Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT * FROM 06avaliador WHERE 0601id=?";
        
        ResultSet rs;
        
               
        List<Avaliador> AvaliadorList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Avaliador avaliar = new Avaliador();
               avaliar.setId(rs.getInt("06id"));
               avaliar.setNome(rs.getString("06nome"));
               avaliar.setCpf(rs.getString("06cpf"));
               avaliar.setTelefolone(rs.getString("06telefone"));
               avaliar.setData_nasc(rs.getDate("06data_nasc"));
               avaliar.setSexo(rs.getString("06sexo"));
               
                //adicionando na lista
                AvaliadorList.add(avaliar);
            }
            
            stmt.close();
            con.close();
            
            return AvaliadorList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    
     public Avaliador EditarAvaliador(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT * FROM 06avaliador WHERE 06id=?";
        
        ResultSet rs;
        
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
               Avaliador ava = new Avaliador();
               rs.next();
               ava.setId(rs.getInt("06id"));
               ava.setNome(rs.getString("06nome"));
               ava.setTelefolone(rs.getString("06telefone"));
               ava.setData_nasc2(rs.getDate("06data_nasc"));
               ava.setCpf(rs.getString("06cpf"));
               ava.setSexo(rs.getString("06sexo"));
               
             
            stmt.close();
            con.close();
            
            return ava;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    public boolean EditarPersonal2(Avaliador ava){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "UPDATE 06avaliador SET 06nome= ? , 06telefone= ? , 06data_nasc= ? , 06cpf= ? , 06sexo = ? WHERE 06id = ? ";
        
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            smt.setString(1, ava.getNome());
            smt.setString(2, ava.getTelefolone());
            smt.setString(3, ava.getData_nasc());
            smt.setString(4, ava.getCpf());
            smt.setString(5, ava.getSexo());
            smt.setInt(6, ava.getId());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }
    }
    
    
    public boolean ExcluirAvaliador(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sqlDelete = "DELETE FROM 06avaliador WHERE 06id = ?";
							
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
    
    public List ListraConsutas(int id){
Connection con = new ConexaoBanco().getConexao();
        
        String sql = "select 02nome, 09data from 02cliente, 09ficha_tecnica where 0902id=02id and 0906id = ?";
        
        ResultSet rs;
        
               
        List<Ficha> AvaliadorList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Ficha fx = new Ficha();
               fx.setNome(rs.getString("02nome"));
               fx.setData(rs.getDate("09data"));
               
                //adicionando na lista
                AvaliadorList.add(fx);
            }
            
            stmt.close();
            con.close();
            
            return AvaliadorList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean AdicionarAvalicaoClinete(Ficha fx){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "INSERT INTO 09ficha_tecnica (09peso, 09altura, 0906id, 09data, 0902id)"
                + " values (?,?,?,?,?)";
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            smt.setFloat(1, fx.getPeso());
            smt.setFloat(2, fx.getAltura());
            smt.setInt(3, fx.getChaveestrageira());
            smt.setString(4, fx.getData());
            smt.setInt(5, fx.getId());
            
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
