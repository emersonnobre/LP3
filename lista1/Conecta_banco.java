import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_banco {

    private String url, usuario, senha;
    private Connection con;

    public Conecta_banco() {
        url = "jdbc:postgresql://localhost:5432/LP3_LISTA_1";
        usuario = "postgres";
        senha = "123";
        try {
			con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    public void executaSql(String sql) {
        try {
            Statement s = con.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet buscaDados(String sql) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void finalizaConexao() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

