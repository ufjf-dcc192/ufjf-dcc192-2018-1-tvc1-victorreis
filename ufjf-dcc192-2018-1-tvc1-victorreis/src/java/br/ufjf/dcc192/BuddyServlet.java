package br.ufjf.dcc192;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
@WebServlet(name = "ComandaServlet", urlPatterns = {"/index.html", "/criar-anfitriao.html", "/criar-intercambista.html", "/listar-anfitrioes.html", "/listar-intercambistas.html"})
public class BuddyServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("/index.html".equals(request.getServletPath())) {
            index(request, response);
            return;
        } else if ("/criar-anfitriao.html".equals(request.getServletPath())) {
            criarAnfitriao(request, response);
            return;
        } else if ("/criar-intercambista.html".equals(request.getServletPath())) {
            criarIntercambista(request, response);
            return;
        } else if ("/listar-anfitrioes.html".equals(request.getServletPath())) {
            listarAnfitrioes(request, response);
            return;
        } else if ("/listar-intercambistas.html".equals(request.getServletPath())) {
            listarIntercambistas(request, response);
            return;
        } else if ("/criar-periodo-ocupado.html".equals(request.getServletPath())) {
            criarPeriodoOcupado(request, response);
            return;
        } else if ("/criar-periodo-interesse.html".equals(request.getServletPath())) {
            criarPeriodoInteresse(request, response);
            return;
        }
        response.sendError(404);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("titulo", "HOME");
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
        despachante.forward(request, response);
    }
    
    private void criarAnfitriao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome-anfitriao");
        String descricao = request.getParameter("descricao");
        String localizacao = request.getParameter("localizacao");
        
        // Recebendo a requisição POST, ou seja, o formulário de CADASTRO foi enviado
        if (nome != null && descricao != null && localizacao != null) {
            Persistencia.criarNovoAnfitriao(nome, "".equals(descricao) ? "-" : descricao, "".equals(localizacao) ? "-" : localizacao);
            
            // Garante que o código fora do IF não será executado
            response.sendRedirect("listar-anfitrioes.html");
            return;
        }
        
        // Recebendo a requisição GET, ou seja, o usuário digitou a URL no navegador ou usou algum link
        request.setAttribute("titulo", "Criar Anfitriao");
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/criar-anfitriao.jsp");
        despachante.forward(request, response);
    }
    
    private void criarIntercambista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome-intercambista");
        String descricao = request.getParameter("descricao");
        String idiomas = request.getParameter("idiomas");
        
        // Recebendo a requisição POST, ou seja, o formulário de CADASTRO foi enviado
        if (nome != null && descricao != null && idiomas != null) {
            Persistencia.criarNovoIntercambista(nome, "".equals(descricao) ? "-" : descricao, "".equals(idiomas) ? "-" : idiomas);
            
            // Garante que o código fora do IF não será executado
            response.sendRedirect("listar-intercambistas.html");
            return;
        }
        
        // Recebendo a requisição GET, ou seja, o usuário digitou a URL no navegador ou usou algum link
        request.setAttribute("titulo", "Criar Intercambista");
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/criar-intercambista.jsp");
        despachante.forward(request, response);
    }
    
    
    private void listarAnfitrioes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("titulo", "Listar Anfitrioes");
        request.setAttribute("anfitrioes", Persistencia.getInstanceAnfitrioes());
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/listar-anfitrioes.jsp");
        despachante.forward(request, response);
    }
    
    private void listarIntercambistas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("titulo", "Listar Intercambistas");
        request.setAttribute("intercambistas", Persistencia.getInstanceIntercambistas());
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/listar-intercambistas.jsp");
        despachante.forward(request, response);
    }
    
    private void criarPeriodoOcupado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String periodoInicio = request.getParameter("periodo-inicio");
        String periodoFinal = request.getParameter("periodo-final");
        String idAnfitriao = request.getParameter("id-anfitriao");
        
        // Recebendo a requisição POST, ou seja, o formulário de CADASTRO foi enviado
        if (periodoInicio != null && periodoFinal != null && idAnfitriao != null) {
            
//            Persistencia.criarNovoIntercambista(nome, "".equals(descricao) ? "-" : descricao, "".equals(idiomas) ? "-" : idiomas);
            
            // Garante que o código fora do IF não será executado
            response.sendRedirect("listar-intercambistas.html");
            return;
        }
        
        request.setAttribute("titulo", "Criar Periodo Ocupado");
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/criar-periodo-ocupado.jsp");
        despachante.forward(request, response);
    }
    
    private void criarPeriodoInteresse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String periodoInicio = request.getParameter("periodo-inicio");
        String periodoFinal = request.getParameter("periodo-final");
        String idIntercambista = request.getParameter("id-intercambista");
        
        // Recebendo a requisição POST, ou seja, o formulário de CADASTRO foi enviado
        if (periodoInicio != null && periodoFinal != null && idIntercambista != null) {
            
//            Persistencia.criarNovoIntercambista(nome, "".equals(descricao) ? "-" : descricao, "".equals(idiomas) ? "-" : idiomas);
            
            // Garante que o código fora do IF não será executado
            response.sendRedirect("listar-intercambistas.html");
            return;
        }
        
        request.setAttribute("titulo", "Criar Periodo Interesse");
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/criar-periodo-interesse.jsp");
        despachante.forward(request, response);
    }
