/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.AluguelDAO;
import Model.DAO.ClienteDAO;

/**
 *
 * @author guilhermemarx14
 */
public class AluguelModel {
    PaluguelModel veiculo;
    ClienteModel cliente;
    VendedorModel vendedor;
    RevisaoModel revisao;
    float valorTotal;
    int kmRodados;
    String dataFim;
    String dataInicio;
    float multaAtraso;
    int finalizado;

    public AluguelModel(){}
    
    public AluguelModel(PaluguelModel veiculo, ClienteModel cliente, VendedorModel vendedor, RevisaoModel revisao){
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.revisao = revisao;
    }
    public AluguelModel(PaluguelModel veiculo, ClienteModel cliente, VendedorModel vendedor, RevisaoModel revisao, float valorTotal, int kmRodados, String dataFim, String dataInicio, float multaAtraso, int finalizado) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.revisao = revisao;
        this.valorTotal = valorTotal;
        this.kmRodados = kmRodados;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.multaAtraso = multaAtraso;
        this.finalizado = finalizado;
    }

    public PaluguelModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(PaluguelModel veiculo) {
        this.veiculo = veiculo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public VendedorModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorModel vendedor) {
        this.vendedor = vendedor;
    }

    public RevisaoModel getRevisao() {
        return revisao;
    }

    public void setRevisao(RevisaoModel revisao) {
        this.revisao = revisao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(int kmRodados) {
        this.kmRodados = kmRodados;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public float getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(float multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public int isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "AluguelModel{" + "veiculo=" + veiculo.idVeiculo + ", cliente=" + cliente.idCliente + ", vendedor=" + vendedor.cpfFuncionario + ", revisao=" + revisao.idRevisao + ", valorTotal=" + valorTotal + ", kmRodados=" + kmRodados + ", dataFim=" + dataFim + ", dataInicio=" + dataInicio + ", multaAtraso=" + multaAtraso + ", finalizado=" + finalizado + '}';
    }

    public boolean save(){
        try{
            AluguelDAO dao = new AluguelDAO();
            if(dao.consultar(veiculo.getIdVeiculo(), cliente.getIdCliente(), vendedor.getCpfFuncionario(), revisao.getIdRevisao())!=null)
                dao.alterar(this);
            else dao.incluir(this);           
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            AluguelDAO dao = new AluguelDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static AluguelModel get(int idVeiculo, int idCliente, String idVendedor, int idRevisao){
        AluguelDAO dao = new AluguelDAO();
        return dao.consultar(idVeiculo, idCliente, idVendedor, idRevisao);
    }
    
    
}
