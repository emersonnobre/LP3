import java.util.Scanner;
class Example_1 {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int num, den;
        float res;
        
        System.out.println("Insira o numerador: ");
        num = sc.nextInt();
        System.out.println("Insira o denominador: ");
        den = sc.nextInt();

        //trata as exceções do código.
        try {
            res = num / den;
            System.out.println("O valor da divisao eh: " + res);
        } catch (Exception e) {
            System.out.println("Erro ao dividir.");
        } finally {
            System.out.println("Finalizando o programa...");
        }
    }
}