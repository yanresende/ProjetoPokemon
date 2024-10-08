import java.util.Random;
import java.util.Scanner;

public class BatalhaPokemon {

    public static void batalhar(Treinador p1, Treinador p2) {

        Scanner scanner = new Scanner(System.in);
        Boolean continuarBatalha = true;
        int codigoAtaque = 0, posiçãoPokemon = 0, posiçãoPokemon2 = 0, posiçãoPokemonTemp = 0;

        System.out.println(p1.getListaPokemons(posiçãoPokemon).getNome() + " está batalhando contra "
                + p2.getListaPokemons(posiçãoPokemon).getNome());
        System.out.println("----------------------------------------------------------");

        while (continuarBatalha) {

            AtaqueJogador(p1.getListaPokemons(posiçãoPokemon), p2.getListaPokemons(
                    posiçãoPokemon2), codigoAtaque, continuarBatalha,
                    scanner);

            if (p2.getListaPokemons(posiçãoPokemon2).getVida() <= 0) {

                continuarBatalha = PokemonDerrotado(continuarBatalha, p1.getListaPokemons(
                        posiçãoPokemon), p2.getListaPokemons(posiçãoPokemon2));
                posiçãoPokemonTemp = posiçãoPokemon2;
                posiçãoPokemon2 = MudarPokemon(p2, posiçãoPokemon2);
                if (posiçãoPokemonTemp != posiçãoPokemon2) {
                    continuarBatalha = true;
                }

            } else {
                System.out.println("Vida de " + p2.getListaPokemons(
                        posiçãoPokemon2).getNome() + ": " + p2.getListaPokemons(posiçãoPokemon2).getVida());
                System.out.println("----------------------------------------------------------");

                OponenteAtaca(p1.getListaPokemons(
                        posiçãoPokemon), p2.getListaPokemons(posiçãoPokemon2), codigoAtaque, continuarBatalha);

                if (p1.getListaPokemons(posiçãoPokemon).getVida() <= 0) {
                    continuarBatalha = PokemonDerrotado(continuarBatalha, p1.getListaPokemons(
                            posiçãoPokemon),
                            p2
                                    .getListaPokemons(posiçãoPokemon2));

                } else {
                    System.out.println(
                            "Vida de " + p1.getListaPokemons(posiçãoPokemon).getNome() + ": " + p1.getListaPokemons(
                                    posiçãoPokemon).getVida());
                    System.out.println("----------------------------------------------------------");
                }
            }
        }
        scanner.close();
    }

    private static int MudarPokemon(Treinador p2, int posiçãoPokemon) {
        if (p2.getListaPokemons(posiçãoPokemon++).getNome() != null) {
            return posiçãoPokemon++;
        } else {
            return posiçãoPokemon;
        }
    }

    private static void OponenteAtaca(Pokemon p1, Pokemon p2, int codigoAtaque, Boolean continuarBatalha) {
        Random random = new Random();
        codigoAtaque = random.nextInt(4) + 1;
        p1.setVida(p1.getVida() - p2.Ataque(codigoAtaque, (Critico(p2.getVantagem(), p2.getTipo(), p1.getTipo()))));
    }

    private static Boolean PokemonDerrotado(Boolean continuarBatalha, Pokemon p1, Pokemon p2) {

        if (p1.getVida() <= 0) {
            System.out.println("----------------------------------------------------------");
            System.out.println(p1.getNome() + " foi derrotado");
            System.out.println(p2.getNome() + " ganhou 10 xp");
            System.out.println("----------------------------------------------------------");
            p2.setNivel(p2.getNivel() + 10);
        }
        if (p2.getVida() <= 0) {
            System.out.println("----------------------------------------------------------");
            System.out.println(p2.getNome() + " foi derrotado");
            System.out.println(p1.getNome() + " ganhou 10 xp");
            System.out.println("----------------------------------------------------------");
            p1.setNivel(p1.getNivel() + 10);
        }
        continuarBatalha = false;
        return continuarBatalha;
    }

    private static void AtaqueJogador(Pokemon p1, Pokemon p2, int codigoAtaque, Boolean continuarBatalha,
            Scanner scanner) {
        System.out.println("Escolha o código do ataque de " + p1.getNome() + ": ");
        codigoAtaque = scanner.nextInt();
        System.out.println("----------------------------------------------------------");
        p2.setVida(p2.getVida() - p1.Ataque(codigoAtaque, (Critico(p1.getVantagem(), p1.getTipo(), p2.getTipo()))));
    }

    public static boolean Critico(String tipos, String tipoAtacante, String fraquesa) {
        String[] vantagem = tipos.split("-");
        for (String tipo : vantagem) {
            if (tipo.equals(fraquesa)) {
                System.out.println("Pokemon adversario tem fraquesa contra tipo " + tipoAtacante);
                return true;
            }
        }
        return false;
    }
}