//    
//    private void abrirOuFecharComanda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Persistencia.abrirOuFecharComanda(request.getParameter("id"));
//        response.sendRedirect("listar-comandas.html");
//    }
//    
//    private void listarItensCadastrados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("titulo", "Listar Itens cadastrados no sistema");
//        request.setAttribute("itens", Persistencia.getInstanceItens());
//        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/listar-itens-cadastrados.jsp");
//        despachante.forward(request, response);
//    }
//    
//    private void listarItensComanda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idComanda = request.getParameter("id-comanda");
//        String idItem = request.getParameter("item");
//        String quantidade = request.getParameter("quantidade");
//        
//        // Recebendo a requisição POST, ou seja, o formulário de CADASTRO foi enviado
//        if (idItem != null && quantidade != null && idComanda != null) {
//            if ("".equals(idItem) || "".equals(quantidade) || "".equals(idComanda) || "0".equals(quantidade)) {
//                request.setAttribute("erro", "Escrever um inteiro diferente de zero para a quantidade.");
//            } else {
//                Persistencia.adicionarItensNaComanda(idComanda, idItem, quantidade);
//            }
//        }
//        
//        String id = request.getParameter("id");
//        if (id == null || "".equals(id)) {
//            response.sendRedirect("listar-comandas.html");
//            return;
//        }
//        
//        // Recebendo a requisição GET, ou seja, o usuário digitou a URL no navegador ou usou algum link
//        request.setAttribute("titulo", "Listar Itens na Comanda");
//        request.setAttribute("comanda", Persistencia.getComandaById(request.getParameter("id")));
//        request.setAttribute("itens", Persistencia.getInstanceItens());
//        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/listar-itens-comanda.jsp");
//        despachante.forward(request, response);
//    }
//    
//    private void removerItensComanda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idComanda = request.getParameter("id");
//        String idItem = request.getParameter("id-item");
//        
//        // Recebendo a requisição GET quando o botão EXCLUIR é clicado
//        if (idItem != null && idComanda != null) {
//            if ("".equals(idItem) || "".equals(idComanda)) {
//                request.setAttribute("erro", "Erro na exclusão de itens.");
//            } else {
//                Persistencia.removerItensNaComanda(idComanda, idItem);
//            }
//        }
//        
//        String id = request.getParameter("id");
//        if (id == null || "".equals(id)) {
//            response.sendRedirect("listar-comandas.html");
//            return;
//        }
//        
//        // Recebendo a requisição GET, ou seja, o usuário digitou a URL no navegador ou usou algum link
//        request.setAttribute("titulo", "Listar Itens na Comanda");
//        request.setAttribute("comanda", Persistencia.getComandaById(request.getParameter("id")));
//        request.setAttribute("itens", Persistencia.getInstanceItens());
//        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/listar-itens-comanda.jsp");
//        despachante.forward(request, response);
//    }
}
