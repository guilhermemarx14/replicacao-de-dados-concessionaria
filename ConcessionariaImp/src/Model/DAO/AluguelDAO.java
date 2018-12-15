
package Model.DAO;

/**
 *
 * @author sarto
 */
import Controller.MDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.AluguelModel;
import Model.Constantes;
import Model.FileController;

public class AluguelDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Aluguel VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String SQLALTERAR = "UPDATE Aluguel SET valorTotal = ?,"
            + "kmRodados = ?, dataFim = ?, dataInicio = ?, multaAtraso = ?, finalizado = ? WHERE idVeiculo = ? AND idCliente = ? AND idVendedor = ? AND idRevisao = ?";
    private final String SQLEXCLUIR = "DELETE FROM Aluguel WHERE idVeiculo = ? AND idCliente = ? AND idVendedor = ? AND idRevisao = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Aluguel WHERE idVeiculo = ? AND idCliente = ? AND idVendedor = ? AND idRevisao = ?";

  
    public boolean incluir(AluguelModel aluguel){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR);
            ps.setInt(1,aluguel.getVeiculo().getIdVeiculo());
            ps.setInt(2,aluguel.getCliente().getIdCliente());
            ps.setString(3,aluguel.getVendedor().getCpfFuncionario());
            ps.setInt(4,aluguel.getRevisao().getIdRevisao());
            ps.setFloat(5,aluguel.getValorTotal());
            ps.setInt(6,aluguel.getKmRodados());
            ps.setString(7,aluguel.getDataFim().toString());
            ps.setString(8,aluguel.getDataInicio().toString());
            ps.setFloat(9,aluguel.getMultaAtraso());
            ps.setInt(10,(aluguel.isFinalizado()));
                       
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
    
    public boolean alterar(AluguelModel aluguel){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setFloat(1,aluguel.getValorTotal());
            ps.setInt(2,aluguel.getKmRodados());
            ps.setString(3,aluguel.getDataFim().toString());
            ps.setString(4,aluguel.getDataInicio().toString());
            ps.setFloat(5,aluguel.getMultaAtraso());
            ps.setInt(6,aluguel.isFinalizado());
            ps.setInt(7,aluguel.getVeiculo().getIdVeiculo());
            ps.setInt(8,aluguel.getCliente().getIdCliente());
            ps.setString(9,aluguel.getVendedor().getCpfFuncionario());
            ps.setInt(10,aluguel.getRevisao().getIdRevisao());
            //System.out.println(ps);
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
    
    public boolean excluir(AluguelModel aluguel){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,aluguel.getVeiculo().getIdVeiculo());
            ps.setInt(2,aluguel.getCliente().getIdCliente());
            ps.setString(3,aluguel.getVendedor().getCpfFuncionario());
            ps.setInt(4,aluguel.getRevisao().getIdRevisao());
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
    
    public AluguelModel consultar(int idVeiculo, int idCliente, String idVendedor, int idRevisao){ //CHECK 
        try{
            AluguelModel aluguel = new AluguelModel();
           // String teste= "SELECT * FROM Aluguel WHERE idVeiculo = "+idVeiculo+", idCliente ="+ idCliente+", idVendedor =\'"+idVendedor+"\', idRevisao = "+idRevisao+"";
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idVeiculo);
            ps.setInt(2,idCliente);
            ps.setString(3,idVendedor);
            ps.setInt(4,idRevisao);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                aluguel.setValorTotal(rs.getFloat(5));
                aluguel.setKmRodados(rs.getInt(6));
                aluguel.setDataFim(rs.getString(7));
                aluguel.setDataInicio(rs.getString(8));
                aluguel.setMultaAtraso(rs.getFloat(9));
                aluguel.setFinalizado(rs.getInt(10));
                return aluguel;
            } else {
                return null;
            }
      
         } catch (SQLException e){
            
            return null;
        }
    }
}
