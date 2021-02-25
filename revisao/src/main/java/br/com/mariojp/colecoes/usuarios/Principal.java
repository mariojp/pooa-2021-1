package br.com.mariojp.colecoes.usuarios;

import br.com.mariojp.colecoes.usuarios.model.Usuario;

/**
 * 
 * Cadastro de *usuarios* para um sistema. Um *usuario* vai possuir 
 * *nome*, *email*, *perfil* e uma *senha*.
 * A senha deve ser criptografada.
 * Os *perfis* devem ser *USUARIO* e *ADMINISTRADOR*.
 * O sitema deve possuir autenticação que deve ser feita pelo email e senha.
 * Apenas o ADMIN pode ver a lista de de usuarios.
 *
 *
 * Um usuario do sistema com perfil de ADMIN acessa o sistema
 * passando o email e a senha. Depois ele acessa pede a lista
 * de Usuarios cadastrados.
 * 
 * Tarefas
 * - Criar a Funcionalidade de autenticação.
 * - Criar a Funcionalidade de Listar Usuario.
 *
 * 
 * Cadastro de Usuarios
 * 
 * Model View Controller 
 * 
 * @author mariojp
 *
 */
public class Principal {
	
	
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario("pedro@email.com","Pedro", "1234","ADMINISTRADOR");
		
		usuario1.salvar();
		
		Usuario usuario2 = new Usuario("maria@email.com","Maria","1234");
		
		usuario2.salvar();
	}

}
