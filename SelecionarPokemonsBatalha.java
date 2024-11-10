import java.util.Scanner;

public class SelecionarPokemonsBatalha {
    public static void main(String[] args) {

        String pokemon1, pokemon2;
        Scanner scanner = new Scanner(System.in);

        // Criando os treinadores
        Treinador ash = new Treinador("Palete", "Ash", "Joto", 20, 0);
        Treinador gegel = new Treinador("SilverStone", "Gegel", "Cairo", 20, 0);

        // Criando os Pokémons
        Pikachu pikachu = new Pikachu(50, 1, ash.getNome());
        Blastoise blastoise = new Blastoise(50, 1, ash.getNome());
        Charizard charizard = new Charizard(50, 1, gegel.getNome());

        Pokemon p1 = null;
        Pokemon p2 = null;

        // Seleção para o treinador Ash
        do {
            System.out.println(ash.getNome() + ", escolha o seu Pokémon (pikachu, charizard, blastoise):");
            pokemon1 = scanner.nextLine().toLowerCase();
            p1 = selecionarPokemon(pokemon1, pikachu, charizard, blastoise);
            if (p1 == null) {
                System.out.println("Pokémon inválido. Tente novamente.");
            }
        } while (p1 == null); // Repete até selecionar um Pokémon válido

        // Seleção para o treinador Gegel
        do {
            System.out.println(gegel.getNome() + ", escolha o seu Pokémon (pikachu, charizard, blastoise):");
            pokemon2 = scanner.nextLine().toLowerCase();
            p2 = selecionarPokemon(pokemon2, pikachu, charizard, blastoise);
            if (p2 == null) {
                System.out.println("Pokémon inválido. Tente novamente.");
            }
        } while (p2 == null); // Repete até selecionar um Pokémon válido

        // Adicionar os pokémons aos treinadores
        ash.adicionarPokemon(p1, 0); // Adiciona o primeiro Pokémon ao Ash
        gegel.adicionarPokemon(p2, 0); // Adiciona o segundo Pokémon ao Gegel

        // O Ash também tem um Blastoise, e o Gegel um Charizard como segundo Pokémon
        ash.adicionarPokemon(blastoise, 1);
        gegel.adicionarPokemon(charizard, 1);

        // Iniciar a batalha
        BatalhaPokemon.batalhar(ash, gegel);

        scanner.close(); // Fechar o scanner
    }

    // Função para selecionar o Pokémon baseado no nome
    public static Pokemon selecionarPokemon(String nomePokemon, Pikachu pikachu, Charizard charizard,
            Blastoise blastoise) {
        switch (nomePokemon) {
            case "pikachu":
                return pikachu;
            case "charizard":
                return charizard;
            case "blastoise":
                return blastoise;
            default:
                return null; // Retorna null se o nome do Pokémon for inválido
        }
    }
}
