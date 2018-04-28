package br.ufjf.dcc192;

public class Anfitriao {
    private Integer id;
    private String nome;
    private String descricao;
    private String localizacao;

    public Anfitriao(Integer id, String nome, String descricao, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    
}
