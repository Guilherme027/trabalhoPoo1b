package questao3.src;

import questao3.lib.InOut;

/**
 * Classe que representa uma aposta em um jogo.
 *
 * @author [Nome do Autor]
 */
public class Aposta {

    /**
     * Fator multiplicador aplicado ao valor da aposta para calcular o prêmio em caso de vitória.
     */
    private static final double FATOR_PREMIO = 2.0;

    /**
     * Identificador único da aposta.
     */
    private int idAposta;

    /**
     * Valor da aposta realizada pelo jogador.
     */
    private double valorAposta;

    /**
     * Jogo ao qual a aposta se refere.
     */
    private Jogo jogo;

    /**
     * Jogador que realizou a aposta.
     */
    private Jogador jogador;

    /**
     * Indica se a aposta já foi finalizada (ou seja, se o resultado já foi definido).
     */
    private boolean isFinalizada;

    /**
     * Indica se o jogador venceu ou perdeu a aposta.
     */
    private boolean resultado;

    /**
     * Construtor da classe Aposta.
     *
     * @param idAposta Identificador único da aposta.
     * @param valorAposta Valor da aposta realizada pelo jogador.
     * @param jogo Jogo ao qual a aposta se refere.
     * @param jogador Jogador que realizou aposta.
     */
    public Aposta(int idAposta, double valorAposta, Jogo jogo, Jogador jogador) {
        this.idAposta = idAposta;
        this.valorAposta = valorAposta;
        this.jogo = jogo;
        this.jogador = jogador;
        this.isFinalizada = true;
        this.resultado = true;
    }

    /**
     * Calcula o prêmio da aposta.
     *
     * O prêmio é calculado multiplicando o valor da aposta pelo fator {@link FATOR_PREMIO} em caso de vitória,
     * ou zero se o jogador perder.
     */
    public void calcularPremio() {
        double premio = 2000.0;
        if (resultado) {
            premio = valorAposta * FATOR_PREMIO;
        } else {
            premio = 0.0;
        }

        InOut.MsgSemIcone("Prêmio da Aposta #" + idAposta, "Prêmio: " + premio);
    }

    /**
     * Registra o resultado da aposta (vitória ou derrota) e exibe uma mensagem informativa ao jogador.
     *
     * @param resultado Indica se o jogador venceu ou perdeu a aposta.
     */
    public void registrarResultado(boolean resultado) {
        this.isFinalizada = true;
        this.resultado = resultado;

        if (resultado) {
            InOut.MsgDeInformacao("VOCÊ GANHOU A APOSTA", "Parabéns! Você venceu esta aposta!");
        } else {
            InOut.MsgDeInformacao("VOCÊ PERDEU A APOSTA", "Infelizmente você perdeu nesta aposta.");
        }
    }

    /**
     * Verifica se a aposta já foi finalizada (ou seja, se o resultado já foi definido).
     *
     * @return True se a aposta já foi finalizada, False caso contrário.
     */
    public boolean isFinalizada() {
        return isFinalizada;
    }

    /**
     * Obtém o resultado da aposta (vitória ou derrota).
     *
     * @return True se o jogador venceu, False se perdeu.
     */
    public boolean getResultado() {
        return resultado;
    }

    /**
     * Obtém o identificador único da aposta.
     *
     * @return Identificador da aposta.
     */
    public int getIdAposta() {
        return idAposta;
    }

    /**
     * Obtém o valor da aposta.
     *
     * @return Valor da aposta.
     */
    public double getValorAposta() {
        return valorAposta;
    }

    /**
     * Obtém o jogo ao qual a aposta se refere.
     *
     * @return Objeto Jogo que representa o jogo da aposta.
     */
    public Jogo getJogo() {
        return jogo;

    }
}
