/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Constantes;
import interfacesrmi.ClienteBancoIdsInterface;
import java.rmi.Naming;

/**
 *
 * @author guilhermemarx14
 */
public class MDB {
    
    static ClienteBancoIdsInterface banco;
    
    public static int getIdBanco(){
        int id;
        while(true){
        try{
        banco = (ClienteBancoIdsInterface) Naming.lookup("//192.168.43.212/BancoId");
        id = banco.getId();
         
        
        return id;
        }catch(Exception e){
        }
        }
    }
    
    public static String getNome(int id){
        String retorno;
        while(true){
            try{
                banco = (ClienteBancoIdsInterface) Naming.lookup("//192.168.43.212/BancoId");
                retorno = banco.getName(id);
                return retorno;
            }catch(Exception e){}
        }
    }
    
    public static void updateIdBanco(){
        while(true){
            try{
                banco = (ClienteBancoIdsInterface) Naming.lookup("//192.168.43.212/BancoId");
                banco.updateId(Constantes.meuNome);
                return;
            }catch(Exception e){}
        }
    }
    
    public static boolean registraBanco(int id, String doador){
        while(true){
            
            try{
                banco = (ClienteBancoIdsInterface) Naming.lookup("//192.168.43.212/BancoId");
                banco.registra(doador,id,Constantes.meuNome);
                
                return true;
                
            }catch(Exception e){}
        }
        
    }
    
    
    
}
