
package fmm.classesauxiliares;

import fmm.scenes.AuthFrame;
import fmm.scenes.CashFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;






public class Caixa {
    private Float saldo_final;
    private Date dat_fech;

    public Float getSaldo_final() {
        return saldo_final;
    }

    public void setSaldo_final(Float saldo_final) {
        this.saldo_final = saldo_final;
    }

    public String getDat_fech() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dat_fech);
    }

    public void setDat_fech(Date dat_fech) {
        this.dat_fech = dat_fech;
    }
    
    public void atualizar() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        
        
        try{
            
            GregorianCalendar dataCal = new GregorianCalendar();
            dataCal.setTime(CashFrame.hj);
            
            int mes = dataCal.get(Calendar.MONTH);
            stmt = con.prepareStatement("select sum(valor_pago) as valor  from historicovendas where id_conta='"+AuthFrame.pessoa.getUser()+"' and dat_fech like '%-"+Integer.toString(mes)+"-%'");// Instrução ao banco de dados          
            rs = stmt.executeQuery();
            rs.first();
            float valor = rs.getFloat("valor");
            System.out.println(valor);
            java.sql.Date dv = new java.sql.Date(CashFrame.hj.getTime());
            stmt = con.prepareStatement("insert into caixa(dat_fech,saldo_final,id_conta) values('"+dv+"',"+valor+",'"+AuthFrame.pessoa.getUser()+"') ");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            stmt = con.prepareStatement("update conta set data_ult='"+dv+"' where username='"+AuthFrame.pessoa.getUser()+"'");// Instrução ao banco de dados
           
            stmt.executeUpdate();
            
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERRO AO ATUALIZAR REGISTROS");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        
    }
    
    
    
    
    
    public List<Caixa> readCash() throws ClassNotFoundException, SQLException{
        Connection con = ConnectionSQL.getConnection();//Inicia a conexão
        
        PreparedStatement stmt = null;// Usado para controlar o sql
        
        ResultSet rs = null;
        
        List<Caixa> caixas = new ArrayList<>();
        
        
        try{
            
            
            stmt = con.prepareStatement("select * from caixa where id_conta='"+AuthFrame.pessoa.getUser()+"' ");// Instrução ao banco de dados
           
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Caixa prod = new Caixa();
                
                prod.setDat_fech(rs.getDate("dat_fech"));
                prod.setSaldo_final(rs.getFloat("saldo_final"));
                
                caixas.add(prod);
            
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERRO AO BUSCAR Caixa");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
        }
        return caixas;
    }
    
}
