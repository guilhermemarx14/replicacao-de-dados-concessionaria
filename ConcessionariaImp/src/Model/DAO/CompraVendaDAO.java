/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.MDB;
import Model.ClienteModel;
import Model.DAO.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.CompraVendaModel;
import Model.Constantes;
import Model.DataModel;
import Model.FileController;
import Model.PvendaModel;
import Model.VendedorModel;

/**
 *
 * @author innanplinio
 */
public class CompraVendaDAO {
    
    private final String SQLINCLUIR = "INSERT INTO CompraVenda VALUES (?,?,?,?,?,?,?)";
    private final String SQLALTERAR = "UPDATE CompraVenda SET dataCompraVenda = ?, "
            + "idVendedor = ?, idCliente = ?, idVeiculo = ?, valorCompraVenda = ?, troca = ? "
            + "WHERE  idCompraVenda = ?";
    private final String SQLEXCLUIR = "DELETE FROM CompraVenda WHERE idCompraVenda = ?";
    private final String SQLCONSULTAR = "SELECT * FROM CompraVenda WHERE idCompraVenda = ?";
    
    
     public boolean incluir(CompraVendaModel CompraVenda){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR);
            
            ps.setInt(1,CompraVenda.getIdCompraVenda());
            ps.setString(2, CompraVenda.getDataCompraVenda());
            ps.setString(3, CompraVenda.getVendedor().getCpfFuncionario());
            ps.setInt(4, CompraVenda.getCliente().getIdCliente());
            ps.setInt(5, CompraVenda.getVeiculo().getIdVeiculo());
            ps.setFloat(6, CompraVenda.getValorCompraVenda());
            ps.setBoolean(7, CompraVenda.isTroca());
            String script = ps.toString();
            ps.executeUpdate();
            int idoperacao = MDB.getIdBanco()+1;
            FileController arquivo = new FileController(""+idoperacao+".txt");
            arquivo.write(script.split(": ")[1]);
            MDB.updateIdBanco();
            Constantes.ID++;
            return true;
        } catch (SQLException e){
            
            return false;
        }
    }
    
    public boolean alterar(CompraVendaModel CompraVenda){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            
            ps.setString(1, CompraVenda.getDataCompraVenda().toString());
            ps.setString(2, CompraVenda.getVendedor().getCpfFuncionario());
            ps.setInt(3, CompraVenda.getCliente().getIdCliente());
            ps.setInt(4, CompraVenda.getVeiculo().getIdVeiculo());
            ps.setFloat(5, CompraVenda.getValorCompraVenda());
            ps.setBoolean(6, CompraVenda.isTroca());
            ps.setInt(7,CompraVenda.getIdCompraVenda());
         //   System.out.println(ps);
//            System.out.println(CompraVenda.getDataCompraVenda().toString());
//            System.out.println(CompraVenda.getVendedor().getCpfFuncionario());
//            System.out.println(CompraVenda.getCliente().getIdCliente());
//            System.out.println(CompraVenda.getVeiculo().getIdVeiculo());
//            System.out.println(CompraVenda.getValorCompraVenda());
//            System.out.println(CompraVenda.isTroca());
            String script = ps.toString();
            ps.executeUpdate();
            int idoperacao = MDB.getIdBanco()+1;
            FileController arquivo = new FileController(""+idoperacao+".txt");
            arquivo.write(script.split(": ")[1]);
            MDB.updateIdBanco();
            Constantes.ID++;
            
            return true;
        } catch (SQLException e){
            
            return false;
        }
    }
    
    public boolean excluir(CompraVendaModel CompraVenda){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,CompraVenda.getIdCompraVenda());
            String script = ps.toString();
            ps.executeUpdate();
            int idoperacao = MDB.getIdBanco()+1;
            FileController arquivo = new FileController(""+idoperacao+".txt");
            arquivo.write(script.split(": ")[1]);
            MDB.updateIdBanco();
            Constantes.ID++;
            return true;
        } catch (SQLException e){
           
            return false;
        }
    }
    
    public CompraVendaModel consultar(int idCompraVenda){//CHECK
        try{
            CompraVendaModel CompraVenda = new CompraVendaModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idCompraVenda);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                CompraVenda.setIdCompraVenda(idCompraVenda);
                CompraVenda.setDataCompraVenda(rs.getString(2));
                CompraVenda.setVendedor(new VendedorModel(rs.getString(3)));
                CompraVenda.setCliente(new ClienteModel(rs.getInt(4)));
                CompraVenda.setVeiculo(new PvendaModel(rs.getInt(5)));
                CompraVenda.setValorCompraVenda(rs.getFloat(6));
                CompraVenda.setTroca(rs.getBoolean(7));
  
                
                
                return CompraVenda;
            } else {
               return null;
            }
            
        } catch (SQLException e){
            
            return null;
        }
    }
    
}
