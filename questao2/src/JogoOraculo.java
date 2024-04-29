package questao2.src;

import questao2.lib.InOut;

/**
 * Classe principal que inicia o Jogo do Oráculo.
 */
public class JogoOraculo {
    public static void main(String[] args) throws Exception {
        InOut.MsgSemIcone("Bem-vindo ao Jogo do Oráculo!", "Prepare-se para uma incrível aventura!");

        // Solicita o nome do guerreiro ao jogador
        String nomeGuerreiro = InOut.leString("Digite o nome do guerreiro: ");
        
        // Cria uma instância do Guerreiro com o nome informado e zero vidas
        new Guerreiro(nomeGuerreiro, 0);
        
        // Cria uma instância do Oráculo
        Oraculo oraculo = new Oraculo();

        // Inicia da introdução do jogo
        oraculo.Introducao();

        // Enquanto o jogador não passar do primeiro nível, continua tentando
        while (oraculo.loadLevel01()) {
            InOut.MsgDeAviso("Perdeu!", "Tente novamente!");
        }

        // Quando o jogador passa do primeiro nível, exibe mensagem de vitória
        oraculo.Vencedor();
        InOut.MsgDeAviso("Parabéns!", "Você passou para o próximo nível!");

        // Enquanto o jogador não passar do segundo nível, continua tentando
        while (oraculo.loadLevel2()) {
            InOut.MsgDeAviso("Perdeu!", "Tente novamente!");
        }

        // Quando o jogador passa do segundo nível, exibe mensagem de conclusão
        InOut.MsgDeAviso("Parabéns!", "Você passou por todos os desafios! O jogo acabou.");
    }
}
