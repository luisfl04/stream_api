package functional_interface.implementacoes;

// Imports:
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample{

    public static void main(String[] args) {
        // Lista de nomes simples:
        List<String> nomes_simples = Arrays.asList("Acleucia", "Marinho", "Oliveira");

        // Criando o 'binary' para agrupar os nomes:
        BinaryOperator<String> agrupar_nomes = (nome_um, nome_dois) -> nome_um + " " + nome_dois; 

        // Variável que receberá o resultado:
        String nome_completo = nomes_simples.stream()
        .reduce("", agrupar_nomes);
    
        System.out.println(nome_completo);
    }
}

// Implementação utilizando classe anônima:
class OtherBinaryOperatorExample{

    public static void main(String[] args) {
        
        // Lista com números de ponto flutuante:
        List<Double> my_numbers = Arrays.asList(1.0, 1.9);
    
        // Implementado o 'binary' com classe anônima:
        BinaryOperator<Double> multiply_numbers = new BinaryOperator<Double>() {
            // Método obrigatório:
            @Override
            public Double apply(Double number_one, Double number_two){
                return number_one + number_two;
            }
        };
        
        // Lista que receberá os valores multiplicados:
        double multiplied_values = my_numbers.stream().reduce(0.0, multiply_numbers);

        // Exibindo:
        System.out.println("Multiplicação de todos os valores da lista de números de ponto flutuantes -> " + multiplied_values);
    }   

}