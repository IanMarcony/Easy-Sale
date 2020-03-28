                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.classesauxiliares;

import fmm.scenes.AlterProdSaleFrame;
import fmm.scenes.AuthFrame;
import fmm.scenes.SaleFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ian Marcony
 */
public class Produto {
    private String nome,existe,id_conta;
    private int quant,id;
    private float preco;

    
    public Produto(){
    
    }


    public Produto(String nome, int quant, float preco,int id) {
        this.nome = nome;            
        this.quant = quant;        
        this.preco = preco;
        this.id=id;
    }
    public Produto(String nome, int quant, float preco) {
        this.nome = nome;            
        this.quant = quant;        
        this.preco = preco;
        
    }

    public Produto(Produto ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getId_conta() {
        return id_conta;
    }

    public void setId_conta(String id_conta) {
        this.id_conta = id_conta;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
}
