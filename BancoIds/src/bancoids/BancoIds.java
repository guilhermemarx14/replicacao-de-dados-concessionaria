/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoids;

import interfacesrmi.ClienteBancoIdsInterface;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilhermemarx14
 */
public class BancoIds extends UnicastRemoteObject implements ClienteBancoIdsInterface{

    /**
     * @param args the command line arguments
     */
    public static ArrayList<String> banco = new ArrayList<>();
    public static int estadoAtual;
    
    public BancoIds() throws Exception{
        super();
    }
    
    public static void main(String[] args) {
        try {
            estadoAtual = Integer.parseInt(args[0]);
            for(int i =0;i<=estadoAtual;i++)
                banco.add("//"+InetAddress.getLocalHost().getHostAddress()+"/Cliente1");
            
            try {
                Registry registry = LocateRegistry.createRegistry(1099);
                System.setProperty( "java.rmi.server.hostname", ""+InetAddress.getLocalHost().getHostAddress() );
                Naming.rebind("//"+InetAddress.getLocalHost().getHostAddress()+"/BancoId", new BancoIds());
                System.out.println("Server ready");
                
            } catch (Exception e) {
                
                System.err.println("Server exception: " + e.toString());
                
            }
        } catch (UnknownHostException ex) {

            Logger.getLogger(BancoIds.class.getName()).log(Level.SEVERE, null, ex);

        } 
    }

    @Override
    public int getId() throws RemoteException {
        return this.estadoAtual;
    }

    @Override
    public void updateId(String name) throws RemoteException {
        System.out.println(name.split("/")[name.split("/").length-1] + " atualizou o Banco novo id = "+(this.estadoAtual+1));
        this.estadoAtual++;
        banco.add(name);
    }

    @Override
    public String getName(int id) throws RemoteException {
        return banco.get(id);
    
    }

    @Override
    public void registra(String nomeDoador, int id, String nomeRecebedor) throws RemoteException {
        System.out.println(nomeRecebedor.split("/")[nomeRecebedor.split("/").length-1] + " solicitou script de id="+id+" a "+nomeDoador.split("/")[nomeDoador.split("/").length-1]);
    }
    
}
