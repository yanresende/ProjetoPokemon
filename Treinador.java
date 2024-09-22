public class Treinador {
    private String nome;
    private int nivel;
    private String[] insignias = new String[10];
    private String cidade;

    public Treinador() {
        this.setCidade("Cidade Desconhecida");
        this.setNivel(1);
        this.setNome("Treinador Generico");
        this.setInsignias(0, "");
    }

    public Treinador(String cidade, String nome, String insignia, int nivel, int posicao) {
        this.setCidade(cidade);
        this.setNivel(nivel);
        this.setNome(nome);
        this.setInsignias(posicao, insignia);
    }

    @Override
    public String toString() {

        return "Nome: " + nome + " nivel: " + nivel + " cidade: " + cidade + " insignias: " + insignias[0];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String[] getInsignias() {
        return insignias;
    }

    public void setInsignias(int posicao, String insignia) {
        if (posicao >= 0 && posicao < insignias.length) {
            this.insignias[posicao] = insignia;
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
