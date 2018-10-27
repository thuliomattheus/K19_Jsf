package estudo.k19Cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AlteraEditora {

	public static void main(String[] args) throws Exception{

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		Scanner entrada = new Scanner(System.in);
		Editora e = new Editora();

		System.out.print("Digite o id da editora que deseja alterar: ");
		e.setId(Long.parseLong(entrada.nextLine()));

		System.out.print("Digite o novo nome da editora: ");
		e.setNome(entrada.nextLine());

		System.out.print("Digite o novo email da editora: ");
		e.setEmail(entrada.nextLine());

		entrada.close();

		String sql = "UPDATE Editora SET nome = ?, email = ? WHERE id = ?";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, e.getNome());
		comando.setString(2, e.getEmail());
		comando.setLong(3, e.getId());
		comando.execute();

		comando.close();
		conexao.close();
		System.out.println("Editora atualizada!");
	}
}
