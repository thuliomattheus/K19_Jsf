package estudo.k19cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaDBLivraria {

	public static void main(String[] args) throws Exception{

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

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
