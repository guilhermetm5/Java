package dao;

public class VideoAula {
	
	public String curso;
	public Integer id;
	public Double valor;
	
	public VideoAula() {	
	}
	
	public VideoAula(String curso, Double valor) {
		this.curso = curso;
		this.valor = valor;
	}
	public VideoAula(String curso, Integer id, Double valor) {
		this.curso = curso;
		this.id = id;
		this.valor = valor;
	}
}
