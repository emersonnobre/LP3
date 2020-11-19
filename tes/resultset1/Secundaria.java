import java.util.Scanner;
import java.sql.ResultSet;

public class Secundaria {
    public static void main (String[] args) {
        Conecta_banco cb = new Conecta_banco();
        Scanner sc = new Scanner(System.in);
        int resp;
        String nome, sql;
        ResultSet rs;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1 - Mostrar os nomes dos setores\n2 - Mostrar os nomes dos servidores\n3 - Mostrar o setor de um servidor\n4 - Mostrar os servidores de um setor\n5 - Sair\nResposta: ");
            resp = sc.nextInt();

            if (resp == 1) {
                sql = "select nome from setor";
                rs = cb.buscaDados(sql);
                try {
                    while(rs.next()){
                        System.out.println(rs.getString("nome"));
                    }
                } catch (Exception e) {
                    System.out.println("\n...\n");
                }
            }else if (resp == 2) {
                sql = "select nome from servidor";
                rs = cb.buscaDados(sql);
                try {
                    while(rs.next()){
                        System.out.println(rs.getString("nome"));
                    }
                } catch (Exception e) {
                    System.out.println("\n...\n");
                }
            }else if (resp == 3) {
                System.out.println("\nInsira o nome do servidor: ");
                nome = sc.next();
                sql = "select setor.nome from setor, servidor where idsetor = setor.id and lower(servidor.nome) = '"+nome.toLowerCase()+"'";
                rs = cb.buscaDados(sql);
                try {
                    while(rs.next()){
                        System.out.println(rs.getString("nome"));
                    }
                } catch (Exception e) {
                    System.out.println("\n...\n");
                }
            }else if (resp == 4) {
                System.out.println("\nInsira o nome do setor: ");
                nome = sc.next();
                sql = "select servidor.nome from setor, servidor where idsetor = setor.id and lower(setor.nome) = '"+nome.toLowerCase()+"'";
                rs = cb.buscaDados(sql);
                try {
                    while(rs.next()){
                        System.out.println(rs.getString("nome"));
                    }
                } catch (Exception e) {
                    System.out.println("\n...\n");
                }
            }else if (resp == 5) {
                System.out.println("\nSaindo...");
            }

        } while (resp != 5);
    }
}