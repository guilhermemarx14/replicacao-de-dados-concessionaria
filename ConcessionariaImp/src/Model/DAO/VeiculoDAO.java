
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
import Model.VeiculoModel;

public class VeiculoDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Veiculo VALUES (?,?,?,?,?,?,?,?)";
    private final String SQLALTERAR = "UPDATE Veiculo SET km = ?, situacao = ?, placa = ?, tipo = ?, modelo = ?, montadora = ?,"
            + "cor = ? WHERE idVeiculo = ?";
    private final String SQLEXCLUIR = "DELETE FROM Veiculo WHERE idVeiculo = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Veiculo WHERE idVeiculo = ?";

//    public VeiculoDAO(VeiculoModel veiculo){
//        this.veiculo = veiculo;
//    }
  
    public boolean incluir(VeiculoModel veiculo){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setInt(1,veiculo.getIdVeiculo());
            ps.setInt(2,veiculo.getKm());
            ps.setInt(3,veiculo.getSituacao());
            ps.setString(4, veiculo.getPlaca());
            ps.setString(5,veiculo.getModelo());
            ps.setString(6,veiculo.getMontadora());
            ps.setString(7,veiculo.getCor());
            ps.setString(8, veiculo.getTipo());
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
    
    public boolean alterar(VeiculoModel veiculo){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setInt(1,veiculo.getKm());
            ps.setInt(2,veiculo.getSituacao());
            ps.setString(3, veiculo.getPlaca());
            ps.setString(4,veiculo.getTipo());
            ps.setString(5,veiculo.getModelo());
            ps.setString(6,veiculo.getMontadora());
            ps.setString(7,veiculo.getCor());
            ps.setInt(8, veiculo.getIdVeiculo());
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
    
    public boolean excluir(VeiculoModel veiculo){ //CHECK
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
    
    public VeiculoModel consultar(int idVeiculo){ //CHECK
        try{
            VeiculoModel veiculo = new VeiculoModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idVeiculo);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                veiculo.setIdVeiculo(idVeiculo);
                veiculo.setKm(rs.getInt(1));
                veiculo.setSituacao(rs.getInt(2));
                veiculo.setPlaca(rs.getString(3));
                veiculo.setTipo(rs.getString(4));
                veiculo.setModelo(rs.getString(5));
                veiculo.setMontadora(rs.getString(6));
                veiculo.setCor(rs.getString(7));
                return veiculo;
            } else {
               return null;
            }
            
        } catch (SQLException e){
            return null;
        }
    }
}
