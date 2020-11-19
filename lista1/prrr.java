import java.sql.ResultSet; 
import java.util.Scanner; 

public class Principal{
	public static void main(String args[]){
		ConectaBanco cb = new ConectaBanco();
		Scanner sc = new Scanner(System.in); 
		String grupo, roteiro, modelo, acessorio, sql;
		int opcao, idBicicleta = 0, idAcessorio = 0;
		
		do{
			System.out.println("\nSelecione a opcao desejada: \n1 = Buscar ciclista \n2 = Buscar treino \n3 = Equipar bicicleta \n4 = Sair: ");
			opcao = sc.nextInt();
			
			if(opcao == 1){
				sc.nextLine();
				System.out.println("Informe o nome de um grupo de ciclistas: ");
				grupo = sc.nextLine();
				sc.nextLine();
				System.out.println("Informe o nome de um roteiro: ");
				roteiro = sc.nextLine();
				
				sql = "select ciclista.nome from ciclista, treino, grupodeciclistas, treinociclista where idtreino = treino.id and idciclista = ciclista.id and idgrupo = grupodeciclistas.id and grupodeciclistas.nome = '"+grupo+"' and roteiro = '"+roteiro+"'";
				ResultSet rs = cb.buscaDados(sql); 

				try{
					while(rs.next()){
						System.out.println("Nome do ciclista: "+ rs.getString("nome"));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
	
			}
			else if(opcao == 2){
				sc.nextLine();
				System.out.println("Informe o roteiro do treino: ");
				roteiro = sc.next();
				
				
				sql = "select ciclista.nome, modelo " +
						"from ciclista, treino, bicicleta, bicicletaciclista, treinociclista "+
						"where idbicicleta = bicicleta.id and " +
							 "bicicletaciclista.idciclista = ciclista.id and "+
							  "idtreino = treino.id and "+
							  "treinociclista.idciclista = ciclista.id and " +
							  "roteiro = '"+roteiro+"'";
				ResultSet rs = cb.buscaDados(sql); 
				
				try{
					while(rs.next()){
						System.out.println("Nome do ciclista: "+rs.getString("nome")
						+ " Modelo da bicicleta: "+rs.getString("modelo"));								
					}					
				}catch(Exception e){
					e.printStackTrace();					
				}
				sc.nextLine();				
			}
			else if(opcao == 3){
				sql = "select modelo from bicicleta";
				ResultSet rs = cb.buscaDados(sql); 

				try{
					while(rs.next()){
						System.out.println("Modelo da bicicleta: "+ rs.getString("modelo"));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				System.out.println("\n");
				sql = "select nome, valor from acessorio";
				rs = cb.buscaDados(sql); 

				try{
					while(rs.next()){
						System.out.println("Nome do acessorio: "+ rs.getString("nome")+
						" Valor: "+rs.getFloat("valor"));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("\n");
				sc.nextLine();
				System.out.println("Informe o modelo da bicicleta: ");
				modelo = sc.nextLine();
				
				sql = "select id from bicicleta where modelo = '"+modelo+"'";
				rs = cb.buscaDados(sql); 

				try{
					while(rs.next()){
						idBicicleta = rs.getInt("id");
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				sc.nextLine();
				System.out.println("Informe o nome de um acessorio: ");
				acessorio = sc.nextLine();
				
				sql = "select id from acessorio where nome = '"+acessorio+"'";
				rs = cb.buscaDados(sql); 

				try{
					while(rs.next()){
						idAcessorio = rs.getInt("id");
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				sql = "insert into bicicletaacessorio values("+idBicicleta+", "+idAcessorio+")";
				cb.executaSql(sql);
				
			}
			
		}while(opcao != 4);
		
	}
}



