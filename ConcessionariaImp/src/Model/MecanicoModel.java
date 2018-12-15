/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DAO.FuncionarioDAO;
import Model.DAO.MecanicoDAO;

/**
 *
 * @author guilhermemarx14
 */
public class MecanicoModel extends FuncionarioModel {
    float comissaoPorRevisao;
    
    public MecanicoModel(){}
    
    public MecanicoModel(String cpfFuncionario, float salarioFixo, String nome, String telefone, float comissaoPorRevisao) {
        this.cpfFuncionario = cpfFuncionario;
        this.salarioFixo = salarioFixo;
        this.nome = nome;
        this.telefone = telefone;
        this.comissaoPorRevisao = comissaoPorRevisao;
    }

    public MecanicoModel(String string) {
        this.cpfFuncionario = string;
    }

    public float getComissaoPorRevisao() {
        return comissaoPorRevisao;
    }

    public void setComissaoPorRevisao(float comissaoPorRevisao) {
        this.comissaoPorRevisao = comissaoPorRevisao;
    }

    @Override
    public String toString() {
        return "MecanicoModel{" + "comissaoPorRevisao=" + comissaoPorRevisao + '}';
    }
    
    
    public boolean save(){
        try{
            MecanicoDAO dao = new MecanicoDAO();
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
            MecanicoDAO dao = new MecanicoDAO();
            FuncionarioDAO fdao = new FuncionarioDAO();
            dao.excluir(this);
            fdao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static MecanicoModel get(String cpfFuncionario){
        MecanicoDAO dao = new MecanicoDAO();
        return dao.consultar(cpfFuncionario);
       
    }
}
