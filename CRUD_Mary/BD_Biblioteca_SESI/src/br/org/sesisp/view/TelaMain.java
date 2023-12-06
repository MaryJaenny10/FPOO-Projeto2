package br.org.sesisp.view;


import java.util.Scanner;
import javax.swing.JOptionPane;
import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Livros;

public class TelaMain {

	public static void main(String[] args) {
		CrudDAO inserir_livro= new CrudDAO();
		Livros livros_1 = new Livros ();
		String opcao;
		int op;
		Scanner entrada = new Scanner (System.in);
		do {
			opcao = JOptionPane.showInputDialog("Selecione uma opcao: " + "\n 1- Inserir Livros  " +"\n 2- Atualizar Livros" + "\n 3- Visualizar "  + "\n 4- Deletar");
			op = Integer.parseInt(opcao);
			switch (op) {
			case 1:
				String nome;
				 nome = JOptionPane.showInputDialog("Digite o Nome do livro  ");
				livros_1.setNomeLivro(nome);
				System.out.println("nome:"+nome);
				String  categoria =  JOptionPane.showInputDialog("Digite  Categoria ");
				livros_1.setCategoria(categoria);
				System.out.println(" Categoria: " + categoria);
				String autor = JOptionPane.showInputDialog("Digite o Nome do Autor ");
				livros_1.setAutor(autor);
				System.out.println("Autor:" + autor);
				String codigo = JOptionPane.showInputDialog("Digite o codigo");
				int c2 = Integer.parseInt(codigo);
				livros_1.setCodigo(c2);
				System.out.println("Codigo" + c2);
				inserir_livro.create(livros_1);
				break;
			case 2:
				String nome1 = JOptionPane.showInputDialog("Digite o nome do livro ");
				livros_1.setNomeLivro(nome1);
				System.out.println("iiiiiiii");
				String  categoria1 =  JOptionPane.showInputDialog("Digite  Categoria ");
				livros_1.setCategoria(categoria1);
				System.out.println("llsls");
				String autor1 = JOptionPane.showInputDialog("Digite o Nome do Autor ");
				livros_1.setAutor(autor1);
				System.out.println("ll");
				String codigo11 = JOptionPane.showInputDialog("Digite o codigo");
				int c3 = Integer.parseInt(codigo11);
				livros_1.setCodigo(c3);
				System.out.println("llslsaaaa");
				inserir_livro.update(livros_1);
				break;
			case 3:
			
				for (Livros pr : inserir_livro.read() ){
					System.out.println("nome  do livro : " + pr.getNomeLivro() + "\n "+"Categotia " + pr.getCategoria()+  "\n "+"Autor " + pr.getAutor());
					
				}
				break;
			case 4 :
				CrudDAO remover_livro = new CrudDAO();
				String c5 = JOptionPane.showInputDialog("Digite o Codigo:  ");
				int c4 = Integer.parseInt(c5);
				livros_1.setCodigo(c4);
			
			
				remover_livro.delete(c4);
			
				
			default:
				break;
			}
		}while (op !=0);
		
		
		
	}

	

	
	

}
