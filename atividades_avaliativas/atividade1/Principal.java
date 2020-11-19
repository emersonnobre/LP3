import java.util.Scanner;
import java.sql.ResultSet;
public class Principal {
    public static void main (String[] args){
        Conecta_banco cb = new Conecta_banco();
        Method met = new Method();
        Scanner sc = new Scanner(System.in);
        ResultSet rs;
        int resp;

        do {
            System.out.println("\n----- MENU -----\n");
            System.out.println("1 - Cadastrar um novo doce\n2 - Atualizar ingrediente\n3 - Atualizar carga de uma modalidade\n4 - Remover ingrediente\n5 - Sair\n");
            System.out.println("Resposta: ");
            resp = sc.nextInt();

            if (resp == 1) {
                met.cadastrarAlimento();
            }
            else if (resp == 2) {
                met.atualizarIngrediente();
            }
            else if (resp == 3) {
                met.atualizarCarga();
            }
            else if (resp == 4) {
                met.removerIngrediente();
            }
            
        } while (resp != 5);
    }
}