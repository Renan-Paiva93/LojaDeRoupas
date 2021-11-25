/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.model;

/**
 *
 * @author Dell
 */
public class Produto {
    
    public static int produtosCadastrados;
    private int id, quantidade;
    private double valor;
    private String nome,fornecedor, marca, descricao;

    public Produto() {
        produtosCadastrados++;
        this.id = produtosCadastrados;
    }

    public static int getProdutosCadastrados() {
        return produtosCadastrados;
    }

    public static void setProdutosCadastrados(int produtosCadastrados) {
        Produto.produtosCadastrados = produtosCadastrados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    

}
