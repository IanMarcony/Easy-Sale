/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;

import fmm.classesauxiliares.CaixaController;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author 2aimaq20
 */
public class CashFrame extends javax.swing.JFrame {
    public static Date hj;
   
    public CashFrame() throws ClassNotFoundException, SQLException, ParseException {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());
        
        SimpleDateFormat formataHoje = new SimpleDateFormat("MM");
         hj= new Date();
        SimpleDateFormat formataDataCaixa = new SimpleDateFormat("MM");
        Date caixa= AuthFrame.pessoa.getDataCaixa();
        
                
        if(formataHoje.parse(formataHoje.format(hj)).after(formataDataCaixa.parse(formataDataCaixa.format(caixa)))){
            CaixaController.up();   
            System.out.println("aqui");
            AuthFrame.pessoa.setDataCaixa(hj);
        }
        CaixaController.readTableCash();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JLabel();
        lblAlter = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCash = new javax.swing.JTable();
        bgCash = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(740, 459));
        setMinimumSize(new java.awt.Dimension(740, 459));
        setPreferredSize(new java.awt.Dimension(740, 459));
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
        back.setBounds(650, 10, 64, 64);

        lblAlter.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblAlter.setForeground(new java.awt.Color(255, 255, 255));
        lblAlter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlter.setText("Caixa");
        getContentPane().add(lblAlter);
        lblAlter.setBounds(200, 10, 320, 50);

        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtCash.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtCash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtCash.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SALDO FINAL", "DATA DE FECHAMENTO(dd/mm/aaaa)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCash.setToolTipText("Valor arrecadado em cada mês");
        jtCash.setOpaque(false);
        jtCash.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtCash.getTableHeader().setReorderingAllowed(false);
        jtCash.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jtCash);
        if (jtCash.getColumnModel().getColumnCount() > 0) {
            jtCash.getColumnModel().getColumn(0).setResizable(false);
            jtCash.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 100, 650, 240);

        bgCash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bg_tm_right.jpg"))); // NOI18N
        getContentPane().add(bgCash);
        bgCash.setBounds(0, 0, 740, 459);

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
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CashFrame().setVisible(true);
                } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                        } catch (ParseException ex) {
                    Logger.getLogger(CashFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bgCash;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtCash;
    private javax.swing.JLabel lblAlter;
    // End of variables declaration//GEN-END:variables
}
