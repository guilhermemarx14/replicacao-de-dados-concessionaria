/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.ClienteDAO;
import Model.DAO.PjuridicaDAO;

/**
 *
 * @author guilhermemarx14
 */
public class PjuridicaModel extends ClienteModel{
    String cnpj;

    public PjuridicaModel(){}
    
    public PjuridicaModel(int IdPjuridica, String telefone, String nome, String cep, String complemento, String numero, String numCartao, String numConta, String cnpj) {
        this.idCliente = IdPjuridica;
        this.telefone = telefone;
        this.nome = nome;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.numCartao = numCartao;
        this.numConta = numConta;
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PjuridicaModel{" + "cnpj=" + cnpj + '}';
    }
    
    public boolean save(){
        try{
            PjuridicaDAO dao = new PjuridicaDAO();
            ClienteDAO cdao = new ClienteDAO();
            if(dao.consultar(idCliente)!=null){
                cdao.alterar(this);
                dao.alterar(this);
            } else{
                cdao.incluir(this);
                this.setIdCliente(cdao.getLastId());
                dao.incluir(this);
            }                    
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            PjuridicaDAO dao = new PjuridicaDAO();
            ClienteDAO cdao = new ClienteDAO();
            dao.excluir(this);
            cdao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static PjuridicaModel get(int idcliente){
        PjuridicaDAO dao = new PjuridicaDAO();
        return dao.consultar(idcliente);
    }
}
