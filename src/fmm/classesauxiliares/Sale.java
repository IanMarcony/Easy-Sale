package fmm.classesauxiliares;

import java.util.Date;

/**
 *
 * @author Ian Marcony
 */
public class Sale {
    private Date dataAtual, dataPay;
    public Comprador comp;
    public Produto prod;
    private float valor_final;
    private String vendido,hora;
    private int quant,id;
    
    public Sale(){
        comp = new Comprador();
        prod = new Produto();
    }

    public Sale(Date dataAtual,  Comprador comp, Produto prod, float valor_final, int quant) {
        this.dataAtual = dataAtual;
        this.dataPay = dataAtual;
        this.comp = comp;
        this.prod = prod;
        this.valor_final = valor_final;
        this.quant = quant;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    public float getValor_final() {
        return valor_final;
    }

    public void setValor_final(float valor_final) {
        this.valor_final = valor_final;
    }

    public String getVendido() {
        return vendido;
    }

    public void setVendido(String vendido) {
        this.vendido = vendido;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public Comprador getComp() {
        return comp;
    }

    public void setComp(Comprador comp) {
        this.comp = comp;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }
    
    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Date getDataPay() {
        return dataPay;
    }

    public void setDataPay(Date dataPay) {
        this.dataPay = dataPay;
    }
    
    
}
