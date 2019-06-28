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
public class Boleto {
    private float valor;
    private String data;
    private String status;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(Date data) {
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        this.data = dt.format(data);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
