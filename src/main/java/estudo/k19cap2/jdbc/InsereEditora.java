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

		// Leitura da senha do mysql
		InputStream configFile = CriaTabelaEditora.class.getClassLoader().getResourceAsStream("config/config.properties");
		Properties prop= new Properties();
		prop.load(configFile);

		// Variáveis de conexão do banco
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = prop.getProperty("mysql.password");

		// Conexão com o banco
		Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

		Scanner entrada = new Scanner(System.in);
		Editora e = new Editora();

		System.out.println("Digite o nome da editora: ");
		e.setNome(entrada.nextLine());

		System.out.println("Digite o email da editora: ");
		e.setEmail(entrada.nextLine());

		entrada.close();


		String sql =
		"INSERT INTO Editora (nome, email) " +
			"VALUES ('" + e.getNome() + "', '" + e.getEmail() + "')";

		// Execução da query e gravação das chaves retornadas pelo banco (id)
		PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		comando.execute();
		System.out.println("Editora inserida!");

		// Recuperação dos valores retornados pelo comando anterior
		ResultSet generatedKeys = comando.getGeneratedKeys();
		generatedKeys.next();
		e.setId(generatedKeys.getLong(1));

		conexao.close();
	}
}
