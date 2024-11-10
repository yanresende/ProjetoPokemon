public class Venonate extends Pokemon {
    public Venonate() {
        this.setNome("Venonate");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Planta");
        this.setTreinador("Treinador Desconhecido");
        this.setVantagem("Agua-Pedra-Terra");
    }

    public Venonate(int vida, int nivel, String treinador) {
        this.setNome("Venonate");
        this.setVida(vida);
        this.setNivel(nivel);
        this.setTipo("Planta");
        this.setTreinador(treinador);
        this.setVantagem("Agua-Pedra-Terra");
    }

    @Override
    public int Ataque(int i, boolean v) {
        if (i == 1) {
            System.out.println("Venonate usou Fly");
            if (v == true) {
                i = 1 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 1;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 2) {
            System.out.println("Venonate usou Bite");
            if (v == true) {
                i = 3 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 3;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 3) {
            System.out.println("Venonate usou Fire Ball");
            if (v == true) {
                i = 5 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 5;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 4) {
            System.out.println("Venonate usou Flame Tower");
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
