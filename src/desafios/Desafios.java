package desafios;       

// Imports nescessários:
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Desafios{
    /* Funcionamento da classe -> Será criada uma lista de números inteiros que será acessível à todos os métodos
     * da classe. Cada método implementa a resolução de um desafio, ao todo são 20 desafios.
    */

    // Lista de números inteiros:
    private List<Integer> lista_de_inteiros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23, 13 ,5, 2, 15);

    public static void main(String[] args) {}

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

    public double calcularMediaDosNumerosMaioresQueCinco(){
        /*Explicação do método -> Uma lista receberá os valores maiores que cinco da lista original a partir de uma filtragem. Após isso os valores serão somados
         * e divididos para se obter a média.
        */

        // Lista com valores filtrados:
        List<Integer> numeros_maiores_que_cinco = lista_de_inteiros.stream()
        .filter(maior_que_cinco -> maior_que_cinco > 5)
        .toList();

        // Obtendo a média:

            // soma dos valores:
            int soma_dos_valores = numeros_maiores_que_cinco.stream().reduce(0, (a, b) -> a + b);

            // Média:
            double media_dos_valores_maiores_que_cinco = soma_dos_valores / numeros_maiores_que_cinco.size();

        // Exibindo:
        System.out.println("Media dos valores maiores que cinco obtidos na lista -> " + media_dos_valores_maiores_que_cinco);

        return media_dos_valores_maiores_que_cinco;
    }

    public boolean verificarSeExisteNumeroMaiorQueDez(){
        /* Explicação do método -> Através do uso da função 'anyMatch()' será identificado se há valores maiores que 10 na lista. Uma 
         * mensagem será exibida conforme o resultado do teste.
        */

        // Implementação:
        boolean condicao = lista_de_inteiros.stream()
        .anyMatch(teste -> teste > 10);

        if(condicao){
            System.out.println("Há valores maiores que dez presentes na lista de números!");
        }
        else{
            System.out.println("Não há valores maiores que dez presentes.");
        }

        return condicao;
    }

    public void EncontrarSegundoMaiorNumeroDaLista(){
        /* Explicação do método -> Primeiramente será obtido o maior número da lista, para exclui-lo da mesma. Após isso, o segundo maior número
         * poderá ser encontrado.
        */

        // Criando uma cópia da lista(Lista que implementam 'Arrays.asList' não permitem remoção de valores):
        List<Integer> lista_de_inteiros_mutavel = new ArrayList<>(lista_de_inteiros);

        // Obtendo o maior número:
        Optional<Integer> maior_numero = lista_de_inteiros_mutavel.stream().max(Comparator.naturalOrder());

        // Exluindo maior número da lista:
        lista_de_inteiros_mutavel.remove(maior_numero.get());

        // Obtendo o segundo maior número:
        Optional<Integer> segundo_maior_numero = lista_de_inteiros_mutavel.stream().max(Comparator.naturalOrder());

        // Exibindo segundo maior número:
        System.out.println("Segundo maior número da lista -> " + segundo_maior_numero.get());
    }

    public int somarValoresDeTodosOsNumeros(){
        /* Explicação do método -> Será feita a iteração em todos os valores da lista e os valores serão incrementados na variável retornada. */

        // Recebendo valor
        int soma_dos_valores_da_lista = lista_de_inteiros.stream().reduce(0, (l,m) -> l + m);

        // Exibindo e retornando:
        System.out.println("O valor de todos os valores da lista é = " + soma_dos_valores_da_lista);
        return soma_dos_valores_da_lista;
    }

    public boolean verificarSeTodosElementosSaoDistintos(){
        /* Explicação do método -> Com o método 'collect()' todos os elementos serão coletados e inseridos em um 'Set', que é uma
         * estrutura de dados que não permite elementos duplicados, com isso, é feita a verificação do tamanho da lista original 
         * com o tamanho do set, para verificar se alterou ou não. Ou seja, é verificado se há valores duplicados ou não.
        */

        // Implementando:
        boolean verificacao_dos_valores_da_lista = lista_de_inteiros.stream()
        .collect(Collectors.toSet())
        .size() == lista_de_inteiros.size();

        if(verificacao_dos_valores_da_lista){
            System.out.println("Todos os valores da lista são distintos.");
        }
        else{
            System.out.println("Há valores duplicados na lista.");
        }

        return verificacao_dos_valores_da_lista;
    }   

    public List<Integer> coletarValoresImparesMultiplosDeTresOuCinco(){
        /* Explicação do método ->  Serão feitos dois filtros, o primeiro para encontrar o valores multiplos de três e de cinco, e o segundo para 
         * remover os valores pares que forem obtidos. Após isso, é exibido o resultado e retornada a lista usada para armazenar estes valores.
        */

        // Recebendo os valores multiplos de 3 e 5:
        List<Integer> numeros_multiplos_de_tres_e_cinco = lista_de_inteiros.stream().filter(numero -> numero % 3 == 0 || numero % 5 == 0).collect(Collectors.toList());

        // Filtrando novamente para remover os valores pares:
        numeros_multiplos_de_tres_e_cinco.removeIf(numero -> numero % 2 == 0);

        // Exibindo e retornando:
        System.out.println("Numeros ímpares multiplos de três e cinco:");
        for(Integer numero_atual : numeros_multiplos_de_tres_e_cinco){
            System.out.println(numero_atual + " ");
        }
    
        return numeros_multiplos_de_tres_e_cinco;
    }   

    public int encontrarSomaDoQuadradoDeTodosOsNumeros(){
        /* Explicação do método -> Primeiramente, irei obter a partir de uma lista nova o quadrado de todos os números contidos na 
         * lista original usando o método 'map()'. Após, com o método 'reduce' farei a soma de todos os quadrados e armazenarei na
         * variável que será retornada.
        */

        // Implementação:   
        List<Integer> quadrado_dos_numeros = lista_de_inteiros.stream().map(numero_atual -> numero_atual * numero_atual).collect(Collectors.toList());

        int soma_dos_quadrados = quadrado_dos_numeros.stream().reduce(0, (numero_um, numero_dois) -> numero_um + numero_dois);

        System.out.println("Soma dos valores de todos os números da lista ao quadrado -> " + soma_dos_quadrados);
    
        return soma_dos_quadrados;
    }   

    public int obterProdutoDeTodosOsNumeros(){
        /* Explicação do método -> Com o método 'reduce' é obtido o valor do produto de todos os valores da lista e esse valor é armazenado 
         * variável que é retornada. 
        */

        // Implementação:
        int produto_de_todos_os_valores = lista_de_inteiros.stream()
        .reduce(1, (a, b) -> a * b);

        System.out.println("Valores -> " + produto_de_todos_os_valores);

        return produto_de_todos_os_valores;
    }

    public List<Integer> filtrarNumerosDentroDeUmIntervalo(int ponto_de_inicio, int ponto_de_chegada){
        /* Explicação do método -> Uma nova lista recebe os valores filtrados. A filtragem é baseada em um ponto de 
         * início e um ponto de chegada que são passados por parâmetro.
        */

        // Lista que armazena os números filtrados:
        List<Integer> numeros_filtrados = lista_de_inteiros.stream()
        .filter(numero -> numero >= ponto_de_inicio && numero <= ponto_de_chegada)
        .toList();

        // Exibindo e retornando:
        if(numeros_filtrados.isEmpty()){
            System.out.println("Não há nenhum valor entre os pontos fornecidos.");
        }
        else{
            System.out.println("Numeros encontrados:");
            numeros_filtrados.forEach(System.out::println);
        }
    
        return numeros_filtrados;
    }

    public static boolean ehPrimo(int numero_passado){
        /* Explicação do método -> Essa é uma função auxiliar que ajuda a verificar se um numero é primo ou não. */

        // Implementando:
        if(numero_passado <= 1){
            return false;
        }
        else{
            for(int iteracao = 2; iteracao <= Math.sqrt(numero_passado); iteracao++){
                if(numero_passado % iteracao == 0){
                    return false;
                }
            }
        
            return true;
        }
    }

    public int encontrarMaiorNumeroPrimo(){
        /* Explicação do método ->  Com o uso do método auxiliar 'ehPrimo()', é feita a filtragem dos valores
         * primos e logo em seguida verificado qual é o maior valores entre eles usando o método 'max'.
        */

        // Obtendo o maior número primo da lista:
        int maior_numero_primo = lista_de_inteiros.stream()
        .filter(Desafios::ehPrimo)
        .max(Integer::compare)
        .orElseThrow( () -> new IllegalArgumentException("Nenhum número primo foi encontrado na lista."));

        // exibindo e retornando:
        System.out.println("O maior número primo da lista eh -> " + maior_numero_primo);
        return maior_numero_primo;
    }

    public boolean verificarSeTemNumeroNegativo(){
        /* Explicação do método -> Com o método 'anyMatch(), será verificado se algum número presente na lista é negativo. ' */

        boolean possui_negativo = lista_de_inteiros.stream()
        .anyMatch(numero -> numero < 0);

        if(possui_negativo){
            List<Integer> lista_de_negativos = lista_de_inteiros.stream()
            .filter(numero -> numero < 0)
            .toList();

            System.out.println("Numeros negativos encontrados na lista:");
            lista_de_negativos.forEach(System.out::println);
        }
        else{
            System.out.println("Não há números negativos presentes na lista!");
        }

        return possui_negativo;
    }

    public void agruparParesEImpares(){
        /* Explicação do método -> Em duas novas listas, será filtrado os valores pares e ímpares para as listas correspondentes de
         * acordo com os valores da lista principal. No fim, as listas são exibidas.
        */

        List<Integer> lista_de_numeros_pares = lista_de_inteiros.stream()
        .filter(numero -> numero % 2 == 0)
        .toList();

        List<Integer> lista_de_numeros_impares = lista_de_inteiros.stream()
        .filter(numero -> numero % 2 == 1)
        .toList();

        System.out.println("Lista de números pares:");
        for(Integer numero_atual : lista_de_numeros_pares){
            System.out.print(numero_atual + " ");
        }   

        System.out.println("\nLista de número Impares:");
        for(Integer numero_atual : lista_de_numeros_impares){
            System.out.print(numero_atual + " ");
        }
    }

    public List<Integer> obterNumerosPrimosDaLista(){
        /* Explicação do método -> A partir do método de verificação de números que está presente nesta classe 'ehPrimo(),'
         * será feita a filtragem dos números primos presentes na lista.
        */

        List<Integer> lista_de_numeros_primos = lista_de_inteiros.stream()
        .filter(Desafios::ehPrimo)
        .toList();

        if(lista_de_numeros_primos.isEmpty()){
            System.out.println("Não há nenhum número primo presente na lista original.");
        }
        else{
            System.out.println("Lista de número primos:");
            for(Integer numero_atual : lista_de_numeros_primos){
                System.out.print(numero_atual + " ");
            }
        }

        return lista_de_numeros_primos;
    }

    public boolean verificarSeTodosNumeroSaoIguais(){
        /* Explicação do método -> A partir do uso do método 'allMatch()' é verificado se todos os números da lista são iguais.
         * Isso é feito comparando todos os números com o primeiro número da lista.
        */

        boolean todos_iguais = lista_de_inteiros.stream()
        .allMatch(numero -> numero.equals(lista_de_inteiros.get(0)));

        if(todos_iguais){
            System.out.println("Todos os números da lista são iguais.");
        }
        else{
            System.out.println("Nem todos os elementos da lista são iguais.");
        }

        return todos_iguais;
    }

    public int somarDivisiveisPorTresECinco(){
        /* Explicação do método -> Uma lista receberá os números que são divisíveis por três e por cinco e 
         * logo em seguida será obtido a soma desses valores.
        */

        List<Integer> numero_divisiveis_por_tres_e_cinco = lista_de_inteiros.stream()
        .filter(numero -> numero % 3 == 0 && numero % 5 == 0)
        .toList();

        int soma_dos_numeros = numero_divisiveis_por_tres_e_cinco.stream()
        .reduce(0, (a, b) -> a + b);

        System.out.println("A soma de todos os números divisíveis por três e cinco é = " + soma_dos_numeros);
    
        return soma_dos_numeros;
    }   

}