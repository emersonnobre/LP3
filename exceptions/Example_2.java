import java.util.Scanner;
class Example_2 {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        String pass;

        System.out.println("Insira sua senha: ");
        pass = sc.nextLine();

        try {
            verify_pass(pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //throws joga a exceção para o outro que invocar o método resolver.
    public static void verify_pass (String pass) throws Exception {
        if (pass.equals("123")) {
            System.out.println("Senha correta.");
        } else {
            throw new Exception("Senha invalida.");
        }
    }
}