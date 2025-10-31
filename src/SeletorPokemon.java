import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

import pokemons.*;
import modelo.Treinador;

public class SeletorPokemon {
    private final Scanner scanner;
    private final Map<String, Supplier<Pokemon>> catalogoPokemons;

    public SeletorPokemon(Scanner scanner) {
        this.scanner = scanner;
        this.catalogoPokemons = criarCatalogo();
    }

    public Pokemon escolherPokemon(Treinador treinador) {
        Pokemon escolhido = null;
        do {
            System.out.println(treinador.getNome() + ", escolha seu Pokémon: " + catalogoPokemons.keySet());
            String nomeEscolhido = scanner.nextLine().trim().toLowerCase();

            escolhido = criarPokemon(nomeEscolhido);

            if (escolhido == null) {
                System.out.println("Pokémon inválido. Tente novamente.\n");
            }

        } while (escolhido == null);

        return escolhido;
    }

    private Pokemon criarPokemon(String nome) {
        Supplier<Pokemon> fornecedor = catalogoPokemons.get(nome);
        return (fornecedor != null) ? fornecedor.get() : null;
    }

    private Map<String, Supplier<Pokemon>> criarCatalogo() {
        Map<String, Supplier<Pokemon>> catalogo = new HashMap<>();
        catalogo.put("pikachu", () -> new Pikachu(20, 1, ""));
        catalogo.put("charizard", () -> new Charizard(20, 1, ""));
        catalogo.put("blastoise", () -> new Blastoise(20, 1, ""));
        catalogo.put("venossauro", () -> new Venossauro(20, 1, ""));
        catalogo.put("venonate", () -> new Venonate(20, 1, ""));
        return catalogo;
    }
}
