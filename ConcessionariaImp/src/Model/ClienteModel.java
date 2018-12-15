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
public class ClienteModel {
    int idCliente;
    String telefone;
    String nome;
    String cep;
    String complemento;
    String numero;
    String numCartao;
    String numConta;

    public ClienteModel(int aInt) {
        this.idCliente = aInt;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }
    public ClienteModel(){}
    public ClienteModel(int idCliente, String telefone, String nome, String cep, String complemento, String numero, String numCartao, String numConta) {
        this.idCliente = idCliente;
        this.telefone = telefone;
        this.nome = nome;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.numCartao = numCartao;
        this.numConta = numConta;
    }

    @Override
    public String toString() {
        return "ClienteModel{" + "idCliente=" + idCliente + ", telefone=" + telefone + ", nome=" + nome + ", cep=" + cep + ", complemento=" + complemento + ", numero=" + numero + ", numCartao=" + numCartao + ", numConta=" + numConta + '}';
    }
    
    public boolean save(){
        try{
            ClienteDAO dao = new ClienteDAO();
            if(dao.consultar(idCliente)!=null)
                dao.alterar(this);
            else dao.incluir(this);           
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            ClienteDAO dao = new ClienteDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static ClienteModel get(int id){
        ClienteDAO dao = new ClienteDAO();
        return dao.consultar(id);
    }
}
