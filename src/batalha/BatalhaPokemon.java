package batalha;
import java.util.Random;
import java.util.Scanner;

import pokemons.Pokemon;
import modelo.Acao;
import modelo.Treinador;

public class BatalhaPokemon {

    private Treinador jogador;
    private Pokemon pokemonAtualJogador;
    private Treinador adversario;
    private Pokemon pokemonAtualAdversario;
    private Scanner scanner;
    private int posicaoPokemonJogador;
    private int posicaoPokemonAdversario;

    public BatalhaPokemon(Treinador j1, Treinador j2, Scanner sc) {
        this.jogador = j1;
        this.adversario = j2;
        this.scanner = sc;
        this.posicaoPokemonJogador = 0;
        this.posicaoPokemonAdversario = 0;
        this.pokemonAtualJogador = this.jogador.getListaPokemons(this.posicaoPokemonJogador);
        this.pokemonAtualAdversario = this.adversario.getListaPokemons(this.posicaoPokemonAdversario);
    }

    public void iniciar() {
        System.out.println("Batalha iniciada entre " + jogador.getNome() + " e " + adversario.getNome());
        System.out.println("----------------------------------------------------------");
        System.out.println(
                jogador.getNome() + " escolheu: " + jogador.getListaPokemons(posicaoPokemonJogador).getNome());
        System.out.println(
                adversario.getNome() + " escolheu: " + adversario.getListaPokemons(posicaoPokemonAdversario).getNome());
        System.out.println("----------------------------------------------------------");

        while (true) {

            // --- TURNO DO JOGADOR ---
            turnoDoJogador();

            if (this.pokemonAtualAdversario.getVida() <= 0) {
                processarPokemonDerrotado(this.pokemonAtualAdversario, this.pokemonAtualJogador);

                // 2. Se foi derrotado, o treinador adversário ainda tem outros para lutar?
                if (!adversarioAindaTemPokemons()) {
                    break; // Não, a batalha acabou.
                } else {
                    mudarPokemonAdversario(); // Sim, então ele é forçado a trocar.
                }
            }

            // --- TURNO DO ADVERSÁRIO ---
            turnoDoAdversario();

            if (this.pokemonAtualJogador.getVida() <= 0) {
                processarPokemonDerrotado(this.pokemonAtualJogador, this.pokemonAtualAdversario);

                // 2. Se foi derrotado, você ainda tem outros para lutar?
                if (!jogadorAindaTemPokemons()) {
                    break; // Não, a batalha acabou.
                } else {
                    System.out.println("Você precisa trocar seu Pokémon!");
                    mudarPokemonJogador(); // Sim, então você é forçado a trocar.
                }
            }
        }

        // Anunciar vencedor
        if (jogadorAindaTemPokemons()) {
            System.out.println(jogador.getNome() + " venceu a batalha!");
        } else if (adversarioAindaTemPokemons()) {
            System.out.println(adversario.getNome() + " venceu a batalha!");
        } else {
            System.out.println("A batalha terminou em empate!");
        }
    }

    // Turno do jogador
    private void turnoDoJogador() {
        System.out.println("\n--- Vez de " + this.jogador.getNome() + " ---");
        Acao acaoEscolhida = obterAcaoDoJogador();
        processarAcao(acaoEscolhida);
    }

    // Turno do adversário
    private void turnoDoAdversario() {
        System.out.println("\n--- Vez de " + this.adversario.getNome() + " ---");
        // IA Simples: sempre atacar
        oponenteAtaca();
    }

