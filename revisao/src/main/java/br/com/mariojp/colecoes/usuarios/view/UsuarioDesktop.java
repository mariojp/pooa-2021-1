package br.com.mariojp.colecoes.usuarios.view;

import javax.swing.JFrame;

import br.com.mariojp.colecoes.usuarios.controller.UsuarioController;

public class UsuarioDesktop extends JFrame{

	private UsuarioController controller;

	//Injecao de Dependencia
	public UsuarioDesktop(UsuarioController controller) {
		super("SISTEMA DE USUARIOS");
		this.controller = controller;
		setSize(300,400);
		setVisible(true);
	}

	
}
