/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.dao;

import academiaweb.configuracaoSGBD.ConexaoBanco;
import academiaweb.entidades.Boleto;
import academiaweb.entidades.Cliente;
import academiaweb.entidades.Ficha;
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
public class ClienteDao {
   
    public boolean CadastraCliente(Cliente cliente){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "INSERT INTO 02cliente (02nome, 02login, 02senha, 02data_nasc, 02endereco, 02telefole, 02cpf, 02sexo, 0201id)"
                            + " values (?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
            smt.setString(1, cliente.getNome());
            smt.setString(2, cliente.getLogin());
            smt.setString(3, cliente.getSenha());
            smt.setString(4, cliente.getData_nasc());
            smt.setString(5, cliente.getEndereco());
            smt.setString(6, cliente.getTelefolone());
            smt.setString(7, cliente.getCpf());
            smt.setString(8, cliente.getSexo());
            smt.setInt(9, cliente.getChaveEstrageira());
            smt.execute();
            smt.close();
            con.close();
            
            return true;
        
    }catch(SQLException ex){
        System.out.println("não foi possivel inserir:");
        return false;
    }
    
}

    public List ListarCliente(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 02id, 02nome, 02telefole FROM 02cliente WHERE 0201id=?";
        
        ResultSet rs;
        
               
        List<Cliente> clientesList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Cliente cliente = new Cliente();
               cliente.setId(rs.getInt("02id"));
               cliente.setNome(rs.getString("02nome"));
               cliente.setTelefolone(rs.getString("02telefole"));
               
                
                //adicionando na lista
                clientesList.add(cliente);
            }
            
            stmt.close();
            con.close();
            
            return clientesList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }

    public List BuscaCliente(String nome){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 02id, 02nome, 02login, 02data_nasc, 02endereco, 02telefole, 02cpf, 02sexo"
                + " FROM 02cliente WHERE  02nome=?";
        
        ResultSet rs;
        
               
        List<Cliente> clientesList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Cliente cliente = new Cliente();
               cliente.setId(rs.getInt("02id"));
               cliente.setNome(rs.getString("02nome"));
               cliente.setLogin(rs.getString("02login"));
               cliente.setData_nasc(rs.getDate("02data_nasc"));
               cliente.setEndereco(rs.getString("02endereco"));
               cliente.setTelefolone(rs.getString("02telefole"));
               cliente.setCpf(rs.getString("02cpf"));
               cliente.setSexo(rs.getString("02sexo"));
               
                
//                adicionando na lista
                clientesList.add(cliente);
            }
            
            stmt.close();
            con.close();
            
            return clientesList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    
    public List ListarBoletoClietente(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT 07Valor, 07dataVencimento, 07status FROM 07boleto WHERE 0702id=?";
        
         ResultSet rs;
        
               
        List<Boleto> bltClentList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Boleto blt = new Boleto();
               blt.setValor(rs.getFloat("07Valor"));
               blt.setData(rs.getDate("07dataVencimento"));
               blt.setStatus(rs.getString("07status"));
               
                
                //adicionando na lista
               bltClentList.add(blt);
            }
            
            stmt.close();
            con.close();
            
            return bltClentList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }

     public List ListarAvaliacaoClietente(int id){
         Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT  09data, 09peso, 09altura, 06nome FROM 09ficha_tecnica, 06avaliador where 0906id=06id and 0902id=?";
        
         ResultSet rs;
        
               
        List<Ficha> FxClentList = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
               Ficha fx = new Ficha();
               fx.setAltura(rs.getFloat("09altura"));
               fx.setPeso(rs.getFloat("09peso"));
               fx.setData(rs.getDate("09data"));
               fx.setNome(rs.getString("06nome"));
               
                
                //adicionando na lista
               FxClentList.add(fx);
            }
            
            stmt.close();
            con.close();
            
            return FxClentList;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    
    }

     
      public Cliente EditarCliente(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sql = "SELECT * FROM 02cliente WHERE 02id=?";
        
        ResultSet rs;
        
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
               Cliente clie = new Cliente();
               rs.next();
               clie.setId(rs.getInt("02id"));
               clie.setNome(rs.getString("02nome"));
               clie.setTelefolone(rs.getString("02telefole"));
               clie.setData_nasc2(rs.getDate("02data_nasc"));
               clie.setCpf(rs.getString("02cpf"));
               clie.setSexo(rs.getString("02sexo"));
               clie.setEndereco(rs.getString("02endereco"));
               clie.setLogin(rs.getString("02login"));
               clie.setSenha(rs.getString("02senha"));
             
            stmt.close();
            con.close();
            
            return clie;
            
        }catch(SQLException ex){
             System.out.println("Nao foi possível listar: " + ex.getMessage());
            return null;
        }
    }
    public boolean EditarCliente2(Cliente clie){
        Connection con = new ConexaoBanco().getConexao();
        String sql = "UPDATE 02cliente SET 02nome = ?, 02login = ?, 02senha = ?, 02data_nasc = ?, 02endereco = ?, 02telefole = ?, 02cpf = ?, 02sexo = ? WHERE 02id = ?";
        
        try{
            PreparedStatement smt = con.prepareStatement(sql);
            
             smt.setString(1, clie.getNome());
            smt.setString(2, clie.getLogin());
            smt.setString(3, clie.getSenha());
            smt.setString(4, clie.getData_nasc());
            smt.setString(5, clie.getEndereco());
            smt.setString(6, clie.getTelefolone());
            smt.setString(7, clie.getCpf());
            smt.setString(8, clie.getSexo());
            smt.setInt(9, clie.getId());
            
            smt.execute();
            smt.close();
            
            con.close();
            return true;
       }catch(SQLException ex){
            System.out.println("Não foi possivel inser no banco:" + ex);
           return false;
       }
    }
    
    
    public boolean ExcluirCliente(int id){
        Connection con = new ConexaoBanco().getConexao();
        
        String sqlDelete = "DELETE FROM 02cliente WHERE 02id = ?";
							
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