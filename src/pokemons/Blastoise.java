package pokemons;

public class Blastoise extends Pokemon {
    public Blastoise() {
        super();
        this.setNome("Blastoise");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Agua");
        this.setVantagem("Terra-Pedra-Fogo");
    }

    public Blastoise(int vida, int nivel, String treinador) {
        this();
        this.setVida(vida);
        this.setNivel(nivel);
        this.setTreinador(treinador);
    }

    @Override
    public int ataque(int tipoAtaque, boolean temVantagem) {
        int dano;
        switch (tipoAtaque) {
            case 1:
                System.out.println("Blastoise usou Derrubada");
                dano = temVantagem ? 2 : 1;
                break;
            case 2:
                System.out.println("Blastoise usou Jato de Agua");
                dano = temVantagem ? 6 : 3;
                break;
            case 3:
                System.out.println("Blastoise usou Investida");
                dano = temVantagem ? 10 : 5;
                break;
            case 4:
                System.out.println("Blastoise usou Canhão de Agua");
                dano = temVantagem ? 20 : 10;
                break;
            default:
                throw new IllegalArgumentException("Ataque inválido!");
        }
        System.out.println("- " + dano + " de vida");
        return dano;
    }

}
