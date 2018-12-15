/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Controller.MDB;
import Model.ClienteModel;
import Model.Constantes;
import Model.DAO.ConexaoBD;
import Model.DataModel;
import Model.FileController;
import Model.MecanicoModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.RevisaoModel;
import Model.VeiculoModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author innanplinio
 */
public class RevisaoDAO {
    
    private final String SQLINCLUIR = "INSERT INTO Revisao VALUES (?,?,?,?,?,?,?,?)";
    private final String SQLALTERAR = "UPDATE Revisao SET efetivado = ?, valorConserto = ?, dataRevisao = ?,"
            + "idCliente = ?,  valorRevisao = ?,  idVeiculo = ?, idMecanico = ? "
            + "WHERE  idRevisao = ? ";
    private final String SQLEXCLUIR = "DELETE FROM Revisao WHERE idRevisao = ?";
    private final String SQLCONSULTAR = "SELECT * FROM Revisao WHERE idRevisao = ?";
   // private final String SQLLASTID = "SELECT MAX(idRevisao) FROM Revisao";
    
    // TESTAR
     public boolean incluir(RevisaoModel revisao){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLINCLUIR); // serve para substituir o codigo de cima
            
            ps.setInt(1,revisao.getIdRevisao());
            ps.setInt(2,revisao.isEfetivado()? 1:0);
            ps.setFloat(3,revisao.getValorConserto());
            ps.setString(4, revisao.getDataRevisao().toString());
            ps.setInt(5,revisao.getCliente().getIdCliente());
            ps.setFloat(6,revisao.getValorRevisao());
            ps.setInt(7,revisao.getVeiculo().getIdVeiculo());
            ps.setString(8,revisao.getMecanico().getCpfFuncionario());
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
    
    public boolean alterar(RevisaoModel Revisao){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLALTERAR);
            ps.setInt(1,Revisao.isEfetivado()? 1:0);
            ps.setFloat(2,Revisao.getValorConserto());
            ps.setString(3,Revisao.getDataRevisao().toString());
            ps.setInt(4, Revisao.getCliente().getIdCliente());
            ps.setFloat(5,Revisao.getValorRevisao());
            ps.setInt(6,Revisao.getVeiculo().getIdVeiculo());
            ps.setString(7,Revisao.getMecanico().getCpfFuncionario());
            ps.setInt(8,Revisao.getIdRevisao());
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
    
    public boolean excluir(RevisaoModel Revisao){ //CHECK
        try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLEXCLUIR);
            ps.setInt(1,Revisao.getIdRevisao());
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
    
    public RevisaoModel consultar(int idRevisao){ //CHECK
        try{
            RevisaoModel Revisao = new RevisaoModel();
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLCONSULTAR);
            ps.setInt(1,idRevisao);
            ResultSet rs = ps.executeQuery(); // começa lendo o arquivo antes do primeiro registro (bof - bottom of file)
            if(rs.next()){ // peço pro rs pular pro primeiro registro encontrado
                Revisao.setIdRevisao(idRevisao);
                Revisao.setEfetivado(rs.getInt(2)==1?true:false);
                Revisao.setValorConserto(rs.getFloat(3));
                Revisao.setDataRevisao(rs.getString(4));
                Revisao.setCliente(new ClienteModel (rs.getInt(5)));
                Revisao.setValorRevisao(rs.getFloat(6));
                Revisao.setVeiculo(new VeiculoModel (rs.getInt(7)));
                Revisao.setMecanico(new MecanicoModel(rs.getString(8)));
                return Revisao;
            } else {
               return null;
            }
            
        } catch (SQLException e){
            
            return null;
        }
    }
//    public int getLastId(){
//       
//        try {
//            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(SQLLASTID);
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//         }
//       return 0; 
//    }
//    
}
