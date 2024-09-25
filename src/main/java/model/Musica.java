package model;

public class Musica {
    private int id;
    private String nome;
    private String artista;
    private String estiloMusical;
    private String duracao;
    private int anoLancamento;

    public Musica() {}

    public Musica(int id, String nome, String artista, String estiloMusical, String duracao, int anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.estiloMusical = estiloMusical;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
