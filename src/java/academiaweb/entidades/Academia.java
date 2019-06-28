/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.entidades;

/**
 *
 * @author Home
 */
public class Academia {

    private int id;
    private String nome;
    private String endereco;
    private String login;
    private String senha;
    private String telefone;

    public Academia(String nome, String endereco, String login, String senha, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
    }

   

    public Academia() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
