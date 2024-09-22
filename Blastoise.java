public class Blastoise extends Pokemon{
    public Blastoise() {
        this.setNome("Blastoise");
        this.setVida(20);
        this.setNivel(1);
        this.setTipo("Agua");
        this.setTreinador("Treinador Desconhecido");
        this.setFraquesa("Eletrico-Planta");
        this.setVantagem("Terra-Pedra-Fogo");
    }

    public Blastoise(int vida, int nivel, String treinador) {
        this.setNome("Blastoise");
        this.setVida(vida);
        this.setNivel(nivel);
        this.setTipo("Agua");
        this.setTreinador(treinador);
        this.setFraquesa("Eletrico-Planta");
        this.setVantagem("Terra-Pedra-Fogo");
    }

    @Override
    public int Ataque(int i, boolean v) {
        if (i == 1) {
            System.out.println("Blastoise usou Derrubada");
            if (v == true) {
                i = 1 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 1;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 2) {
            System.out.println("Blastoise usou Jato de Agua");
            if (v == true) {
                i = 3 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 3;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 3) {
            System.out.println("Blastoise usou Investida");
            if (v == true) {
                i = 5 * 2;
                System.out.println("- " + i + " de vida");
            } else {
                i = 5;
                System.out.println("- " + i + " de vida");
            }
            return i;
        } else if (i == 4) {
            System.out.println("Blastoise usou Canhão de Agua");
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
