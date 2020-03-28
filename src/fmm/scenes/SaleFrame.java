/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.scenes;

import fmm.classesauxiliares.*;
import static fmm.scenes.SaleNowFrame.quantidade;
import java.awt.Cursor;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2aimaq20
 */
public class SaleFrame extends javax.swing.JFrame {
    private Produto ps;
    private List<Produto> prodS,prodLista;
    private List<Integer> limite;
    private Salesman vendedor1;
    public static Comprador c1;
    private Date hj;
    private float totalP;
    private float vpay;    
    private boolean sameBuyer;
    /**
     * Creates new form SaleFrame
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public SaleFrame() throws ClassNotFoundException, SQLException {
        initComponents();
        
        ps = new Produto();
        vendedor1 = new Salesman(AuthFrame.pessoa.getUser(), AuthFrame.pessoa.getSenha(),AuthFrame.pessoa.getTotal(),AuthFrame.pessoa.getReceber());
        setIconImage(new ImageIcon(getClass().getResource("/fmm/assets/logo_EasySale.png")).getImage());
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
         hj = new Date();
        
                
        jcbProdutos.addItem("--Selecione um item--");
        ProdutoController.readNameProducts(0);
        quantidade.setEnabled(false);
        prodS = new ArrayList<>();
        prodLista= new ArrayList<>();
        limite = new ArrayList<>();
        prodS = ProdutoController.readProducts();
        for(int i=0;i<prodS.size();i++)limite.add(prodS.get(i).getQuant());
        c1= new Comprador();       
        dayToday.setText(sdf.format(hj));
        dayPay.setText(sdf.format(hj));
        
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        total = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        unitaryV = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();
        pesquisaProduto = new javax.swing.JTextField();
        street = new javax.swing.JTextField();
        numeroComprador = new javax.swing.JTextField();
        nomeComprador = new javax.swing.JTextField();
        dayToday = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ns = new javax.swing.JTextField();
        sale1 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dayPay = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        name1 = new javax.swing.JTextArea();
        quantidade = new javax.swing.JSpinner();
        sale = new javax.swing.JLabel();
        jcbProdutos = new javax.swing.JComboBox<>();
        dd = new javax.swing.JTextField();
        lblNew = new javax.swing.JLabel();
        bgSale = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Sale");
        setMaximumSize(new java.awt.Dimension(934, 522));
        setMinimumSize(new java.awt.Dimension(934, 522));
        setResizable(false);
        getContentPane().setLayout(null);

        total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        total.setText("TOTAL: R$ 00.0");
        getContentPane().add(total);
        total.setBounds(650, 220, 220, 30);

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
        jScrollPane1.setBounds(580, 40, 340, 130);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REGISTRAR COMPRADOR");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 220, 220, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Valor a Pagar: R$ ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(340, 150, 240, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Data de Hoje");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 190, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("<html><sup style=\"color: red;\">*</sup><u>Nome:<u>");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 260, 60, 30);

        unitaryV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        unitaryV.setText("Valor Unitário: R$ ");
        getContentPane().add(unitaryV);
        unitaryV.setBounds(340, 110, 240, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("<html><sup style=\"color: red;\">*</sup><u>Produto:<u>");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(50, 50, 80, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("<html><sup style=\"color: red;\">*</sup><u>Quantidade:<u>");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 150, 80, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("<html><sup style=\"color: red;\">*</sup><u>Data para Pagar:<u>");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(300, 190, 110, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("<html><sup style=\"color: red;\">*</sup><u>Telefone:<u>");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(290, 260, 80, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Rua:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(70, 300, 60, 30);

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/lupaPesquisa_icon.png"))); // NOI18N
        btnPesquisa.setToolTipText("Pesquisar Produto");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisa);
        btnPesquisa.setBounds(290, 70, 30, 30);

        pesquisaProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(pesquisaProduto);
        pesquisaProduto.setBounds(140, 70, 150, 30);

        street.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(street);
        street.setBounds(130, 300, 150, 30);

        numeroComprador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(numeroComprador);
        numeroComprador.setBounds(450, 260, 210, 30);

        nomeComprador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(nomeComprador);
        nomeComprador.setBounds(130, 260, 150, 30);

        dayToday.setEditable(false);
        dayToday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        dayToday.setEnabled(false);
        dayToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTodayActionPerformed(evt);
            }
        });
        getContentPane().add(dayToday);
        dayToday.setBounds(140, 190, 140, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Complemento: ");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(70, 340, 110, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Bairro:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(420, 300, 50, 30);

        bairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(bairro);
        bairro.setBounds(480, 300, 180, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("N°:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(300, 300, 30, 30);

        ns.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(ns);
        ns.setBounds(340, 300, 60, 30);

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
        sale1.setBounds(210, 420, 64, 64);

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
        back.setBounds(840, 420, 64, 64);

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/removeProd.png"))); // NOI18N
        btnRemover.setToolTipText("Remove Produto");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover);
        btnRemover.setBounds(760, 180, 30, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("REGISTRAR PRODUTO");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 10, 200, 40);

        dayPay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        getContentPane().add(dayPay);
        dayPay.setBounds(420, 190, 140, 30);

        name1.setColumns(20);
        name1.setRows(5);
        jScrollPane2.setViewportView(name1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(180, 340, 480, 60);

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
        quantidade.setBounds(140, 150, 180, 30);

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
        jcbProdutos.setBounds(140, 110, 180, 30);

        dd.setText("DD");
        getContentPane().add(dd);
        dd.setBounds(370, 260, 70, 30);

        lblNew.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNew.setForeground(new java.awt.Color(255, 255, 255));
        lblNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNew.setText("NOVA VENDA");
        getContentPane().add(lblNew);
        lblNew.setBounds(180, 0, 350, 60);

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
            quantidade.setEnabled(true);
            quantidade.setValue(0);
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

    private void dayTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTodayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayTodayActionPerformed

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
        if(SaleController.maySale(0)&&SaleController.correctDate()&&prodLista.size()>0){
            //registrar
            c1.setId_conta(vendedor1.getUser());
            c1.setNome(nomeComprador.getText());
            c1.setTelefone(dd.getText()+numeroComprador.getText());
            c1.end1.setBairro(bairro.getText());
            c1.end1.setComplemento(name1.getText());
            c1.end1.setNumero(ns.getText());
            c1.end1.setRua(street.getText());
            
            SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
            
            
            
            
            try {
                for(int i=0;i<prodLista.size();i++)totalPagar+=prodLista.get(i).getPreco();
                System.out.println("Total pagar: "+totalPagar);
                for(int i=0;i<prodLista.size();i++){
                
                    if(i==0){
                        SalesmanController.vender(vendedor1.getUser(),c1,sdf.parse(dayToday.getText()) ,sdf.parse(dayPay.getText()) ,prodLista.get(i));                        
                    }
                    else SalesmanController.venderMesmoComprador(vendedor1.getUser(),c1,sdf.parse(dayToday.getText()) ,sdf.parse(dayPay.getText()) ,prodLista.get(i));
                }
                 SalesmanController.AtualizaPendencias(totalPagar);
                JOptionPane.showMessageDialog(this,"Vendido com sucesso!","Finalizado",JOptionPane.INFORMATION_MESSAGE);
                        HomeFrame hf;
       try {
                    hf = new HomeFrame();
                    hf.setLocationRelativeTo(null);
                    this.dispose();
                    hf.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
            } catch (ParseException ex) {
                System.out.println("erro ao passar datas");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
            }
            
        }
        else{
            //aviso
            if(prodLista.size()==0)JOptionPane.showMessageDialog(this, "Sem produtos para vender","Alerta",0);
            if(!SaleController.maySale(0)) JOptionPane.showMessageDialog(this, "Campos obrigatórios vazios","Alerta",0);
            if(!SaleController.correctDate()) JOptionPane.showMessageDialog(this, "Erro na Data!","Alerta",0);
        }
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
        Iterator<Produto> it = prodLista.iterator();  
	while (it.hasNext()) {  
		Produto prodP = it.next(); 
                totalP+=prodP.getPreco();
	}      
        
        
        if(limite.get(jcbProdutos.getSelectedIndex()-1)!=0&&Integer.valueOf(String.valueOf(quantidade.getValue()))!=0){
            Produto prd= new Produto(ps.getNome(),ps.getQuant(),vpay);
            totalP+=vpay;
            prodLista.add(prd);
            String aux="TOTAL: R$";
            total.setText(aux+Float.toString(totalP));
            
            limite.set(jcbProdutos.getSelectedIndex()-1,limite.get(jcbProdutos.getSelectedIndex()-1)-ps.getQuant());
            

            DefaultTableModel modelo =  (DefaultTableModel) tblProdutos.getModel();
            modelo.addRow(new Object[]{
                    prd.getNome(),prd.getQuant(),vpay

                }); 
            quantidade.setValue(0);
            tblProdutos.setModel(modelo);
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
                    new SaleFrame().setVisible(true);
                } catch (ClassNotFoundException|SQLException ex) {
                            System.out.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JTextField bairro;
    private javax.swing.JLabel bgSale;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnRemover;
    public static javax.swing.JFormattedTextField dayPay;
    public static javax.swing.JFormattedTextField dayToday;
    private javax.swing.JTextField dd;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JComboBox<String> jcbProdutos;
    private javax.swing.JLabel lblNew;
    private javax.swing.JTextArea name1;
    public static javax.swing.JTextField nomeComprador;
    private javax.swing.JTextField ns;
    public static javax.swing.JTextField numeroComprador;
    public static javax.swing.JTextField pesquisaProduto;
    public static javax.swing.JSpinner quantidade;
    private javax.swing.JLabel sale;
    private javax.swing.JLabel sale1;
    private javax.swing.JTextField street;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JLabel total;
    private javax.swing.JLabel unitaryV;
    // End of variables declaration//GEN-END:variables
}
