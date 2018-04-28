package br.ufjf.dcc192;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {

    private static ArrayList<Anfitriao> anfitrioes;
    private static ArrayList<Intercambista> intercambistas;
    private static Integer autoIncrementoAnfitriao;
    private static Integer autoIncrementoIntercambista;
    
    public static ArrayList<Anfitriao> getInstanceAnfitrioes() {
        if (anfitrioes == null) {
            anfitrioes = new ArrayList<>();
            autoIncrementoAnfitriao = 1;
            anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, "anf1", "descricaooo11", "rua ..."));
            anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, "anf22", "descricaooo222", "rua ..."));
            anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, "anf3", "descricaooo33", "rua ..."));
            anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, "anf44", "descricaooo4", "rua ..."));
            anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, "anf555", "descricaooo55", "rua ..."));
            
            anfitrioes.get(0).getPeriodosOcupados().add(new Periodo(new Date(), new Date()));
            anfitrioes.get(2).getPeriodosOcupados().add(new Periodo(new Date(), new Date()));
            anfitrioes.get(2).getPeriodosOcupados().add(new Periodo(new Date(), new Date()));
            anfitrioes.get(3).getPeriodosOcupados().add(new Periodo(new Date(), new Date()));
            anfitrioes.get(4).getPeriodosOcupados().add(new Periodo(new Date(), new Date()));
        }
        return anfitrioes;
    }
    
    public static ArrayList<Intercambista> getInstanceIntercambistas() {
        if (intercambistas == null) {
            intercambistas = new ArrayList<>();
            autoIncrementoIntercambista = 1;
            intercambistas.add(new Intercambista(autoIncrementoIntercambista++, "inter1", "descricaooo11", "inglês"));
            intercambistas.add(new Intercambista(autoIncrementoIntercambista++, "inter22", "descricaooo222", "inglês e espanhol"));
            intercambistas.add(new Intercambista(autoIncrementoIntercambista++, "inter3", "descricaooo33", "inglês"));
            intercambistas.add(new Intercambista(autoIncrementoIntercambista++, "inter44", "descricaooo4", "espanhol"));
            intercambistas.add(new Intercambista(autoIncrementoIntercambista++, "inter555", "descricaooo55", "inglês"));
            
            intercambistas.get(1).getPeriodosDeInteresse().add(new Periodo(new Date(), new Date()));
            intercambistas.get(1).getPeriodosDeInteresse().add(new Periodo(new Date(), new Date()));
            intercambistas.get(2).getPeriodosDeInteresse().add(new Periodo(new Date(), new Date()));
        }
        return intercambistas;
    }
    
    public static Intercambista getIntercambistaById(Object id) {
        getInstanceIntercambistas();
        Integer idInteger;
        
        if (id instanceof Integer) {
            idInteger = (Integer) id;
        } else if (id instanceof String) {
            idInteger = Integer.parseInt((String) id);
        } else {
            return null;
        }
        
        for (Intercambista intercambista : intercambistas) {
            if (idInteger.equals(intercambista.getId())) {
                return intercambista;
            }
        }
        return null;
    }
    
    public static Anfitriao getAnfitriaoById(Object id) {
        getInstanceAnfitrioes();
        Integer idInteger;
        
        if (id instanceof Integer) {
            idInteger = (Integer) id;
        } else if (id instanceof String) {
            idInteger = Integer.parseInt((String) id);
        } else {
            return null;
        }
        
        for (Anfitriao anfitriao : anfitrioes) {
            if (idInteger.equals(anfitriao.getId())) {
                return anfitriao;
            }
        }
        return null;
    }
    
    public static boolean criarNovoIntercambista(String nome, String descricao, String idioma) {
        getInstanceAnfitrioes();
        getInstanceIntercambistas();

        intercambistas.add(new Intercambista(autoIncrementoIntercambista++, nome, descricao, idioma));
        autoIncrementoIntercambista++;
        return true;
    }
    
    public static boolean criarNovoAnfitriao(String nome, String descricao, String localizacao) {
        getInstanceAnfitrioes();
        getInstanceIntercambistas();

        anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, nome, descricao, localizacao));
        autoIncrementoAnfitriao++;
        return true;
    }
    
    public static boolean criarPeriodoOcupado(String idAnfitriao, String periodoInicio, String periodoFinal) {
        getInstanceAnfitrioes();
        getInstanceIntercambistas();
        
        Anfitriao anfitriao = getAnfitriaoById(idAnfitriao);
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            anfitriao.getPeriodosOcupados().add(new Periodo(simpleDateFormat.parse(periodoInicio), simpleDateFormat.parse(periodoFinal)));
        } catch (ParseException | NumberFormatException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

//        anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, nome, descricao, localizacao));
//        autoIncrementoAnfitriao++;
        return true;
    }
    
    public static boolean criarPeriodoInteresse(String idIntercambista, String periodoInicio, String periodoFinal)  {
        getInstanceAnfitrioes();
        getInstanceIntercambistas();
        
        Intercambista intercambista = getIntercambistaById(idIntercambista);
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try {
            intercambista.getPeriodosDeInteresse().add(new Periodo(simpleDateFormat.parse(periodoInicio), simpleDateFormat.parse(periodoFinal)));
        } catch (ParseException | NumberFormatException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

//        anfitrioes.add(new Anfitriao(autoIncrementoAnfitriao++, nome, descricao, localizacao));
//        autoIncrementoAnfitriao++;
        return true;
    }
    
//
//    public static boolean abrirOuFecharComanda(String id) {
//        getInstanceComandas();
//        Comanda comanda = getComandaById(id);
//        
//        if (comanda != null) {
//            if (comanda.getHoraFechamento() == null) {
//                comanda.setHoraFechamento(new Date().toString());
//            } else {
//                comanda.setHoraFechamento(null);
//            }
//            return true;
//        }
//        return false;
//    }
//    
//    public static Integer adicionarItensNaComanda(String idComanda, String idItem, String quantidade) {
//        getInstanceMesas();
//        getInstanceComandas();
//        getInstanceItens();
//        
//        Comanda comanda = getComandaById(idComanda);
//        Item item = getItemById(idItem);
//        Integer quantidadeItens = Integer.parseInt(quantidade);
//        
//        if (comanda.getItens().containsKey(item)) {
//            Integer resultado = comanda.getItens().get(item) + quantidadeItens;
//            if (resultado <= 0) {
//                comanda.getItens().remove(item);
//            } else {
//                comanda.getItens().replace(item, resultado);
//            }
//        } else {
//            comanda.getItens().put(item, quantidadeItens);
//        }
//        
//        return autoIncrementoComandas++;
//    }
//    
//    public static boolean removerItensNaComanda(String idComanda, String idItem) {
//        getInstanceMesas();
//        getInstanceComandas();
//        getInstanceItens();
//        
//        Comanda comanda = getComandaById(idComanda);
//        Item item = getItemById(idItem);
//        
//        if (comanda.getItens().containsKey(item)) {
//            comanda.getItens().remove(item);
//            return true;
//        }
//        return false;
//    }
}
