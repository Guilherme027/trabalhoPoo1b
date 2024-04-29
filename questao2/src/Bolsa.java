package questao2.src;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Representa a bolsa de um guerreiro para guardar itens.
 */
public class Bolsa {
    private ArrayList<Item> itens = new ArrayList<>(); // Lista de itens na bolsa

    /**
     * Adiciona um item à bolsa.
     * @param item O item a ser adicionado.
     */
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    /**
     * Equipa um item da bolsa.
     * Se houver outros itens equipados, desequipa o primeiro deles.
     * @param item O item a ser equipado.
     */
    public void equipar(Item item) {
        Optional<Item> primeiroItem = itens.stream().findFirst();
        primeiroItem.ifPresent(i -> i.equipado = false);
    }
}
