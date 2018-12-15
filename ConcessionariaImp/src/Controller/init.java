/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.Povoador;
import Model.*;
import Model.DAO.*;
import frame.MainFrame;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author sarto
 */

public class init {
    public static void main(String[] args){
       
        try{
        Povoador.getId();//atualiza id do banco de dados local
        Constantes.meuNome = "//"+ InetAddress.getLocalHost().getHostAddress() +":55555/Cliente3";;
            
        //Abre o servidor RMI para fornecer os scripts a outros clientes
        Registry registry = LocateRegistry.createRegistry(55555);
        
        System.setProperty( "java.rmi.server.hostname", ""+InetAddress.getLocalHost().getHostAddress()+"" );
        System.out.println(Constantes.ID);
        Naming.rebind(Constantes.meuNome, new ThreadClienteCliente());
        System.out.println("cliente3 rodando");
        
        //starta a thread que mantem o banco atualizado
        Thread thread = new Thread(new ThreadAtualizaCliente());//STARTA O TRABALHO CLIENTE
        thread.start();
        
        //start no programa
        MainFrame.main(args);
        
        }catch(Exception e){}
    }
    
}
