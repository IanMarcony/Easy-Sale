/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;

import fmm.classesauxiliares.Produto;
import fmm.classesauxiliares.ProdutoController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author 2aimaq20
 */
public class Inventory extends javax.swing.JFrame {
    public static Produto pAlter;
    private List<Produto> prodS;
    /**
     * Creates new form Inventory
     */
    public Inventory() throws ClassNotFoundException, SQLException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());
        DefaultTableModel modelo =  (DefaultTableModel) jtInvet.getModel();
        jtInvet.setRowSorter(new TableRowSorter(modelo));
        
        prodS = new ArrayList<>();
        prodS = ProdutoController.readProductsInvet();
        
        ProdutoController.readTable();

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCode = new javax.swing.JLabel();
        pCode = new javax.swing.JTextField();
        btnPesquisa1 = new javax.swing.JButton();
        pesquisaProduto = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInvet = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        back1 = new javax.swing.JLabel();
        back2 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bgRP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMinimumSize(new java.awt.Dimension(739, 469));
        setResizable(false);
        getContentPane().setLayout(null);

        lblCode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCode.setText("Código:");
        getContentPane().add(lblCode);
        lblCode.setBounds(380, 390, 150, 10);

        pCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(pCode);
        pCode.setBounds(380, 400, 150, 30);

        btnPesquisa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/lupaPesquisa_icon.png"))); // NOI18N
        btnPesquisa1.setToolTipText("Pesquisar Produto");
        btnPesquisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisa1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisa1);
        btnPesquisa1.setBounds(530, 400, 30, 30);

        pesquisaProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(pesquisaProduto);
        pesquisaProduto.setBounds(380, 340, 150, 30);

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/lupaPesquisa_icon.png"))); // NOI18N
        btnPesquisa.setToolTipText("Pesquisar Produto");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisa);
        btnPesquisa.setBounds(530, 340, 30, 30);

        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtInvet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtInvet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtInvet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço", "Quantidade", "Disponibilidade", "Codigo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtInvet.setOpaque(false);
        jtInvet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtInvet.getTableHeader().setReorderingAllowed(false);
        jtInvet.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jtInvet);
        if (jtInvet.getColumnModel().getColumnCount() > 0) {
            jtInvet.getColumnModel().getColumn(0).setResizable(false);
            jtInvet.getColumnModel().getColumn(1).setResizable(false);
            jtInvet.getColumnModel().getColumn(2).setResizable(false);
            jtInvet.getColumnModel().getColumn(3).setResizable(false);
            jtInvet.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 670, 240);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome Produto:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 330, 150, 10);

        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/clearProduto_icon.png"))); // NOI18N
        back1.setToolTipText("Excluir Produto");
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
        back1.setBounds(220, 360, 64, 64);

        back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/upProduto_icon.png"))); // NOI18N
        back2.setToolTipText("Alterar Produto");
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
        back2.setBounds(70, 360, 64, 64);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESTOQUE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 10, 350, 60);

        bgRP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bg_tm_right.jpg"))); // NOI18N
        getContentPane().add(bgRP);
        bgRP.setBounds(0, -10, 740, 480);

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

    private void back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseClicked
       
        if(jtInvet.getSelectedRow()>=0){
            pAlter = new Produto();
       
       pAlter.setId_conta(AuthFrame.pessoa.getUser());
       
       pAlter.setNome((jtInvet.getValueAt(jtInvet.getSelectedRow(),0)).toString());
       pAlter.setExiste((jtInvet.getValueAt(jtInvet.getSelectedRow(),3)).toString());
       
       String preco = (jtInvet.getValueAt(jtInvet.getSelectedRow(),1)).toString();
       String quant = (jtInvet.getValueAt(jtInvet.getSelectedRow(),2)).toString();
       
       pAlter.setPreco(Float.parseFloat(preco));
       pAlter.setQuant(Integer.parseInt(quant));
       
       int num = JOptionPane.showConfirmDialog(this, "Você realmente quer apagar?");
       if(num==0){
                try {
                    //Função para deletar registro
                    ProdutoController.eraseProduct(pAlter);
                    Inventory in = new Inventory();
           in.setLocation(getLocation());
           dispose();
           in.setVisible(true);
                } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                }
           
       }
       
       }else{
           JOptionPane.showMessageDialog(this, "Você não escolheu nenhum produto para deletar!");
       
       }
       
    }//GEN-LAST:event_back1MouseClicked

    private void back1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseEntered
        back1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_back1MouseEntered

    private void back1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseExited
        back1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_back1MouseExited

    private void back2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MouseClicked
       
        if(jtInvet.getSelectedRow()>=0){
           pAlter = new Produto();
       
       pAlter.setId_conta(AuthFrame.pessoa.getUser());
       
       pAlter.setNome((jtInvet.getValueAt(jtInvet.getSelectedRow(),0)).toString());
       pAlter.setExiste((jtInvet.getValueAt(jtInvet.getSelectedRow(),3)).toString());
       
       String preco = (jtInvet.getValueAt(jtInvet.getSelectedRow(),1)).toString();
       String quant = (jtInvet.getValueAt(jtInvet.getSelectedRow(),2)).toString();
       int id =  (int)  jtInvet.getValueAt(jtInvet.getSelectedRow(),4);
       pAlter.setPreco(Float.parseFloat(preco));
       pAlter.setQuant(Integer.parseInt(quant));
       pAlter.setId(id);
       //Função para alterar item
       
       AlterProduct aa = new AlterProduct();
       aa.setLocation(getLocation());
       dispose();
       aa.setVisible(true);
       
       }else{
           JOptionPane.showMessageDialog(this, "Você não escolheu nenhum produto para alterar!");
       }
    }//GEN-LAST:event_back2MouseClicked

    private void back2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MouseEntered
        back2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_back2MouseEntered

    private void back2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back2MouseExited
        back2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_back2MouseExited

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        boolean ver=false;
        int indexProd=0;
        Iterator<Produto> it = prodS.iterator();
        while (it.hasNext()) {
            Produto prodP = it.next();
            if(prodP.getNome().toLowerCase().contains(pesquisaProduto.getText().toLowerCase())&&!pesquisaProduto.getText().toLowerCase().equals("")){

                ver=!ver;
                indexProd= prodS.indexOf(prodP);

                break;

            }
            
        }
      
       
        if(ver){
            jtInvet.setRowSelectionInterval(indexProd, indexProd);
        }else{
            JOptionPane.showMessageDialog(this,"Produto Não encontrado!","Alerta",0);
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisa1ActionPerformed
        boolean ver=false;
        int indexProd=0;
        int aux=0;
        
        
              

        try{
            Iterator<Produto> it = prodS.iterator();
             while (it.hasNext()) {
                Produto prodP = it.next();
                aux=Integer.parseInt(pCode.getText());
                if(prodP.getId()==aux){
                    ver=!ver;
                    indexProd= prodS.indexOf(prodP);

                    break;
                }
             }

            if(ver){
                jtInvet.setRowSelectionInterval(indexProd, indexProd);
            }else{
                JOptionPane.showMessageDialog(this,"Produto Não encontrado!","Alerta",0);
            }

        }catch(NumberFormatException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"Digite um número!","Alerta",0);
        }
                
               
        
    }//GEN-LAST:event_btnPesquisa1ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inventory().setVisible(true);
                 } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel back1;
    private javax.swing.JLabel back2;
    private javax.swing.JLabel bgRP;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnPesquisa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtInvet;
    private javax.swing.JLabel lblCode;
    public static javax.swing.JTextField pCode;
    public static javax.swing.JTextField pesquisaProduto;
    // End of variables declaration//GEN-END:variables
}
