
    import java.util.Scanner;

    public class Class {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite a string a ser invertida: ");
            String original = sc.nextLine();

            // Convertendo a string para um array de caracteres
            char[] array = original.toCharArray();

            // Invertendo os caracteres do array
            for (int i = 0, j = array.length - 1; i < j; i++, j--) {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

            // Convertendo o array de volta para uma string
            String invertida = new String(array);

            System.out.println("A string invertida é: " + invertida);
        }

    }

