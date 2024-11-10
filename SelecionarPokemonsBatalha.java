import java.util.Scanner;

public class SelecionarPokemonsBatalha {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criando os treinadores
        Treinador ash = new Treinador("Palete", "Ash", "Joto", 20, 0);
        Treinador gegel = new Treinador("SilverStone", "Gegel", "Indigo", 20, 0);

        // Adicionar os pokémons aos treinadores
        ash.adicionarPokemon(escolhaPokemon(ash, scanner), 0);
        gegel.adicionarPokemon(escolhaPokemon(gegel, scanner), 0);

        BatalhaPokemon.batalhar(ash, gegel);

        scanner.close();
    }

    public static Pokemon selecionarPokemon(String pokemonEscolhido, Pikachu pikachu, Charizard charizard,
            Blastoise blastoise, Venonate venonate, Venossauro venossauro) {
        switch (pokemonEscolhido) {
            case "pikachu":
                return pikachu;
            case "charizard":
                return charizard;
            case "blastoise":
                return blastoise;
            case "venossauro":
                return venossauro;
            case "venonate":
                return venonate;
            default:
                return null;
        }
    }

    public static Pokemon escolhaPokemon(Treinador treinador, Scanner scanner) {

        String pokemonEscolhido;
        Pokemon p1;

        Pikachu pikachu = new Pikachu(50, 1, "");
        Blastoise blastoise = new Blastoise(50, 1, "");
        Charizard charizard = new Charizard(50, 1, "");
        Venonate venonate = new Venonate(50, 1, "");
        Venossauro venossauro = new Venossauro(50, 1, "");

        do {
            System.out.println(
                    treinador.getNome()
                            + ", escolha o seu Pokémon (pikachu, charizard, blastoise, venossauro, venonate):");
            pokemonEscolhido = scanner.nextLine().toLowerCase();
            p1 = selecionarPokemon(pokemonEscolhido, pikachu, charizard, blastoise, venonate, venossauro);
            if (p1 == null) {
                System.out.println("Pokémon inválido. Tente novamente.");
            }
        } while (p1 == null);
        return p1;
    }

}
