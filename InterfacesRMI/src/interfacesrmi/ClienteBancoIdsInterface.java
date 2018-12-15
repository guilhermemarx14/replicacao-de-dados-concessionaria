/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author guilhermemarx14
 */
public interface ClienteBancoIdsInterface  extends Remote{
    public int getId() throws RemoteException;
    public void updateId(String name) throws RemoteException;
    public String getName(int id) throws RemoteException;
    public void registra(String nomeDoador,int id, String nomeRecebedor) throws RemoteException;
}
