public class Charizard extends Pokemon {
    public Charizard() {
        this.setNome("Charizard");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Fogo");
        this.setVantagem("Dragão");
    }

    public Charizard(int vida, int nivel, String treinador) {
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
                System.out.println("Charizard usou Fly");
                dano = temVantagem ? 2 : 1;
                break;
            case 2:
                System.out.println("Charizard usou Bite");
                dano = temVantagem ? 6 : 3;
                break;
            case 3:
                System.out.println("Charizard usou Fire Ball");
                dano = temVantagem ? 10 : 5;
                break;
            case 4:
                System.out.println("Charizard usou Flame Tower");
                dano = temVantagem ? 20 : 10;
                break;
            default:
                throw new IllegalArgumentException("Ataque inválido!");
        }
        System.out.println("- " + dano + " de vida");
        return dano;
    }

}
