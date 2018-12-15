/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Model.DAO.PvendaDAO;
import java.util.ArrayList;

/**
 *
 * @author guilhermemarx14
 */
public class PvendaModel extends VeiculoModel{
    float precoVenda;

    public PvendaModel(){}
    
    public PvendaModel(int km, int situacao, String placa, String tipo, String modelo, String montadora, String cor, float precoVenda) {
        this.km = km;
        this.situacao = situacao;
        this.placa = placa;
        this.tipo = tipo;
        this.modelo = modelo;
        this.montadora = montadora;
        this.cor = cor;
        this.precoVenda = precoVenda;
    }

    public PvendaModel(int aInt) {
        this.idVeiculo = aInt;
    }
    
    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return "PvendaModel{" + "precoVenda=" + precoVenda + '}';
    }
    
    public boolean save(){
        try{
            PvendaDAO dao = new PvendaDAO();
            if(dao.consultar(idVeiculo)!=null)
                dao.alterar(this);
            else dao.incluir(this);           
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            PvendaDAO dao = new PvendaDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static PvendaModel get(int idVeiculo){
        PvendaDAO dao = new PvendaDAO();
        return dao.consultar(idVeiculo);
       
    }
    
}
