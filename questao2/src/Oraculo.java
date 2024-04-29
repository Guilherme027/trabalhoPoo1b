package questao2.src;

import questao2.lib.InOut;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o Oráculo no jogo.
 */
public class Oraculo {
    private String nome; // Nome do Oráculo
    private Guerreiro guerreiro; // Referência ao guerreiro do jogo

    /**
     * Método que inicia o prólogo de introdução do jogo.
     */
    public void prologoIntroducao() {
        String cabecalho = "Início da Aventura";
        InOut.MsgDeAviso(cabecalho, "Bem-vindo, aventureiro! Eu sou o Oráculo, e estou aqui para guiá-lo em sua jornada.");

        definirNome(InOut.leString("Qual é o seu nome, nobre guerreiro?"));

        InOut.MsgDeAviso(cabecalho, "É um prazer conhecê-lo, " + this.nome + ". Agora, me conte um pouco sobre você.");

        this.guerreiro = new Guerreiro(InOut.leString("Meu nome é "), 3);

        InOut.MsgDeInformacao("Informações", "Parabéns, " + this.guerreiro.obterNome() + "! Você possui " + this.guerreiro.obterQuantidadeVidas() + " vidas.");

        InOut.MsgDeAviso(this.nome, "Partiu! vamos para a primeira fase!");
    }

    /**
     * Método que carrega o primeiro nível do jogo.
     * @return true se o jogador passar de fase, false se perder.
     * @throws Exception
     */
    public boolean loadLevel01() throws Exception {
        String opcao = InOut.leString("Escolha entre Par ou Ímpar:").toUpperCase();

        while ((!opcao.equals("PAR")) && (!opcao.equals("ÍMPAR"))) {
            InOut.MsgDeErro("Erro", "Por favor, escolha entre Par ou Ímpar.");
            opcao = InOut.leString("Par ou Ímpar?").toUpperCase();
        }

        double numeroSorteado = Math.random() * 10;
        int numeroJogador = InOut.leInt("Escolha um número:");

        boolean status = ((numeroJogador + numeroSorteado) % 2 == 0 && opcao.equals("PAR")) || ((numeroJogador + numeroSorteado) % 2 != 0 && opcao.equals("ÍMPAR"));

        if (status) {
            this.guerreiro.perderVida(1);
            InOut.MsgDeInformacao("Informação", "Você perdeu 1 vida. Restam-lhe " + this.guerreiro.obterQuantidadeVidas() + " vidas.");
        }

        return status;
    }

    /**
     * Método que carrega o segundo nível do jogo.
     * @return true se o jogador passar de fase, false se perder.
     * @throws Exception
     */
    public boolean loadLevel2() throws Exception {
        InOut.MsgDeAviso(this.nome, "Parabéns, " + this.guerreiro.obterNome() + "! Você passou pelo primeiro desafio.");
        InOut.MsgDeAviso(this.nome, "O proximo desafio te deixará assombrado!!");
    
        List<String> charadas = new ArrayList<>();
        List<String> respostas = new ArrayList<>();
    
        // Adiciona as charadas e respostas
        charadas.add("O que é que é verde, pula e quando cai na água morre afogado?");
        respostas.add("PEIXE");
    
        charadas.add("O que é que quanto mais seca, mais molhada fica?");
        respostas.add("TOALHA");
    
        charadas.add("O que é, o que é: quanto mais se tira, mais aumenta?");
        respostas.add("BURACO");
    
        int numeroSorteado = (int) (Math.random() * 3);
        String resposta = InOut.leString(charadas.get(numeroSorteado));
    
        if (respostas.get(numeroSorteado).contains(resposta.toUpperCase())) {
            return false;
        }
    
        this.guerreiro.perderVida(1);
        InOut.MsgDeInformacao("Informação", "Você perdeu 1 vida. Restam-lhe " + this.guerreiro.obterQuantidadeVidas() + " vidas.");
    
        return true;
    }
    
    /**
     * Método que lida com a vitória do jogador.
     */
    public void Vencedor() {
        InOut.MsgDeAviso(this.nome, "Parabéns, " + this.guerreiro.obterNome() + "! Você se saiu muito bem até aqui.");
        InOut.MsgDeAviso(this.nome, "Como recompensa, eu lhe presenteio com uma espada lendária: a Espada do Herói.");
    
        Item espadaDoHeroi = new Item();
        espadaDoHeroi.idItem = 1;
        espadaDoHeroi.tipoItem = "Espada";
    
        InOut.MsgDeInformacao("Novo Item", "Você recebeu: Espada do Herói");
        this.guerreiro.bolsa.adicionarItem(espadaDoHeroi);
    
        Boolean resposta = InOut.MsgDeInformacao("Novo Item", "Deseja equipar este item?");
        if (resposta != null && resposta.booleanValue()) {
            this.guerreiro.bolsa.equipar(espadaDoHeroi);
        }
    
        InOut.MsgDeAviso(this.nome, "Agora, prepare-se para a próxima etapa de sua jornada!");
    }
    
    /**
     * Método estático que inicia a sequência de derrota do jogador.
     */
    public static void iniciarSequenciaDerrotado() {
        InOut.MsgDeAviso("Fim da Jornada", "Infelizmente, você não passou nos desafios. Melhor sorte na próxima vez.");
        System.exit(0);
    }

    /**
     * Método que define o nome do Oráculo.
     * @param nome o nome do Oráculo
     */
    public void definirNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o nome do Oráculo.
     * @return o nome do Oráculo
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que sorteia a quantidade de vidas do jogador.
     * @return a quantidade de vidas sorteada
     */
    public Integer sortearVidas() {
        double sorteio = Math.random();
        sorteio = 9 * (1.0 - sorteio) + 12 * sorteio;
        return (int) sorteio;
    }
}
