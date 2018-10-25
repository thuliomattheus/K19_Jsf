package estudo.k19cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsereLivro {

	public static void main(String[] args) throws Exception {

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		Scanner entrada = new Scanner(System.in);
		Livro l = new Livro();

		// Nome do livro
		System.out.println("Digite o nome do livro: ");
		l.setTitulo(entrada.nextLine());

		// Preço do livro
		System.out.print("Digite o preço do livro: R$ ");
		l.setPreco(entrada.nextDouble());

		// Consulta dos atributos de todas as editoras cadastradas
		String sql = "SELECT nome, id from Editora";
		PreparedStatement comando = conexao.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery();

		// Listagem dos nomes (e id's) das editoras
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
		sql = "INSERT INTO Livro (titulo, preco, editoraId) VALUES (?, ?, ?)";

		// Execução da query e gravação das informações
		comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		comando.setString(1, l.getTitulo());
		comando.setDouble(2, l.getPreco());
		comando.setLong(3, l.getEditoraId());
		comando.execute();

		// Recuperação dos valores retornados pelo comando anterior
		ResultSet generatedKeys = comando.getGeneratedKeys();
		generatedKeys.next();
		l.setId(generatedKeys.getLong(1));

		// Encerramento das consultas e conexão ao banco
		comando.close();
		conexao.close();
		System.out.println("Livro inserido!");
	}

}
