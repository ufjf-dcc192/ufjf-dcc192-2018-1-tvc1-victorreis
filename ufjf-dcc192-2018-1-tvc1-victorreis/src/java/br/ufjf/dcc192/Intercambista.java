package br.ufjf.dcc192;

public class Intercambista {
    private Integer id;
    private String nome;
    private String descricao;
    private String idioma;

    public Intercambista(Integer id, String nome, String descricao, String idioma) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idioma = idioma;
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
}
