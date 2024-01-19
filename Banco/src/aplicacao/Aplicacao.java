package aplicacao;

import java.util.Scanner;

import dao.VideoAula;
import dao.VideoAulaDAO;

public class Aplicacao {

	public static void main(String[] args) {
		
		
		VideoAula aula = new VideoAula("Java para iniciantes",1 , 475.75);
		VideoAula aula1 = new VideoAula("Java para intermediario",2 , 575.75);
		VideoAula aula2 = new VideoAula("Java avançado",3 , 875.75);

		VideoAulaDAO dao = new VideoAulaDAO();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escolha uma opção");
		System.out.println("1 - Consultar tudo | 2 - Cadastrar novo curso | 3 - Atualizar Valor do curso | 4 - Apagar curso ");
		String m = entrada.nextLine();
		int menu = Integer.parseInt(m);
		
		if (menu == 1) {
			dao.consultaTudo();
		}
		else if(menu == 2) {
			System.out.println("Informe o nome do novo curso ");
			String nome = entrada.nextLine();
			System.out.println("Informe o valor do novo curso: ");
			String valor = entrada.nextLine();
			VideoAula novocurso = new VideoAula(nome, Double.parseDouble(valor));
			dao.grava(novocurso);
;		}
		else if (menu == 3) {
			System.out.print("\nQual o id do curso?");
			String id = entrada.nextLine();
			System.out.print("\nQual o valor do curso?");
			String valorCurso = entrada.nextLine();
			dao.alteraValor(Integer.parseInt(id), Double.parseDouble(valorCurso));
		}
		else if(menu == 4) {
			System.out.println("Qual o Id do curso que deseja apagar? ");
			String id = entrada.nextLine();
			dao.apaga(Integer.parseInt(id));
		}
		else {
			System.out.println("Opção Inválida");
		}
		
		//dao.grava(novocurso);
		//dao.consultaTudo();
		//dao.apagaTabela();
		//dao.criaTabela();
		//dao.grava(aula);
		//dao.consultaTudo();
		//dao.grava(aula1);
		//dao.grava(aula2);
		//dao.consultaTudo();
		//dao.consultaPorNome("Java para iniciantes");
		//dao.alteraValor(1, 250.99);
		//dao.consultaPorNome("Java para iniciantes");
		//dao.apaga(3);
		//dao.consultaTudo();
	}

}
