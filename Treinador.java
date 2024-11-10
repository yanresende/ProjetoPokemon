public class Treinador {

    private String nome;
    private int nivel;
    private String[] insignias = new String[10];
    private String cidade;
    private Pokemon[] listaPokemons;

    public Treinador() {
        this.setCidade("Cidade Desconhecida");
        this.setNivel(1);
        this.setNome("Treinador Generico");
        this.setInsignias(0, "");
        this.listaPokemons = new Pokemon[2];
    }

    public Treinador(String cidade, String nome, String insignia, int nivel, int posicao) {
        this.setCidade(cidade);
        this.setNivel(nivel);
        this.setNome(nome);
        this.setInsignias(posicao, insignia);
        this.listaPokemons = new Pokemon[2];
    }

    @Override
    public String toString() {

        return "Nome: " + nome + " nivel: " + nivel + " cidade: " + cidade + " insignias: " + insignias[0];
    }

    public Pokemon[] getListaPokemons() {
        return listaPokemons;
    }
    

    public Pokemon getListaPokemons(int posicao) {
        if (posicao >= 0 && posicao < listaPokemons.length) {
            return listaPokemons[posicao];
        } else {
            System.out.println("Posição inválida!");
            return null;
        }
    }
    

    public void setListaPokemons(Pokemon[] listaPokemons) {
        this.listaPokemons = listaPokemons;
    }

    public void adicionarPokemon(Pokemon pokemon, int posicao) {
        if (posicao >= 0 && posicao < listaPokemons.length) {
            this.listaPokemons[posicao] = pokemon;
        } else {
            System.out.println("Posição inválida!");
        }
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
