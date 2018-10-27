package estudo.k19Cap2.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {

	public static Connection createConnection() throws SQLException{

		// Leitura da senha do mysql
		InputStream configFile = CriaTabelaEditora.class.getClassLoader().getResourceAsStream("config/config.properties");
		Properties prop= new Properties();
		try {
			prop.load(configFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		// Variáveis de conexão do banco
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = prop.getProperty("mysql.password");

		return DriverManager.getConnection(stringDeConexao, usuario, senha);
	}

}
