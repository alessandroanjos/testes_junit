package br.com.allessandro;

public class Aluno {

	private String nome;
	
	private boolean statusMatricula;

	public boolean isStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(boolean statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void verificaAlunoMatriculado() throws ValidacaoException {
		if (!this.statusMatricula) {
			throw new ValidacaoException("Aluno não matriculado");
		}
	}
}
