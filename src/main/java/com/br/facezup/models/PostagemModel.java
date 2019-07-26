package com.br.facezup.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class PostagemModel implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String foto;
	
	@NotNull
	private String usuario;
	
	@NotNull
	private String postagem;

	public PostagemModel() {

	}

	public PostagemModel(String foto, String usuario, String postagem) {
		this.foto = foto;
		this.usuario = usuario;
		this.postagem = postagem;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getPostagem() {
		return postagem;
	}

	public void setPostagem(String postagem) {
		this.postagem = postagem;
	}

	public String getUsuario() {
		return usuario;
	}
    
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder modelo = new StringBuilder();

		modelo.append("Usuario: " +this.usuario);
		modelo.append("\n");
		modelo.append("Postou: "+ this.postagem);

		return super.toString();
	}
}