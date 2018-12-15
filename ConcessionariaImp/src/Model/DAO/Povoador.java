/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Constantes;
import Model.Constantes;
import Model.FileController;
import Model.FileController;
import java.sql.PreparedStatement;

/**
 *
 * @author guilhermemarx14
 */
public class Povoador {
    public static void povoa(){
        FileController arquivo = new FileController("" + (Constantes.ID+1) + ".txt");
        
        while(arquivo.exists()){ 
            try{
            PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(arquivo.read());
            ps.executeUpdate();
            Constantes.ID++;
            arquivo = new FileController("" + (Constantes.ID+1) + ".txt");
            }catch(Exception e){
                
            }
            
            
        }
    }
    
    public static void getId(){
      FileController arquivo = new FileController("" + (Constantes.ID+1) + ".txt");
      while(arquivo.exists())
      {
          Constantes.ID++;
          arquivo = new FileController("" + (Constantes.ID+1) + ".txt");
      }
    }
}
