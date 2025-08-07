abstract class Pokemon {

    private String nome;
    private String tipo;
    private String treinador;
    private String vantagem;
    private int nivel;
    private int vida;

    public Pokemon() {
        this.nome = "";
        this.tipo = "";
        this.treinador = "";
        this.vantagem = "";
        this.nivel = 1;
        this.vida = 50;
    }

    public abstract int ataque(int tipoAtaque, boolean temVantagem);

    public String getVantagem() {
        return vantagem;
    }

    public void setVantagem(String vantagem) {
        this.vantagem = vantagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}