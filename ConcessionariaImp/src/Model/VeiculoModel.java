/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.VeiculoDAO;
import java.util.ArrayList;

/**
 *
 * @author guilhermemarx14
 */
public class VeiculoModel {
    int idVeiculo;
    int km;
    int situacao;
    String placa;
    String tipo;
    String modelo;
    String montadora;
    String cor;

    public VeiculoModel(int idVeiculo, int km, int situacao, String placa, String tipo, String modelo, String montadora, String cor) {
        this.idVeiculo = idVeiculo;
        this.km = km;
        this.situacao = situacao;
        this.placa = placa;
        this.tipo = tipo;
        this.modelo = modelo;
        this.montadora = montadora;
        this.cor = cor;
    }

    public VeiculoModel() {
    }

    
    public VeiculoModel(int aInt) {
        this.idVeiculo = aInt;
    }



    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "VeiculoModel{" + "idVeiculo=" + idVeiculo + ", km=" + km + ", situacao=" + situacao + ", placa=" + placa + ", tipo=" + tipo + ", modelo=" + modelo + ", montadora=" + montadora + ", cor=" + cor + '}';
    }
    
    
    public boolean save(){
        try{
            VeiculoDAO dao = new VeiculoDAO();
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
            VeiculoDAO dao = new VeiculoDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static VeiculoModel get(int idVeiculo){
        VeiculoDAO dao = new VeiculoDAO();
        return dao.consultar(idVeiculo);
       
    }
    
}
