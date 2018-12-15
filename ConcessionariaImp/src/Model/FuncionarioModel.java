/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.AluguelDAO;
import Model.DAO.FuncionarioDAO;

/**
 *
 * @author guilhermemarx14
 */
public class FuncionarioModel {
    String cpfFuncionario;
    float salarioFixo;
    String nome;
    String telefone;


    public FuncionarioModel(){}

    public FuncionarioModel(String cpfFuncionario, float salarioFixo, String nome, String telefone) {
        
        this.cpfFuncionario = cpfFuncionario;
        this.salarioFixo = salarioFixo;
        this.nome = nome;
        this.telefone = telefone;
    }
  
    public FuncionarioModel(String cpfFuncionario){
        this.cpfFuncionario = cpfFuncionario;
    }
    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public float getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(float salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "FuncionarioModel{"+" cpfFuncionario=" + cpfFuncionario + ", salarioFixo=" + salarioFixo + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    public boolean save(){
        try{
            FuncionarioDAO dao = new FuncionarioDAO();
            if(dao.consultar(cpfFuncionario)!=null)
                dao.alterar(this);
            else dao.incluir(this);           
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static FuncionarioModel get(String cpf){
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.consultar(cpf);
    }
}