    // Obtém a ação do jogador
    private Acao obterAcaoDoJogador() {
        int escolha;
        while (true) { // Loop infinito que será quebrado por um 'return'
            System.out.println("Escolha o que " + jogador.getNome() + " irá fazer: ");
            System.out.println("1 = Atacar / 2 = Mudar Pokemon / 3 = Usar item / 4 = Fugir");
            System.out.println("----------------------------------------------------------");
            escolha = this.scanner.nextInt();

            if (escolha >= 1 && escolha <= 4) {
                switch (escolha) {
                    case 1:
                        return Acao.ATACAR;
                    case 2:
                        return Acao.MUDAR_POKEMON;
                    case 3:
                        return Acao.USAR_ITEM;
                    case 4:
                        return Acao.FUGIR;
                }
            }

            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // Ataque do jogador
    private void ataqueJogador() {
        System.out.println("Escolha o código do ataque de " + jogador.getNome() + ": ");
        int codigoAtaque = scanner.nextInt();
        System.out.println("----------------------------------------------------------");
        pokemonAtualAdversario.setVida(pokemonAtualAdversario.getVida() - pokemonAtualJogador.ataque(codigoAtaque,
                critico(pokemonAtualJogador.getVantagem(), pokemonAtualJogador.getTipo(),
                        pokemonAtualAdversario.getTipo())));
    }

    // Ataque oponente
    private void oponenteAtaca() {
        Random random = new Random();
        int codigoAtaque = random.nextInt(4) + 1;
        pokemonAtualJogador.setVida(pokemonAtualJogador.getVida() - pokemonAtualAdversario.ataque(codigoAtaque,
                critico(pokemonAtualAdversario.getVantagem(), pokemonAtualAdversario.getTipo(),
                        pokemonAtualJogador.getTipo())));
    }

    // Verifica fraqueza
    private boolean critico(String tipos, String tipoAtacante, String fraqueza) {
        String[] vantagem = tipos.split("-");
        for (String tipo : vantagem) {
            if (tipo.equals(fraqueza)) {
                return true;
            }
        }
        return false;
    }

    private void processarAcao(Acao acaoEscolhida) {
        switch (acaoEscolhida) {
            case ATACAR:
                ataqueJogador();
                break;
            case MUDAR_POKEMON:
                mudarPokemonJogador();
                break;
            case USAR_ITEM:
                usarItem();
                break;
            case FUGIR:
                fugir();
                break;
            case INVALIDA:
                System.out.println("Ação inválida! Tente novamente.");
                break;
        }
    }

    // NOVO MÉTODO PARA PROCESSAR O RESULTADO
    private void processarPokemonDerrotado(Pokemon derrotado, Pokemon vencedor) {
        System.out.println("----------------------------------------------------------");
        System.out.println(derrotado.getNome() + " foi derrotado!");
        System.out.println(vencedor.getNome() + " ganhou 10 xp!");
        vencedor.setNivel(vencedor.getNivel() + 10);
        System.out.println("----------------------------------------------------------");
    }

    private boolean jogadorAindaTemPokemons() {
        for (Pokemon pokemon : jogador.getListaPokemons()) {
            if (pokemon != null && pokemon.getVida() > 0) {
                return true;
            }
        }
        System.out.println(jogador.getNome() + " não possui mais Pokémons com vida.");
        return false;
    }

    private boolean adversarioAindaTemPokemons() {
        for (Pokemon pokemon : adversario.getListaPokemons()) {
            if (pokemon != null && pokemon.getVida() > 0) {
                return true;
            }
        }
        System.out.println(adversario.getNome() + " não possui mais Pokémons com vida.");
        return false;
    }

    private void fugir() {
        System.out.println("Você fugiu da batalha!");
    }

    private void usarItem() {
        System.out.println("Qual item você deseja usar?");
        System.out.println("1 - Poção Pequena: +5 de vida");
        System.out.println("2 - Poção Grande: +10 de vida");
        System.out.println("3 - Reviver: Revive o Pokemon com 30 de vida");

        int nItem = 0, itemEscolhido = 0;
        nItem = scanner.nextInt();

        while (nItem < 1 || nItem > 3) {
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
            case 3:
                itemEscolhido = 30;
        }

        System.out.println("Em qual Pokémon quer usar o item?");
        if (itemEscolhido == 1 || itemEscolhido == 2) {
            for (int i = 0; i < jogador.getListaPokemons().length; i++) {
                if (jogador.getListaPokemons()[i] != null && jogador.getListaPokemons()[i].getVida() > 0) {
                    System.out.println(
                            i + " - " + jogador.getListaPokemons()[i].getNome() + " - "
                                    + jogador.getListaPokemons()[i].getVida());
                }
            }

            nItem = scanner.nextInt();
            while (nItem < 0 || nItem >= jogador.getListaPokemons().length
                    || jogador.getListaPokemons(nItem).getVida() <= 0) {
                System.out.println("Escolha inválida. Tente novamente:");
                nItem = scanner.nextInt();
            }
        } else {
            for (int i = 0; i < jogador.getListaPokemons().length; i++) {
                if (jogador.getListaPokemons()[i] != null && jogador.getListaPokemons()[i].getVida() <= 0) {
                    System.out.println(
                            i + " - " + jogador.getListaPokemons()[i].getNome());
                }
            }

            nItem = scanner.nextInt();
            while (nItem < 0 || nItem >= jogador.getListaPokemons().length
                    || jogador.getListaPokemons(nItem).getVida() > 0) {
                System.out.println("Escolha inválida. Tente novamente:");
                nItem = scanner.nextInt();
            }
        }

        System.out.println(jogador.getNome() + " usou um item no " + jogador.getListaPokemons(nItem).getNome());
        System.out.println(jogador.getListaPokemons(nItem).getNome() + " ganhou " + itemEscolhido + " de vida");
        jogador.getListaPokemons(nItem).setVida(jogador.getListaPokemons(nItem).getVida() + itemEscolhido);
    }

    private void mudarPokemonJogador() {
        int novaPosicao;
        System.out.println("Por qual Pokémon deseja trocar: ");
        for (int i = 0; i < jogador.getListaPokemons().length; i++) {
            if (jogador.getListaPokemons(i) != null) {
                System.out.println(i + " - " + jogador.getListaPokemons(i).getNome());
            }
        }

        do {
            System.out.print("Digite o número do Pokémon escolhido: ");
            novaPosicao = scanner.nextInt();
            if (novaPosicao < 0 || novaPosicao >= jogador.getListaPokemons().length
                    || novaPosicao == posicaoPokemonJogador
                    || jogador.getListaPokemons(novaPosicao).getVida() <= 0) {
                System.out.println("Posição inválida!");
            }
        } while (novaPosicao < 0 || novaPosicao >= jogador.getListaPokemons().length
                || novaPosicao == posicaoPokemonJogador
                || jogador.getListaPokemons(novaPosicao).getVida() <= 0);

        posicaoPokemonJogador = novaPosicao;
        this.pokemonAtualJogador = this.jogador.getListaPokemons(this.posicaoPokemonJogador);
        System.out.println(this.jogador.getNome() + " trocou para " + this.pokemonAtualJogador.getNome() + "!");
    }

    // Muda o Pokémon do adversário
    private void mudarPokemonAdversario() {

        for (int i = 0; i < adversario.getListaPokemons().length; i++) {
            if (adversario.getListaPokemons(i) != null && adversario.getListaPokemons(i).getVida() > 0) {

                // 1. ATUALIZA A POSIÇÃO
                posicaoPokemonAdversario = i;

                // 2. ATUALIZA A REFERÊNCIA DO POKÉMON ATUAL
                pokemonAtualAdversario = adversario.getListaPokemons(i);

                System.out.println(
                        adversario.getNome() + " trocou para " + pokemonAtualAdversario.getNome() + "!");
                return; // Sai do método assim que a troca for feita
            }
        }
    }

}