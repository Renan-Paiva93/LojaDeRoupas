/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.tads.controller;

import br.sp.senac.tads.DAO.ClienteDAO;
import br.sp.senac.tads.model.Cliente;

/**
 *
 * @author Dell
 */
public class RelatoriosController {
    
    ClienteDAO cliente = new ClienteDAO();
    
    public void cadastrarController(Cliente clienteBean) {
        cliente.casdastroCLiente(clienteBean);
    }
    
    public void alterarContrller(Cliente clienteBean) {
        cliente.alterarCLiente(clienteBean);
    }
    
}
