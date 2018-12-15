/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.MDB;
import Model.Constantes;
import Model.FileController;
import Model.MecanicoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sarto
 */
public class MecanicoDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Mecanico VALUES (?,?)";
    private final String SQLALTERAR = "UPDATE Mecanico SET comissaoPorRevisao =? WHERE cpfFuncionario = ?";
    private final String SQLEXCLUIR = "DELETE FROM Mecanico WHERE cpfFuncionario = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Mecanico WHERE cpfFuncionario = ?";

  
    // TESTAR
    public boolean incluir(MecanicoModel mecanico){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setString(1, mecanico.getCpfFuncionario());
            ps.setFloat(2, mecanico.getComissaoPorRevisao());
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
    
    public boolean alterar(MecanicoModel mecanico){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setFloat(1, mecanico.getComissaoPorRevisao());
            ps.setString(2,mecanico.getCpfFuncionario());
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
    
    public boolean excluir(MecanicoModel mecanico){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setString(1,mecanico.getCpfFuncionario());
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
    
    public MecanicoModel consultar(String cpfFuncionario){ //CHECK
        try{
            MecanicoModel mecanico = new MecanicoModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setString(1,cpfFuncionario);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                mecanico.setComissaoPorRevisao(rs.getFloat(2));
                return mecanico;
            } else {
                return null;
            }
            
        } catch (SQLException e){
            
            return null;
        }
    }
}
