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
public class Personal extends Pessoa{
    private float salario;

    public Personal(float salario, String nome, String cpf, String telefolone, String data_nasc, String sexo, int chaveEstrageira) {
        super(nome, cpf, telefolone, data_nasc, sexo, chaveEstrageira);
        this.salario = salario;
    }

    public Personal() {
    }

    public Personal(float salario, int id, String nome, String cpf, String telefolone, String data_nasc, String sexo) {
        super(id, nome, cpf, telefolone, data_nasc, sexo);
        this.salario = salario;
    }
    

    
    
    
    
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

  
}
