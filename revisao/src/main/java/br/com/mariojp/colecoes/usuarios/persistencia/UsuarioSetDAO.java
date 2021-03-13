package br.com.mariojp.colecoes.usuarios.persistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.mariojp.colecoes.usuarios.model.Usuario;
import br.com.mariojp.colecoes.usuarios.view.UsuarioConsole;

public class UsuarioSetDAO implements BancoDAO {
	
	private Set<Usuario> usuarios = new TreeSet<>();

	public UsuarioSetDAO() {
		String senha = UsuarioConsole.criptografarSenha("1234");
		Usuario usuario = new Usuario("Pedro","pedro@email.com", senha,"ADMINISTRADOR");
		salvar(usuario);
		Usuario usuario2 = new Usuario("Maria","maria@email.com", senha);
		salvar(usuario2);
	}
	
	@Override
	public void salvar(Usuario usuario) {
		if(usuario.getEmail().contains("@")) {
			usuarios.add(usuario);
		}		
	}

	@Override
	public List<Usuario> lista() {
		return Collections.unmodifiableList(new ArrayList<>(usuarios));
	}
	
	

}
