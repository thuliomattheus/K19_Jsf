package estudo.k19cap2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class InsereLivro {

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
		Livro l = new Livro();

		// Nome do livro
		System.out.println("Digite o nome do livro: ");
		l.setTitulo(entrada.nextLine());

		// Preço do livro
		System.out.print("Digite o preço do livro: R$ ");
		l.setPreco(entrada.nextDouble());

		// Listagem dos nomes (e id's) das editoras
		String sql = "SELECT * from Editora";
		PreparedStatement comando = conexao.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery();

		System.out.println("\nEditoras disponíveis:");
		while(resultado.next()) {
			System.out.println("\t"+resultado.getString("nome")+" ("+resultado.getLong("id")+")");
		}

		// Editora do livro
		System.out.println("\nDigite o id da editora: ");
		l.setEditoraId(entrada.nextLong());

		// Encerramento do scanner
		entrada.close();

		// Inserção do livro
		sql =
		"INSERT INTO Livro (titulo, preco, editoraId) " +
			"VALUES ('" +
				l.getTitulo() +	"', '" +
				l.getPreco() +	"', '" +
				l.getEditoraId() +	"')";

		// Execução da query e gravação das chaves retornadas pelo banco (id)
		comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		comando.execute();
		System.out.println("Editora inserida!");

		// Recuperação dos valores retornados pelo comando anterior
		ResultSet generatedKeys = comando.getGeneratedKeys();
		generatedKeys.next();
		l.setId(generatedKeys.getLong(1));

		// Encerramento das consultas e conexão ao banco
		comando.close();
		conexao.close();
	}

}
