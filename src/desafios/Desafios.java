package desafios;       

// Imports nescessários:
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;


public class Desafios{
    /* Funcionamento da classe -> Será criada uma lista de números inteiros que será acessível à todos os métodos
     * da classe. Cada método implementa a resolução de um desafio, ao todo são 20 desafios.
    */

    // Lista de números inteiros:
    private List<Integer> lista_de_inteiros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

    public static void main(String[] args) {
        Desafios teste = new Desafios();
        teste.removerValoresImpares();
    }

    public void ordenarLista(){
        /* Explicação do método -> Uma nova lista de inteiros vazia será criada e receberá os valores ordenados
         * a partir da lista inicial.
        */

        // Nova lista:
        List<Integer> lista_ordenada = lista_de_inteiros.stream()
        .sorted()
        .collect(Collectors.toList());

        // Exibição de valores:
        System.out.println("Lista ordenada:");
        for(Integer numero_atual : lista_ordenada){
            System.out.print(numero_atual + " ");
        }
    }

    public void somarNumerosPares(){
        /*Explicação do método -> Uma variável recerá o valor da soma dos números pares da lista de inteiros. */

        // Lista que receberá os números pares:
        List<Integer> numeros_pares = lista_de_inteiros.stream()
        .filter(numero_par -> numero_par % 2 == 0)
        .distinct() // -> removendo elementos duplicados.
        .collect(Collectors.toList());
    
        // Fazendo a soma de todos os números pares:

            // Var que receberá valor:
            int soma_dos_valores_pares = 0;

            // Criando o 'binary' que auxiliará na soma dos valores
            BinaryOperator<Integer> somar_pares = (primeiro_valor, segundo_valor) -> primeiro_valor + segundo_valor;

            // atribuição:
            soma_dos_valores_pares = numeros_pares.stream().reduce(0, somar_pares);
            
        // Exibição do valor: 
        System.out.println("O valor da soma dos números pares da lista(Sem duplicações) é = " + soma_dos_valores_pares);
    }

    public void verificarSeTodosSaoPositivos(){
        /* explicação do método -> Uma variável booleana receberá o resultado do teste em relação ao valor de todos os números
        da lista(Se são todos positivos ou não).
        */  

        // Implementação:
        boolean teste_de_todos_os_valores = lista_de_inteiros.stream()
        .allMatch(validacao -> validacao > 0);

        // Exibição do resultado:
        if(teste_de_todos_os_valores){
            System.out.println("Todos os valores da lista são positivos.");
        }
        else{
            System.out.println("Nem todos os valores da lista possuem valores positivos.");
        }
    }

    public void removerValoresImpares(){
        /*Explicação dos métodos -> Uma nova lista será criada e receberá todos os valores da lista original(Isso foi feito para não alterar os valores da lista original).
         Em seguida, serão verificados os valores impares contidos e os mesmos serão removidos.
        */
    
        // Nova lista:
        List<Integer> copia_da_lista_de_inteiros = new ArrayList<>(lista_de_inteiros);
        
        // Obtendo os números impares: 
        List<Integer> numeros_impares = copia_da_lista_de_inteiros.stream()
        .filter(numero_impar -> numero_impar % 2 == 1)
        .collect(Collectors.toList());
    
        // Removendo valores impares:
        copia_da_lista_de_inteiros.removeAll(numeros_impares);
        
        // Exibindo lista com a remoção dos valores:
        System.out.println("Versão da lista com a remoção dos valores impares:");
        for(Integer numero_atual : copia_da_lista_de_inteiros){
            System.out.print(numero_atual + " ");
        }
    }


}