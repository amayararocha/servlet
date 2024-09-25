package web;

import dao.MusicaDao;
import model.Musica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MusicaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MusicaDao dao;

    public MusicaServlet() throws ClassNotFoundException, SQLException {
        super();
        this.dao = new MusicaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at:").append(request.getContextPath());

        RequestDispatcher index = request.getRequestDispatcher("index.jsp");
        try {
            request.setAttribute("musicas", dao.getAllMusica());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        index.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Musica musica = new Musica();
        musica.setNome(request.getParameter("nome"));
        musica.setArtista(request.getParameter("artista"));
        musica.setEstiloMusical(request.getParameter("estiloMusical"));
        musica.setDuracao(request.getParameter("duracao"));
        musica.setAnoLancamento(Integer.parseInt(request.getParameter("anoLancamento")));

        try {
            dao.addMusica(musica);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
