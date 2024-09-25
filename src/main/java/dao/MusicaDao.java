package dao;

import db.DbConnect;
import model.Musica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaDao {

    private Connection connection;

    public MusicaDao() throws ClassNotFoundException, SQLException {
        connection = DbConnect.getConnection();
    }

    public void addMusica(Musica musica) throws SQLException {
        try {
            PreparedStatement pst = connection.prepareStatement("INSERT INTO musica(nome, artista, estiloMusical, duracao, anoLancamento) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, musica.getNome());
            pst.setString(2, musica.getArtista());
            pst.setString(3, musica.getEstiloMusical());
            pst.setString(4, musica.getDuracao());
            pst.setInt(5, musica.getAnoLancamento());

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Musica> getAllMusica() throws SQLException {
        List<Musica> musicas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM musica");

            while (rs.next()) {
                Musica musica = new Musica();

                musica.setId(rs.getInt("id"));
                musica.setNome(rs.getString("nome"));
                musica.setArtista(rs.getString("artista"));
                musica.setEstiloMusical(rs.getString("estiloMusical"));
                musica.setDuracao(rs.getString("duracao"));
                musica.setAnoLancamento(rs.getInt("anoLancamento"));

                musicas.add(musica);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicas;
    }
}
