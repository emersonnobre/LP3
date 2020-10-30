import java.sql.ResultSet;
import java.util.Scanner;

class Principal {
    public static void main(String[] args) {
        Conecta_banco cb = new Conecta_banco();
        Scanner sc = new Scanner(System.in);
        String nome;

        System.out.println("Insira um nome: ");
        nome = sc.nextLine();

        String sql = "select setor.nome from setor, servidor where setor.id = idsetor and servidor.nome = '"+nome+"'";
        ResultSet rs = cb.buscaDados(sql);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}