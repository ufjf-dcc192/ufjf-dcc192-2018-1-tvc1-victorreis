package br.ufjf.dcc192;

import java.util.Date;

public class Periodo {
    private Date inicioPeriodo;
    private Date finalPeriodo;

    public Periodo(Date inicioPeriodo, Date finalPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
        this.finalPeriodo = finalPeriodo;
    }

    public Date getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Date inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Date getFinalPeriodo() {
        return finalPeriodo;
    }

    public void setFinalPeriodo(Date finalPeriodo) {
        this.finalPeriodo = finalPeriodo;
    }
    
    
}
