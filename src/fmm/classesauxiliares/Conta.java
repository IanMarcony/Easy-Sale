/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

/**
 *
 * @author Ian Marcony
 */
public class Conta {
    
    private String user, senha;
    private Email email;

    public Conta(String user, String senha, String email) {
        this.user = user;
        this.senha = senha;
        this.email = new Email(email);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public void setEmail(String email) {
        this.email.setEndereco(email);
    }
  
    
}
