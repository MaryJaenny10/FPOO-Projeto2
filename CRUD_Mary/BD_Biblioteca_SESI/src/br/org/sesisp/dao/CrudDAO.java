package br.org.sesisp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.org.sesisp.controller.Conexao;
import br.org.sesisp.model.Livros;

public class CrudDAO {
	//CRUD C-Create R- Read U- Update D-Delete 
	
	//CREATE (inserir DADOS)
	
	public void create (Livros livros ) {
		String sql="INSERT INTO livros (Codigo, Nome, Autor,Categoria) VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = (Connection ) Conexao.criandoonexao();
			p = (PreparedStatement) conn.prepareStatement(sql); //cast
			p.setInt(1, livros.getCodigo());
			p.setString(2, livros.getNomeLivro());	
			p.setString(3, livros.getAutor());	
			p.setString(4, livros.getCategoria());	
			p.execute();
			System.out.println("aqui"+p);
			
;		}catch (Exception e ) {
		JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \n ERRO:" +  e);
}finally {
	try {
		if (p!= null);
		p.close();
	
}catch (Exception e) {
	e.printStackTrace();
}
	}


}// fim CREATE
	//*************************************************************************
	
	
	public void update (Livros livro) {
		String sql ="UPDATE livros SET Nome = ? ,  Autor = ? , Categoria  =?  WHERE Codigo =?";
		Connection conn = null;
		PreparedStatement p =  null; //linnk com banco
		try {
			conn = Conexao.criandoonexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1,livro.getNomeLivro());
			p.setString(2, livro.getAutor());
			p.setString(3, livro.getCategoria());
			p.setInt(4,livro.getCodigo());
		
			p.execute(); //"executa inst para grava " dados no banco 
			JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso!");
			System.out.println("dados atualizados com sucesso!");
		}catch (Exception e ) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \n ERRO:" +  e);
		}finally {
			try {
				if (p!= null);
				p.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	}//fim update
	//********************************************************************
	
	public List <Livros> read (){
		String sql = "SELECT * FROM livros";
		List <Livros> alunos = new ArrayList <Livros> ();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		try {
			conn = Conexao.criandoonexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			resultado = p.executeQuery(); //mostra os dados 
			while (resultado.next()) {
				Livros ver_livros = new Livros ();
				//recuperar Autor 
				ver_livros.setAutor(resultado.getString("Autor"));
				//recuperar categotia
				ver_livros.setCategoria(resultado.getString("Categoria"));
				//recuperar livros
			ver_livros.setNomeLivro(resultado.getString("Nome"));
			//recuperar codigo
			ver_livros.setCodigo(resultado.getInt("Codigo"));
				// adicionar na lista
				alunos.add(ver_livros);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if (p!= null);
					p.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			}	
		
		
		return alunos;
	}//fim READ
	//*********************************************************************
	//D -Delete
		public boolean delete (int codigo) {
			String sql = "DELETE FROM livros WHERE Codigo = ?";
			Connection conn = null;
			PreparedStatement p = null;
		try {
			conn = Conexao.criandoonexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
					p.setInt (1, codigo);
					p.execute();
					JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso!");
					System.out.println("dados atualizados com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \n ERRO:" +  e);
		}finally {
			try {
				if (p!= null);
				p.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}	
		return false;
		}//fim do delete
	
	
	
	
	
	
	
	
	
}//fim CRUD
	
