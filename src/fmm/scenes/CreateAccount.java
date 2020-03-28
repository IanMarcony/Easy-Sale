package fmm.scenes;

import fmm.classesauxiliares.Conta;
import fmm.classesauxiliares.ContaController;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class CreateAccount extends javax.swing.JFrame {
    
    
    public CreateAccount() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        alertPass = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        repass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(739, 459));
        setMinimumSize(new java.awt.Dimension(739, 459));
        setPreferredSize(new java.awt.Dimension(739, 459));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setText("(mínimo: 8 caracteres máximo: 16 caracteres)");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 20, 280, 14);

        email.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        email.setToolTipText("Email para resgatar senha ");
        getContentPane().add(email);
        email.setBounds(290, 230, 180, 40);

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(lblUser);
        lblUser.setBounds(260, 90, 260, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EMAIL");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(290, 190, 170, 30);

        jLabel4.setText("(mínimo: 8 caracteres máximo: 16 caracteres)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 130, 280, 14);

        alertPass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        alertPass.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(alertPass);
        alertPass.setBounds(250, 280, 270, 60);

        lblEmail.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblEmail);
        lblEmail.setBounds(480, 240, 220, 20);

        pass1.setToolTipText("Senha de usuário");
        getContentPane().add(pass1);
        pass1.setBounds(110, 160, 180, 40);

        repass.setToolTipText("Deve ser igual ao campo anterior");
        getContentPane().add(repass);
        repass.setBounds(460, 160, 180, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REESCREVER SENHA");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(460, 120, 170, 30);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/volta_icon.png"))); // NOI18N
        back.setToolTipText("Voltar");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(640, 20, 64, 64);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/user_create_icon.png"))); // NOI18N
        save.setToolTipText("Criar Usuário");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(360, 330, 60, 64);

        username.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        username.setToolTipText("Nome de Usuário");
        getContentPane().add(username);
        username.setBounds(230, 40, 310, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SENHA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 120, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome de Usuário");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 10, 130, 30);

        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bg2.jpg"))); // NOI18N
        getContentPane().add(bg1);
        bg1.setBounds(0, 0, 750, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
         AuthFrame af = new AuthFrame();
              af.setLocation(this.getLocation());
              this.dispose();
              af.setVisible(true);
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_backMouseExited

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        save.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_saveMouseExited

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        try {
            if(!ContaController.PesquisaConta(username.getText())){
                boolean pode=true;
                if(username.getText().contains(" ")){
                    JOptionPane.showMessageDialog(this, "Nome de usuário não deve conter espaços!","Alerta",0);
                    pode=false;
                }
                if(username.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Nome de usuário não deve está vazio!","Alerta",0);
                    pode=false;
                }
                if(username.getText().length()<8||username.getText().length()>16){
                    JOptionPane.showMessageDialog(this, "Nome de usuário deve está entre 8 a 16 caracteres!","Alerta",0);
                    pode=false;
                }
                if(!(new String(pass1.getPassword()).equals(new String(repass.getPassword())))){
                    JOptionPane.showMessageDialog(this, "As senhas não são iguais!","Alerta",0);
                    pode=false;
                }
                
                if((new String(pass1.getPassword()).length()<8 || new String(pass1.getPassword()).length()>16)||(new String(repass.getPassword()).length()<8 || new String(repass.getPassword()).length()>16)){
                    JOptionPane.showMessageDialog(this, "A senha deve está entre 8 a 16 caracteres!","Alerta",0);
                    pode=false;
                }
                if((new String(pass1.getPassword()).equals(""))|| (new String(repass.getPassword()).equals(""))){
                    JOptionPane.showMessageDialog(this, "A senha não deve está vazia!","Alerta",0);
                    pode=false;
                }
                if(email.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "O email não deve está vazio!","Alerta",0);
                    pode=false;
                }
                if(!(email.getText().toLowerCase().contains("@gmail.com")||email.getText().toLowerCase().contains("@outlook.com")||email.getText().toLowerCase().contains("@hotmail.com"))){
                    JOptionPane.showMessageDialog(this, "Não é um email válido!","Alerta",0);
                    pode=false;
                }
                
                if(pode){
                    Conta c = new Conta(username.getText(), new String(repass.getPassword()), email.getText());
                    try {
                        if(ContaController.criarConta(c)){
                            AuthFrame af = new AuthFrame();
                            af.setLocation(this.getLocation());
                            this.dispose();
                            af.setVisible(true);
                        }
                    } catch (SQLException | ClassNotFoundException | ParseException ex) {
                        ex.printStackTrace();
                    }
                }
            }else JOptionPane.showMessageDialog(this, "O NOME DE USUARIO JÁ EXISTE!","Alerta",JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException | SQLException ex) {
           JOptionPane.showMessageDialog(this, "ERRO AO VALIDAR POSSIBILIDADE USUARIO!","Alerta",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveMouseClicked

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
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertPass;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bg1;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField repass;
    private javax.swing.JLabel save;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
