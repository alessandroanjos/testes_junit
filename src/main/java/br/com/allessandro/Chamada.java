package br.com.allessandro;

import java.time.LocalDate;

/**
 * Dominio Chamada
 * 
 * @author allessandroanjos
 *
 */
public class Chamada {

	private Aluno aluno;
	private boolean isPresente;
	private LocalDate data;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isPresente() {
		return isPresente;
	}

	public void setPresente(boolean isPresente) {
		this.isPresente = isPresente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
