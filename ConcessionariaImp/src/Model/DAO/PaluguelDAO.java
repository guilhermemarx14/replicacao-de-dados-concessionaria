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
import Model.PaluguelModel;

/**
 *
 * @author innanplinio
 */
public class PaluguelDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Paluguel VALUES (?,?,?)";
    private final String SQLALTERAR = "UPDATE Paluguel SET precoFixo = ?, precoPorKm = ?"
            + " WHERE idVeiculo = ?";
    private final String SQLEXCLUIR = "DELETE FROM Paluguel WHERE idVeiculo = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Paluguel WHERE idVeiculo = ?";
    
    // TESTAR
    public boolean incluir(PaluguelModel veiculo){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setInt(1, veiculo.getIdVeiculo());
            ps.setFloat(2,veiculo.getPrecoFixo());
            ps.setFloat(3,veiculo.getPrecoPorKm());
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
    
    public boolean alterar(PaluguelModel veiculo){ // CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            
            ps.setFloat(1, veiculo.getPrecoFixo());
            ps.setFloat(2, veiculo.getPrecoPorKm());
            ps.setInt(3, veiculo.getIdVeiculo());
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
    
    public boolean excluir(PaluguelModel veiculo){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,veiculo.getIdVeiculo());
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
    
    public PaluguelModel consultar(int idVeiculo){ //CHECK
        
        try{
            PaluguelModel Paluguel = new PaluguelModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idVeiculo);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                Paluguel.setIdVeiculo(idVeiculo);
                Paluguel.setPrecoFixo(rs.getFloat(2));
                Paluguel.setPrecoPorKm(rs.getFloat(3));
                return Paluguel;
            }
        } catch (SQLException e){
           
            return null;
        }
        return null;
    }
    
}
