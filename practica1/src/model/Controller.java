package model;

import model.Usuario;

public abstract class Controller {
	protected Usuario usuario;
	public Controller(Usuario usuario){
		this.usuario=usuario;
	}
	
}
