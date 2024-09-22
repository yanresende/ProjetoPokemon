import java.util.Scanner;

public class SelecionarPokemonsBatalha {
    public static void main(String[] args) {

        String pokemon1, pokemon2;
        Scanner scanner = new Scanner(System.in);

        Treinador ash = new Treinador("Palete", "Ash", "Joto", 20, 0);
        Treinador gegel = new Treinador("SilverStone", "Gegel", "Cairo", 20, 0);

        Pikachu pikachu = new Pikachu(50, 1, ash.getNome());
        Blastoise blastoise = new Blastoise(50, 1, ash.getNome());
        Charizard charizard = new Charizard(50, 1, gegel.getNome());

        Pokemon p1 = null;
        Pokemon p2 = null;

        System.out.println("Escolha 2 pokemons para batalhar (pikachu, charizard, blastoise):");

        pokemon1 = scanner.nextLine().toLowerCase();
        pokemon2 = scanner.nextLine().toLowerCase();

        switch (pokemon1) {
            case "pikachu":
                p1 = pikachu;
                break;
            case "charizard":
                p1 = charizard;
                break;
            case "blastoise":
                p1 = blastoise;
                break;
            default:
                System.out.println("Pokémon 1 inválido");
                break;
        }

        switch (pokemon2) {
            case "pikachu":
                p2 = pikachu;
                break;
            case "charizard":
                p2 = charizard;
                break;
            case "blastoise":
                p2 = blastoise;
                break;
            default:
                System.out.println("Pokémon 2 inválido");
                break;
        }

        if (p1 != null && p2 != null) {
            BatalhaPokemon.batalhar(p1, p2);
        } else {
            System.out.println("Erro ao selecionar os Pokémons para a batalha.");
        }

        scanner.close();
    }
}
