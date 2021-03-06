package br.com.mariojp.colecoes.usuarios.view;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import br.com.mariojp.colecoes.usuarios.controller.UsuarioController;
import br.com.mariojp.colecoes.usuarios.model.Usuario;

/**
 * MVC - V
 * @author mariojp
 *
 */
public class UsuarioConsole {
	
	private Scanner console = new Scanner(System.in);
	private UsuarioController controller ;
	private Usuario usuario;

	public UsuarioConsole(UsuarioController controller) {
		this.controller = controller;
		this.BemVindo();
		this.login();
	}
	
	public void BemVindo() {
		System.out.print("BEM Vindo ao Sistema de Consulta de Usuarios");
	}
	
	public void login() {
		System.out.println("Login de Acesso");
		System.out.print("Email:");
		String email = console.nextLine();
		System.out.print("Senha:");
		String senha = console.nextLine();
		senha = this.criptografarSenha(senha);
		System.out.println(senha);
		usuario = controller.login(email,senha);
		if(usuario != null) {
			menu();
		}else {
			login();
		}
	}
	
	public void menu() {
		String opcao = "";
		do {
			System.out.println("Menu");
			System.out.println("1 - Listar Usuario");
			System.out.println("2 - Criar Usuario");
			System.out.println("S - SAIR");
			System.out.print("OPÇÃO: ");
			opcao =	console.nextLine();
			switch (opcao) {
			case "1":
				System.out.println("1 - Listar Usuario");
				List<Usuario> lista = controller.listaUsuario();
				for (Usuario usuario : lista) {
					System.out.println(usuario);
				}
				break;
			case "2":
				if("ADMINISTRADOR".equals(usuario.getPerfil())) {
					System.out.println("2 - Criar Usuario");
					System.out.print("Nome: ");
					String nome =	console.nextLine();
					System.out.print("Email: ");
					String email =	console.nextLine();
					System.out.print("Senha: ");
					String senha =	console.nextLine();
					senha = this.criptografarSenha(senha);
					System.out.print("ADMIN?(S/N)[N]");
					String admin =	console.nextLine();
					Boolean isAdmin = false;
					if(admin.equalsIgnoreCase("S")) {
						isAdmin = true;
					}
					controller.cadastrarUsuario(nome,email,senha,isAdmin);
				} else {
					System.out.println("Apenas Admin");
				}
				
				break;

			default:
				break;
			}
		}while (!opcao.equalsIgnoreCase("S"));
	}
	
	
	public static String criptografarSenha(String senha) {
		MessageDigest md;
		String hash = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] disgest = md.digest();
			hash = DatatypeConverter.printHexBinary(disgest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;

	}
	

}
