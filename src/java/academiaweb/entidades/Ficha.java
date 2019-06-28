/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academiaweb.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Douglas
 */
public class Ficha {
    private int id;
    private float altura;
    private float peso;
    private String nome;
    private String data;
    private int chaveestrageira;

    public Ficha() {
    }

    public Ficha(int id, float altura, float peso, String data, int chaveestrageira) {
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.data = data;
        this.chaveestrageira = chaveestrageira;
    }

    
    
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(Date data) {
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        this.data = dt.format(data);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChaveestrageira() {
        return chaveestrageira;
    }

    public void setChaveestrageira(int chaveestrageira) {
        this.chaveestrageira = chaveestrageira;
    }
    
    
}
