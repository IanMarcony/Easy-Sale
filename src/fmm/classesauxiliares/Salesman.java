/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.AuthFrame;
import fmm.scenes.SaleFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ian Marcony
 */
public class Salesman {
    private String user,senha;
    private float total,receber;
    private Date dataCaixa;

    public Date getDataCaixa() {
        return dataCaixa;
    }

    public void setDataCaixa(Date dataCaixa) {
        this.dataCaixa = dataCaixa;
    }
    
    
    public Salesman(String user, String senha, float total, float receber){
        this.user = user;
        this.senha = senha;
        this.total = total;
        this.receber = receber;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getReceber() {
        return receber;
    }

    public void setReceber(float receber) {
        this.receber = receber;
    }
    
    
    
    
    
    public static void alterAccount(String nome) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
       // System.out.println("preparando executar");
        
        try{
            stmt = con.prepareStatement("update conta set username='"+nome+"' where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update produto set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update caixa set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update comprador set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update venda set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update historicovendas set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            AuthFrame.pessoa.setUser(nome);
            
            JOptionPane.showMessageDialog(null,"ALTERADO COM SUCESSO");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO CRIAR USUÁRIO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        
    }
    
    public static void alterAccount(String nome,String senha) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
       // System.out.println("preparando executar");
        
        try{
            stmt = con.prepareStatement("update conta set username='"+nome+"' where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update conta set senha='"+senha+"' where username='"+nome+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update produto set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update caixa set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update comprador set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update venda set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            stmt = con.prepareStatement("update historicovendas set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            
            AuthFrame.pessoa.setUser(nome);
            
            JOptionPane.showMessageDialog(null,"ALTERADO COM SUCESSO");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO CRIAR USUÁRIO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        
    }
    
    public static void alterPass(String senha) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
      //  System.out.println("preparando executar");
        
        try{
            
            stmt = con.prepareStatement("update conta set senha='"+senha+"' where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            
            AuthFrame.pessoa.setSenha(senha);
            
            JOptionPane.showMessageDialog(null,"ALTERADO COM SUCESSO");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO CRIAR USUÁRIO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        
    }
    
}
