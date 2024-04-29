package questao3.src;

/**
 * Classe que representa um crédito de apostas.
 *
 * @author [Nome do Autor]
 */
public class Credito {

    /**
     * Saldo disponível no crédito.
     */
    private double saldo;

    /**
     * Data de validade do crédito.
     */
    private String validade;

    /**
     * Moeda em que o crédito está expresso.
     */
    private String moeda;

    /**
     * Indica se o crédito está bloqueado para uso.
     */
    private boolean bloqueado;

    /**
     * Construtor da classe Credito.
     *
     * @param saldo Saldo disponível no crédito.
     * @param validade Data de validade do crédito.
     * @param moeda Moeda em que o crédito está expresso.
     * @param bloqueado Indica se o crédito está bloqueado para uso.
     */
    public Credito(double saldo, String validade, String moeda, boolean bloqueado) {
        this.saldo = saldo;
        this.validade = validade;
        this.moeda = moeda;
        this.bloqueado = bloqueado;
    }

    /**
     * Obtém o saldo disponível no crédito.
     *
     * @return Saldo do crédito.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Define o saldo disponível no crédito.
     *
     * @param saldo Novo valor do saldo.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtém a data de validade do crédito.
     *
     * @return Data de validade do crédito.
     */
    public String getValidade() {
        return validade;
    }

    /**
     * Define a data de validade do crédito.
     *
     * @param validade Nova data de validade.
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }

    /**
     * Obtém a moeda em que o crédito está expresso.
     *
     * @return Moeda do crédito.
     */
    public String getMoeda() {
        return moeda;
    }

    /**
     * Define a moeda em que o crédito está expresso.
     *
     * @param moeda Nova moeda do crédito.
     */
    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    /**
     * Verifica se o crédito está bloqueado para uso.
     *
     * @return True se o crédito está bloqueado, False caso contrário.
     */
    public boolean isBloqueado() {
        return bloqueado;
    }

    /**
     * Define se o crédito está bloqueado para uso.
     *
     * @param bloqueado Novo estado de bloqueio do crédito.
     */
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
