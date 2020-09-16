package br.unifil.dc.sisop;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Write a description of class ComandosInternos here.
 *
 * @author Ricardo Inacio Alvares e Silva
 * @version 180823
 */
public final class ComandosInternos {
    
    public static void exibirRelogio() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        //throw new RuntimeException("Método ainda não implementado");
    }
    
    public static void escreverListaArquivos(String diretorio) {
        String dirAtual = System.getProperty("user.dir");
        File dir = new File(System.getProperty("user.dir"));
        String arqs[] = dir.list();
        for (int i = 0; i < arqs.length; i++) {
            System.out.println(arqs[i]);
        }
        //throw new RuntimeException("Método ainda não implementado");
    }

    public static void criarNovoDiretorio(List<String> args) {
        File teste = new File(args.get(0));
        if(teste.exists()) {
            System.out.println("Já existe um arquivo/diretório com este nome.");
        } else{
            new File(args.get(0)).mkdir();
        }
        //throw new RuntimeException("Método ainda não implementado");
    }
    
    public static void apagarDiretorio(List<String> args) {
        File teste = new File(args.get(0));
        if(teste.exists()) {
            new File(args.get(0)).delete();
        }else{
            System.out.println("O arquivo/diretório a ser deletado não existe.");
        }

        //throw new RuntimeException("Método ainda não implementado");
    }
    
    public static void mudarDiretorioTrabalho(List<String> args){
        File diretorio = new File(args.get(0));
        if(diretorio.exists()){
            System.setProperty("user.dir", diretorio.getAbsolutePath());
            System.out.println("Diretório alterado");
        }else{
            System.out.println("Diretório não existe");
        }
        //throw new RuntimeException("Método ainda não implementado");
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
