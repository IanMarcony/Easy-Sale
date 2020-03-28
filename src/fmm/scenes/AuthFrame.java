/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;


import fmm.classesauxiliares.Salesman;
import fmm.classesauxiliares.ContaController;
import fmm.classesauxiliares.SalesmanController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author 2aimaq20
 */
public class AuthFrame extends javax.swing.JFrame {
    
    public static Salesman pessoa;
    public static Date data= new Date();
   
    public AuthFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        username.setToolTipText("Insira seu nome de usuário");
        password.setToolTipText("Insira sua senha");
        btnLoga.setToolTipText("Aperte para logar");
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());

                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linkForget1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        linkForget = new javax.swing.JLabel();
        linkSignIn = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        alertAuth = new javax.swing.JLabel();
        btnLoga = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(739, 459));
        setMinimumSize(new java.awt.Dimension(739, 459));
        setResizable(false);
        getContentPane().setLayout(null);

        linkForget1.setForeground(new java.awt.Color(255, 0, 0));
        linkForget1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkForget1.setText("<html><u>Sobre o sistema<u>");
        linkForget1.setToolTipText("Cria Conta");
        linkForget1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linkForget1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkForget1MouseClicked(evt);
            }
        });
        getContentPane().add(linkForget1);
        linkForget1.setBounds(220, 400, 280, 30);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(260, 10, 200, 170);

        linkForget.setForeground(new java.awt.Color(255, 0, 0));
        linkForget.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkForget.setText("<html><u>Esqueci a senha<u>");
        linkForget.setToolTipText("Cria Conta");
        linkForget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkForgetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                linkForgetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                linkForgetMouseExited(evt);
            }
        });
        getContentPane().add(linkForget);
        linkForget.setBounds(220, 370, 280, 30);

        linkSignIn.setBackground(new java.awt.Color(255, 255, 255));
        linkSignIn.setForeground(new java.awt.Color(255, 0, 0));
        linkSignIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkSignIn.setText("<html><u>Não tem uma conta? Crie Agora!<u>");
        linkSignIn.setToolTipText("Cria Conta");
        linkSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkSignInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                linkSignInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                linkSignInMouseExited(evt);
            }
        });
        getContentPane().add(linkSignIn);
        linkSignIn.setBounds(200, 340, 330, 30);

        username.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        username.setToolTipText("Nome de Usuário");
        getContentPane().add(username);
        username.setBounds(120, 200, 160, 40);

        alertAuth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertAuth.setForeground(new java.awt.Color(255, 0, 0));
        alertAuth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(alertAuth);
        alertAuth.setBounds(230, 240, 270, 40);

        btnLoga.setBackground(new java.awt.Color(153, 255, 51));
        btnLoga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLoga.setText("ENTRAR");
        btnLoga.setToolTipText("Acessar o sistema");
        btnLoga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogaMouseExited(evt);
            }
        });
        btnLoga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogaActionPerformed(evt);
            }
        });
        btnLoga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLogaKeyPressed(evt);
            }
        });
        getContentPane().add(btnLoga);
        btnLoga.setBounds(290, 290, 140, 50);

        password.setToolTipText("Senha de usuário");
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(440, 200, 180, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("Dev: Ian Marcony");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(580, 380, 110, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SENHA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(540, 170, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome de usuário");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 170, 130, 30);

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bg2.jpg"))); // NOI18N
        getContentPane().add(bg1);
        bg1.setBounds(0, 0, 750, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogaActionPerformed
         if(username.getText().equals("")&&(new String(password.getPassword())).equals("")){
            alertAuth.setForeground(Color.red);
            alertAuth.setText("Campos Vazios");
        }
        else{
            try {
                if(ContaController.logarConta(username.getText(), new String(password.getPassword()))){
                    
                    try {
                        pessoa = new Salesman(username.getText(),new String(password.getPassword()),0,0); 
                        pessoa.setReceber(SalesmanController.totalPendencias());
                        pessoa.setTotal(SalesmanController.totalVendas());
                        pessoa.setDataCaixa(data);
                        System.out.println(pessoa.getDataCaixa());
                    } catch (ClassNotFoundException|SQLException ex) {
                        System.out.println(ex);
                    }
                    
                    HomeFrame hf = new HomeFrame();
                    hf.setLocation(this.getLocation());
                    this.dispose();
                    hf.setVisible(true);
                }
                else{
                    alertAuth.setForeground(Color.red);
                    alertAuth.setText("Username ou Senha Inválidos!");
                }
            } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                        }
            
        }
    }//GEN-LAST:event_btnLogaActionPerformed

    private void linkSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkSignInMouseClicked
        CreateAccount ca = new CreateAccount();
       ca.setLocation(this.getLocation());
       this.dispose();
       ca.setVisible(true);
    }//GEN-LAST:event_linkSignInMouseClicked

    private void btnLogaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLogaKeyPressed
        if(evt.getKeyCode()==10){
          if(username.getText().equals("")&&(new String(password.getPassword())).equals("")){
            alertAuth.setForeground(Color.red);
            alertAuth.setText("Campos Vazios");
        }
        else{
            try {
                if(ContaController.logarConta(username.getText(), new String(password.getPassword()))){
                    
                    try {
                        pessoa = new Salesman(username.getText(),new String(password.getPassword()),0,0); 
                        pessoa.setReceber(SalesmanController.totalPendencias());
                        pessoa.setTotal(SalesmanController.totalVendas());
                        pessoa.setDataCaixa(data);
                        System.out.println(pessoa.getDataCaixa());
                    } catch (ClassNotFoundException|SQLException ex) {
                        System.out.println(ex);
                    }
                    
                    HomeFrame hf = new HomeFrame();
                    hf.setLocation(this.getLocation());
                    this.dispose();
                    hf.setVisible(true);
                }
                else{
                    alertAuth.setForeground(Color.red);
                    alertAuth.setText("Username ou Senha Inválidos!");
                }
            } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                        }
            
        }
        }
    }//GEN-LAST:event_btnLogaKeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if(evt.getKeyCode()==10){
             if(username.getText().equals("")&&(new String(password.getPassword())).equals("")){
            alertAuth.setForeground(Color.red);
            alertAuth.setText("Campos Vazios");
        }
        else{
            try {
                if(ContaController.logarConta(username.getText(), new String(password.getPassword()))){
                    
                    try {
                        pessoa = new Salesman(username.getText(),new String(password.getPassword()),0,0); 
                        pessoa.setReceber(SalesmanController.totalPendencias());
                        pessoa.setTotal(SalesmanController.totalVendas());
                        pessoa.setDataCaixa(data);
                        System.out.println(pessoa.getDataCaixa());
                    } catch (ClassNotFoundException|SQLException ex) {
                        System.out.println(ex);
                    }
                    
                    HomeFrame hf = new HomeFrame();
                    hf.setLocation(this.getLocation());
                    this.dispose();
                    hf.setVisible(true);
                }
                else{
                    alertAuth.setForeground(Color.red);
                    alertAuth.setText("Username ou Senha Inválidos!");
                }
            } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                        }
            
        }
        }

    }//GEN-LAST:event_passwordKeyPressed

    private void linkForgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkForgetMouseClicked
       ForgetPassFrame hf = new ForgetPassFrame();
                    hf.setLocation(this.getLocation());
                    this.dispose();
                    hf.setVisible(true);
    }//GEN-LAST:event_linkForgetMouseClicked

    private void btnLogaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogaMouseEntered
        btnLoga.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnLogaMouseEntered

    private void btnLogaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogaMouseExited
       btnLoga.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnLogaMouseExited

    private void linkSignInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkSignInMouseEntered
        linkSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_linkSignInMouseEntered

    private void linkSignInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkSignInMouseExited
        linkSignIn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_linkSignInMouseExited

    private void linkForgetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkForgetMouseEntered
        linkForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_linkForgetMouseEntered

    private void linkForgetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkForgetMouseExited
       linkForget.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_linkForgetMouseExited

    private void linkForget1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkForget1MouseClicked
        try {
            Desktop.getDesktop().open(new File(".../Site/index.html"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_linkForget1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AuthFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertAuth;
    private javax.swing.JLabel bg1;
    private javax.swing.JButton btnLoga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel linkForget;
    private javax.swing.JLabel linkForget1;
    private javax.swing.JLabel linkSignIn;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}