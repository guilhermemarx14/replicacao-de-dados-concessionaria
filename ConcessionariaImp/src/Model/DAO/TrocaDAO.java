/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.MDB;
import Model.CompraVendaModel;
import Model.Constantes;
import Model.FileController;
import Model.TrocaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sarto
 */
public class TrocaDAO {
    
    // NAO SEI FAZER ESSA MERDAAAAAA
    private final String SQLINCLUIR = "INSERT INTO Troca VALUES (?,?)";
    private final String SQLALTERAR = "UPDATE Troca SET  WHERE venda = ? AND compra = ?";
    private final String SQLEXCLUIR = "DELETE FROM Troca WHERE venda = ? AND compra = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Troca WHERE venda = ? AND compra = ?";
    
    // TESTAR
    public boolean incluir(TrocaModel troca){
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setInt(1, troca.getVenda().getIdCompraVenda());
            ps.setInt(2,troca.getCompra().getIdCompraVenda());
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
    
    public boolean alterar(TrocaModel troca){
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setInt(1, troca.getVenda().getIdCompraVenda());
            ps.setInt(2,troca.getCompra().getIdCompraVenda());
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
    
    public boolean excluir(TrocaModel troca){
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,troca.getVenda().getIdCompraVenda());
            ps.setInt(2, troca.getCompra().getIdCompraVenda());
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
    
    public TrocaModel consultar(int idVenda, int idCompra){
        try{
            TrocaModel troca = new TrocaModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, idVenda);
            ps.setInt(2, idCompra);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                troca.setVenda(new CompraVendaModel(rs.getInt(1)));
                troca.setCompra(new CompraVendaModel(rs.getInt(2)));
                return troca;
            }
        } catch (SQLException e){
           
            return null;
        }
        return null;
    }
    
}
