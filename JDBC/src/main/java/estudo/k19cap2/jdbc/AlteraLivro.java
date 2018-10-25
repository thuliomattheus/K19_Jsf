package estudo.k19cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AlteraLivro {

	public static void main(String[] args) throws Exception{

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		Scanner entrada = new Scanner(System.in);
		Livro l = new Livro();

		System.out.print("Digite o id do livro que deseja alterar: ");
		l.setId(Long.parseLong(entrada.nextLine()));

		System.out.print("Digite o novo título do livro: ");
		l.setTitulo(entrada.nextLine());

		System.out.print("Digite o novo preço do livro: ");
		l.setPreco(entrada.nextDouble());

		entrada.close();

		String sql = "UPDATE Livro SET titulo = ?, preco = ? WHERE id = ?";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, l.getTitulo());
		comando.setDouble(2, l.getPreco());
		comando.setLong(3, l.getId());
		comando.execute();

		comando.close();
		conexao.close();
		System.out.println("Livro atualizado!");
	}

}
