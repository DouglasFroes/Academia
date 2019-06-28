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
public class Avaliador extends Pessoa{
    

    public Avaliador(String nome, String cpf, String telefolone, String data_nasc, String sexo, int chaveEstrageira) {
        super(nome, cpf, telefolone, data_nasc, sexo, chaveEstrageira);
    }

    public Avaliador() {
        
    }

    public Avaliador(int id, String nome, String cpf, String telefolone, String data_nasc, String sexo) {
        super(id, nome, cpf, telefolone, data_nasc, sexo);
    }

    
    
    
   
}
