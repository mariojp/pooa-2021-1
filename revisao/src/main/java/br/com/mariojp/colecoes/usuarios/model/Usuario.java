package br.com.mariojp.colecoes.usuarios.model;

/**
 * MVC - M
 * MODEL
 * - ANEMICO (X)
 * - RICO ( )
 * @author mariojp
 *
 */
public class Usuario implements Comparable<Usuario>{
	

	
	private String nome;
	private String email; // index
	private String senha;
	private String perfil; //?
	
	/**
	 * 
	 * @param nome
	 * @param email
	 * @param senha
	 * @param perfil
	 */
	public Usuario(String nome, String email, String senha, String perfil) {
		super();
		this.nome = nome;
		this.email = email;
		//TODO FIX SENHA DEVE SER CRIPTOGRAFADA
		this.senha = senha;
		this.perfil = perfil;
	}

	/**
	 * Cria usuario com o Perfil de USUARIO
	 * @param nome
	 * @param email
	 * @param senha
	 */
	public Usuario(String nome, String email, String senha) {
		this(nome,email,senha,"USUARIO");
	}




	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	


	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", senha=");
		builder.append(senha);
		builder.append(", perfil=");
		builder.append(perfil);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Usuario o) {
		return this.getEmail().compareTo(o.getEmail());
	}
	

	
	
}
