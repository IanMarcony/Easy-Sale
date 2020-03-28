package fmm.classesauxiliares;


public class Comprador {
    private String nome,id_conta,telefone;
    private int id_venda,id,qVendas;
    public Endereco end1;
    
    public Comprador(){
        end1 = new Endereco();
    }

    
    
    public int getqVendas() {
        return qVendas;
    }

    public void setqVendas(int qVendas) {
        this.qVendas = qVendas;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    

    public String getId_conta() {
        return id_conta;
    }

    public void setId_conta(String id_conta) {
        this.id_conta = id_conta;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }
    
    
}
