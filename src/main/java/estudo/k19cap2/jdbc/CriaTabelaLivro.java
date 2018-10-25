package estudo.k19cap2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class CriaTabelaLivro {

	public static void main(String[] args) throws Exception{

		// Leitura da senha do mysql
		InputStream configFile = CriaTabelaEditora.class.getClassLoader().getResourceAsStream("config/config.properties");
		Properties prop= new Properties();
		prop.load(configFile);

		// Variáveis de conexão do banco
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = prop.getProperty("mysql.password");

		Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

		String sql =
			"CREATE TABLE IF NOT EXISTS Livro (" +
				"id BIGINT NOT NULL AUTO_INCREMENT," +
				"titulo VARCHAR (255) NOT NULL," +
				"preco DOUBLE NOT NULL," +
				"editoraId BIGINT NOT NULL," +
				"PRIMARY KEY (id)," +
				"FOREIGN KEY (editoraId) REFERENCES Editora(id)" +
				"ON DELETE CASCADE ON UPDATE CASCADE" +
			")" +
			"ENGINE = InnoDB";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Tabela Livro criada!");

		conexao.close();

	}
}
