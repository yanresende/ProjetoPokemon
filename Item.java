public class Item {
    private String nome;
    private int poderDeCura;
    private boolean revive; // true se for um item de reviver

    public Item(String nome, int poderDeCura, boolean revive) {
        this.nome = nome;
        this.poderDeCura = poderDeCura;
        this.revive = revive;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getPoderDeCura() {
        return poderDeCura;
    }

    public boolean podeReviver() {
        return revive;
    }
}