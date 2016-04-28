package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class Dataconsjugador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private String pasword;
	
	public Dataconsjugador(String nickname, String pasword) {
		super();
		this.nickname = nickname;
		this.pasword = pasword;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPasword() {
		return pasword;
	}

}
