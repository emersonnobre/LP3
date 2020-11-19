import java.util.Scanner;
import java.sql.ResultSet;

public class Principal {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Conecta_banco cb = new Conecta_banco();
        String sql;
        sql = "select nome from aluno order by id";
        ResultSet rs = cb.buscaDados(sql);
        
        try {
            while(rs.next()) {
                System.out.println(rs.getString("nome") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}