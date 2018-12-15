/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.AluguelDAO;
import Model.DAO.PaluguelDAO;
import java.util.ArrayList;

/**
 *
 * @author guilhermemarx14
 */
public class PaluguelModel extends VeiculoModel{
    float precoFixo;
    float precoPorKm;
    
    public PaluguelModel(){}
    
    
    public PaluguelModel(int km, int situacao, String placa, String tipo, String modelo, String montadora, String cor, float precoFixo, float precoPorKm) {
        this.km = km;
        this.situacao = situacao;
        this.placa = placa;
        this.tipo = tipo;
        this.modelo = modelo;
        this.montadora = montadora;
        this.cor = cor;
        this.precoFixo = precoFixo;
        this.precoPorKm = precoPorKm;
    }

    public PaluguelModel(int idVeiculo){
        this.idVeiculo = idVeiculo;
    }
    public float getPrecoFixo() {
        return precoFixo;
    }

    public void setPrecoFixo(float precoFixo) {
        this.precoFixo = precoFixo;
    }

    public float getPrecoPorKm() {
        return precoPorKm;
    }

    public void setPrecoPorKm(float precoPorKm) {
        this.precoPorKm = precoPorKm;
    }
   
    @Override
    public String toString() {
        return "PaluguelModel{" + "precoFixo=" + precoFixo + ", precoPorKm=" + precoPorKm + '}';
    }
     
    public boolean save(){
        try{
            PaluguelDAO dao = new PaluguelDAO();
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
            PaluguelDAO dao = new PaluguelDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static PaluguelModel get(int idVeiculo){
        PaluguelDAO dao = new PaluguelDAO();
        return dao.consultar(idVeiculo);
    }
}
