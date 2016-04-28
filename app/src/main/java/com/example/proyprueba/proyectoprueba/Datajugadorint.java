package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class Datajugadorint implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nickname;
	private String pasword;
	private int numPreg;
	public Datajugadorint(String nickname, String pasword, int numPreg) {
		super();
		this.nickname = nickname;
		this.pasword = pasword;
		this.numPreg = numPreg;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPasword() {
		return pasword;
	}
	public int getNumPreg() {
		return numPreg;
	}
	
	
}
