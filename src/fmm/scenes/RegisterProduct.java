/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;

import fmm.classesauxiliares.Produto;
import fmm.classesauxiliares.ProdutoController;
import java.awt.Cursor;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Ian Marcony
 */
public class RegisterProduct extends javax.swing.JFrame {
    
    /**
     * Creates new form RegisterProduct
     */
    public RegisterProduct() {
        initComponents();
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

        sale4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        quant = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        preco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        bgRP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(739, 459));
        setMinimumSize(new java.awt.Dimension(739, 459));
        setPreferredSize(new java.awt.Dimension(739, 459));
        setResizable(false);
        getContentPane().setLayout(null);

        sale4.setBackground(new java.awt.Color(255, 255, 255));
        sale4.setForeground(new java.awt.Color(255, 255, 255));
        sale4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/save_icon.png"))); // NOI18N
        sale4.setToolTipText("Registrar Produto");
        sale4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sale4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sale4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sale4MouseExited(evt);
            }
        });
        getContentPane().add(sale4);
        sale4.setBounds(240, 340, 64, 64);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUANTIDADE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 260, 140, 30);

        quant.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantStateChanged(evt);
            }
        });
        getContentPane().add(quant);
        quant.setBounds(160, 300, 190, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("REGISTRAR PRODUTO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 10, 280, 40);

        preco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(preco);
        preco.setBounds(170, 210, 190, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PREÇO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 170, 140, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 70, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("R$");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 220, 30, 30);

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
        back.setBounds(630, 360, 64, 64);

        nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(nome);
        nome.setBounds(160, 110, 190, 40);

        bgRP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bg_tm_right.jpg"))); // NOI18N
        getContentPane().add(bgRP);
        bgRP.setBounds(0, 0, 740, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantStateChanged
        if(Integer.valueOf(String.valueOf(quant.getValue()))<0){
            quant.setValue(0);
        }
    }//GEN-LAST:event_quantStateChanged

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

    private void sale4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sale4MouseClicked
        if(preco.getText().contains(",")){
            System.out.println("contém vírgula");
            preco.setText(preco.getText().replace(",", "."));
            System.out.println(preco.getText());
        }
        Produto p = new Produto(nome.getText(),Integer.valueOf(String.valueOf(quant.getValue())),Float.parseFloat(preco.getText()));
        boolean bl = nome.getText().equals("")&&Integer.valueOf(String.valueOf(quant.getValue()))<=0&&(Integer.valueOf(String.valueOf(quant.getValue()))<=0||quant.getValue()==null);
        if(!bl){            
            try {
                ProdutoController.criarProduto(p);
             } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                }            
            int cont = JOptionPane.showConfirmDialog(this, "Gostaria de adicionar mais um produto?");
            if(cont>0){
                      HomeFrame hf;
        try {
            hf = new HomeFrame(); 
            hf.setLocation(this.getLocation());
        this.dispose();
        hf.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
                        
           }
            else{
                
                
                nome.setText("");
                quant.setValue(0);
                preco.setText("");
            }
                
        }else{
            JOptionPane.showMessageDialog(this,"Campos vazios!!");
        }
    }//GEN-LAST:event_sale4MouseClicked

    private void sale4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sale4MouseEntered
        sale4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sale4MouseEntered

    private void sale4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sale4MouseExited
        sale4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_sale4MouseExited

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
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bgRP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField preco;
    private javax.swing.JSpinner quant;
    private javax.swing.JLabel sale4;
    // End of variables declaration//GEN-END:variables
}
