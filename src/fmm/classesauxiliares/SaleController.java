package fmm.classesauxiliares;

import fmm.scenes.AuthFrame;
import fmm.scenes.DetalheVendaFrame;
import fmm.scenes.PedingSaleFrame;
import static fmm.scenes.PedingSaleFrame.Lvendas;
import fmm.scenes.SaleFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2aimaq20
 */
public class SaleController {
    
    
    public static void readSales2() throws ClassNotFoundException, SQLException{
        DefaultTableModel modelo =  (DefaultTableModel) PedingSaleFrame.tblSales.getModel();                
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for(Sale s: readPedingSales()){
            Lvendas.add(s);
             modelo.addRow(new Object[]{
                 s.comp.getNome(),s.prod.getNome(),s.getQuant(),sdf.format(s.getDataAtual()),sdf.format(s.getDataPay()),s.getValor_final()
            
            });
        }
    
    } 
    public static void readSales3() throws ClassNotFoundException, SQLException{
        DefaultTableModel modelo =  (DefaultTableModel) DetalheVendaFrame.detalhes.getModel();                
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Sale s: readControlSales()){
            
             modelo.addRow(new Object[]{
                 s.getProd().getNome(),s.getQuant(),s.getValor_final(),sdf.format(s.getDataPay()),s.getHora()
            
            });
        }
    
    } 
     
    public static boolean correctDate(){
        SimpleDateFormat  sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dataHJ=null;
        Date dataPA=null;
         boolean b =false;
         
     
        try {
             dataHJ = sdf.parse(SaleFrame.dayToday.getText());
            dataPA = sdf.parse(SaleFrame.dayPay.getText());
            b =dataPA.before(dataHJ) ;// dia de pagamento antes de hj
        } catch (ParseException ex) {
            System.out.println("Erro");
        }
             
              
          
    
           
        if(b)return false;//erro
        else if (dataPA.equals(dataHJ) || !b)return true;//ok
        
        return false;
       
    }
    
    public static boolean maySale(int i){
        boolean v=false;
        int n=0;
        switch(i){
            case 0:     n = Integer.valueOf(String.valueOf(SaleFrame.quantidade.getValue()));
                        v =  SaleFrame.dayPay.getText().equals("") || SaleFrame.nomeComprador.getText().equals("") || SaleFrame.numeroComprador.getText().equals("") || (SaleFrame.numeroComprador.getText().length()!=9) ;
                
            break;            
        }
        if(v){      

                    return false;
                }
                else{
                    return true;
                }
    }
    
    public static  List<Sale> readPedingSales() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null, stmt_prod=null, stmt_comp=null;// Usado para controlar o sql
        
        ResultSet rs = null, rs_prod=null, rs_comp=null;
        
        List<Sale> vendas = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM venda  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' order by id desc");// Instrução ao banco de dados          
            rs = stmt.executeQuery();
           // System.out.println("passei da primeira");
            
            while(rs.next()){
                Sale v1 = new Sale();
                Comprador c1 = new Comprador();
                Produto p1 = new Produto();
               // System.out.println("instaciado objetos");
                
                //Produto
               // System.out.println("iniciando a parte do produto, id do produto: "+rs.getInt("id_produto"));
                stmt_prod = con.prepareStatement("SELECT id,nome,preco FROM produto  WHERE id="+rs.getInt("id_produto")+"");// Instrução ao banco de dados          
                
                rs_prod = stmt_prod.executeQuery();
                rs_prod.first(); 
                
                p1.setId(rs_prod.getInt("id"));
                p1.setNome(rs_prod.getString("nome"));             
                p1.setPreco(rs_prod.getFloat("preco"));
                
                stmt_comp = con.prepareStatement("SELECT * FROM comprador  WHERE  id="+rs.getInt("id_comprador")+"");// Instrução ao banco de dados          
                rs_comp = stmt_comp.executeQuery();
                 rs_comp.first(); 
                
                 c1.setId(rs_comp.getInt("id"));
                c1.setNome(rs_comp.getString("nome"));   
                c1.setTelefone(rs_comp.getString("telefone"));
                c1.end1.setRua(rs_comp.getString("rua"));
                c1.end1.setBairro(rs_comp.getString("bairro"));
                c1.end1.setNumero(rs_comp.getString("numero"));
                c1.end1.setComplemento(rs_comp.getString("complemento"));
                
               // System.out.println("passou do comprador");
                //Venda
                
                v1.setComp(c1);
                v1.setProd(p1);
                v1.setDataAtual(rs.getDate("data_venda"));
                v1.setDataPay(rs.getDate("data_venc"));
                v1.setQuant(rs.getInt("quant"));
                v1.setValor_final(rs.getFloat("valor_final"));
                v1.setVendido(rs.getString("vendido"));
                v1.setId(rs.getInt("id"));
                
                
                vendas.add(v1);
                
            
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR  VENDAS");
            System.out.println(ex);
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        return vendas;
   
    }
      
     public static  List<Sale> readControlSales() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Sale> vendas = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM controlevendas  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' order by id desc");// Instrução ao banco de dados          
            rs = stmt.executeQuery();
           // System.out.println("passei da primeira");
            
            while(rs.next()){
                Sale v1 = new Sale();                                             
                v1.prod.setNome(rs.getString("nome_produto"));
                v1.setQuant(rs.getInt("quantidade"));
                v1.setValor_final(rs.getFloat("valor_pago"));
                v1.setDataPay(rs.getDate("data_venda"));
                v1.setHora(rs.getString("hora"));
                
                vendas.add(v1);
                
            
            }
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR  VENDAS");
            
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        return vendas;
   
    }
      
    public static void deletePedingSales(int id_venda, float valor, String user,int id_comprador, int id_produto,int quantV) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null, stmt_aux=null;// Usado para controlar o sql
        
        ResultSet rs=null, rs_aux=null;
        
      //  System.out.println(" no método de exclusão");
        
        try{
        //    System.out.println("id do comprador: "+id_comprador);
            
            stmt_aux = con.prepareStatement("select * from comprador where id="+id_comprador+"");
            
            rs_aux = stmt_aux.executeQuery();
            rs_aux.first();
            
            
            int v = rs_aux.getInt("quantVendas");
            
           // System.out.println("quantidade de vendas do comprador: "+v);
            
            if(v==1){
                
           //     System.out.println("irei deletar o comprador tbm");
           
           stmt= con.prepareStatement("select * from venda where id="+id_venda+"");
           
           rs= stmt.executeQuery();
           rs.first();
           
           int quant = rs.getInt("quant");
           
           stmt= con.prepareStatement("select * from produto where id="+id_produto+"");
           
           rs= stmt.executeQuery();
           rs.first();
           
           int quantP = rs.getInt("quant");
           
           
            stmt = con.prepareStatement("DELETE FROM venda   WHERE id="+id_venda+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
          //      System.out.println("deletado a venda");
            stmt = con.prepareStatement("DELETE FROM comprador   WHERE id="+id_comprador+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            //System.out.println("deletado o comprador\n Começando a atualização do totaL_receber");
            
            stmt = con.prepareStatement("SELECT * FROM conta where username='"+user+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            float aux = rs.getFloat("total_receber");
            aux-=valor;
            
            stmt = con.prepareStatement("UPDATE conta SET total_receber="+aux+"   WHERE username='"+user+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
           //     System.out.println("atualizado");
            
            
            
            }else{
                
            //    System.out.println("apenas a venda será deletada");
                
                
                stmt = con.prepareStatement("DELETE FROM venda   WHERE id="+id_venda+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
           //     System.out.println("deletado a venda\nComeçando  atualização do total_receber");
            
            stmt = con.prepareStatement("SELECT * FROM conta where username='"+user+"'");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            float aux= rs.getFloat("total_receber");
            
          //      System.out.println("feito a pesquisa do valor");
            aux-=valor;
            
            stmt = con.prepareStatement("UPDATE conta SET total_receber="+aux+"   WHERE username='"+user+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
          //      System.out.println("atualizado valor no banco");
            
            v--;
            stmt = con.prepareStatement("UPDATE comprador SET quantVendas="+v+"   WHERE id="+id_comprador+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            //    System.out.println("atualizado quantidade de vendas do comprador");
            
            }
            stmt = con.prepareStatement("SELECT quant FROM produto where id="+id_produto+"");// Instrução ao banco de dados
           
            rs=stmt.executeQuery();
            
            rs.first();
            float aux= rs.getFloat("quant");
            quantV+=aux;
            
            
            stmt = con.prepareStatement("UPDATE produto SET quant="+quantV+"   WHERE id="+id_produto+"");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            
            //JOptionPane.showMessageDialog(null,"DELETADO COM SUCESSO");
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"ERRO AO DELETAR");
            
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
    
    }
    
    public static List<Sale> completeSale() throws ClassNotFoundException, SQLException{
       Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        List<Sale> vendas = new ArrayList<>();

        try{
            stmt = con.prepareStatement("SELECT * FROM historicovendas  WHERE id_conta ='"+AuthFrame.pessoa.getUser()+"' order by dat_fech desc");// Instrução ao banco de dados          
            rs = stmt.executeQuery();
           // System.out.println("passei da primeira");
            
            while(rs.next()){
                Sale v1 = new Sale();
                v1.setDataPay(rs.getDate("dat_fech"));
                v1.setValor_final(rs.getFloat("valor_pago"));
               
                
                vendas.add(v1);
               }
   
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR  VENDAS");
            System.out.println(ex);
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        return vendas;
    }

}
