package br.com.mariojp.colecoes.usuarios.controller;

import java.util.List;

import br.com.mariojp.colecoes.usuarios.model.Usuario;
import br.com.mariojp.colecoes.usuarios.persistencia.BancoDAO;
import br.com.mariojp.colecoes.usuarios.view.UsuarioConsole;

/**
 * MVC - C
 * 
 * @author mariojp
 *
 */
public class UsuarioController {

	
	private BancoDAO dao;
	
	
	public UsuarioController(BancoDAO dao) {
		this.dao = dao;
	}


	public Usuario login(String login, String senha) {
		List<Usuario> lista = dao.lista();
		for (Usuario item : lista) {
			if(item.getEmail().equalsIgnoreCase(login) &&
			item.getSenha().equals(senha)) {
				return item;
			}
		}
		return null;
	}


	public List<Usuario> listaUsuario() {
		List<Usuario> lista = dao.lista();
		return lista;
	}


	public void cadastrarUsuario(String nome, String email, String senha, Boolean isAdmin) {
		Usuario usuario;
		if(isAdmin) {
			usuario = new Usuario(nome,email, senha,"ADMINISTRADOR");
		}else {
			usuario = new Usuario(nome,email, senha);
		}
		dao.salvar(usuario);
	
	}
	
	
}
