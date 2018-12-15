/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.MDB;
import Model.Constantes;
import Model.DAO.ConexaoBD;
import Model.FileController;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.PvendaModel;

/**
 *
 * @author innanplinio
 */
public class PvendaDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Pvenda VALUES (?,?)";
    private final String SQLALTERAR = "UPDATE Pvenda SET precoVenda = ? WHERE idVeiculo = ?";
    private final String SQLEXCLUIR = "DELETE FROM Pvenda WHERE idVeiculo = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Pvenda WHERE idVeiculo = ?";
    
    
    //TESTAR
    public boolean incluir(PvendaModel Pvenda){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setInt(1, Pvenda.getIdVeiculo());
            ps.setFloat(2,Pvenda.getPrecoVenda());
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
    
    public boolean alterar(PvendaModel Pvenda){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            
            ps.setFloat(1, Pvenda.getPrecoVenda());
            ps.setInt(2, Pvenda.getIdVeiculo());
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
    
    public boolean excluir(PvendaModel Pvenda){
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,Pvenda.getIdVeiculo());
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
    
    public PvendaModel consultar(int idVeiculo){ //CHECK
        try{
            PvendaModel Pvenda = new PvendaModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idVeiculo);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                Pvenda.setIdVeiculo(idVeiculo);
                Pvenda.setPrecoVenda(rs.getFloat(2));
                return Pvenda;
            }
        } catch (SQLException e){
           
            return null;
        }
        return null;
    }
    
}
