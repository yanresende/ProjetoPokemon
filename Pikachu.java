public class Pikachu extends Pokemon {

    public Pikachu() {
        this.setNome("Pikachu");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Elétrico");
        this.setTreinador("Treinador Desconhecido");
        this.setFraquesa("Terra");
        this.setVantagem("Agua-Voador");
    }

    public Pikachu(int vida, int nivel, String treinador) {
        this.setNome("Pikachu");
        this.setVida(vida);
        this.setNivel(nivel);
        this.setTipo("Elétrico");
        this.setTreinador(treinador);
        this.setFraquesa("Terra");
        this.setVantagem("Agua-Voador");

    }

    @Override
    public int Ataque(int i, boolean v) {
        if (i == 1) {
            System.out.println("Pikachu usou Choque do trovão");
            if (v == true) {
                i = 1 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 1;
                System.out.println("- " + i + " de vida");
            }
            return i;

        } else if (i == 2) {
            System.out.println("Pikachu usou Ataque rapido");
            if (v == true) {
                i = 3 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 3;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 3) {
            System.out.println("Pikachu usou Calda de ferro");
            if (v == true) {
                i = 5 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 5;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 4) {
            System.out.println("Pikachu usou Bola Relampago");
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