/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Model.DAO.TrocaDAO;
/**
 *
 * @author guilhermemarx14
 */
public class TrocaModel {
    CompraVendaModel venda;
    CompraVendaModel compra;

    public TrocaModel(){}
    
    public TrocaModel(CompraVendaModel venda, CompraVendaModel compra) {
        this.venda = venda;
        this.compra = compra;
    }

    public CompraVendaModel getVenda() {
        return venda;
    }

    public void setVenda(CompraVendaModel venda) {
        this.venda = venda;
    }

    public CompraVendaModel getCompra() {
        return compra;
    }

    public void setCompra(CompraVendaModel compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "TrocaModel{" + "venda=" + venda + ", compra=" + compra + '}';
    }
    
    
    public boolean save(){
        try{
            TrocaDAO dao = new TrocaDAO();
            if(dao.consultar(venda.getIdCompraVenda(), compra.getIdCompraVenda())!=null)
               dao.alterar(this);
            else dao.incluir(this);           
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try{
            TrocaDAO dao = new TrocaDAO();
            dao.excluir(this);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static TrocaModel get(int idVenda, int idCompra){
        TrocaDAO dao = new TrocaDAO();
        return dao.consultar(idVenda,idCompra);
       
    }
    
}
