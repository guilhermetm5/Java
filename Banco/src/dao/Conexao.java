package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	String SERVIDOR = "localhost:3306";
	String BANCO = "dados_java";
	String USUARIO = "root";
	String SENHA = "";
	String STRINGDECONEXAO = "jdbc:mysql://" + SERVIDOR + "/" + BANCO;
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(STRINGDECONEXAO, USUARIO, SENHA);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Falha ao criar uma conexão com o banco de dados!");
			throw new RuntimeException(e);
		}
	}
}
