
package Model.DAO;

/**
 *
 * @author sarto
 */

import Controller.MDB;
import Model.Constantes;
import Model.DAO.ConexaoBD;
import Model.FileController;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.FuncionarioModel;

public class FuncionarioDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Funcionario VALUES (?,?,?,?)";
    private final String SQLALTERAR = "UPDATE Funcionario SET salarioFixo = ?, nome = ?, telefone = ? WHERE cpfFuncionario = ?";
    private final String SQLEXCLUIR = "DELETE FROM Funcionario WHERE cpfFuncionario = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Funcionario WHERE cpfFuncionario = ?";

  
    
    public boolean incluir(FuncionarioModel funcionario){   // CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setString(1,funcionario.getCpfFuncionario());
            ps.setFloat(2,funcionario.getSalarioFixo());
            ps.setString(3,funcionario.getNome());
            ps.setString(4, funcionario.getTelefone());
            
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
    
    public boolean alterar(FuncionarioModel funcionario){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setFloat(1,funcionario.getSalarioFixo());
            ps.setString(2,funcionario.getNome());
            ps.setString(3, funcionario.getTelefone());
            ps.setString(4,funcionario.getCpfFuncionario());
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
    
    public boolean excluir(FuncionarioModel funcionario){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setString(1,funcionario.getCpfFuncionario());
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
    
    public FuncionarioModel consultar(String cpfFuncionario){ // CHECK
        try{
            FuncionarioModel funcionario = new FuncionarioModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setString(1,cpfFuncionario);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                funcionario.setCpfFuncionario(cpfFuncionario);
                funcionario.setSalarioFixo(rs.getFloat(2));
                funcionario.setNome(rs.getString(3));
                funcionario.setTelefone(rs.getString(4));
                return funcionario;
            } else {
                return null;
            }
            
        } catch (SQLException e){
            
            return null;
        }
    }
   
}
