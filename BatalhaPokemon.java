import java.util.Random;
import java.util.Scanner;

public class BatalhaPokemon {

    public static void batalhar(Treinador p1, Treinador p2) {
        Scanner scanner = new Scanner(System.in);
        boolean continuarBatalha = true;
        int posicaoPokemonJogador = 0, posicaoPokemonAdversario = 0;

        while (continuarBatalha) {
            int codigoAcao = obterAcaoDoJogador(scanner, p1);
            processarAcao(p1, p2, codigoAcao, posicaoPokemonJogador, posicaoPokemonAdversario, scanner);

            if (!checarVidaPokemon(p2, posicaoPokemonAdversario)) {
                continuarBatalha = pokemonDerrotado(p1.getListaPokemons(posicaoPokemonJogador),
                        p2.getListaPokemons(posicaoPokemonAdversario));
                posicaoPokemonAdversario = mudarPokemon(p1, p2, posicaoPokemonAdversario);
            } else {
                oponenteAtaca(p1.getListaPokemons(posicaoPokemonJogador),
                        p2.getListaPokemons(posicaoPokemonAdversario));
            }
        }
        scanner.close();
    }

    private static int obterAcaoDoJogador(Scanner scanner, Treinador p1) {
        int codigoAcao = 0;
        while (codigoAcao < 1 || codigoAcao > 5) {
            System.out.println("Escolha o que " + p1.getNome() + " irá fazer: ");
            System.out.println("1 = Atacar / 2 = Mudar Pokemon / 3 = Usar item / 4 = Fugir");
            System.out.println("----------------------------------------------------------");
            codigoAcao = scanner.nextInt();
        }
        return codigoAcao;
    }

    private static boolean checarVidaPokemon(Treinador treinador, int posicaoPokemon) {
        return treinador.getListaPokemons(posicaoPokemon).getVida() > 0;
    }

    private static void fugir() {
        System.out.println("Você fugiu da batalha!");
    }

    private static void usarItem(Treinador p1, Scanner scanner) {
        System.out.println("Qual item você deseja usar?");
        System.out.println("1 - Poção Pequena: +5 de vida");
        System.out.println("2 - Poção Grande: +10 de vida");

        int nItem = 0, itemEscolhido = 0;
        nItem = scanner.nextInt();

        while (nItem < 1 || nItem > 2) {
            System.out.println("Opção inválida. Tente novamente:");
            nItem = scanner.nextInt();
        }

        switch (nItem) {
            case 1:
                itemEscolhido = 5;
                break;
            case 2:
                itemEscolhido = 10;
                break;
        }

        System.out.println("Em qual Pokémon quer usar o item?");

        for (int i = 0; i < p1.getListaPokemons().length; i++) {
            if (p1.getListaPokemons()[i] != null && p1.getListaPokemons()[i].getVida() > 0) {
                System.out.println(
                        i + " - " + p1.getListaPokemons()[i].getNome() + " - " + p1.getListaPokemons()[i].getVida());
            }
        }

        nItem = scanner.nextInt();
        while (nItem < 0 || nItem >= p1.getListaPokemons().length || p1.getListaPokemons(nItem).getVida() <= 0) {
            System.out.println("Escolha inválida. Tente novamente:");
            nItem = scanner.nextInt();
        }

        System.out.println(p1.getNome() + " usou um item no " + p1.getListaPokemons(nItem).getNome());
        System.out.println(p1.getListaPokemons(nItem).getNome() + " ganhou " + itemEscolhido + " de vida");
        p1.getListaPokemons(nItem).setVida(p1.getListaPokemons(nItem).getVida() + itemEscolhido);
    }

    private static int mudarPokemonJogador(Treinador p1, int posicaoAtual, Scanner scanner) {
        int novaPosicao;
        System.out.println("Por qual Pokémon deseja trocar: ");
        for (int i = 0; i < p1.getListaPokemons().length; i++) {
            if (p1.getListaPokemons(i) != null) {
                System.out.println(i + " - " + p1.getListaPokemons(i).getNome());
            }
        }

        do {
            System.out.print("Digite o número do Pokémon escolhido: ");
            novaPosicao = scanner.nextInt();
            if (novaPosicao < 0 || novaPosicao >= p1.getListaPokemons().length || novaPosicao == posicaoAtual
                    || p1.getListaPokemons(novaPosicao).getVida() <= 0) {
                System.out.println("Posição inválida!");
            }
        } while (novaPosicao < 0 || novaPosicao >= p1.getListaPokemons().length || novaPosicao == posicaoAtual
                || p1.getListaPokemons(novaPosicao).getVida() <= 0);

        return novaPosicao;
    }

    private static int mudarPokemon(Treinador p1, Treinador p2, int posicaoAtual) {
        for (int i = 0; i < p2.getListaPokemons().length; i++) {
            if (p2.getListaPokemons(i) != null && p2.getListaPokemons(i).getVida() > 0) {
                return i;
            }
        }
        System.out.println("O treinador " + p2.getNome() + " não possui mais Pokémons com vida.");
        System.out.println("O treinador " + p1.getNome() + " ganhou a batalha.");
        return posicaoAtual; // Alternativamente, encerre a batalha.
    }

    private static void oponenteAtaca(Pokemon p1, Pokemon p2) {
        Random random = new Random();
        int codigoAtaque = random.nextInt(4) + 1;
        p1.setVida(p1.getVida() - p2.ataque(codigoAtaque, critico(p2.getVantagem(), p2.getTipo(), p1.getTipo())));
    }

    private static boolean pokemonDerrotado(Pokemon p1, Pokemon p2) {
        if (p1.getVida() <= 0) {
            System.out.println("----------------------------------------------------------");
            System.out.println(p1.getNome() + " foi derrotado");
            System.out.println(p2.getNome() + " ganhou 10 xp");
            p2.setNivel(p2.getNivel() + 10);
            System.out.println("----------------------------------------------------------");
        } else if (p2.getVida() <= 0) {
            System.out.println("----------------------------------------------------------");
            System.out.println(p2.getNome() + " foi derrotado");
            System.out.println(p1.getNome() + " ganhou 10 xp");
            p1.setNivel(p1.getNivel() + 10);
            System.out.println("----------------------------------------------------------");
        }
        return false;
    }

    private static void ataqueJogador(Pokemon p1, Pokemon p2, Scanner scanner) {
        System.out.println("Escolha o código do ataque de " + p1.getNome() + ": ");
        int codigoAtaque = scanner.nextInt();
        System.out.println("----------------------------------------------------------");
        p2.setVida(p2.getVida() - p1.ataque(codigoAtaque, critico(p1.getVantagem(), p1.getTipo(), p2.getTipo())));
    }

    private static boolean critico(String tipos, String tipoAtacante, String fraqueza) {
        String[] vantagem = tipos.split("-");
        for (String tipo : vantagem) {
            if (tipo.equals(fraqueza)) {
                return true;
            }
        }
        return false;
    }

    private static void processarAcao(Treinador p1, Treinador p2, int codigoAcao, int posicaoPokemonJogador,
            int posicaoPokemonAdversario, Scanner scanner) {
        switch (codigoAcao) {
            case 1:
                ataqueJogador(p1.getListaPokemons(posicaoPokemonJogador), p2.getListaPokemons(posicaoPokemonAdversario),
                        scanner);
                break;
            case 2:
                posicaoPokemonJogador = mudarPokemonJogador(p1, posicaoPokemonJogador, scanner);
                break;
            case 3:
                usarItem(p1, scanner);
                break;
            case 4:
                fugir();
                break;
            default:
                System.out.println("Ação inválida! Escolha novamente.");
        }
    }
}
