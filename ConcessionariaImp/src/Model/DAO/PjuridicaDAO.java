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
import Model.PjuridicaModel;

/**
 *
 * @author innanplinio
 */
public class PjuridicaDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Pjuridica VALUES (?,?)";
    private final String SQLALTERAR = "UPDATE Pjuridica SET cnpj = ? WHERE idCliente = ?";
    private final String SQLEXCLUIR = "DELETE FROM Pjuridica WHERE idCliente = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Pjuridica WHERE idCliente = ?";
    
    //TESTAR
    public boolean incluir(PjuridicaModel pessoa){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setInt(1, pessoa.getIdCliente());
            ps.setString(2,pessoa.getCnpj());
            
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
    
    public boolean alterar(PjuridicaModel pessoa){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setString(1, pessoa.getCnpj());
            ps.setInt(2, pessoa.getIdCliente());
            
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
    
    public boolean excluir(PjuridicaModel pessoa){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,pessoa.getIdCliente());
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
    
    public PjuridicaModel consultar(int idCliente){ //CHECK
        try{
            PjuridicaModel Pjuridica = new PjuridicaModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idCliente);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                Pjuridica.setIdCliente(idCliente);
                Pjuridica.setCnpj(rs.getString(2));
                return Pjuridica;
            }
        } catch (SQLException e){
           
            return null;
        }
        return null;
    }
    
    
}
