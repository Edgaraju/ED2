/* *****************************************************************************
 * C�digos desenvolvidos pelos seguintes alunos
 *
 * @author Claudson Bispo Martins Santos    201410042132
 * @author Edgar Vieira Lima Neto           201410042150
 * @author Guilherme Boroni Pereira         201410042197
 * ****************************************************************************/

package ed2;

import java.io.*;

public class Ed2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException,
                                                  IOException {
        // Obt�m o momento em que o algoritmo come�ou a ser processado
        long startTime = System.currentTimeMillis();
        System.out.println("In�cio em: " + startTime);
        
        // Instancia manualmente 3 alunos
        // Aluno first = new Aluno(15, "Adalgisa", "Rua 4, 5", (short) 15, "F", "adalgisa@semcoracao.com");
        // Aluno second = new Aluno(8, "Tairone", "Rua 5, 71", (short) 37, "M", "tairone@cigano.com");
        // Aluno third = new Aluno(7, "Levy Vianna", "Rua 6, 45", (short) 14, "M", "levyvianna@volume5.com");

        // Instancia o manipulador de arquivos
        String arquivo = "data\\enem_seq.db";
        //ManipuladorSimples teste = new ManipuladorSimples(arquivo);
        ManipuladorSequencial teste = new ManipuladorSequencial(arquivo);

        // Persiste os alunos instanciados manualmente no arquivo
        // teste.addReg(first);
        // teste.addReg(second);
        // teste.addReg(third);
        
        // Instancia e persiste automaticamente 1 Milh�o de registros no arquivo
        /*Aluno novo = null;
        for (int i = 1; i <= 1000000; i++) {
            novo = new Aluno(i, String.valueOf(i), "Rua 6, 45", (short) 14, "M", "email@com");
            teste.addReg(novo);
        }*/
        
        // L� as matriculas a serem buscadas
        ManipuladorSequencial teste2 = new ManipuladorSequencial("data\\selected.db");
        int[] selected = teste2.lerSelecionados();
        
        // Realiza a busca sequencial das matriculas
        for (int i = 0; i < 1; i++) {
            Aluno a = teste.getReg(selected[i]);
            if (a != null) System.out.println(a.getMatricula() + " | " + 
                    a.getNome().substring(0,15) + " | " +
                    a.getEmail());
        }
  
        // Obt�m do arquivo os alunos que foram instanciados manualmente
        /*Aluno b = teste.getReg(8);
        if (b != null) System.out.println(b.getMatricula() + " | " + 
                                          b.getNome().substring(0,15) + " | " +
                                          b.getEmail());
        b = teste.getReg(15);
        if (b != null) System.out.println(b.getMatricula() + " | " + 
                                          b.getNome().substring(0,15) + " | " +
                                          b.getEmail());
        b = teste.getReg(7);
        if (b != null) System.out.println(b.getMatricula() + " | " + 
                                          b.getNome().substring(0,15) + " | " +
                                          b.getEmail());*/

        // Deleta do arquivo os alunos que foram instanciados manualmente
        /*Aluno del = teste.delReg(8);
        if (del != null)
            System.out.println("O aluno " + del.getNome() +
                               " (" + del.getMatricula() + ") foi removido.");
        del = teste.delReg(15);
        if (del != null)
            System.out.println("O aluno " + del.getNome() +
                               " (" + del.getMatricula() + ") foi removido.");
        del = teste.delReg(7);
        if (del != null)
            System.out.println("O aluno " + del.getNome() +
                               " (" + del.getMatricula() + ") foi removido.");*/

        // Obt�m o momento em que o algoritmo terminou de ser processado
        long endTime   = System.currentTimeMillis();
        // Calcula e imprime o tempo total de execu��o em milisegundos
        long totalTime = endTime - startTime;
        
        long sec = totalTime / 1000;
        long min = sec / 60;
        long hrs = min / 60;
        
        System.out.println("---------------------");
        System.out.println(totalTime + " ms");
        System.out.println(hrs + "h " + min + "min " + sec + "s");
    }
    
}
