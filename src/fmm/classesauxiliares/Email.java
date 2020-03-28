/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author 2aimaq20
 */
public class Email {
    private String endereco;

    public Email() {
        
    }
    public Email(String end) {
        this.endereco = end;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
   public static void enviar(String email, String usr, String senha){
     Properties props = new Properties();
    /** Parâmetros de conexão com servidor Gmail */
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", 465);
    props.put("mail.smtp.socketFactory.class", 
    "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", true);
    props.put("mail.debug",true);
    props.put("mail.smtp.port", 465);
 
    Session session = Session.getDefaultInstance(props,
      new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() 
           {
                 return new PasswordAuthentication("easysaleproject@gmail.com","pcujkjxssmmtjpyk");
           }
      });
 
    /** Ativa Debug para sessão */
    session.setDebug(true);
 
    try {
 
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("non-reply-easysale@gmail.com")); 
      //Remetente
 
      Address[] toUser = InternetAddress.parse(email.trim().toLowerCase());  
 
      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject("- Pedido para recuperar senha - ");//Assunto
      message.setContent("<html>Olá, você pediu recuperação de senha!!!<br>Aproveitamos e enviamos seus dados completos para acessar sua conta no Easy Sale<br>Seu username:"+usr+" <br> Sua Senha:"+senha+"<br> Att.<br> Easy Sale  </hmtl>","text/html");
      
      /**Método para enviar a mensagem criada*/
      Transport.send(message);
 
      System.out.println("Feito!!!");
      JOptionPane.showMessageDialog(null, "Enviado!");
     } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao enviar o email!","Alerta",0);
        e.printStackTrace();
    }
   }
}
