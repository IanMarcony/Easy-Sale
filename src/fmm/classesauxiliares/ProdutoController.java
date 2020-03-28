/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.AlterPSFrame;
import fmm.scenes.AlterProdSaleFrame;
import fmm.scenes.AuthFrame;
import fmm.scenes.Inventory;
import fmm.scenes.SaleFrame;
import fmm.scenes.SaleNowFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2aimaq20
 */
public class ProdutoController {
    
    public static void readTable() throws ClassNotFoundException, SQLException{
        DefaultTableModel modelo =  (DefaultTableModel) Inventory.jtInvet.getModel();
        
     
        for(Produto p: readProductsInvet()){
            modelo.addRow(new Object[]{
                p.getNome(),p.getPreco(),p.getQuant(),p.getExiste(),p.getId()
            
            });
        }

    }

    public static List<Produto> readProducts() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null, stmt_aux=null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        System.out.println(AuthFrame.pessoa.getUser());
        
        try{
            stmt = con.prepareStatement("SELECT * FROM produto  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' order by id asc");// Instrução ao banco de dados
           
            
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
            //    System.out.println("2.Quantidade "+rs.getInt("quant"));
                if(rs.getInt("quant")>0&&!rs.getString("disponibilidade").equals("Indisponível")){
                
                    Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));             
                prod.setPreco(rs.getFloat("preco"));
                prod.setExiste(rs.getString("disponibilidade"));
                
                prod.setQuant(rs.getInt("quant"));
                
