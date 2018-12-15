/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.AluguelDAO;
import Model.DAO.CompraVendaDAO;

/**
 *
 * @author guilhermemarx14
 */
public class CompraVendaModel {
    int idCompraVenda;
    ClienteModel cliente;
    String dataCompraVenda;
    VendedorModel vendedor;
    PvendaModel veiculo;
    float valorCompraVenda;
    boolean troca;

    public boolean isTroca() {
        return troca;
    }

    public void setTroca(boolean troca) {
        this.troca = troca;
    }

    public CompraVendaModel(){}
    
    public CompraVendaModel(int idCompraVenda){
        this.idCompraVenda = idCompraVenda;
    }
    
    public CompraVendaModel(ClienteModel cliente, String dataCompraVenda, VendedorModel vendedor, PvendaModel veiculo, float valorCompraVenda, boolean troca) {
        this.cliente = cliente;
        this.dataCompraVenda = dataCompraVenda;
        this.vendedor = vendedor;
        this.veiculo = veiculo;
        this.valorCompraVenda = valorCompraVenda;
        this.troca = troca;
    }

    public float getValorCompraVenda() {
        return valorCompraVenda;
    }

    public void setValorCompraVenda(float valorCompraVenda) {
        this.valorCompraVenda = valorCompraVenda;
    }

    
    
    public int getIdCompraVenda() {
        return idCompraVenda;
    }

    public void setIdCompraVenda(int idCompraVenda) {
        this.idCompraVenda = idCompraVenda;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getDataCompraVenda() {
        return dataCompraVenda;
    }

    public void setDataCompraVenda(String dataCompraVenda) {
        this.dataCompraVenda = dataCompraVenda;
    }

    public VendedorModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorModel vendedor) {
        this.vendedor = vendedor;
    }

    public PvendaModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(PvendaModel veiculo) {
        this.veiculo = veiculo;
    }
    
    @Override
    public String toString() {
        return "CompraVendaModel{" + "idCompraVenda=" + idCompraVenda + ", cliente=" + cliente + ", dataCompraVenda=" + dataCompraVenda + ", vendedor=" + vendedor + ", veiculo=" + veiculo + ", valorCompraVenda=" + valorCompraVenda + ", troca=" + troca + '}';
    }
    
    public boolean save(){
        try{
            CompraVendaDAO dao = new CompraVendaDAO();
            if(dao.consultar(idCompraVenda)!=null)
                dao.alterar(this);
            else dao.incluir(this);           
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            CompraVendaDAO dao = new CompraVendaDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static CompraVendaModel get(int id){
        CompraVendaDAO dao = new CompraVendaDAO();
        return dao.consultar(id);
    }
}
