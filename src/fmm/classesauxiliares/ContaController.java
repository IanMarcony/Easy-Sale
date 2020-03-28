/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.AuthFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 2aimaq20
 */
public class ContaController {
    
    
    public static int verificaPass(String p1, String p2,boolean a,boolean b,boolean c){
        if(!(p1.length()>=8&&p1.length()<=16)&&(p1.equals(p2))&&(!a||b||c)){
            return 0;
        }
        else if(!(p1.equals(p2))&&(p1.length()>=8&&p1.length()<=16)&&(!a||b||c)){
          return 1;
        }
        else if(!(p1.equals(p2))&&!(p1.length()>=8&&p1.length()<=16)&&(!a||b||c)){
            return 2;
        }
        else{
            return 3;
        }
    }
    
    public static int verificaPass(String p1, String p2){
        if(!(p1.length()>=8&&p1.length()<=16)&&(p1.equals(p2))){
            return 0;
        }
        else if(!(p1.equals(p2))&&(p1.length()>=8&&p1.length()<=16)){
          return 1;
        }
        else if(!(p1.equals(p2))&&!(p1.length()>=8&&p1.length()<=16)){
            return 2;
        }
        else{
            return 3;
        }
    }
    
    public static boolean PesquisaConta(String nome) throws ClassNotFoundException, SQLException{
        boolean ok=false;
        Connection con = ConnectionSQL.getConnection();//Inicia a conexÃ£o
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        
        try{
            //System.out.println("Fazendo a busca");
            stmt = con.prepareStatement("SELECT * FROM CONTA WHERE username ='"+nome+"'");// InstruÃ§Ã£o ao banco de dados
           
            rs = stmt.executeQuery();
            //System.out.println("Executei a query");
            
            if(rs.next()){
                ok = !ok;                
                System.out.println("Existe");
            }
            
            
        }catch(SQLException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "ERRO AO VALIDAR POSSIBILIDADE USUARIO!","Alerta",JOptionPane.ERROR_MESSAGE);
            
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
            
        }
        
        
        return ok;
    }
    public static boolean logarConta(String nome, String senha) throws SQLException, ClassNotFoundException{
       Connection con = ConnectionSQL.getConnection();//Inicia a conexÃ£o
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        boolean check = false;
        try{
            //System.out.println("Fazendo a busca");
            stmt = con.prepareStatement("SELECT * FROM CONTA WHERE username ='"+nome+"' and senha ='"+senha+"'");// InstruÃ§Ã£o ao banco de dados
           
            rs = stmt.executeQuery();
            //System.out.println("Executei a query");
            
            if(rs.next()){
                check = true;
                AuthFrame.data = rs.getDate("data_ult");
                
            }
            
            
        }catch(SQLException ex){
           ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao Acessar!!!","Alerta",0);
            
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
            
        }
        
        return check;
        
    }
    
    
    public static boolean criarConta(Conta c) throws SQLException, ClassNotFoundException, ParseException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexÃ£o
        boolean ok=false;
        PreparedStatement stmt = null;// Usado para controlar o sql
      
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date hj= new Date();
            
            java.sql.Date dv = new java.sql.Date(sdf.parse(sdf.format(hj)).getTime());
            stmt = con.prepareStatement("INSERT INTO conta values('"+c.getUser()+"','"+c.getSenha()+"','"+c.getEmail()+"',0,0,'"+dv+"')");// InstruÃ§Ã£o ao banco de dados
           
            
            stmt.executeUpdate();
            
            ok=!ok;
            JOptionPane.showMessageDialog(null,"Conta criada!","Concluído",JOptionPane.INFORMATION_MESSAGE);                                    
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao criar","Alerta",0);
            
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        return ok;
        
    }

    public static boolean alterarConta1(String nome) throws ClassNotFoundException, SQLException{
         Connection con = ConnectionSQL.getConnection();//Inicia a conexÃ£o
        boolean ok = false;
        PreparedStatement stmt = null;// Usado para controlar o sql
       // System.out.println("preparando executar");
        
        try{
            stmt = con.prepareStatement("update conta set username='"+nome+"' where username='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update produto set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update caixa set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update comprador set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update venda set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update historicovendas set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            AuthFrame.pessoa.setUser(nome);
            
            JOptionPane.showMessageDialog(null,"ALTERADO COM SUCESSO");
            ok=!ok;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO CRIAR USUÁRIO","Alerta",0);
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        return ok;
    }
    
    public static boolean alterarConta2(String senha) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexÃ£o
        boolean ok=false;
        PreparedStatement stmt = null;// Usado para controlar o sql
      //  System.out.println("preparando executar");
        
        try{
            
            stmt = con.prepareStatement("update conta set senha='"+senha+"' where username='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            
            AuthFrame.pessoa.setSenha(senha);
            
            JOptionPane.showMessageDialog(null,"ALTERADO COM SUCESSO");
            ok=!ok;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO CRIAR USUÃ�RIO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        return ok;
        
    }
    public static boolean alterarConta3(String nome, String senha) throws ClassNotFoundException, SQLException{
        
        
        
        Connection con = ConnectionSQL.getConnection();//Inicia a conexÃ£o
        boolean ok=false;
        PreparedStatement stmt = null;// Usado para controlar o sql
       // System.out.println("preparando executar");
        
        try{
            stmt = con.prepareStatement("update conta set username='"+nome+"' where username='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update conta set senha='"+senha+"' where username='"+nome+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update produto set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update caixa set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update comprador set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("update venda set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            stmt = con.prepareStatement("update historicovendas set id_conta='"+nome+"' where id_conta='"+AuthFrame.pessoa.getUser()+"'");// InstruÃ§Ã£o ao banco de dados
           
            stmt.executeUpdate();
            
            
            AuthFrame.pessoa.setUser(nome);
            
            JOptionPane.showMessageDialog(null,"ALTERADO COM SUCESSO");
            ok=!ok;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO CRIAR USUÃ�RIO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        return ok;
    }
    
    public static boolean esqueciSenha(String email) throws ClassNotFoundException, SQLException{
        boolean ok=false;
        Connection con= ConnectionSQL.getConnection();
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM CONTA WHERE email='"+email+"'");// InstruÃ§Ã£o ao banco de dados
           
            rs = stmt.executeQuery();
            rs.first();
            
            String user = rs.getString("username");
            String pass = rs.getString("senha");
            Email.enviar(email, user, pass);
            ok=!ok;  
            
            
            
            
            
            
              
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao encontrar Email!!!");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
            
        }
        
        return ok;
        
    }
}
