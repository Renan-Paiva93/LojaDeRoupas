/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.DAO;

import br.sp.senac.tads.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class ProdutoDAO {

    public static String url = "jdbc:mysql://localhost:3306/lojaderoupas";
    public static String login = "root";
    public static String senha = "admin";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static boolean salvar(Produto obj) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        //PreparedStament instrucaoSQL = null;
        try {
            //ETAPA 1 - Carregadr o driver
            Class.forName(DRIVER);

            //2º passo - abrir conexao
            conexao = DriverManager.getConnection(url, login, senha);

            instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, marca, fornecedor) VALUES (?, ?, ?)");
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getMarca());
            instrucaoSQL.setString(3, obj.getFornecedor());
            //instrucaoSQL.setInt(4, obj.getQuantidade());
            //instrucaoSQL.setDouble(5, obj.getValor());
            //instrucaoSQL.setString(6, obj.getDescricao());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (Exception e) {
            retorno = false;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close(); //libera a conexação com banco
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }

    public static ArrayList<Produto> consultar() {

        ArrayList<Produto> listaRetorno = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null; // retorna obj que consulta no banco

        try {
            //ETAPA 1 - Carregadr o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //ETAPA 2  - Abrir conexao (banco de dados)
            conexao = DriverManager.getConnection(url, login, senha);

            //ETAPA 3 - Executar um comando SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                Produto obj = new Produto();
                obj.setId(rs.getInt("idProduto"));
                obj.setNome(rs.getNString("nome"));
                obj.setMarca(rs.getNString("marca"));
                //obj.setQuantidade(rs.getInt("qtd"));

                listaRetorno.add(obj);

            }

        } catch (Exception e) {

            listaRetorno = null;

        } finally {

            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return listaRetorno;

    }

    public static boolean excluir(int ID) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        //PreparedStament instrucaoSQL = null;
        try {
            //ETAPA 1 - Carregadr o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //ETAPA 2  - Abrir conexao (banco de dados)
            conexao = DriverManager.getConnection(url, login, senha);

            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");

            instrucaoSQL.setInt(1, ID);

            int LinhasAfetadas = instrucaoSQL.executeUpdate();

            if (LinhasAfetadas > 0) {

            } else {
                retorno = true;
            }
            retorno = false;

        } catch (Exception e) {
            retorno = false;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close(); //liberar a conexação com banco
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;

    }

}
        
    
   
       
