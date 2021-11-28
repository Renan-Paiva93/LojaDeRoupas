
package br.sp.senac.tads.model;
/**
 *
 * @author Dell
 */
public class Cliente {
    
   private static int clientesCadastrados;
    private int id;
    private String nome,
            email,
            cpf,
            genero,
            nascimento,
            celular,
            fixo,
            estadoCivil,
            endereco;

    public Cliente() {
        clientesCadastrados++;
        //this.id = clientesCadastrados;
    
    }

    public static int getClientesCadastrados() {
        return clientesCadastrados;
    }

    public static void setClientesCadastrados(int clientesCadastrados) {
        Cliente.clientesCadastrados = clientesCadastrados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void getCpf(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


