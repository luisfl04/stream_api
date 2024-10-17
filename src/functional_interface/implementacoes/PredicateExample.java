package functional_interface.implementacoes;

// Imports:
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    
    public static void main(String[] args) {
        // Lista de valores inteiros:
        List<Integer> valores_inteiros = Arrays.asList(3,7,82,1,23);

        // Criando meu predicate que filtra os valores menores que 7:
        Predicate<Integer> menor_que_sete = valores -> valores < 7;

        // Nova lista que recebe os valores filtrados:
        List<Integer> valores_menores_que_sete = valores_inteiros.stream()
        .filter(menor_que_sete)
        .toList();
    
        // Exibição:
        valores_menores_que_sete.forEach(System.out::println);
    } 

}

// Implementação com classe anônima:
class OtherPredicateExample{

    public static void main(String[] args) {
        
        // Lista de palavras reservadas:
        List<String> palavras_reservadas = Arrays.asList("int", "String", "for", "do while", "unsigned");

        // Predicate com classe anônima:
        Predicate<String> menor_que_quatro_letras = new Predicate<String>() {
            @Override
            public boolean test(String palavra_testada){
                return palavra_testada.length() < 4;
            }
        };
    
        // Lista que receberá os valores filtrados:
        List<String> palavras_reservadas_com_menos_que_quatro_letras = palavras_reservadas.stream()
        .filter(menor_que_quatro_letras)
        .toList();
        
        // Exibindo:
        palavras_reservadas_com_menos_que_quatro_letras.forEach(System.out::println);
    }

}
