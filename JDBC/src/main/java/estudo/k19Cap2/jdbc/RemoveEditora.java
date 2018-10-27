package estudo.k19Cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveEditora {

	public static void main(String[] args) throws Exception{
		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o id da editora que deseja remover:");
		Long id = Long.parseLong(entrada.nextLine());

		entrada.close();

		String sql = "DELETE FROM Editora WHERE id = ?";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
		comando.execute();

		comando.close();
		conexao.close();
		System.out.println("Editora removida!");
	}
}
