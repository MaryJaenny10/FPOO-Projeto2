package br.org.sesisp.model;

public class Livros {
	//atributos 
	private int codigo;
	private String NomeLivro;
	private String Autor;
	private String Categoria;
	//construtor padrao
	public Livros () {
		super();
	}
	//metodos set get 

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeLivro() {
		return NomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		NomeLivro = nomeLivro;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categotia) {
		Categoria = categotia;
	}
	

}
