package javafxmvc.model.domain;

public class Talhao {
    private int idTalhao;
    private String descricao;

    public Talhao() {
    }

    public Talhao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdTalhao() {
        return idTalhao;
    }

    public void setIdTalhao(int idTalhao) {
        this.idTalhao = idTalhao;
    }  
}
