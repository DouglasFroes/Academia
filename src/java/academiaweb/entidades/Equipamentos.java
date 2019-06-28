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
public class Equipamentos {
    private int id;
    private String nome;
    private float valor;
    private String modelo;
    private int chaveEstrageira;

    public Equipamentos(String nome, float valor, String modelo, int haveEstrageira) {
        this.nome = nome;
        this.valor = valor;
        this.modelo = modelo;
        this.chaveEstrageira = haveEstrageira;
    }

    public Equipamentos() {
    
    }

    public Equipamentos(int id, String nome, float valor, String modelo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.modelo = modelo;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getChaveEstrageira() {
        return chaveEstrageira;
    }

    public void setChaveEstrageira(int chaveEstrageira) {
        this.chaveEstrageira = chaveEstrageira;
    }
    
    
}
