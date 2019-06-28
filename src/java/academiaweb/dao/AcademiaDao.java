/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.dao;

import academiaweb.configuracaoSGBD.ConexaoBanco;
import academiaweb.entidades.Academia;
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
public class AcademiaDao {
    
  public boolean salvarAcademiaDao(Academia academia){
        
        Connection con = new ConexaoBanco().getConexao();
        String sql="insert  into "
                + "01academia (01nome, 01endereco, 01login, 01senha, 01telefone)"
                + " values (?,?,?,?,?);  ";
        
        try{
            PreparedStatement stm=  con.prepareStatement(sql);
            stm.setString(1,academia.getNome());
            stm.setString(2,academia.getEndereco());
            stm.setString(3,academia.getLogin());
            stm.setString(4,academia.getSenha());
            stm.setString(5,academia.getTelefone());
            
            stm.execute();
            stm.close();
            con.close();
            return true;
        }catch(SQLException ex){
        System.out.println("Nao foi possivel Inserir os Dados no Banco "+ ex.getMessage());
        return false;
        }
    }
    
    public List<Academia> listarAcademiaDao(){
       List<Academia> listAcademia = new ArrayList<Academia>();
       
       Connection con = new ConexaoBanco().getConexao();
        String sql="SELECT 01id,01nome,01endereco, 01telefone FROM 01academia  ";
        
        try{
            PreparedStatement stm=  con.prepareStatement(sql);
            //Tras dados do banco de dados
            // todos os dados da academia
            stm.execute();
            ResultSet resultSet =  stm.executeQuery();
            // jogo os dados na classe Academia,
            //e depois insira na minha lista que sera retornada no meu Foreach dentro da minha jsp
            while(resultSet.next()){
                Academia academia = new Academia();
                academia.setId(resultSet.getInt("01id"));
                academia.setNome(resultSet.getString("01nome"));
                academia.setEndereco(resultSet.getString("01endereco"));
                academia.setTelefone(resultSet.getString("01telefone"));
                listAcademia.add(academia);
            }
                
                return listAcademia;
                
        }catch(SQLException ex){
        System.out.println("Buscar Dados do Banco Erro "+ ex.getMessage());
        return null;
        }
        
       
    }
    public Academia buscarAcademiaDao(int id){
        Academia academia = new Academia();
        Connection con = new ConexaoBanco().getConexao();
            String sql = "SELECT *FROM 01academia as academia WHERE academia.01nome = ?";
            
            try{
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, academia.getNome());
            stm.execute();
            ResultSet result = stm.executeQuery();
        
        while(result.next()){
            
        academia.setId(result.getInt("01id"));
        academia.setNome(result.getString("01nome"));
        }
        return academia;
        }catch(SQLException ex){
            System.out.println("Erro ao deletar"+ex.getMessage());
           return null;
        }
          
    }
    public boolean atualizarAcademiaDao(Academia academia){
        
        academia = this.buscarAcademiaDao(academia.getId());
        if(academia!=null){
            Connection con = new ConexaoBanco().getConexao();
            String sql = "UPDATE  01academia as acd SET acd.nome = ? WHERE academia.01id = ?";
           
            try{
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1,academia.getNome());
                stm.setInt(2,academia.getId());
                stm.execute();                
                stm.close();
                con.close();
                
                return true;
        }catch(SQLException ex){
            System.out.println("Erro ao deletar"+ex.getMessage());
            return false;
        }
        }else{
            System.out.println("Academia nao Encontrada !");
            return false;
        }
    }
    public boolean deletarAcademiaDao(int id){
        Academia academia = new Academia();
        Connection con = new ConexaoBanco().getConexao();
        String sql = "DELETE FROM WHERE 01id = ? ";
        try{PreparedStatement stm = con.prepareStatement(sql);
        
        stm.setString(1,academia.getNome());
        stm.execute();
        stm.close();
        con.close(); 
            return true;
        }catch(SQLException ex){
            System.out.println("Erro ao deletar"+ex.getMessage());
            return false;
        }
    }
    
      
}
