package pokemons;

public class Venossauro extends Pokemon {
    public Venossauro() {
        this.setNome("Venossauro");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Planta");
        this.setVantagem("Agua-Pedra-Terra");
    }

    public Venossauro(int vida, int nivel, String treinador) {
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
                System.out.println("Venossauro usou Fly");
                dano = temVantagem ? 2 : 1;
                break;
            case 2:
                System.out.println("Venossauro usou Bite");
                dano = temVantagem ? 6 : 3;
                break;
            case 3:
                System.out.println("Venossauro usou Fire Ball");
                dano = temVantagem ? 10 : 5;
                break;
            case 4:
                System.out.println("Venossauro usou Flame Tower");
                dano = temVantagem ? 20 : 10;
                break;
            default:
                throw new IllegalArgumentException("Ataque inválido!");
        }
        System.out.println("- " + dano + " de vida");
        return dano;
    }

}
