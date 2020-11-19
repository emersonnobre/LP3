import java.util.Scanner;
public class Principal {
    public static void main (String[] args){
        ConectaBanco con = new ConectaBanco();
        Scanner sc = new Scanner(System.in);
        String  nome, data, cpf, sql;
        int resp, id;

        do {
            System.out.println("\n----- MENU -----\n");
            System.out.println("1 - Inserir um novo registro\n2 - Atualizar um registro\n3 - Sair\nResposta: ");
            resp = sc.nextInt();

            if (resp == 1){
                System.out.println("\nInsira o nome: ");
                nome = sc.next();
                System.out.println("Insira a data (ano-mes-dia): ");
                data = sc.next();
                System.out.println("Insira o CPF (apenas numeros): ");
                cpf = sc.next();

                sql = "insert into aluno (nome, nascimento, cpf) values ('"+nome+"', '"+data+"', '"+cpf+"')";
                try {
                    con.executaSql(sql);
                    System.out.println("Dados inseridos.\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (resp == 2){
                System.out.println("\nInsira o id do registro a ser atualizado: ");
                id = sc.nextInt();
                System.out.println("\nInsira o novo nome: ");
                nome = sc.next();
                System.out.println("\nInsira a nova data: ");
                data = sc.next();
                System.out.println("\nInsira o novo CPF: ");
                cpf = sc.next();

                try {
                    sql = "update aluno set nome = '"+nome+"' , nascimento = '"+data+"' , cpf = '"+cpf+"' where id = "+id+"";
                    con.executaSql(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (resp == 3){
                System.out.println("\nSaindo...");
            }
        } while(resp != 3);
        
    }
}