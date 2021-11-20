/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.model;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Venda {
    
    private static int vendasCadastradas;

    private int idVenda, idCliente;
    private String data,nomeCliente,cpfCliente;
            
    private String[] produtos; // {ID Produto, nome, quantidade, valor unitario}
    private Double valorTotal;

    public Venda() {
        vendasCadastradas++;
        idVenda = vendasCadastradas;
    }

    public static int getVendasCadastradas() {
        return vendasCadastradas;
    }

    public static void setVendasCadastradas(int vendasCadastradas) {
        Venda.vendasCadastradas = vendasCadastradas;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String[] getProdutos() {
        return produtos;
    }

    public void setProdutos(String[] produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
