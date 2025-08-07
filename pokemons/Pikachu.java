public class Pikachu extends Pokemon {

    public Pikachu() {
        super();
        this.setNome("Pikachu");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Elétrico");
        this.setVantagem("Agua-Voador");
    }

    public Pikachu(int vida, int nivel, String treinador) {
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
                System.out.println("Pikachu usou Choque do trovão");
                dano = temVantagem ? 2 : 1;
                break;
            case 2:
                System.out.println("Pikachu usou Ataque rápido");
                dano = temVantagem ? 6 : 3;
                break;
            case 3:
                System.out.println("Pikachu usou Cauda de ferro");
                dano = temVantagem ? 10 : 5;
                break;
            case 4:
                System.out.println("Pikachu usou Bola Relâmpago");
                dano = temVantagem ? 20 : 10;
                break;
            default:
                throw new IllegalArgumentException("Ataque inválido!");
        }
        System.out.println("- " + dano + " de vida");
        return dano;
    }
}