/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.AlterPSFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 2aimaq20
 */
public class CompradorController {
    
    public static boolean alterCompPedingSale(int id_comprador,String nome, String telefone, String bairro, String rua, String numero, String complemento){
        boolean ok=false;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            
               con = ConnectionSQL.getConnection();            
            
                stmt= con.prepareStatement("update comprador set nome='"+nome+"' , telefone='"+telefone+"' , rua='"+rua+"' , bairro='"+bairro+"' , numero='"+numero+"' , complemento='"+complemento+"' where id="+id_comprador+" ");
                   
                
                stmt.executeUpdate();
                
                AlterPSFrame.vendaA.comp.setTelefone(telefone);
                AlterPSFrame.vendaA.comp.setNome(nome); 
                AlterPSFrame.vendaA.comp.end1.setRua(rua);
                AlterPSFrame.vendaA.comp.end1.setBairro(bairro);
                AlterPSFrame.vendaA.comp.end1.setComplemento(complemento);
                AlterPSFrame.vendaA.comp.end1.setNumero(numero);
          JOptionPane.showMessageDialog(null, "Alterado!");
            ok=!ok;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionSQL.closeConnection(con, stmt);
        }
        
        return ok;
    }
    
}
