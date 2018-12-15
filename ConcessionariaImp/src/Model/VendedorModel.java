/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.FuncionarioDAO;
import Model.DAO.VendedorDAO;

/**
 *
 * @author guilhermemarx14
 */
public class VendedorModel extends FuncionarioModel{
    int porcentagemComissao;

    public VendedorModel(){}
    
    public VendedorModel(String cpfFuncionario){
        this.cpfFuncionario = cpfFuncionario;
    }
    
    public VendedorModel(String cpfFuncionario, float salarioFixo, String nome, String telefone, int porcentagemComissao) {
        this.cpfFuncionario = cpfFuncionario;
        this.salarioFixo = salarioFixo;
        this.nome = nome;
        this.telefone = telefone;
        this.porcentagemComissao = porcentagemComissao;
    }
    
    public int getPorcentagemComissao() {
        return porcentagemComissao;
    }

    public void setPorcentagemComissao(int porcentagemComissao) {
        this.porcentagemComissao = porcentagemComissao;
    }

    @Override
    public String toString() {
        return "VendedorModel{" + "porcentagemComissao=" + porcentagemComissao + '}';
    }
    
    
    public boolean save(){
        try{
           VendedorDAO dao = new VendedorDAO();
            FuncionarioDAO fdao = new FuncionarioDAO();
            if(dao.consultar(cpfFuncionario)!=null){
                fdao.alterar(this);
                dao.alterar(this);
            }
            else {
               fdao.incluir(this);
                dao.incluir(this);
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            VendedorDAO dao = new VendedorDAO();
            FuncionarioDAO fdao = new FuncionarioDAO();
            dao.excluir(this);
            fdao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static VendedorModel get(String cpfFuncionario){
        VendedorDAO dao = new VendedorDAO();
        return dao.consultar(cpfFuncionario);
       
    }
}
