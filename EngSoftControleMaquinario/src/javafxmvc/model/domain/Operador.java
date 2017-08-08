package javafxmvc.model.domain;

public class Operador {
    private int idOperador;
    private String nome;
    private String cnh;
    private String telefone;

    public Operador() {
    }

    public Operador(String nome, String cnh, String telefone) {
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(int idOperador) {
        this.idOperador = idOperador;
    }
    
}
