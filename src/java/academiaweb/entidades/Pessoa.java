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
public abstract class Pessoa{
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefolone;
    private String data_nasc;
    private String sexo;
    private int chaveEstrageira;

   

    public Pessoa(String nome, String cpf, String telefolone, String data_nasc, String sexo, int chaveEstrageira) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefolone = telefolone;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.chaveEstrageira = chaveEstrageira;
    }

    public Pessoa(int id, String nome, String cpf, String telefolone, String data_nasc, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefolone = telefolone;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
    }

    
    
    public Pessoa() {
    }

    
     public int getChaveEstrageira() {
        return chaveEstrageira;
    }

    public void setChaveEstrageira(int chaveEstrageira) {
        this.chaveEstrageira = chaveEstrageira;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefolone() {
        return telefolone;
    }

    public void setTelefolone(String telefolone) {
        this.telefolone = telefolone;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        this.data_nasc = data.format(data_nasc);
    }
    public void setData_nasc2(Date data_nasc) {
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        this.data_nasc = data.format(data_nasc);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   
   
}
