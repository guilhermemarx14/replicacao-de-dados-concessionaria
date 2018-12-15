
package Model.DAO;

import Controller.MDB;
import Model.DAO.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.ClienteModel;
import Model.Constantes;
import Model.FileController;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sarto
 */
public class ClienteDAO {

    private final String SQLINCLUIR = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?)";
    private final String SQLALTERAR = "UPDATE Cliente SET telefone = ?, nome = ?, cep = ?, complemento = ?, numero = ?, numCartao = ?, numConta = ? WHERE idCliente = ?";
    private final String SQLEXCLUIR = "DELETE FROM Cliente WHERE idCliente = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Cliente WHERE idCliente = ?";
    private final String SQLLASTID = "SELECT MAX(idCliente) FROM Cliente";


    public boolean incluir(ClienteModel cliente){//CHECK, QUANDO NAO SABE O ID A SER INSERIDO, USA O NUMERO ZERO
        try{
            /*String sql = "INSERT INTO CLIENTE VALUES ("+ cliente.getIdCliente() +","+ 
                    cliente.getTelefone() +"','" + cliente.getNome()+ "','" + cliente.getCep()+ "','" + 
                    cliente.getComplemento()+ "','" + cliente.getNumero()+ "','" +cliente.getNumCartao()+ "','" + 
                    cliente.getNumConta()+"')";
            */
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            ps.setInt(1,cliente.getIdCliente());
            ps.setString(2,cliente.getTelefone());
            ps.setString(3,cliente.getNome());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getComplemento());
            ps.setString(6, cliente.getNumero());
            ps.setString(7, cliente.getNumCartao());
            ps.setString(8, cliente.getNumConta());
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
    
    public boolean alterar(ClienteModel cliente){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            
            ps.setString(1,cliente.getTelefone());
            ps.setString(2,cliente.getNome());
            ps.setString(3, cliente.getCep());
            ps.setString(4, cliente.getComplemento());
            ps.setString(5, cliente.getNumero());
            ps.setString(6, cliente.getNumCartao());
            ps.setString(7, cliente.getNumConta());
            ps.setInt(8,cliente.getIdCliente());
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
    
    public boolean excluir(ClienteModel cliente){//CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,cliente.getIdCliente());
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
    
    public ClienteModel consultar(int idCliente){//CHECK
        try{
            ClienteModel cliente = new ClienteModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idCliente);
            
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                cliente.setIdCliente(idCliente);
                cliente.setTelefone(rs.getString(2));
                cliente.setNome(rs.getString(3));
                cliente.setCep(rs.getString(4));
                cliente.setComplemento(rs.getString(5));
                cliente.setNumero(rs.getString(6));
                cliente.setNumCartao(rs.getString(7));
                cliente.setNumConta(rs.getString(8));
                return cliente;
            } else {
                
            }
        } catch (SQLException e){
           
            return null;
        }
        return null;
    }
    
    public int getLastId(){
       
        try {
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLLASTID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
       return 0; 
    }
}

