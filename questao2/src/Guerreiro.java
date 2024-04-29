package questao2.src;
import questao2.lib.InOut;

/**
 * Representa um guerreiro que participa do jogo.
 */
public class Guerreiro {
    public String nomeGuerreiro; // Nome do guerreiro
    public int quantidadeVidas; // Quantidade de vidas do guerreiro
    public Bolsa bolsa = new Bolsa(); // Bolsa do guerreiro para guardar itens

    /**
     * Construtor da classe Guerreiro.
     * @param nome Nome do guerreiro.
     * @param qtdVidas Quantidade inicial de vidas do guerreiro.
     */
    public Guerreiro(String nome, int qtdVidas) {
        this.nomeGuerreiro = nome;
        this.quantidadeVidas = qtdVidas;
    }

    /**
     * Obtém o nome do guerreiro.
     * @return O nome do guerreiro.
     */
    public String obterNome() {
        return nomeGuerreiro;
    }

    /**
     * Obtém a quantidade de vidas do guerreiro.
     * @return A quantidade de vidas do guerreiro.
     */
    public int obterQuantidadeVidas() {
        return quantidadeVidas;
    }

    /**
     * Adiciona vidas ao guerreiro.
     * @param qtd A quantidade de vidas a ser adicionada.
     */
    public void adicionarVida(int qtd) {
        quantidadeVidas += qtd;
    }

    /**
     * Remove vidas do guerreiro.
     * @param qtd A quantidade de vidas a ser removida.
     * @throws Exception Se o guerreiro não tiver mais vidas.
     */
    public void perderVida(int qtd) throws Exception {
        if (verificarVida()) {
            quantidadeVidas -= qtd;
        } else {
            solicitarAjuda();
        }
    }

    /**
     * Verifica se o guerreiro ainda possui vidas.
     * @return true se o guerreiro ainda tem vidas, caso contrário, false.
     */
    private boolean verificarVida() {
        return quantidadeVidas > 0;
    }

    /**
     * Solicita ajuda ao Oráculo quando o guerreiro está prestes a morrer.
     * Se o pedido de misericórdia for bem-sucedido, o guerreiro ganha mais vidas.
     * Caso contrário, o guerreiro é derrotado.
     * @throws Exception Se houver um problema ao solicitar ajuda.
     */
    private void solicitarAjuda() throws Exception {
        InOut.MsgDeInformacao("Última Chance", "Você está prestes a morrer! Faça um pedido de misericórdia para o Oráculo.");
        String pedido = InOut.leString("Escreva seu pedido de misericórdia aqui");

        int numPalavras = (int) pedido.chars().filter(Character::isWhitespace).count() + 1;

        if (numPalavras > 5) {
            InOut.MsgDeInformacao("Sucesso!", "O Oráculo ouviu seu apelo e concedeu-lhe uma nova oportunidade! \nVocê ganhou 3 vidas.");
            quantidadeVidas += 3;
        } else {
            InOut.MsgSemIcone("Falha do Herói", "Seu pedido não convenceu o Oráculo. Você morreu.");
            Oraculo.iniciarSequenciaDerrotado();
        }
    }
}
