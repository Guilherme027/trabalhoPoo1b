package questao3.src;

import java.util.ArrayList;
import java.util.List;
import questao3.lib.InOut;

/**
 * Representa um jogador no sistema de apostas.
 */
public class Jogador {

    // Atributos
    String nome;
    String sobrenome;
    String apelido;
    String cpf;
    String nacionalidade;
    String dataNascimento;
    double saldo;
    String moeda;
    List<Aposta> apostasAtivas;

    /**
     * Construtor da classe Jogador.
     * @param nome o nome do jogador
     * @param sobrenome o sobrenome do jogador
     * @param apelido o apelido do jogador
     * @param cpf o CPF do jogador
     * @param nacionalidade a nacionalidade do jogador
     * @param dataNascimento a data de nascimento do jogador
     */
    public Jogador(String nome, String sobrenome, String apelido, String cpf, String nacionalidade, String dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.saldo = 1000.0; // saldo inicial de 1000.0
        this.moeda = "R$"; // moeda padrão é Real brasileiro
        this.apostasAtivas = new ArrayList<>(); // lista de apostas ativas
    }

    /**
     * Realiza uma aposta para este jogador em um jogo específico.
     * @param jogo o jogo em que a aposta será realizada
     * @param valorAposta o valor da aposta
     * @return true se a aposta for bem-sucedida, false caso contrário
     */
    public boolean fazerAposta(Jogo jogo, double valorAposta) {
        if (verificarAposta(jogo, valorAposta)) {
            Aposta aposta = new Aposta(0, valorAposta, jogo, this);
            apostasAtivas.add(aposta);
            saldo -= valorAposta; // deduz o valor da aposta do saldo do jogador
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cancela uma aposta.
     * @param aposta a aposta a ser cancelada
     */
    public void cancelarAposta(Aposta aposta) {
        if (apostasAtivas.contains(aposta)) {
            if (!aposta.isFinalizada()) {
                saldo += aposta.getValorAposta(); // devolve o valor da aposta ao saldo do jogador
                apostasAtivas.remove(aposta);
                InOut.MsgDeInformacao("Aposta cancelada", "Aposta de " + this.nome + " cancelada com sucesso!");
            } else {
                InOut.MsgDeAviso("Aviso", "Aposta já finalizada.");
            }
        } else {
            InOut.MsgDeAviso("Aviso", "Aposta não encontrada.");
        }
    }

    /**
     * Verifica se o jogador pode fazer uma aposta com o valor especificado.
     * @param jogo o jogo em que a aposta será feita
     * @param valorAposta o valor da aposta
     * @return true se o jogador tiver saldo suficiente e o valor da aposta estiver dentro do limite do jogo, false caso contrário
     */
    private boolean verificarAposta(Jogo jogo, double valorAposta) {
        return saldo >= valorAposta && valorAposta <= jogo.getApostaMax();
    }

    // Métodos Getters

    /**
     * Obtém o saldo atual do jogador.
     * @return o saldo do jogador
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtém a lista de apostas ativas do jogador.
     * @return a lista de apostas ativas
     */
    public List<Aposta> getApostasAtivas() {
        return apostasAtivas;
    }

    // Outros Métodos

    /**
     * Atualiza o saldo do jogador.
     * @param valor o valor a ser adicionado ao saldo
     */
    public void atualizarSaldo(double valor) {
        this.saldo += valor;
    }

    /**
     * Obtém todas as apostas do jogador.
     * @return a lista de todas as apostas do jogador
     */
    public List<Aposta> getAllApostas() {
        return apostasAtivas;
    }

    // Atributo Estático

    /**
     * Lista de todos os jogadores cadastrados no sistema.
     */
    public static List<Jogador> jogadoresCadastrados = new ArrayList<>();

    /**
     * Obtém todos os jogadores cadastrados no sistema.
     * @return um array contendo todos os jogadores cadastrados
     */
    public static Jogador[] getAllJogadores() {
        return jogadoresCadastrados.toArray(new Jogador[0]);
    }
}
