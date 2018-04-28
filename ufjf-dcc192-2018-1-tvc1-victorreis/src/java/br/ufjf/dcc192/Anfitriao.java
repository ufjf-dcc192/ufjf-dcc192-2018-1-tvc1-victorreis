package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.Date;

public class Anfitriao {
    private Integer id;
    private String nome;
    private String descricao;
    private String localizacao;
    private ArrayList<Periodo> periodosOcupados;

    public Anfitriao(Integer id, String nome, String descricao, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.periodosOcupados = new ArrayList<>();
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

    public ArrayList<Periodo> getPeriodosOcupados() {
        return periodosOcupados;
    }

    public void setPeriodosOcupados(ArrayList<Periodo> periodosOcupados) {
        this.periodosOcupados = periodosOcupados;
    }
    
    public boolean isOcupado(Periodo periodo) {
        for (Periodo periodoOcupado : periodosOcupados) {
            if (periodoOcupado.getFinalPeriodo().before(new Date())) {
                return false;
            }
            if ((periodoOcupado.getInicioPeriodo().before(periodo.getInicioPeriodo())
                    && periodoOcupado.getFinalPeriodo().after(periodo.getInicioPeriodo()))
                    || (periodoOcupado.getInicioPeriodo().before(periodo.getFinalPeriodo())
                    && periodoOcupado.getFinalPeriodo().after(periodo.getFinalPeriodo()))) {
                return true;
            }
        }
        return false;
    }
    
    
    
}
