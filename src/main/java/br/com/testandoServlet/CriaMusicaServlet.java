package br.com.testandoServlet;

import model.Musica;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CriaMusicaServlet extends HttpServlet {

    static ArrayList<Musica> musicas = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String artista = request.getParameter("artista");
        String estiloMusical = request.getParameter("estiloMusical");
        String duracao = request.getParameter("duracao");
        int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));

        System.out.println(nome);
        System.out.println(artista);
        System.out.println(estiloMusical);
        System.out.println(duracao);
        System.out.println(anoLancamento);

        musicas.add(new Musica(1, nome, artista, estiloMusical, duracao, anoLancamento));

        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Música Adicionada com sucesso</h1></body></html>");
    }
}
