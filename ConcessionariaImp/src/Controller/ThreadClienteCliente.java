/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FileController;
import interfacesrmi.ClienteClienteInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author guilhermemarx14
 */
public class ThreadClienteCliente extends UnicastRemoteObject implements ClienteClienteInterface{

    
    public ThreadClienteCliente() throws Exception{
        super();
    }
    
    @Override
    public String getScript(int id) throws RemoteException {
        FileController arquivo = new FileController("" + id + ".txt");
        return arquivo.read();
    }
    
    @Override
    public String toString(){
        return "";
    }
}
