package javafxmvc.model.domain;

public class Peca {
   private String nome;
   private String marca;
   private String descricao;

    public Peca() {
    }

    public Peca(String nome, String marca, String descricao) {
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   
}
