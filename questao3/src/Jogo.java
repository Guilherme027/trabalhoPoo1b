package questao3.src;

/**
 * Classe que representa um jogo no qual é possível realizar apostas.
 *
 * @author [Nome do Autor]
 */
public class Jogo {

    /**
     * Descrição textual do jogo.
     */
    private String descricao;

    /**
     * Valor máximo permitido para uma aposta neste jogo.
     */
    private double apostaMax;

    /**
     * Construtor da classe Jogo.
     *
     * @param descricao Descrição textual do jogo.
     * @param apostaMax Valor máximo permitido para uma aposta neste jogo.
     */
    public Jogo(String descricao, double apostaMax) {
        this.descricao = descricao;
        this.apostaMax = apostaMax;
    }

    /**
     * Obtém a descrição textual do jogo.
     *
     * @return Descrição do jogo.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição textual do jogo.
     *
     * @param descricao Nova descrição do jogo.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o valor máximo permitido para uma aposta neste jogo.
     *
     * @return Valor máximo da aposta.
     */
    public double getApostaMax() {
        return apostaMax;
    }

    /**
     * Define o valor máximo permitido para uma aposta neste jogo.
     *
     * @param apostaMax Novo valor máximo da aposta.
     */
    public void setApostaMax(double apostaMax) {
        this.apostaMax = apostaMax;
    }
}
