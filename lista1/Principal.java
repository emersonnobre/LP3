import java.util.Scanner;
import java.sql.ResultSet;

public class Principal {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Conecta_banco cb = new Conecta_banco();
        int resp, idBicicleta = 0, idAcessorio = 0;
        String sql, grupo, nome, roteiro, modelo, acessorio;

        do {
            System.out.println("\n-----MENU-----");
            System.out.println("1 - Buscar ciclista\n2 - Buscar treino\n3 - Equipar bicicleta\n4 - Sair\nResposta: ");
            resp = sc.nextInt();

            if(resp == 1){
                sc.nextLine();
                System.out.println("\nInsira o nome de um grupo de ciclistas: ");
                grupo = sc.nextLine();
                sc.nextLine();
                System.out.println("\nInsira um roteiro de treino: ");
                roteiro = sc.nextLine();
                
                sql = "select ciclista.nome from ciclista, grupodeciclistas, treino, treinociclista where idgrupo = grupodeciclistas.id and treinociclista.idciclista = ciclista.id and treinociclista.idtreino = treino.id and lower(treino.roteiro) = '"+roteiro+"' and lower(grupodeciclistas.nome) = '"+grupo+"'";
                ResultSet rs = cb.buscaDados(sql);
                try {
                    while (rs.next()){
                        System.out.println("Nome: " + rs.getString(1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (resp == 2) {
                sc.nextLine();
                System.out.println("\nInforme um roteiro: ");
                roteiro = sc.nextLine();
                System.out.println("\n");
    
                sql = "select ciclista.nome, bicicleta.modelo from ciclista, bicicleta, bicicletaciclista, treino, treinociclista where bicicletaciclista.idciclista = ciclista.id and bicicletaciclista.idbicicleta = bicicleta.id and treinociclista.idciclista = ciclista.id and treinociclista.idtreino = treino.id and lower(treino.roteiro) = '"+roteiro.toLowerCase()+"'";
                ResultSet rs = cb.buscaDados(sql);
                try {
                    while (rs.next()) {
                        System.out.println("Nome do ciclista:" + rs.getString(1) + " || Modelo da bike: " + rs.getString(2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (resp == 3) {
                sql = "select modelo from bicicleta";
                ResultSet rs = cb.buscaDados(sql);
                try {
                    System.out.println("\n----MODELOS DE BICICLETAS----\n");
                    while (rs.next()) {
                        System.out.println("Modelo: " + rs.getString(1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                sql = "select nome, valor from acessorio";
                rs = cb.buscaDados(sql);
                try {
                    System.out.println("\n----ACESSORIOS DISPONIVEIS----\n");
                    while (rs.next()) {
                        System.out.println("Nome: " + rs.getString(1) + " || Valor: R$" + rs.getFloat(2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                sc.nextLine();
                System.out.println("\nInforme o modelo a ser equipado: ");
                modelo = sc.nextLine();

                sql = "select id from bicicleta where lower(modelo) = '"+modelo.toLowerCase()+"'";
                rs = cb.buscaDados(sql);

                try {
                    while (rs.next()){
                        idBicicleta = rs.getInt(1);
                    }
                     
                } catch (Exception e) {
                    e.printStackTrace();
                }
                

                System.out.println("Informe o acessorio a ser utilizado: ");
                acessorio = sc.nextLine();

                sql = "select id from acessorio where lower(nome) = '"+acessorio.toLowerCase()+"'";
                rs = cb.buscaDados(sql);

                try {
                    while (rs.next()){
                        idAcessorio = rs.getInt(1);
                    }
                     
                } catch (Exception e) {
                    e.printStackTrace();
                }
                

                sql = "insert into bicicletaacessorio (idbicicleta, idacessorio) values ("+idBicicleta+", "+idAcessorio+")";
                cb.executaSql(sql);

            } else if (resp == 4) {
                System.out.println("\nSaindo...");
            } else {
                System.out.println("\nOpcao nao reconhecida.");
            }
        } while (resp != 4);
    }
}