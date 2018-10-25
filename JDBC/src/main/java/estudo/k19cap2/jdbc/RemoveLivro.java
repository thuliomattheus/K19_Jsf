package estudo.k19cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveLivro {

	public static void main(String[] args) throws Exception{
		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o id do livro que deseja remover:");
		Long id = Long.parseLong(entrada.nextLine());

		entrada.close();

		String sql = "DELETE FROM Livro WHERE id = ?";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
		comando.execute();

		comando.close();
		conexao.close();
		System.out.println("Livro removido!");
	}
}
