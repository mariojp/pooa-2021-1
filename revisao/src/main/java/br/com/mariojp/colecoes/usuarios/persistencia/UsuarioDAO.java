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
 * DATA ACCESS OBJECT
 * @author mariojp
 *
 */
public class UsuarioDAO {

	
	// Usuario[] usuarios = new Usuario[100];
	private Map<String,Usuario> usuarios = new HashMap<String,Usuario>();
	//private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public void salvar(Usuario usuario) {
		if(usuario.getEmail().contains("@")) {
			//usuarios.add(usuario);
			usuarios.put(usuario.getEmail(),usuario);
		}
		
	}

	public List<Usuario> lista() {
		return Collections.unmodifiableList(new ArrayList<>(usuarios.values()));
//		List<Usuario> list2 = usuarios.stream().collect(Collectors.toList());
//		return list2;
		//return usuarios;
	}
	
	
}
