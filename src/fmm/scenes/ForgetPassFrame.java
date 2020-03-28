package fmm.scenes;

import fmm.classesauxiliares.*;
import java.awt.Cursor;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class ForgetPassFrame extends javax.swing.JFrame {

    
    public ForgetPassFrame() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JLabel();
        save1 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(739, 459));
        setMinimumSize(new java.awt.Dimension(739, 459));
        setPreferredSize(new java.awt.Dimension(739, 459));
        setResizable(false);
        getContentPane().setLayout(null);

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

        save1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/lupa_icon.png"))); // NOI18N
        save1.setToolTipText("Pesquisar");
        save1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                save1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                save1MouseExited(evt);
            }
        });
        getContentPane().add(save1);
        save1.setBounds(360, 310, 60, 64);
        getContentPane().add(email);
        email.setBounds(260, 140, 250, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite o email  para recuperar:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 110, 220, 90);

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

    private void save1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save1MouseClicked
        try {
            if(ContaController.esqueciSenha(email.getText())){
                AuthFrame af = new AuthFrame();
              af.setLocation(this.getLocation());
              this.dispose();
              af.setVisible(true);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro");
        }
    }//GEN-LAST:event_save1MouseClicked

    private void save1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save1MouseEntered
        save1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_save1MouseEntered

    private void save1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save1MouseExited
        save1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_save1MouseExited

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
            java.util.logging.Logger.getLogger(ForgetPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bg1;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel save1;
    // End of variables declaration//GEN-END:variables
}
