/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.senac.tads.DAO;

import br.sp.senac.tads.model.Cliente;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Dell
 */
public class ClienteDAO {
    
    //criar metodo salvar
    public void create(Cliente c){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            //stmt = con.prepareStatement("INSERT INTO cliente(nome, email, nascimento, cpf, estadoCivil, celular, telefone, endereco) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt = con.prepareStatement("INSERT INTO cliente2 (nome, email, genero, nascimento, cpf, estadoCivil, celular, fixo, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getGenero());
            stmt.setString(4, c.getNascimento());
            stmt.setString(5, c.getCpf());
            stmt.setString(6, c.getEstadoCivil());
            stmt.setString(7, c.getCelular());
            stmt.setString(8, c.getFixo());
            stmt.setString(9, c.getEndereco());
           
            stmt.executeUpdate();
           
           
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Cliente> read() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente2");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCelular(rs.getString("celular"));
                clientes.add(cliente);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            // adicionar uma mensagem
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
        
    }
            
    
    
}
