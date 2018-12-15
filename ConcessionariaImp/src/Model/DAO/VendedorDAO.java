/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.MDB;
import Model.Constantes;
import Model.FileController;
import Model.VendedorModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sarto
 */
public class VendedorDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Vendedor VALUES (?,?)";
    private final String SQLALTERAR = "UPDATE Vendedor SET  porcentagemComissao =? WHERE cpfFuncionario = ?";
    private final String SQLEXCLUIR = "DELETE FROM Vendedor WHERE cpfFuncionario = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Vendedor WHERE cpfFuncionario = ?";

  
   
    public boolean incluir(VendedorModel vendedor){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setString(1,vendedor.getCpfFuncionario());
            ps.setInt(2, vendedor.getPorcentagemComissao());
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
    
    public boolean alterar(VendedorModel vendedor){ // CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setInt(1, vendedor.getPorcentagemComissao());
            ps.setString(2,vendedor.getCpfFuncionario());
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
    
    public boolean excluir(VendedorModel vendedor){ // CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setString(1,vendedor.getCpfFuncionario());
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
    
    public VendedorModel consultar(String cpfFuncionario){ // CHECK
        try{
            VendedorModel vendedor = new VendedorModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setString(1,cpfFuncionario);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                vendedor.setPorcentagemComissao(rs.getInt(2));
                return vendedor;
            } else {
                return null;
            }
            
        } catch (SQLException e){
            
            return null;
        }
    }
}
