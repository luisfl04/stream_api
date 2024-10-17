package functional_interface.implementacoes;

import java.util.ArrayList;
// Imports:
import java.util.Arrays;
import java.util.function.Function;
import java.util.List;

public class FunctionExample {

    public static void main(String[] args) {

        // Lista de numeros inteiros:
        List<Integer> lista_de_inteiros = Arrays.asList(2,4,6,8);

        // Criando Function que tranforma os numeros da lista em valores de ponto flutuante:
        Function<Integer, Double> inteiro_quebrado = numero_quebrado -> numero_quebrado + 0.5;
    
        // Usando a function para obter uma nova lista com os valores quebrados:
        List<Double> inteiros_quebrados = lista_de_inteiros.stream()
        .map(inteiro_quebrado)
        .toList();
    
        // Exibindo valores:
        inteiros_quebrados.forEach(System.out::println);
    }   

}

// Implementando 'Function<T,R>' com classe anônima:
class OtherFunctionExample{

    public static void main(String[] args) {
        
        // Lista de nomes aleatórios:
        List<String> nomes_de_bibliotecarias = Arrays.asList("Gilvana", "Silvana", "Allerrandra");

        // Criando a function com classe anônima:
        Function<String, String> nomes_maiusculos = new Function<String, String>() {
            // Implementando método obrigatório:
            @Override
            public String apply(String nome_em_letra_maiuscula){
                return nome_em_letra_maiuscula.toUpperCase();
            }
        };

        // Criando lista que irá receber os nomes em maiúsculo:
        List<String> lista_de_nomes_de_bibliotecarias_em_maiusculo = new ArrayList<>();
        // Adicionado valores:
        for(String nome : nomes_de_bibliotecarias){
            lista_de_nomes_de_bibliotecarias_em_maiusculo.add(nomes_maiusculos.apply(nome));
        }

        // Exibição:
        lista_de_nomes_de_bibliotecarias_em_maiusculo.forEach(System.out::println);

    }  


}