package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VideoAulaDAO {

	Connection conexao;
	String NOMEDATABELA = "Cursos";
	
	public VideoAulaDAO() {
		this.conexao = new Conexao().conectar();
	}
	
	public void criaTabela() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS " +
		NOMEDATABELA +
		" (Curso VARCHAR(255), " +
		"Id SMALLINT(5) NOT NULL AUTO_INCREMENT, " +
		"Valor DECIMAL(5,2), " +
		"PRIMARY KEY (Id) )";
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.execute(sql);
		pst.close();
		System.out.println("Tabela criada com sucesso!");
		
		} catch(SQLException e) {
			System.out.println("Falha na criação da tabela!");
			throw new RuntimeException(e);
		}
	}
	public void apagaTabela() {
		try {
			String sql = "DROP TABLE IF EXISTS " + NOMEDATABELA;
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.execute(sql);
			pst.close();
			System.out.println("Tabela apagada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Falha ao excluir a tabela");
			throw new RuntimeException(e);
		}
	}
	public void grava(VideoAula videoAula) {
		try {
			String sql ="INSERT INTO " + NOMEDATABELA +
						" (Curso, Id, Valor) " +
						"VALUES (?, NULL, ?)";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, videoAula.curso );
			pst.setDouble(2, videoAula.valor );
			pst.execute();
			System.out.println("Registro gravado com sucesso!");
	} catch (SQLException e) {
		System.out.println("Falha ao gravar dados na tabela");
		throw new RuntimeException(e);
	}
   }
	public void consultaTudo() {
		try {
			ArrayList<VideoAula> videoAulas = new ArrayList<>();
			String sql = "SELECT * FROM " + NOMEDATABELA;
			PreparedStatement pst =conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				VideoAula va = new VideoAula(
						rs.getString("Curso"),
						rs.getInt("Id"),
						rs.getDouble("Valor"));
				videoAulas.add(va);
			}
			videoAulas.forEach(a -> System.out.println("*** " +
					a.id + " | " +
					a.curso + " | " +
					a.valor + " ***"));
			rs.close();
		}catch(SQLException e) {
			System.out.println("Falha ao consultar a tabela!");
			throw new RuntimeException(e);
		}
	}
	public void consultaPorNome( String nomeDoCurso) {
		try {
			String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE Curso = ?";
			PreparedStatement pst =conexao.prepareStatement(sql);
			pst.setString(1, nomeDoCurso);
			ResultSet rs = pst.executeQuery();
			while (rs.next() ) {
				System.out.println("O curso " + nomeDoCurso + 
						" custa R$" + rs.getDouble("Valor"));
			}
			rs.close();
		} catch(SQLException e) {
			System.out.println("Falha ao consultar o valor do curso!");
			throw new RuntimeException(e);
		}
	}
	public void alteraValor(Integer id, Double novoValor) {
		try {
			String sql = "UPDATE " + NOMEDATABELA +
					" SET Valor = ? WHERE Id = ?";
			PreparedStatement pst =conexao.prepareStatement(sql);
			pst.setDouble(1, novoValor);
			pst.setInt(2, id);
			pst.execute();
			pst.close();
			System.out.println("Registro feito com sucesso!");
		} catch(SQLException e) {
			System.out.println("Falha ao alterar dados na tabela!");
			throw new RuntimeException(e);
		}
	}
	public void apaga(Integer id) {
		try {
			String sql = "DELETE FROM " + NOMEDATABELA +
						" WHERE Id = ?";
			PreparedStatement pst =conexao.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			pst.close();
			System.out.println("Registro apagado com sucesso!");
		} catch(SQLException e) {
			System.out.println("Falha ao alterar dados na tabela!");
			throw new RuntimeException(e);
		}
	}
	
}
