public class Charizard extends Pokemon {
    public Charizard() {
        this.setNome("Charizard");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Dragão");
        this.setTreinador("Treinador Desconhecido");
        this.setFraquesa("Dragão-Gelo-Fada");
        this.setVantagem("Dragão");
    }

    public Charizard(int vida, int nivel, String treinador) {
        this.setNome("Charizard");
        this.setVida(vida);
        this.setNivel(nivel);
        this.setTipo("Dragão");
        this.setTreinador(treinador);
        this.setFraquesa("Dragão-Gelo-Fada");
        this.setVantagem("Dragão");
    }

    @Override
    public int Ataque(int i, boolean v) {
        if (i == 1) {
            System.out.println("Charizard usou Fly");
            if (v == true) {
                i = 1 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 1;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 2) {
            System.out.println("Charizard usou Bite");
            if (v == true) {
                i = 3 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 3;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 3) {
            System.out.println("Charizard usou Fire Ball");
            if (v == true) {
                i = 5 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 5;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 4) {
            System.out.println("Charizard usou Flame Tower");
            if (v == true) {
                i = 10 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 10;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i < 1 && i > 4) {
            System.err.println("Nada acontece");
        }
        return i;

    }
}
