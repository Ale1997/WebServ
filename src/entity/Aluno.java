package entity;

import java.io.Serializable;

public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idAluno;
	private String nome;
	private String email;
	
	public Aluno() {
	}
	
	public Aluno(Integer idAluno, String nome, String email) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", email=" + email + "]";
	}

	public Integer getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
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
	

}
