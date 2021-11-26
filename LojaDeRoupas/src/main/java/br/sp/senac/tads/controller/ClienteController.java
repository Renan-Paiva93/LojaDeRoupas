/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.controller;

import br.sp.senac.tads.DAO.ClienteDAO;
import br.sp.senac.tads.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ClienteController {
    
    public static boolean salvar(String pNome, String pEmail, String pGenero, String pNascimento,
                                 String pCpf, String pEstCivil, String pCel, String pFixo, String pEndereco){
        
        Cliente c = new Cliente();
        c.setNome(pNome);
        c.setEmail(pEmail);
        c.setGenero(pGenero);
        c.setNascimento(pNascimento);
        c.setCpf(pCpf);
        c.setEstadoCivil(pEstCivil);
        c.setCelular(pCel);
        c.setFixo(pFixo);
        c.setEndereco(pEndereco);
        
        return ClienteDAO.salvar(c);
    }
    
    public static boolean excluir(int ID){   
        return ClienteDAO.excluir(ID);     
    }
    
    public static ArrayList<String[]> consultar(){


    ArrayList<Cliente> listaRetorno = ClienteDAO.consultar();
    ArrayList<String[]> retornoView = new ArrayList<>();

     
    for (Cliente produto : listaRetorno) {

            retornoView.add(new String[] {
                
                String.valueOf(produto.getId()),
                String.valueOf(produto.getNome()),
                String.valueOf(produto.getEmail()),

              }
          );
    } 
    return retornoView;     
  }
    
}    

    
    
    
   
    

