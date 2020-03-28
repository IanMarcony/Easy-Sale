/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.AuthFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author 2aimaq20
 */
public class GraficoBarrasDAO extends JInternalFrame {
    public GraficoBarrasDAO() throws ClassNotFoundException, SQLException {
            setClosable(false);
            setIconifiable(false);//Se o frame vai poder ser minimizado.
            setResizable(false);//Pemite editar o tamanho.
        criarGrafico();     
        setSize(670,350);
        setLocation(-16,-25);
        
    
        setVisible(true);
         
    }
    public  void criarGrafico() throws ClassNotFoundException {
        Connection con=null;
        PreparedStatement stmt = null;// Usado para controlar o sql
        ChartPanel painel = null;
        ResultSet rs = null;
        try{
            DefaultCategoryDataset barra = new DefaultCategoryDataset();

             con = ConnectionSQL.getConnection();//Inicia a conexão

            
            
            stmt = con.prepareStatement("select sum(valor_pago) as valor,dat_fech as data from historicovendas where id_conta='"+AuthFrame.pessoa.getUser()+"' group by dat_fech ;");// Instrução ao banco de dados          
            rs = stmt.executeQuery();
           
            
            while(rs.next()){
                barra.setValue(rs.getFloat("valor"), rs.getDate("data"), "");             
            }
            
            
            JFreeChart grafico = ChartFactory.createBarChart3D("","Dias de Fechamento","VALOR ARRECADADO",barra,PlotOrientation.VERTICAL,true,true,false);
            painel = new ChartPanel(grafico);
            painel.setVisible(true);
            add(painel);
          
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao Acessar!!!");
        }finally{
            ConnectionSQL.closeConnection(con,stmt,rs);
            
        }
       
    }
    
    
}
