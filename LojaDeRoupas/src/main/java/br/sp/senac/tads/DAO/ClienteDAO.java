/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.DAO;

import br.sp.senac.tads.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author renan.paiva
 */
public class ClienteDAO {
    
    //public static String url="jdbc:mysql://localhost:3307/basenotafiscal?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public static String url = "jdbc:mysql://localhost:3307/lojaderoupas";
    public static String login = "root";
    public static String senha = "";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static boolean salvar(Cliente obj){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(url, login, senha);
            
            // Fazer INSERT na tabela
            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome, email, genero, nascimento, cpf, estadoCivil, celular, fixo, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getEmail());
            instrucaoSQL.setString(3, obj.getGenero());
            instrucaoSQL.setString(4, obj.getNascimento());
            instrucaoSQL.setString(5, obj.getCpf());     
            instrucaoSQL.setString(6, obj.getEstadoCivil());
            instrucaoSQL.setString(7, obj.getCelular());
            instrucaoSQL.setString(8, obj.getFixo());
            instrucaoSQL.setString(9, obj.getEndereco());
           
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
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return retorno;
    }

    public static ArrayList<Cliente> consultar() {

        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null; // retorna obj que consulta no banco

        try {
            //ETAPA 1 - Carregadr o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //ETAPA 2  - Abrir conexao (banco de dados)
            conexao = DriverManager.getConnection(url, login, senha);

            //ETAPA 3 - Executar um comando SQL
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente");

            rs = instrucaoSQL.executeQuery();

            // Espelho da cosulta do banco da dados
            while (rs.next()) {

                Cliente obj = new Cliente();
                obj.setId(rs.getInt("idCliente"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setGenero(rs.getString("genero"));
                obj.setNascimento(rs.getString("nascimento"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEstadoCivil(rs.getString("estadoCivil"));
                obj.setCelular(rs.getString("celular"));
                obj.setFixo(rs.getString("fixo"));
                obj.setEndereco(rs.getString("endereco"));
  

                listaRetorno.add(obj); // adiciona o objeto e manda para lista

            }

        } catch (Exception e) {

            listaRetorno = null;

        } finally {

            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
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

            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");

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
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;

    }
    
    public ArrayList<Cliente> pesquisarClienteNome(Cliente clienteBean) {
        
        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        Connection conexao = null;
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, login, senha);
            instrucaoSQL = conexao.prepareStatement("select ID_CLIENTE, NOME_CLIENTE, CPF, SEXO from CLIENTE where NOME_CLIENTE like ?");
            instrucaoSQL.setString(1, clienteBean.getNome() + "%");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("ID_CLIENTE"));
                cli.setNome(rs.getString("NOME_CLIENTE"));
                cli.getCpf(rs.getString("CPF"));
                cli.setGenero(rs.getString("SEXO"));
                listaCliente.add(cli);
            }
            return listaCliente;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha na consulta!");
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                //Fecho a minha conexão
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao fechar a conexão!");
            }
        }
    }

    public ArrayList<Cliente> pesquisarClienteCpf(Cliente clienteBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   }

