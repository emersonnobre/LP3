import java.util.Scanner;
import java.sql.ResultSet;
public class Method {
    private Scanner sc = new Scanner(System.in);
    ResultSet rs;
    Conecta_banco cb = new Conecta_banco();
    private String sql;

    public void cadastrarAlimento() {
        int idconfeiteiro;
        String nome_doce; 
        float peso_doce, valor_doce;
        System.out.println("\n----- CADASTRO DO DOCE -----\n");
        System.out.println("Informe o id do confeiteiro responsavel: ");
        idconfeiteiro = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe o nome do novo doce: ");
        nome_doce = sc.nextLine();
        System.out.println("Informe o peso medio do novo doce: ");
        peso_doce = sc.nextFloat();
        System.out.println("Informe o valor do novo doce: ");
        valor_doce = sc.nextFloat();

        sql = "insert into doce (nome, pesomedio, valor, idconfeiteiro) values ('"+nome_doce+"', "+peso_doce+", "+valor_doce+", "+idconfeiteiro+")";
        cb.executaSql(sql);
    }

    public void atualizarIngrediente() {
        String nome_antigo, nome_novo;
        float peso_novo;
        System.out.println("\n----- ATUALIZACAO DE INGREDIENTE -----\n");
        sc.nextLine();
        System.out.println("Informe o nome do ingrediente a ser atualizado: ");
        nome_antigo = sc.nextLine();
        System.out.println("Informe o novo nome: ");
        nome_novo = sc.nextLine();
        System.out.println("Informe o novo peso: ");
        peso_novo = sc.nextFloat();

        sql = "update ingrediente set nome = '"+nome_novo+"', peso = "+peso_novo+" where lower(nome) = '"+nome_antigo.toLowerCase()+"'";

        try {
            cb.executaSql(sql);
            System.out.println("Ingrediente atualizado!!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarCarga() {
        String modalidade;
        System.out.println("\n----- ATUALIZACAO DE CARGA -----\n");
        System.out.println("Informe a modalidade a ser atualizada: ");
        modalidade = sc.nextLine();
        
        sql = "update curso set duracao = duracao + 10 where lower(modalidade) = '"+modalidade.toLowerCase()+"'";
        try {
            cb.executaSql(sql);
            System.out.println("Carga atualizada!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removerIngrediente() {
        String nome_ingrediente;
        int id_ingrediente = 0;
        System.out.println("\n----- REMOCAO DE INGREDIENTE -----\n");
        System.out.println("Informe o nome do ingrediente a ser removido: ");
        nome_ingrediente = sc.nextLine();

        try {
            id_ingrediente = this.retornaIdIngrediente(nome_ingrediente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        sql = "delete from doceingrediente where idingrediente = "+id_ingrediente+"";

        try {
            cb.executaSql(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sql = "delete from ingrediente where id = "+id_ingrediente+"";

        try {
            cb.executaSql(sql);
            System.out.println("Ingrediente removido com sucesso!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int retornaIdIngrediente(String nome) {
        int id = 0;
        sql = "select id from ingrediente where lower(nome) = '"+nome.toLowerCase()+"'";
        rs = cb.buscaDados(sql);
        try {
            while(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
}