/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.entidades;

/**
 *
 * @author Douglas
 */
public class InformaçoesUsuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private int idaca;

    public InformaçoesUsuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public InformaçoesUsuario() {
    }

    public int getIdaca() {
        return idaca;
    }

    public void setIdaca(int idaca) {
        this.idaca = idaca;
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

    public  void setNome(String nome) {
        this.nome = nome;
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
    
    
}
