import java.util.Scanner;

import batalha.BatalhaPokemon;
import modelo.Treinador;

public class Jogo {
    private final Scanner scanner;
    private final SeletorPokemon seletor;

    public Jogo(Scanner scanner) {
        this.scanner = scanner;
        this.seletor = new SeletorPokemon(scanner);
    }

    public void iniciar() {
        System.out.println("=== Bem-vindo ao Mundo Pokémon! ===");

        Treinador ash = new Treinador("Palete", "Ash", "Joto", 20, 0);
        Treinador gegel = new Treinador("SilverStone", "Gegel", "Indigo", 20, 0);

        ash.adicionarPokemon(seletor.escolherPokemon(ash), 0);
        gegel.adicionarPokemon(seletor.escolherPokemon(gegel), 0);

        BatalhaPokemon batalha = new BatalhaPokemon(ash, gegel, scanner);
        batalha.iniciar();
    }
}
