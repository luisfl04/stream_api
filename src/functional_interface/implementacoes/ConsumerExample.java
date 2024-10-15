package functional_interface.implementacoes;

// Imports:
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        // Criando uma lista de nomes aleatórios:
        List<String> nomes_dos_funcionarios = Arrays.asList("Augusto Silva" ,"Pedro", "Almeida", "Marinho");

        // Criando o consumer que verifica os nomes que iniciam com o caractere 'A':
            Consumer<String> nomes_que_iniciam_com_letra_a = nome_filtrado -> {
                if(nome_filtrado.startsWith("A")){
                    System.out.println(nome_filtrado);
                }
            };

        // Usando o consumer para filtrar os valores da lista:
        nomes_dos_funcionarios.forEach(nomes_que_iniciam_com_letra_a);
    }  

}

// Outra forma de implementar o 'Consumer':
class OtherConsumerExample{

    public static void main(String[] args) {
        
        // Lista de números inteiros:
        List<Integer> numeros_aleatorios = Arrays.asList(1,3,5,7,77,83,22,41);

        // Usando o consumer com uma classe anônima que sobescreve o método abstrato para filtrar os números ímpares da lista:
        Consumer<Integer> numeros_impares = new Consumer<Integer>() {
            // Sobescrevendo o método:
            @Override
            public void accept(Integer numero_testado){
                // Irei exibir somente valores impares.
                if(numero_testado % 2 == 1){
                    System.out.println(numero_testado);
                }
            }

        };

        // Imprimindo os valores com base no uso do consumer:
        for(Integer numero_testado : numeros_aleatorios){
            numeros_impares.accept(numero_testado);
        }

    }

}