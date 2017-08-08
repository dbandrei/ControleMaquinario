package javafxmvc.model.domain;

public class Maquinario {
    private int idMaquinario;
    private String nome;
    private String marca;
    private String ano;
    private String chassi;
    private String observacao;

    public Maquinario() {
    }

    public Maquinario(int idMaquinario, String nome, String marca, String ano, String chassi, String observacao) {
        this.idMaquinario = idMaquinario;
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.chassi = chassi;
        this.observacao = observacao;
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public int getIdMaquinario() {
        return idMaquinario;
    }

    public void setIdMaquinario(int idMaquinario) {
        this.idMaquinario = idMaquinario;
    }  
}
