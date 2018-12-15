/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author guilhermemarx14
 */
public class FileController {
    String fileName;
    BufferedReader buffRead;
    BufferedWriter buffWrite;
    
    public FileController (String name)
    {
        this.fileName = name;
    }
    
    public String read(){
        String retorno = "";
        try{
            buffRead = new BufferedReader(new FileReader(fileName));
            
            String line = buffRead.readLine();
            
            while (line != null)
            {
                retorno+= " " + line;
                line = buffRead.readLine();
            }
            
            buffRead.close();
        }catch(Exception e){}
        return retorno;
    }
    
    public void write(String texto){//Escreve um ArrayList de strings no arquivo, sendo que cada String vira uma nova linha no arquivo
        try{
            
        buffWrite = new BufferedWriter(new FileWriter(fileName));
       
            buffWrite.append(texto);
        
        buffWrite.close();
        }catch(Exception e){}
    }
    
    public boolean exists(){//Verifica se o arquivo existe
        File arq = new File(this.fileName);
        return arq.exists();
    }
}

