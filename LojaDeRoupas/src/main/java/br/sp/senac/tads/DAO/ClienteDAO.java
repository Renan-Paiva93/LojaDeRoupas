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
import java.sql.SQLException;
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
            //stmt = con.prepareStatement("INSERT INTO cliente(nome, email, sexo, nascimento, cpf, estadoCivil, celular, telefone, endereco(?,?,?,?,?,?,?,?,?)");
            stmt = con.prepareStatement("INSERT INTO cliente2 (nome) VALUES (?)");
           stmt.setString(1, c.getNome());
           //stmt.setString(2, c.getEmail());
           //stmt.setString(3, c.getGenero());
           //stmt.setString(4, c.getNascimento());
           //stmt.setString(5, c.getCpf());
           //stmt.setString(6, c.getEstadoCivil());
           //stmt.setString(7, c.getCelular());
           //stmt.setString(8, c.getFixo());
           //stmt.setString(9, c.getEndereco());
           
           stmt.executeUpdate();
           
           
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
