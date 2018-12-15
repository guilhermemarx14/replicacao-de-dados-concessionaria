/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.ClienteDAO;
import Model.DAO.PfisicaDAO;

/**
 *
 * @author guilhermemarx14
 */
public class PfisicaModel extends ClienteModel{
    String cpf;

    public PfisicaModel(){}
    
    public PfisicaModel(int IdPfisica, String telefone, String nome, String cep, String complemento, String numero, String numCartao, String numConta, String cpf) {
        this.idCliente = IdPfisica;
        this.telefone = telefone;
        this.nome = nome;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.numCartao = numCartao;
        this.numConta = numConta;
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PfisicaModel{" + "cpf=" + cpf + '}';
    }
    
    public boolean save(){
        try{
            PfisicaDAO dao = new PfisicaDAO();
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
            PfisicaDAO dao = new PfisicaDAO();
            ClienteDAO cdao = new ClienteDAO();
            dao.excluir(this);
            cdao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static PfisicaModel get(int idcliente){
        PfisicaDAO dao = new PfisicaDAO();
        return dao.consultar(idcliente);
    }
}
