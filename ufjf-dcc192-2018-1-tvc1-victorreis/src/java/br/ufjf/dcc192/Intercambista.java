package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.Date;

public class Intercambista {
    private Integer id;
    private String nome;
    private String descricao;
    private String idioma;
    private ArrayList<Periodo> periodosDeInteresse;

    public Intercambista(Integer id, String nome, String descricao, String idioma) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idioma = idioma;
        this.periodosDeInteresse = new ArrayList<>();
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
    
    public ArrayList<Periodo> getPeriodosDeInteresse() {
        return periodosDeInteresse;
    }

    public void setPeriodosDeInteresse(ArrayList<Periodo> periodosDeInteresse) {
        this.periodosDeInteresse = periodosDeInteresse;
    }
    
    public boolean jaPossuiInteresse(Periodo periodo) {
        for (Periodo periodoDeInteresse : periodosDeInteresse) {
            if (periodoDeInteresse.getFinalPeriodo().before(new Date())) {
                return false;
            }
            if ((periodoDeInteresse.getInicioPeriodo().before(periodo.getInicioPeriodo())
                    && periodoDeInteresse.getFinalPeriodo().after(periodo.getInicioPeriodo()))
                    || (periodoDeInteresse.getInicioPeriodo().before(periodo.getFinalPeriodo())
                    && periodoDeInteresse.getFinalPeriodo().after(periodo.getFinalPeriodo()))) {
                return true;
            }
        }
        return false;
    }
    
}
