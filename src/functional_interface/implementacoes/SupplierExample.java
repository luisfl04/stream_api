package functional_interface.implementacoes;

// Imports:
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SupplierExample {
    
    public static void main(String[] args) {

        // Criando o supplier:
        Supplier<String> saudacao_personalizada = () -> "Oi mano!";

        // Populando uma lista a partir do valor do supplier criado:
        List<String> lista_de_saudacoes = Stream.generate(saudacao_personalizada)
        .limit(10)
        .toList();

        // Imprimindo cada elemento da lista:
        lista_de_saudacoes.forEach(System.out::println);
    }
}

// Outra implementação de supplier usando uma classe anônima:
class OtherSupplierExample{

    public static void main(String[] args) {
        // Criando o supplier com classe anônima:
        Supplier<Integer> numero_dez = new Supplier<Integer>() {
            @Override
            public Integer get(){
                return 10;
            }
        };

        // Populando uma lista com o supplier:
        List<Integer> lista_de_numeros_dez = new ArrayList<>();
        for(int valores_para_adicionar = 0; valores_para_adicionar < 10; valores_para_adicionar++){
            lista_de_numeros_dez.add(numero_dez.get());
        }

        // Exibindo valores:
        lista_de_numeros_dez.forEach(System.out::println);
    }

}