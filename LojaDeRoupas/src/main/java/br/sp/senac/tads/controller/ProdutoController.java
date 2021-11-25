/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.controller;

import br.sp.senac.tads.DAO.ProdutoDAO;
import br.sp.senac.tads.model.Produto;

/**
 *
 * @author Dell
 */
public class ProdutoController {
    
    public static boolean salvar(String pNome, String pMarca, String pFornecedor, int pQtd, double pValor, String pDescricao){
        
        //Criar obj nota fiscal 
        Produto prod = new Produto();
        prod.setNome(pNome);
        prod.setMarca(pMarca);
        prod.setFornecedor(pFornecedor);
        prod.setQuantidade(pQtd);
        prod.setValor(pValor);
        prod.setDescricao(pDescricao);
        
        return ProdutoDAO.salvar(prod);
       

       
    }
    
}
