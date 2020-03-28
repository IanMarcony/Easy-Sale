/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.CashFrame;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2aimaq20
 */
public class CaixaController {
    
    
    
    public static void readTableCash() throws ClassNotFoundException, SQLException{
        DefaultTableModel modelo =  (DefaultTableModel) CashFrame.jtCash.getModel();
        
        Caixa c1 = new Caixa();
        
        for(Caixa c: c1.readCash()){
            modelo.addRow(new Object[]{
               c.getSaldo_final(),c.getDat_fech()
            });
        }

    }
    
    public static void up() throws ClassNotFoundException, SQLException{
        new Caixa().atualizar();
    }
    
}
