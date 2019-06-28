/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.entidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Home
 */
public class Cliente extends Pessoa{
   
    private String login;
    private String senha;
    private String status;
    private String endereco;
    

    public Cliente(String login, String senha, String endereco, String nome,
            String cpf, String telefolone, String data_nasc, String sexo, int chaveEstrageira) {
        super(nome, cpf, telefolone, data_nasc, sexo, chaveEstrageira);
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente() {
    }

    public Cliente(String login, String senha, String endereco, int id, String nome, String cpf, String telefolone, String data_nasc, String sexo) {
        super(id, nome, cpf, telefolone, data_nasc, sexo);
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
    }

    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


   
}
