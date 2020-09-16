package br.unifil.dc.sisop;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * Write a description of class ComandoPrompt here.
 *
 * @author Ricardo Inacio Alvares e Silva
 * @version 180823
 */
public class ComandoPrompt {
    
    public ComandoPrompt(String comando) {
        // ESCREVA AQUI SEU CODIGO PARA ESTRUTURAR O COMANDO RECEBIDO DO PROMPT.
        char aux = ' ';
        String comandoFinal = "";
        int fimComando = 0;
        for (int i = 0; i < comando.length(); i++) {
            if (comando.charAt(i) == aux) {
                comandoFinal = comando.substring(0, i);
                fimComando = i;
                break;
            }else if (i == comando.length()-1){
                comandoFinal = comando;
                break;
            }

        }

        //if(comandoFinal.equals("cd") || comandoFinal.equals("ad") || comandoFinal.equals("mdt")) {
            argumentos = new String[10];
            int auxParametro = fimComando;
            int contadorParametro = 0;
            for (int i = fimComando + 1; i < comando.length(); i++) {
                if (comando.charAt(i) == aux) {
                    argumentos[contadorParametro] = comando.substring(auxParametro + 1, i).trim();
                    contadorParametro++;
                    auxParametro = i;//talvez tenha que ter incremento
                }
            }
            for (int i = 0; i < comando.length(); i++) {
                if (argumentos[i] == null) {
                    argumentos[i] = comando.substring(auxParametro + 1).trim();
                    break;
                }
            }
        //}
        nome = comandoFinal.trim();
    }
    
    /**
     * Método acessor get para o nome do comando.
     * 
     * @return o nome do comando, exatamente como foi entrado.
     */
    public String getNome() { 

        return nome;
    }
    
    /**
     * Método acessor get para os argumentos que seguram ao nome do comando.
     * 
     * @return Lista de argumentos do comando, protegida contra modificações externas.
     */
    public List<String> getArgumentos() {

        return Collections.unmodifiableList(Arrays.asList(argumentos));
    }
    
    private final String nome;
    private final String[] argumentos;
}
