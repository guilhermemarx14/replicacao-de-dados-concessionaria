/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author guilhermemarx14
 */
public class DataModel {
    int dia, mes, ano;
    
    
    public DataModel(String data){
        if(data!= null && data.split("/").length == 3){
            this.dia = Integer.parseInt(data.split("/")[0]);
            this.mes = Integer.parseInt(data.split("/")[1]);
            this.ano = Integer.parseInt(data.split("/")[2]);
        }
        else {
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }
    
    public String toString(){
        return "" + dia + "/" + mes + "/" + ano;
    }
}
