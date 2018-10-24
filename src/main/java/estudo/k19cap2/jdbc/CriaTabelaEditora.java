package estudo.k19cap2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class CriaTabelaEditora {

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
			"CREATE TABLE IF NOT EXISTS Editora (" +
				"id BIGINT NOT NULL AUTO_INCREMENT," +
				"nome VARCHAR (255) NOT NULL," +
				"email VARCHAR (255) NOT NULL," +
				"PRIMARY KEY (id)" +
			")" +
			"ENGINE = InnoDB";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Tabela Editora criada!");

		conexao.close();
	}
}
