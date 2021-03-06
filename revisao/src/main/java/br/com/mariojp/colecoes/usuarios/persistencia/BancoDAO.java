package br.com.mariojp.colecoes.usuarios.persistencia;

import java.util.List;

import br.com.mariojp.colecoes.usuarios.model.Usuario;

public interface BancoDAO {

	void salvar(Usuario usuario);

	List<Usuario> lista();

}