                produtos.add(prod);
               //     System.out.println("passei o produto à lista");
                }else{
                //    System.out.println("iniciando atualização de campo");
                    stmt_aux = con.prepareStatement("update produto set disponibilidade='Indisponível' where id="+rs.getInt("id")+"");
                    stmt_aux.executeUpdate();
                 //   System.out.println("finalizei 1");
                    stmt_aux = con.prepareStatement("update produto set quant=0 where id="+rs.getInt("id")+"");
                    stmt_aux.executeUpdate();
                 //   System.out.println("finalizei 2");
                }
            
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR  PRODUTO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        return produtos;
    }
    
    public static List<Produto> readProductsInvet() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null, stmt_aux=null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM produto  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' order by id asc");// Instrução ao banco de dados
           
            
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                    Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));             
                prod.setPreco(rs.getFloat("preco"));
                
                if(rs.getInt("quant")<=0){
                    stmt_aux = con.prepareStatement("update produto set disponibilidade='Indisponível' where id="+rs.getInt("id")+"");
                    stmt_aux.executeUpdate();
                    prod.setExiste("Indisponível");
                }else if(rs.getInt("quant")>0&&rs.getString("disponibilidade").equals("Indisponível")){
                    stmt_aux = con.prepareStatement("update produto set disponibilidade='Disponível' where id="+rs.getInt("id")+"");
                    stmt_aux.executeUpdate();
                
                    prod.setExiste("Disponível");
                
                }else{
                    prod.setExiste(rs.getString("disponibilidade"));
                }
                
                prod.setQuant(rs.getInt("quant"));
                
                produtos.add(prod);
               
                
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR  PRODUTO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        return produtos;
    }
    
    public static void readNameProducts(int i) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        int n=0;
        
        
       // System.out.println(AuthFrame.pessoa.getUser());
        
        try{
            stmt = con.prepareStatement("SELECT * FROM produto  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' order by id asc");// Instrução ao banco de dados
           
            
            
            rs = stmt.executeQuery();
            
            while(rs.next()){       
                
                if(rs.getInt("quant")>0&&i==0)SaleFrame.jcbProdutos.addItem(rs.getString("nome"));                
                else if(rs.getInt("quant")>0&&i==2)SaleNowFrame.jcbProdutos.addItem(rs.getString("nome"));                
                else if(rs.getInt("quant")>0&&i==1)AlterProdSaleFrame.produtosComboBox.addItem(rs.getString("nome"));
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR NOME DO PRODUTO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        
    }
   
    public static void criarProduto(Produto obj) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
       // System.out.println("preparando executar");
        
        try{
            stmt = con.prepareStatement("INSERT INTO produto values(DEFAULT,'"+obj.getNome()+"',"+obj.getPreco()+",'"+AuthFrame.pessoa.getUser()+"',"+obj.getQuant()+",'Disponivel')");// Instrução ao banco de dados
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"SALVO COM SUCESSO");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO REGISTRAR PRODUTO");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        
    }
    
    public static void eraseProduct(Produto obj) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM produto   WHERE id_conta='"+obj.getId_conta()+"' and  nome='"+obj.getNome()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
           
          JOptionPane.showMessageDialog(null,"DELETADO COM SUCESSO");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO DELETAR");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        
        
        
    }

    
    public static boolean alterProductALL(String nome,float preco  ,int quant,int id) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        int vf = quant;
        PreparedStatement stmt = null;// Usado para controlar o sql
       // System.out.println("preparando executar");
        boolean ok=false;
        try{
            
            stmt = con.prepareStatement("UPDATE  produto SET nome = '"+nome+"'   WHERE id_conta='"+AuthFrame.pessoa.getUser()+"'  and id="+id+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE  produto SET preco = "+preco+"   WHERE id_conta='"+AuthFrame.pessoa.getUser()+"'    and id="+id+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE  produto SET quant = "+vf+"   WHERE id_conta='"+AuthFrame.pessoa.getUser()+"'    and id="+id+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
           
            ok=!ok;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO DELETAR");
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
        return ok;
    }
    
    
    public static int  alterProdPedingSale(Produto pnew, int quantComprada, int id_venda, float old_valorPagar, float receber) throws ClassNotFoundException, SQLException{
      
        Connection con = ConnectionSQL.getConnection();
            
         PreparedStatement stmt = null;
         
         int quantNew=0,n=0;
         
         try{
             
             if(quantComprada>pnew.getQuant()){
                 quantNew=quantComprada-pnew.getQuant();
                 quantComprada-=quantNew;
                 pnew.setQuant(pnew.getQuant()+quantNew);
             }
             else{
                 quantNew=pnew.getQuant()-quantComprada;
                 quantComprada+=quantNew;
                 pnew.setQuant(pnew.getQuant()-quantNew);
             
             }
             
             float valor_pagar= quantComprada*pnew.getPreco();
             
             stmt = con.prepareStatement("UPDATE venda set quant="+quantComprada+"  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' and id="+id_venda+"");// Instrução ao banco de dados          
             stmt.executeUpdate();
             
             stmt = con.prepareStatement("UPDATE venda set id_produto="+pnew.getId()+"  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' and id="+id_venda+"");// Instrução ao banco de dados          
             stmt.executeUpdate();
             
             stmt = con.prepareStatement("UPDATE venda set valor_final="+valor_pagar+"  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' and id="+id_venda+"");// Instrução ao banco de dados          
             stmt.executeUpdate();
             
             receber-=old_valorPagar;
             receber+=valor_pagar;
             
             stmt = con.prepareStatement("UPDATE conta set total_receber="+receber+"  WHERE username ='"+AuthFrame.pessoa.getUser()+"' ");// Instrução ao banco de dados          
             stmt.executeUpdate();
             
             
             
             stmt = con.prepareStatement("UPDATE produto set quant="+pnew.getQuant()+"  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' and id="+pnew.getId()+"");// Instrução ao banco de dados          
             stmt.executeUpdate();
             
             AlterPSFrame.vendaA.setQuant(quantComprada);
             AlterPSFrame.vendaA.setValor_final(valor_pagar);
             AlterPSFrame.vendaA.setProd(pnew);
             n++;
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO ALTERAR");
            System.out.println(ex);
        }finally{
            ConnectionSQL.closeConnection(con,stmt);
        }
                
      
         return n;
    }

}
