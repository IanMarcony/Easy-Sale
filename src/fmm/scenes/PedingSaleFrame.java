/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;

import fmm.classesauxiliares.Sale;
import fmm.classesauxiliares.SaleController;
import fmm.classesauxiliares.SalesmanController;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ian Marcony
 */
public class PedingSaleFrame extends javax.swing.JFrame {
    public static List<Sale> Lvendas;
    private Sale venda;
    
    /**
     * Creates new form PedingSaleFrame
     */
    public PedingSaleFrame() throws ClassNotFoundException, SQLException, ParseException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());
        DefaultTableModel modelo =  (DefaultTableModel) tblSales.getModel();
        
        tblSales.setRowSorter(new TableRowSorter(modelo));
        
        Lvendas=SaleController.readPedingSales();
        
        SaleController.readSales2();
        
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisaProduto = new javax.swing.JTextField();
        back3 = new javax.swing.JLabel();
        back2 = new javax.swing.JLabel();
        back1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        back = new javax.swing.JLabel();
        lblPS = new javax.swing.JLabel();
        bgPSF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(739, 459));
        setMinimumSize(new java.awt.Dimension(739, 459));
        setPreferredSize(new java.awt.Dimension(739, 459));
        setResizable(false);
        getContentPane().setLayout(null);

        pesquisaProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(pesquisaProduto);
        pesquisaProduto.setBounds(530, 70, 150, 30);

        back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/info_icon.png"))); // NOI18N
        back3.setToolTipText("Mais Informações Sobre a Venda");
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
        back3.setBounds(80, 370, 64, 60);

        back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/excluir_icon.png"))); // NOI18N
        back2.setToolTipText("Excluir");
        back2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back2MouseExited(evt);
            }
        });
        getContentPane().add(back2);
        back2.setBounds(200, 370, 64, 60);

        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/check_icon.png"))); // NOI18N
        back1.setToolTipText("Finalizar Venda");
        back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back1MouseExited(evt);
            }
        });
        getContentPane().add(back1);
        back1.setBounds(320, 370, 64, 64);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nome Comprador:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 70, 110, 30);

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/lupaPesquisa_icon.png"))); // NOI18N
        btnPesquisa.setToolTipText("Pesquisar Produto");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisa);
        btnPesquisa.setBounds(680, 70, 30, 30);

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Comprador", "Produto", "Quantidade", "Data da Venda", "Data para Pagar", "Total a Pagar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSales.setToolTipText("Todas as vendas pedentes");
        tblSales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblSalesMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tblSales);
        if (tblSales.getColumnModel().getColumnCount() > 0) {
            tblSales.getColumnModel().getColumn(0).setResizable(false);
            tblSales.getColumnModel().getColumn(1).setResizable(false);
            tblSales.getColumnModel().getColumn(2).setResizable(false);
            tblSales.getColumnModel().getColumn(3).setResizable(false);
            tblSales.getColumnModel().getColumn(4).setResizable(false);
            tblSales.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 650, 230);

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

        lblPS.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        lblPS.setForeground(new java.awt.Color(255, 255, 255));
        lblPS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPS.setText("Vendas Pedentes");
        getContentPane().add(lblPS);
        lblPS.setBounds(170, 0, 380, 70);

        bgPSF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bg_tm_right.jpg"))); // NOI18N
        getContentPane().add(bgPSF);
        bgPSF.setBounds(0, 0, 740, 459);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalesMouseEntered
       
           tblSales.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
    }//GEN-LAST:event_tblSalesMouseEntered

    private void tblSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalesMouseExited
       tblSales.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tblSalesMouseExited

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

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        boolean ver=false;
        int indexProd=0;
        Iterator<Sale> it = Lvendas.iterator();
        while (it.hasNext()) {
            Sale prodP = it.next();
            if(prodP.comp.getNome().toLowerCase().contains(pesquisaProduto.getText().toLowerCase())){

                ver=!ver;
                indexProd= Lvendas.indexOf(prodP);

                break;

            }
        }
        if(ver){

           tblSales.setRowSelectionInterval(indexProd, indexProd);

        }else{
            JOptionPane.showMessageDialog(this,"Comprador Não encontrado!","Alerta",0);
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseClicked
        if(tblSales.getSelectedRow()>=0){
            
                    Sale v2= new Sale();
                    v2=Lvendas.get(tblSales.getSelectedRow());                
        
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String obj = JOptionPane.showInputDialog(this, "Valor pago: ", "Pagamento", JOptionPane.QUESTION_MESSAGE);
        if(obj!=null){    
            if(obj.contains(","))obj.replace(",", ".");
       
           float vp=Float.parseFloat( obj);
                if(vp>v2.getValor_final()&vp!=0){
                        JOptionPane.showMessageDialog(this,"Troco:R$ "+(vp-v2.getValor_final()),"Pagamento",JOptionPane.INFORMATION_MESSAGE);
                }           
                Date hj = new Date();
                SalesmanController.finalizarVenda(v2.comp.getId(), v2.getId(), v2.prod.getId(), v2.getValor_final(),sdf.parse(sdf.format(hj)));                
                JOptionPane.showMessageDialog(this,"Vendido com sucesso!","Finalizado",JOptionPane.INFORMATION_MESSAGE);
                
                PedingSaleFrame ps;
                          try {
                               ps = new PedingSaleFrame();
                               ps.setLocation(getLocation());
                            dispose();
                             ps.setVisible(true);
                           } catch (ClassNotFoundException|SQLException ex) {
                                System.out.println(ex);
                            } catch (ParseException ex) {
                    Logger.getLogger(PedingSaleFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
            } catch (ClassNotFoundException ex) {
                System.out.println("erro");
            } catch (ParseException ex) {
                Logger.getLogger(PedingSaleFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else JOptionPane.showMessageDialog(this,"Nenhuma venda selecionada!","Alerta",0);
    }//GEN-LAST:event_back1MouseClicked

    private void back1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseEntered
        back1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_back1MouseEntered

    private void back1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseExited
        back1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_back1MouseExited

    private void back2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MouseClicked
       if(tblSales.getSelectedRow()>=0){
            venda = new Sale();
            venda= Lvendas.get(tblSales.getSelectedRow());
            try {
                SaleController.deletePedingSales(venda.getId(), (float) tblSales.getValueAt(tblSales.getSelectedRow(), 5), AuthFrame.pessoa.getUser(),venda.comp.getId(), venda.prod.getId(),venda.getQuant());
            } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                }
            
            PedingSaleFrame ps;
                      try {
                           ps = new PedingSaleFrame();
                           ps.setLocation(getLocation());
                        dispose();
                         ps.setVisible(true);
                       } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                        } catch (ParseException ex) {
                Logger.getLogger(PedingSaleFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }else JOptionPane.showMessageDialog(this,"Nenhuma venda selecionada!","Alerta",0);
    }//GEN-LAST:event_back2MouseClicked

    private void back2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MouseEntered
        back2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_back2MouseEntered

    private void back2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MouseExited
        back2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_back2MouseExited

    private void back3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back3MouseClicked
        if(tblSales.getSelectedRow()>=0){    
                AlterPSFrame.vendaA=new Sale();
                AlterPSFrame.vendaA = Lvendas.get(tblSales.getSelectedRow());

                AlterPSFrame  aps;

                    aps = new AlterPSFrame();
                    aps.setLocation(getLocation());

               aps.setVisible(true);

               dispose();

        }else JOptionPane.showMessageDialog(this,"Nenhuma venda selecionada!","Alerta",0);
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
            java.util.logging.Logger.getLogger(PedingSaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedingSaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedingSaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedingSaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PedingSaleFrame().setVisible(true);
                 } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                } catch (ParseException ex) {
                    Logger.getLogger(PedingSaleFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel back1;
    private javax.swing.JLabel back2;
    private javax.swing.JLabel back3;
    private javax.swing.JLabel bgPSF;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPS;
    public static javax.swing.JTextField pesquisaProduto;
    public static javax.swing.JTable tblSales;
    // End of variables declaration//GEN-END:variables
}
