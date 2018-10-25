package estudo.k19cap2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class InsereEditora {

	public static void main(String[] args) throws Exception {

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		Scanner entrada = new Scanner(System.in);
		Editora e = new Editora();

		// Nome da editora
		System.out.println("Digite o nome da editora: ");
		e.setNome(entrada.nextLine());

		// Email da editora
		System.out.println("Digite o email da editora: ");
		e.setEmail(entrada.nextLine());

		// Encerramento do scanner
		entrada.close();

		// Inserção da editora
		String sql = "INSERT INTO Editora (nome, email) VALUES (?, ?)";

		// Execução da query e gravação das informações
		PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		comando.setString(1, e.getNome());
		comando.setString(2, e.getEmail());
		comando.execute();

		// Recuperação dos valores retornados pelo comando anterior
		ResultSet generatedKeys = comando.getGeneratedKeys();
		generatedKeys.next();
		e.setId(generatedKeys.getLong(1));

		// Encerramento das consultas e conexão ao banco
		comando.close();
		conexao.close();
		System.out.println("Editora inserida!");

	}
}
