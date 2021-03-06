/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;

import fmm.classesauxiliares.*;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 2aimaq20
 */
public class HistoricoVendasFrame extends javax.swing.JFrame {
    private Sale vendaCompleted;
    
    /**
     * Creates new form HistoricoVendasFrame
     */
    public HistoricoVendasFrame() throws ClassNotFoundException, SQLException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());
        vendaCompleted = new Sale();
      desk.add(new GraficoBarrasDAO());
      
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back3 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        desk = new javax.swing.JDesktopPane();
        save = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bgACS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(739, 470));
        setMinimumSize(new java.awt.Dimension(739, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/info_icon.png"))); // NOI18N
        back3.setToolTipText("Mais Informações Sobre as Vendas");
        back3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        back3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back3MouseExited(evt);
            }
        });
        getContentPane().add(back3);
        back3.setBounds(350, 370, 64, 60);

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
        back.setBounds(610, 370, 64, 64);

        desk.setToolTipText("Gráfico do Histórico de Vendas");
        getContentPane().add(desk);
        desk.setBounds(50, 40, 640, 320);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/limpar_icon.png"))); // NOI18N
        save.setToolTipText("Limpar Tudo");
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
        save.setBounds(110, 370, 70, 64);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Historico de Vendas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, -10, 300, 70);

        bgACS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bg_tm_right.jpg"))); // NOI18N
        getContentPane().add(bgACS);
        bgACS.setBounds(0, 0, 740, 459);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        HomeFrame hf;
        try {
            hf = new HomeFrame();
            hf.setLocation(this.getLocation());
            this.dispose();
           
            hf.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_backMouseExited

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        int n = JOptionPane.showConfirmDialog(this, "<html>Deseja realmente excluir seu histórico?<br>Se confirmar, o total ganho em vendas será apagado</html>" );
        if(n==0){
           SalesmanController.excluirHistorico();
            HistoricoVendasFrame hv;
        try {
            hv = new HistoricoVendasFrame();
            hv.setLocation(this.getLocation());
            hv.setVisible(true);
            this.dispose(); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }//GEN-LAST:event_saveMouseClicked

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        save.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_saveMouseExited

    private void back3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back3MouseClicked
       DetalheVendaFrame  v;
        try {
            v = new DetalheVendaFrame();
            v.setLocationRelativeTo(null);
            v.setVisible(true);
            dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HistoricoVendasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
               
    }//GEN-LAST:event_back3MouseClicked

    private void back3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back3MouseEntered
        back3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_back3MouseEntered

    private void back3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back3MouseExited
        back3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_back3MouseExited

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
            java.util.logging.Logger.getLogger(HistoricoVendasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoVendasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoVendasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoVendasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HistoricoVendasFrame().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(HistoricoVendasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel back3;
    private javax.swing.JLabel bgACS;
    private javax.swing.JDesktopPane desk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel save;
    // End of variables declaration//GEN-END:variables
}
