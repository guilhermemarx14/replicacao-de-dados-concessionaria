/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Constantes;
import Model.DAO.ConexaoBD;
import Model.FileController;
import interfacesrmi.ClienteClienteInterface;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;

/**
 *
 * @author guilhermemarx14
 */
public class ThreadAtualizaCliente extends UnicastRemoteObject implements Runnable{

    
    static ClienteClienteInterface doador;
    
    public ThreadAtualizaCliente() throws Exception{
        super();
    }
    
    @Override
    public void run() {
        while(true){
            try{
                
                
                String script;
                int idBanco =  MDB.getIdBanco();
                
                if(Constantes.ID == idBanco)
                    continue;
                
                while(Constantes.ID < idBanco)
                {
                    String nomedoador = MDB.getNome(Constantes.ID+1);
                    
                    
                    doador = (ClienteClienteInterface) Naming.lookup(nomedoador);
                    
                    script = doador.getScript(Constantes.ID+1);
                    
                    
                    MDB.registraBanco( Constantes.ID+1, nomedoador);
                    
                    PreparedStatement ps = ConexaoBD.getConexaoBD().prepareStatement(script);
                    ps.executeUpdate();
                    
                    Constantes.ID++;
                    FileController arquivo = new FileController(""+Constantes.ID+".txt");
                    arquivo.write(script);
                    
                }
                
                
            }catch(Exception e){
            }
        }
    }
    
}
