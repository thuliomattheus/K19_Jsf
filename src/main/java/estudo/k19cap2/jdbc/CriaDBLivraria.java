package estudo.k19cap2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class CriaDBLivraria {

	public static void main(String[] args) throws Exception{

		// Leitura da senha do mysql
		InputStream configFile = CriaTabelaEditora.class.getClassLoader().getResourceAsStream("config/config.properties");
		Properties prop= new Properties();
		prop.load(configFile);

		// Variáveis de conexão do banco
		String stringDeConexao = "jdbc:mysql://localhost:3306";
		String usuario = "root";
		String senha = prop.getProperty("mysql.password");

		// Conexão com o banco
		Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

		// Remoção do banco caso já exista
		String sql = "DROP DATABASE IF EXISTS livraria";
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		// Remoção do banco caso já exista
		sql = "CREATE DATABASE livraria";
		comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Base de dados livraria criada...");

		conexao.close();
	}

}
