import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criando os treinadores
        Treinador ash = new Treinador("Palete", "Ash", "Joto", 20, 0);
        Treinador gegel = new Treinador("SilverStone", "Gegel", "Indigo", 20, 0);

        // Adicionar os pokémons aos treinadores
        ash.adicionarPokemon(escolhaPokemon(ash, scanner), 0);
        gegel.adicionarPokemon(escolhaPokemon(gegel, scanner), 0);

        // Iniciar a batalha
        BatalhaPokemon batalha = new BatalhaPokemon(ash, gegel, scanner);
        batalha.iniciar();

        scanner.close();
    }

    public static Pokemon escolhaPokemon(Treinador treinador, Scanner scanner) {

        String pokemonEscolhido;
        Pokemon p1;

        do {
            System.out.println(
                    treinador.getNome()
                            + ", escolha o seu Pokémon (pikachu, charizard, blastoise, venossauro, venonate):");
            pokemonEscolhido = scanner.nextLine().toLowerCase();
            p1 = selecionarPokemon(pokemonEscolhido);
            if (p1 == null) {
                System.out.println("Pokémon inválido. Tente novamente.");
            }
        } while (p1 == null);
        return p1;
    }

    public static Pokemon selecionarPokemon(String pokemonEscolhido) {
        switch (pokemonEscolhido) {
            case "pikachu":
                return new Pikachu(20, 1, "");
            case "charizard":
                return new Charizard(20, 1, "");
            case "blastoise":
                return new Blastoise(20, 1, "");
            case "venossauro":
                return new Venossauro(20, 1, "");
            case "venonate":
                return new Venonate(20, 1, "");
            default:
                break;
        }
        return null;
    }

}
