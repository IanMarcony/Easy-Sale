/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;

import fmm.classesauxiliares.*;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2aimaq20
 */
public class SaleNowFrame extends javax.swing.JFrame {
    private Produto ps;
    private List<Produto> prodS,prodLista;
    private List<Integer> limite;
    private Salesman vendedor1;
    private float totalP;
    public static Comprador c1;
    private Date hj;
    private float vpay;    
    /**
     * Creates new form SaleFrame
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public SaleNowFrame() throws ClassNotFoundException, SQLException {
        initComponents();
        
        ps = new Produto();
        vendedor1 = new Salesman(AuthFrame.pessoa.getUser(), AuthFrame.pessoa.getSenha(),AuthFrame.pessoa.getTotal(),AuthFrame.pessoa.getReceber());
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
         hj = new Date();
        
                
        jcbProdutos.addItem("--Selecione um item--");
        ProdutoController.readNameProducts(2);
        quantidade.setEnabled(false);
        prodS = new ArrayList<>();
        prodLista= new ArrayList<>();
        limite = new ArrayList<>();
        prodS = ProdutoController.readProducts();
        for(int i=0;i<prodS.size();i++)limite.add(prodS.get(i).getQuant());
       c1= new Comprador();
        
        
        
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        total = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        unitaryV = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();
        pesquisaProduto = new javax.swing.JTextField();
        sale1 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        quantidade = new javax.swing.JSpinner();
        sale = new javax.swing.JLabel();
        jcbProdutos = new javax.swing.JComboBox<>();
        lblNew = new javax.swing.JLabel();
        bgSale = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(647, 521));
        setMinimumSize(new java.awt.Dimension(647, 521));
        setResizable(false);
        getContentPane().setLayout(null);

        total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        total.setText("TOTAL: R$ 00.0");
        getContentPane().add(total);
        total.setBounds(360, 350, 210, 30);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setResizable(false);
            tblProdutos.getColumnModel().getColumn(1).setResizable(false);
            tblProdutos.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 210, 460, 130);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Valor a Pagar: R$ ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(340, 170, 330, 30);

        unitaryV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        unitaryV.setText("Valor Unitário: R$ ");
        getContentPane().add(unitaryV);
        unitaryV.setBounds(340, 130, 330, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("<html><sup style=\"color: red;\">*</sup><u>Produto:<u>");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(50, 70, 80, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("<html><sup style=\"color: red;\">*</sup><u>Quantidade:<u>");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 170, 80, 30);

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/lupaPesquisa_icon.png"))); // NOI18N
        btnPesquisa.setToolTipText("Pesquisar Produto");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisa);
        btnPesquisa.setBounds(290, 90, 30, 30);

        pesquisaProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(pesquisaProduto);
        pesquisaProduto.setBounds(140, 90, 150, 30);

        sale1.setBackground(new java.awt.Color(255, 255, 255));
        sale1.setForeground(new java.awt.Color(255, 255, 255));
        sale1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/addProduto_icon.png"))); // NOI18N
        sale1.setToolTipText("Adicionar Produto");
        sale1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sale1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sale1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sale1MouseExited(evt);
            }
        });
        getContentPane().add(sale1);
        sale1.setBounds(280, 420, 64, 64);

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
        back.setBounds(560, 420, 64, 64);

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/removeProd.png"))); // NOI18N
        btnRemover.setToolTipText("Remove Produto");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover);
        btnRemover.setBounds(290, 350, 30, 30);

        quantidade.setToolTipText("Não apague o zero para evitar erros");
        quantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantidadeStateChanged(evt);
            }
        });
        quantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quantidadeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quantidadeMouseExited(evt);
            }
        });
        getContentPane().add(quantidade);
        quantidade.setBounds(140, 170, 180, 30);

        sale.setBackground(new java.awt.Color(255, 255, 255));
        sale.setForeground(new java.awt.Color(255, 255, 255));
        sale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/addSale_icon.png"))); // NOI18N
        sale.setToolTipText("Vender");
        sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saleMouseExited(evt);
            }
        });
        getContentPane().add(sale);
        sale.setBounds(50, 420, 64, 64);

        jcbProdutos.setMaximumRowCount(1000);
        jcbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcbProdutosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcbProdutosMouseExited(evt);
            }
        });
        jcbProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProdutosActionPerformed(evt);
            }
        });
        getContentPane().add(jcbProdutos);
        jcbProdutos.setBounds(140, 130, 180, 30);

        lblNew.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNew.setForeground(new java.awt.Color(255, 255, 255));
        lblNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNew.setText("NOVA VENDA");
        getContentPane().add(lblNew);
        lblNew.setBounds(130, 0, 350, 60);

        bgSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/bgSale.png"))); // NOI18N
        getContentPane().add(bgSale);
        bgSale.setBounds(0, 0, 934, 522);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantidadeStateChanged
        
       
       if(jcbProdutos.getSelectedIndex()>0){
             if(Integer.valueOf(String.valueOf(quantidade.getValue()))<0){
                quantidade.setValue(0);
            }else if(Integer.valueOf(String.valueOf(quantidade.getValue()))>limite.get(jcbProdutos.getSelectedIndex()-1)){

                quantidade.setValue(new Integer(limite.get(jcbProdutos.getSelectedIndex()-1)));

            }
            else{
                int n = Integer.valueOf(String.valueOf(quantidade.getValue()));
                ps.setQuant(n);
                String txt = "Valor a Pagar: R$ ";
                vpay=n*ps.getPreco();

                jLabel4.setText(txt+Float.toString(n*ps.getPreco()));
            }
       
       }
    }//GEN-LAST:event_quantidadeStateChanged

    private void jcbProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProdutosActionPerformed
        if(jcbProdutos.getSelectedIndex()!=0){
            ps = prodS.get(jcbProdutos.getSelectedIndex()-1);
            quantidade.setValue(0);
            quantidade.setEnabled(true);
            
            String txt = "Valor Unitário: R$ ";
            unitaryV.setText(txt+Float.toString(ps.getPreco()));
            
        }else{
            quantidade.setEnabled(false);
            quantidade.setValue(0);
            String txt = "Valor Unitário: R$ ";
            unitaryV.setText(txt);
            jLabel4.setText("Valor a Pagar: R$");
            
        }
    }//GEN-LAST:event_jcbProdutosActionPerformed

    private void jcbProdutosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbProdutosMouseEntered
       jcbProdutos.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jcbProdutosMouseEntered

    private void jcbProdutosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbProdutosMouseExited
       jcbProdutos.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jcbProdutosMouseExited

    private void quantidadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantidadeMouseEntered
       quantidade.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_quantidadeMouseEntered

    private void quantidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantidadeMouseExited
        quantidade.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_quantidadeMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        HomeFrame hf;
        try {
            hf = new HomeFrame();
            hf.setLocationRelativeTo(null);
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

    private void saleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleMouseClicked
        float totalPagar=0;
        if(prodLista.size()>0){
            
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
             Date hj = new Date();
             for(int i=0;i<prodLista.size();i++){                                     
                    totalPagar+=prodLista.get(i).getPreco();                               
           }
                String obj = JOptionPane.showInputDialog(this, "<html>Total: "+totalPagar+"<br> Valor pago: </html>", "Pagamento", JOptionPane.QUESTION_MESSAGE);
        if(obj!=null){    
            if(obj.contains(","))obj.replace(",", ".");
       
           float vp=Float.parseFloat( obj);
           
           if(vp>totalPagar){
               JOptionPane.showMessageDialog(this,"Troco:R$ "+(vp-totalPagar),"Pagamento",JOptionPane.INFORMATION_MESSAGE);
           }
           for(int i=0;i<prodLista.size();i++){     
                

                    
                    
                try {
                    
                    Produto auxp=prodLista.get(i);
                    totalPagar+=auxp.getPreco();
                    System.out.println("Valor do produto pagar: "+auxp.getPreco());
                    SalesmanController.finalizarVendaNow(auxp.getId(), auxp.getPreco(), sdf.parse(sdf.format(hj)),auxp.getQuant());
                } catch (ParseException| ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                       JOptionPane.showMessageDialog(null,"<html>Erro ao finalizar venda!<br>Produto:"+prodLista.get(i).getNome()+"<br>Quantidade:"+prodLista.get(i).getQuant()+"<br>Subtotal: "+prodLista.get(i).getPreco()+"</html>","Alerta",0);
                       break;
                }
                         

                   

           }
            
           
                JOptionPane.showMessageDialog(this,"Vendido com sucesso!","Finalizado",JOptionPane.INFORMATION_MESSAGE);
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
        }
        else JOptionPane.showMessageDialog(this, "Sem produtos para vender","Alerta",0);
            //aviso
            
            
            
       
    }//GEN-LAST:event_saleMouseClicked

    private void saleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleMouseEntered
        sale.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_saleMouseEntered

    private void saleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleMouseExited
        sale.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_saleMouseExited

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
       boolean ver=false;
       int indexProd=0;
        Iterator<Produto> it = prodS.iterator();  
	while (it.hasNext()) {  
		Produto prodP = it.next(); 
                if(prodP.getNome().toLowerCase().contains(pesquisaProduto.getText().toLowerCase())){
                    
                        ver=!ver;
                        indexProd= prodS.indexOf(prodP);
                        
                        break;
                    
                }
	}          
        if(ver){
           
           jcbProdutos.setSelectedIndex(indexProd+1);
           
       }else{
           JOptionPane.showMessageDialog(this,"Produto Não encontrado!","Alerta",0);
       }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void sale1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sale1MouseClicked
        totalP=0;
        System.out.println("Valor pagar:"+vpay );
        Iterator<Produto> it = prodLista.iterator();  
	while (it.hasNext()) {  
		Produto prodP = it.next(); 
                totalP+=prodP.getPreco();
	}    
        if(limite.get(jcbProdutos.getSelectedIndex()-1)!=0&&Integer.valueOf(String.valueOf(quantidade.getValue()))!=0){
            Produto prd= new Produto(ps.getNome(),ps.getQuant(),vpay,ps.getId());
            prodLista.add(prd);
            totalP+=vpay;
            String aux="TOTAL: R$";
            total.setText(aux+Float.toString(totalP));
            
            limite.set(jcbProdutos.getSelectedIndex()-1,limite.get(jcbProdutos.getSelectedIndex()-1)-ps.getQuant());


            DefaultTableModel modelo =  (DefaultTableModel) tblProdutos.getModel();
            modelo.addRow(new Object[]{
                    prd.getNome(),prd.getQuant(),vpay

                });
            tblProdutos.setModel(modelo);
            quantidade.setValue(0);
        }
    }//GEN-LAST:event_sale1MouseClicked

    private void sale1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sale1MouseEntered
        sale1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sale1MouseEntered

    private void sale1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sale1MouseExited
       sale1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_sale1MouseExited

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if(tblProdutos.getModel().getRowCount()!=0&&prodLista.size()>0){
        
        
            DefaultTableModel modelo =  (DefaultTableModel) tblProdutos.getModel();
            int index = tblProdutos.getSelectedRow();
            Produto auxP= prodLista.get(index);
            String aux="TOTAL: R$";
            total.setText(aux+Float.toString(totalP-auxP.getPreco()));
            int indexN = 0;
            Iterator<Produto> it = prodS.iterator();  
	while (it.hasNext()) {  
		Produto prodP = it.next(); 
                if(auxP.getNome().equals(prodP.getNome())){
                                            
                        indexN= prodS.indexOf(prodP);
                        
                        break;
                    
                }
	}        
            
            
            limite.set(indexN,limite.get(indexN)+auxP.getQuant());
            modelo.removeRow(index);
            prodLista.remove(index);
            
            
            tblProdutos.setModel(modelo);
            tblProdutos.updateUI();
        }      
        
    }//GEN-LAST:event_btnRemoverActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SaleNowFrame().setVisible(true);
                } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bgSale;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JComboBox<String> jcbProdutos;
    private javax.swing.JLabel lblNew;
    public static javax.swing.JTextField pesquisaProduto;
    public static javax.swing.JSpinner quantidade;
    private javax.swing.JLabel sale;
    private javax.swing.JLabel sale1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JLabel total;
    private javax.swing.JLabel unitaryV;
    // End of variables declaration//GEN-END:variables
}
