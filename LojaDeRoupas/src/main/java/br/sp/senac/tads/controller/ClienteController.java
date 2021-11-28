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
    
    ClienteDAO cliente = new ClienteDAO();
    
    public static boolean salvar(String pNome, String pEmail, String pGenero, String pNascimento,
                                 String pCpf, String pEstadoCivil, String pCel, String pFixo, String pEndereco){
        
        Cliente c = new Cliente();
        c.setNome(pNome);
        c.setEmail(pEmail);
        c.setGenero(pGenero);
        c.setNascimento(pNascimento);
        c.setCpf(pCpf);
        c.setEstadoCivil(pEstadoCivil);
        c.setCelular(pCel);
        c.setFixo(pFixo);
        c.setEndereco(pEndereco);
        
        return ClienteDAO.salvar(c);
    }
    
    public static boolean excluir(int ID){   
        return ClienteDAO.excluir(ID);     
    }
    
    public ArrayList pesquisarNomeController(Cliente clienteBean) {
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        listaCliente = cliente.pesquisarClienteNome(clienteBean);
        return listaCliente;
    }
    
    /**
     * Método responsável por pesquisar um Cliente por CPF.
     * 
     * @param clienteBean Recebe um Objeto do Tipo Cliente.
     * @return retorna uma lista contendo o Objeto Cliente pesquisado.
     */
    public ArrayList pesquisarCpfController(Cliente clienteBean) {
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        listaCliente = cliente.pesquisarClienteCpf(clienteBean);
        return listaCliente;
    }
    
    
    
    public static ArrayList<String[]> consultar(){


    ArrayList<Cliente> listaRetorno = ClienteDAO.consultar();
    ArrayList<String[]> retornoView = new ArrayList<>();   
     
    for (Cliente cliente : listaRetorno) {

            retornoView.add(new String[] {
                
                String.valueOf(cliente.getId()),
                String.valueOf(cliente.getNome()),
                String.valueOf(cliente.getEmail()),
                String.valueOf(cliente.getCelular()),

              }
          );
    } 
    return retornoView;     
  }
   
}    
