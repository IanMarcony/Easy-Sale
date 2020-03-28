/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.AuthFrame;
import fmm.scenes.SaleFrame;
import fmm.scenes.SaleNowFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author 2aimaq20
 */
public class SalesmanController {
    
    public static float totalVendas() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        float total =-1;
        //System.out.println(AuthFrame.pessoa.getUser());
        
        try{
           // System.out.println("Fazendo a busca");
            stmt = con.prepareStatement("SELECT sum(valor_pago) as valor FROM historicovendas WHERE id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
            
            rs = stmt.executeQuery();
           // System.out.println("Executei a query");
         
                    rs.first();
                        total = rs.getFloat("valor");
                        
                    
          //  System.out.println("passei o valor = "+total);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao Acessar!!!");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
            
        }
        return total;
    }
    public static float totalPendencias() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        float total =-1;
       // System.out.println(AuthFrame.pessoa.getUser());
        
        try{
         //   System.out.println("Fazendo a busca");
            stmt = con.prepareStatement("SELECT * FROM CONTA WHERE username ='"+AuthFrame.pessoa.getUser()+"' and senha ='"+AuthFrame.pessoa.getSenha()+"'");// Instrução ao banco de dados
            
            rs = stmt.executeQuery();
            //System.out.println("Executei a query");
         
                    rs.first();
                    total = rs.getFloat("total_receber");
                        if(total<0){
                            stmt = con.prepareStatement("UPDATE conta SET total_receber=0 WHERE username ='"+AuthFrame.pessoa.getUser()+"' and senha ='"+AuthFrame.pessoa.getSenha()+"'");// Instrução ao banco de dados
                            stmt.executeUpdate();
                            total=0;
                        }
                        
                    
           // System.out.println("passei o valor = "+total);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao Acessar!!!");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
            
        }
        return total;
    }
    public static void AtualizaPendencias(float total)throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
    //    System.out.println("preparando executar");
        
        ResultSet rs=null;
    
            
        try{
            
            
            stmt = con.prepareStatement("select total_receber from conta where username='"+AuthFrame.pessoa.getUser()+"' ");
            
            rs = stmt.executeQuery();
            
            rs.first();
            
            float valorReceber= rs.getInt("total_receber");
            total+=valorReceber;
            
            AuthFrame.pessoa.setReceber(valorReceber);
            
          //  System.out.println("valor atualizado, "+ AuthFrame.pessoa.getReceber());
            
            stmt= con.prepareStatement("update conta set total_receber="+total+" where username='"+AuthFrame.pessoa.getUser()+"'");
            
            stmt.executeUpdate();
           
            
            
            
           
            
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Erro ao vender!","Alerta",0);
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
    }
    public static void vender(String nomeVendedor,Comprador comp,Date data_venda, Date data_fech,Produto p) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
    //    System.out.println("preparando executar");
        
        ResultSet rs=null;
        
        int idProduto = 0,idComprador=0,idVenda=0,quantProd=0;
        float valorReceber=0;
        
    
        try{
            stmt = con.prepareStatement("INSERT INTO comprador(nome,telefone,rua,bairro,numero,complemento,id_conta,quantVendas) values('"+comp.getNome()+"','"+comp.getTelefone()+"','"+comp.end1.getRua()+"','"+comp.end1.getBairro()+"','"+comp.end1.getNumero()+"','"+comp.end1.getComplemento()+"','"+nomeVendedor+"',1)");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
       //     System.out.println("executei 1");
            
            stmt = con.prepareStatement("select id from produto where nome='"+p.getNome()+"' and id_conta='"+nomeVendedor+"'");
            
            rs = stmt.executeQuery();
            
            rs.first();
            
            idProduto= rs.getInt("id");
            
            
          //  System.out.println("executei 2, idProduto = "+idProduto);
            
            stmt = con.prepareStatement("select id from comprador where nome='"+comp.getNome()+"' and id_conta='"+nomeVendedor+"'");
            
            rs = stmt.executeQuery();
           
            rs.first();
           idComprador= rs.getInt("id");
           SaleFrame.c1.setId(idComprador);
          //  System.out.println("executei 3, idComprador = "+idComprador);
            
            stmt = con.prepareStatement("INSERT INTO venda(id_produto,data_venda,data_venc,id_comprador,quant,valor_final,id_conta,vendido) values(?,?,?,?,?,?,? ,'não')");// Instrução ao banco de dados
            java.sql.Date dv = new java.sql.Date(data_venda.getTime());
            java.sql.Date df = new java.sql.Date(data_fech.getTime());
            stmt.setInt(1, idProduto);
            stmt.setDate(2,  dv);
            stmt.setDate(3, df);
            stmt.setInt(4, idComprador);
            stmt.setInt(5, p.getQuant());
            stmt.setFloat(6, p.getPreco());
            stmt.setString(7,nomeVendedor);
            
            stmt.executeUpdate();
            
       //     System.out.println("executei 4, venda inserida no banco");
            
            
            stmt = con.prepareStatement("select * from produto where id="+idProduto+"");
            
            rs = stmt.executeQuery();
           
            rs.first();
           quantProd= rs.getInt("quant");
           
          //  System.out.println("recebi a quantidade do produto id="+idProduto+" que é "+quantProd);
           
           quantProd-=p.getQuant();
           
           
           stmt = con.prepareStatement("update produto set quant="+quantProd+" where id_conta='"+nomeVendedor+"' and id="+idProduto+"");
           stmt.executeUpdate();
           
           // System.out.println("Atualizando a quantidade no banco do produto vendido");
           
          //  System.out.println("Finalizei");
            
            
           
            
            
            
           
            
        }catch(SQLException ex){
            ex.printStackTrace();
           JOptionPane.showMessageDialog(null,"Erro ao vender!","Alerta",0);
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        
    
    }
    
    public static void venderMesmoComprador(String nomeVendedor,Comprador comp,Date data_venda, Date data_fech,Produto p) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        //System.out.println("preparando executar");
        
        ResultSet rs=null;
        
        int idProduto = 0,idVenda=0,quantProd=0;
        float valorReceber=0;
        
    
        try{
            
         //   System.out.println("executei 1");
            
            stmt = con.prepareStatement("select id from produto where nome='"+p.getNome()+"' and id_conta='"+nomeVendedor+"'");
            
            rs = stmt.executeQuery();
            
            rs.first();
            
            idProduto= rs.getInt("id");
            
            
            
            stmt = con.prepareStatement("INSERT INTO venda(id_produto,data_venda,data_venc,id_comprador,quant,valor_final,id_conta,vendido) values(?,?,?,?,?,?,? ,'não')");// Instrução ao banco de dados
           java.sql.Date dv = new java.sql.Date(data_venda.getTime());
           java.sql.Date df = new java.sql.Date(data_fech.getTime());
            stmt.setInt(1, idProduto);
            stmt.setDate(2,  dv);
            stmt.setDate(3, df);
            stmt.setInt(4,comp.getId());
            stmt.setInt(5, p.getQuant());
            stmt.setFloat(6, p.getPreco());
            stmt.setString(7,nomeVendedor);
            
            stmt.executeUpdate();
            
            
            stmt = con.prepareStatement("select quantVendas from comprador where id="+comp.getId()+" and id_conta='"+nomeVendedor+"'");
            
            rs = stmt.executeQuery();
            
            rs.first();
            
            int q= rs.getInt("quantVendas");
            q++;
            
            stmt = con.prepareStatement("update comprador set quantVendas="+q+" where id="+comp.getId()+" and id_conta='"+nomeVendedor+"'");
            
             stmt.executeUpdate();
            
            
            stmt = con.prepareStatement("select * from produto where id="+idProduto+"");
            
            rs = stmt.executeQuery();
           
            rs.first();
           quantProd= rs.getInt("quant");
           
          //  System.out.println("recebi a quantidade do produto id="+idProduto+" que é "+quantProd);
           
           quantProd-=p.getQuant();
           
           
           stmt = con.prepareStatement("update produto set quant="+quantProd+" where id_conta='"+nomeVendedor+"' and id="+idProduto+"");
           stmt.executeUpdate();
        
           
            
           
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao finalizar venda!","Alerta",0);
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        
    
    }
    
    public static void finalizarVenda(int id_comprador, int id_venda, int id_produto, float valor, Date data_fech ) throws ClassNotFoundException{
        Connection con;
        try {
            con = ConnectionSQL.getConnection(); //Inicia a conexão
            PreparedStatement stmt = null, stmt_aux=null;// Usado para controlar o sql
        
        ResultSet rs=null, rs_aux=null;
        Sale  venda = null;
        
      //  System.out.println(" no método de exclusão");
        
        try{
        //    System.out.println("id do comprador: "+id_comprador);
            stmt_aux = con.prepareStatement("select * from produto where id="+id_produto+"");
            
            rs_aux = stmt_aux.executeQuery();
            rs_aux.first();
            Produto produto = new Produto(rs_aux.getString("nome"),rs_aux.getInt("quant"),rs_aux.getFloat("preco"));
            
            
            stmt_aux = con.prepareStatement("select * from venda where id="+id_venda+"");
            
            rs_aux = stmt_aux.executeQuery();
            rs_aux.first();
            venda = new Sale(data_fech,null,produto,valor,rs_aux.getInt("quant"));
        
            stmt_aux = con.prepareStatement("select * from comprador where id="+id_comprador+"");
            
            rs_aux = stmt_aux.executeQuery();
            rs_aux.first();
            
            
            int v = rs_aux.getInt("quantVendas");
           // System.out.println("quantidade de vendas do comprador: "+v);
            
            if(v==1){
                
           //     System.out.println("irei deletar o comprador tbm");
           
           
           
           
            stmt = con.prepareStatement("DELETE FROM venda   WHERE id="+id_venda+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
          //      System.out.println("deletado a venda");
            stmt = con.prepareStatement("DELETE FROM comprador   WHERE id="+id_comprador+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            //System.out.println("deletado o comprador\n Começando a atualização do totaL_receber");
            
            stmt = con.prepareStatement("SELECT * FROM conta where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            float aux = rs.getFloat("total_receber");//no banco
            float aux2=valor;
            aux-=valor;
            
            stmt = con.prepareStatement("UPDATE conta SET total_receber="+aux+"   WHERE username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("SELECT * FROM conta where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            
            aux2+=rs.getFloat("total_venda");
            
            
            stmt = con.prepareStatement("UPDATE conta SET total_venda="+aux2+"   WHERE username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
           //     System.out.println("atualizado");
            
            
            
            }else{
                
            //    System.out.println("apenas a venda será deletada");
                
              
                stmt = con.prepareStatement("DELETE FROM venda   WHERE id="+id_venda+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
     
           //     System.out.println("deletado a venda\nComeçando  atualização do total_receber");
            
            stmt = con.prepareStatement("SELECT * FROM conta where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            float aux = rs.getFloat("total_receber");
            float aux2=valor;
            aux-=valor;
            
            stmt = con.prepareStatement("UPDATE conta SET total_receber="+aux+"   WHERE username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("SELECT * FROM conta where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            
            aux2+=rs.getFloat("total_venda");
            
            
            stmt = con.prepareStatement("UPDATE conta SET total_venda="+aux2+"   WHERE username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
          //      System.out.println("atualizado valor no banco");
            
            v--;
            stmt = con.prepareStatement("UPDATE comprador SET quantVendas="+v+"   WHERE id="+id_comprador+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            //    System.out.println("atualizado quantidade de vendas do comprador");
            
            }
            
            stmt = con.prepareStatement("INSERT INTO historicovendas(dat_fech,valor_pago,id_conta) values(?,?,?)");
            java.sql.Date df = new java.sql.Date(data_fech.getTime());
            stmt.setDate(1, df);
            stmt.setFloat(2, valor);
            stmt.setString(3,AuthFrame.pessoa.getUser());
            
            stmt.executeUpdate();
            
            
            // nome produto - quantidade - valor pago - data
            stmt = con.prepareStatement("INSERT INTO controlevendas(nome_produto,quantidade,valor_pago,data_venda,hora,id_conta) values(?,?,?,?,?,?)");
            stmt.setString(1, venda.prod.getNome());
            stmt.setInt(2, venda.getQuant());
            stmt.setFloat(3, venda.getValor_final());            
            stmt.setDate(4,df);
            SimpleDateFormat sdf = new  SimpleDateFormat("hh:mm");
            
            stmt.setString(5, sdf.format(new GregorianCalendar().getTime()));
            stmt.setString(6,AuthFrame.pessoa.getUser());
            stmt.executeUpdate();
            
            
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
           JOptionPane.showMessageDialog(null,"Erro ao finalizar venda!","Alerta",0);
            
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        
        
    } catch (SQLException ex) {
          System.out.println("erro");
    }
        
        
    }
    
     public static void finalizarVendaNow( int id_produto, float valor, Date data_fech, int quant ) throws ClassNotFoundException, SQLException{
        Connection con= ConnectionSQL.getConnection();
        PreparedStatement stmt = null;// Usado para controlar o sql        
        ResultSet rs=null;            
         int quantProd=0;
         System.out.println("Valor passado para o banco: "+valor);
        try {
            stmt = con.prepareStatement("select * from produto where id="+id_produto+"");
            
            rs = stmt.executeQuery();
            
            rs.first();
            Produto produto = new Produto(rs.getString("nome"),rs.getInt("quant"),rs.getFloat("preco"));
            
        
   
            
            stmt = con.prepareStatement("SELECT * FROM conta where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            
            float valorP=valor+rs.getFloat("total_venda");
            
            
            stmt = con.prepareStatement("UPDATE conta SET total_venda="+valorP+"   WHERE username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("SELECT quant FROM produto WHERE id="+id_produto+" and id_conta='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();           
            
                         
                quantProd=rs.getInt("quant")-quant;
                 

           stmt = con.prepareStatement("UPDATE produto SET quant="+quantProd+" WHERE id_conta='"+AuthFrame.pessoa.getUser()+"' AND id="+id_produto+"");
           stmt.executeUpdate();
           System.out.println("Atualizado");
           
            
            
            stmt = con.prepareStatement("INSERT INTO historicovendas(dat_fech,valor_pago,id_conta) values(?,?,?)");
            
            java.sql.Date df = new java.sql.Date(data_fech.getTime());
            stmt.setDate(1, df);
            stmt.setFloat(2, valor);
            System.out.println("Valor: "+valor);
            stmt.setString(3,AuthFrame.pessoa.getUser());
            
            stmt.executeUpdate();
            
             stmt = con.prepareStatement("INSERT INTO controlevendas(nome_produto,quantidade,valor_pago,data_venda,hora,id_conta) values(?,?,?,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, quant);
            stmt.setFloat(3,valor);            
            stmt.setDate(4,df);
            SimpleDateFormat sdf = new  SimpleDateFormat("hh:mm");
            
            stmt.setString(5, sdf.format(new GregorianCalendar().getTime()));
            stmt.setString(6,AuthFrame.pessoa.getUser());
            stmt.executeUpdate();
            
        
        
    } catch (SQLException ex) {
          ex.printStackTrace();
           JOptionPane.showMessageDialog(null,"Erro ao finalizar venda!","Alerta",0);
        
        
    }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        
        
        
    }
    
    
    
    public static void excluirHistorico(){
        Connection con=null;
        PreparedStatement stmt=null;
        try {
            con = ConnectionSQL.getConnection();
            
            stmt = con.prepareStatement("DELETE FROM historicovendas where id_conta='"+AuthFrame.pessoa.getUser()+"'");
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("DELETE FROM controlevendas where id_conta='"+AuthFrame.pessoa.getUser()+"'");
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE  conta SET total_venda=0 where username='"+AuthFrame.pessoa.getUser()+"'");
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"APAGADO COM SUCESSO" );
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            
        }finally{
            ConnectionSQL.closeConnection(con, stmt);
        }
    }
    
    
}
