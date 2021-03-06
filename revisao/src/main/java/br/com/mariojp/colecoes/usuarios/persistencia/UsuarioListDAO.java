package br.com.mariojp.colecoes.usuarios.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.mariojp.colecoes.usuarios.model.Usuario;

/**
 * DAO
 * DATA ACCESS OBJECT
 * @author mariojp
 *
 */
public class UsuarioListDAO implements BancoDAO {

	//Lista estatica
	//Usuario[] usuarios = new Usuario[100];
	//Lista dinamica
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioListDAO() {
		Usuario usuario = new Usuario("Pedro","pedro@email.com", "1234","ADMINISTRADOR");
		salvar(usuario);
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
