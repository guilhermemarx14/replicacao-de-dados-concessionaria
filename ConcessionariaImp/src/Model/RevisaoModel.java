/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Model.DAO.RevisaoDAO;

/**
 *
 * @author guilhermemarx14
 */
public class RevisaoModel {
    int idRevisao;
    boolean efetivado;
    float valorConserto;
    String dataRevisao;
    ClienteModel cliente;
    float valorRevisao;
    VeiculoModel veiculo;
    MecanicoModel mecanico;

    public RevisaoModel(){}
    public RevisaoModel(int idRevisao){
        this.idRevisao = idRevisao;
    }
    public RevisaoModel(boolean efetivado, float valorConserto, String dataRevisao, ClienteModel cliente, float valorRevisao, VeiculoModel veiculo, MecanicoModel mecanico) {
        this.efetivado = efetivado;
        this.valorConserto = valorConserto;
        this.dataRevisao = dataRevisao;
        this.cliente = cliente;
        this.valorRevisao = valorRevisao;
        this.veiculo = veiculo;
        this.mecanico = mecanico;
    }

    public int getIdRevisao() {
        return idRevisao;
    }

    public void setIdRevisao(int idRevisao) {
        this.idRevisao = idRevisao;
    }

    public boolean isEfetivado() {
        return efetivado;
    }

    public void setEfetivado(boolean efetivado) {
        this.efetivado = efetivado;
    }

    public float getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(float valorConserto) {
        this.valorConserto = valorConserto;
    }

    public String getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(String dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public float getValorRevisao() {
        return valorRevisao;
    }

    public void setValorRevisao(float valorRevisao) {
        this.valorRevisao = valorRevisao;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

    public MecanicoModel getMecanico() {
        return mecanico;
    }

    public void setMecanico(MecanicoModel mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "RevisaoModel{" + "idRevisao=" + idRevisao + ", efetivado=" + efetivado + ", valorConserto=" + valorConserto + ", dataRevisao=" + dataRevisao + ", cliente=" + cliente.idCliente + ", valorRevisao=" + valorRevisao + ", veiculo=" + veiculo.idVeiculo + ", mecanico=" + mecanico.cpfFuncionario + '}';
    }
    
    public boolean save(){
        try{
            RevisaoDAO dao = new RevisaoDAO();
            if(dao.consultar(idRevisao)!=null)
                dao.alterar(this);
            else dao.incluir(this);           
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            RevisaoDAO dao = new RevisaoDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static RevisaoModel get(int idRevisao){
        RevisaoDAO dao = new RevisaoDAO();
        return dao.consultar(idRevisao);
       
    }
}
