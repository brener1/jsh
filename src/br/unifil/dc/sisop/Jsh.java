package br.unifil.dc.sisop;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

/**
 * Write a description of class Jsh here.
 *
 * @author Ricardo Inacio Alvares e Silva
 * @version 180823
 */
public final class Jsh {
    
    /**
    * Funcao principal do Jsh.
    */
    public static void promptTerminal() {

        while (true) {
    		exibirPrompt();
    		ComandoPrompt comandoEntrado = lerComando();
    		executarComando(comandoEntrado);
    	}
    }

    /**
    * Escreve o prompt na saida padrao para o usuário reconhecê-lo e saber que o
    * terminal está pronto para receber o próximo comando como entrada.
    */
    public static void exibirPrompt() {

            System.out.print(System.getProperty("user.name")+"#"+" : "+System.getProperty("user.dir")+" ");


    }

    /**
    * Preenche as strings comando e parametros com a entrada do usuario do terminal.
    * A primeira palavra digitada eh sempre o nome do comando desejado. Quaisquer
    * outras palavras subsequentes sao parametros para o comando. A palavras sao
    * separadas pelo caractere de espaco ' '. A leitura de um comando eh feita ate
    * que o usuario pressione a tecla <ENTER>, ou seja, ate que seja lido o caractere
    * EOL (End Of Line).
    *
    * @return Retorna o comando e os parâmetros inseridos pelo usuário
    */
    public static ComandoPrompt lerComando() {
        Scanner input = new Scanner(System.in);
        String comando = input.nextLine();
        return new ComandoPrompt(comando);
    }

    /**
    * Recebe o comando lido e os parametros, verifica se eh um comando interno e,
    * se for, o executa.
    * 
    * Se nao for, verifica se é o nome de um programa terceiro localizado no atual 
    * diretorio de trabalho. Se for, cria um novo processo e o executa. Enquanto
    * esse processo executa, o processo do uniterm deve permanecer em espera.
    *
    * Se nao for nenhuma das situacoes anteriores, exibe uma mensagem de comando ou
    * programa desconhecido.
    */
    public static void executarComando(ComandoPrompt comando){
                switch(comando.getNome()){
                    case "encerrar":
                        System.exit(0);
                        break;
                    case "relogio":
                        ComandosInternos.exibirRelogio();
                        break;
                    case "la":
                        ComandosInternos.escreverListaArquivos(".");
                        break;
                    case "cd":
                        List<String> args = comando.getArgumentos();
                        ComandosInternos.criarNovoDiretorio(args);
                        break;
                    case "ad":
                        List<String> args2 = comando.getArgumentos();
                        ComandosInternos.apagarDiretorio(args2);
                        break;
                    case "mdt":
                        List<String> args3 = comando.getArgumentos();
                        ComandosInternos.mudarDiretorioTrabalho(args3);
                        break;
                        
                    default:
                        executarPrograma(comando);
                        break;
                }
    }

    public static void executarPrograma(ComandoPrompt comando) {
        boolean existe = false;
        File dir = new File(System.getProperty("user.dir"));
        String arqs[] = dir.list();
        for (String compare : arqs) {
            if (compare.equals(comando.getNome())){
                existe = true;
            }
        }

        if (existe){
            File executar = new File(comando.getNome());
            if(executar.canExecute()){
                try {
                    Desktop.getDesktop().open(executar);
                }
                catch(Exception e){ }
            }else{
                System.out.println("O arquivo não tem permissão para execução.");
            }
        }else{
            System.out.println("Comando não existente");
        }
    }


    /**
     * Entrada do programa. Provavelmente você não precisará modificar esse método.
     */
    public static void main(String[] args) {

        promptTerminal();
    }
    
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private Jsh() {}
}
