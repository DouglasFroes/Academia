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
public class Atividades {
    private int id;
    private String nome;
    private String Personal;
    private int chaveestrageira;

    public Atividades() {
    }
    
    

    public String getPersonal() {
        return Personal;
    }

    public void setPersonal(String Personal) {
        this.Personal = Personal;
    }

    public Atividades(String nome, int chaveestrageira) {
        this.nome = nome;
        this.chaveestrageira = chaveestrageira;
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

    public int getChaveestrageira() {
        return chaveestrageira;
    }

    public void setChaveestrageira(int chaveestrageira) {
        this.chaveestrageira = chaveestrageira;
    }
    
    
}
