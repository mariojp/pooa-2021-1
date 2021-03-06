package br.com.mariojp.colecoes.usuarios.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.mariojp.colecoes.usuarios.controller.UsuarioController;
import br.com.mariojp.colecoes.usuarios.model.Usuario;
import br.com.mariojp.colecoes.usuarios.view.UsuarioConsole;

/**
 * DAO
 * DATA ACCESS OBJECT
 * @author mariojp
 *
 */
public class UsuarioMapDAO implements BancoDAO{

	private Map<String,Usuario> usuarios = new HashMap<String,Usuario>();

	public UsuarioMapDAO() {
		String senha = UsuarioConsole.criptografarSenha("1234");
		Usuario usuario = new Usuario("Pedro","pedro@email.com", senha,"ADMINISTRADOR");
		salvar(usuario);
		Usuario usuario2 = new Usuario("Maria","maria@email.com", senha);
		salvar(usuario2);
	}
	
	public void salvar(Usuario usuario) {
		if(usuario.getEmail().contains("@")) {
			usuarios.put(usuario.getEmail(),usuario);
		}
		
	}

	public List<Usuario> lista() {
		return Collections.unmodifiableList(new ArrayList<>(usuarios.values()));
	}
	
	
}
