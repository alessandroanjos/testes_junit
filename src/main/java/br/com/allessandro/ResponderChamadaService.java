package br.com.allessandro;

/**
 * Registra a chamada de um aluno.
 * @author allessandroanjos
 *
 */
public class ResponderChamadaService {

	private ChamadaRepository chamadaRepository;

	public ResponderChamadaService(ChamadaRepository chamadaRepository) {
		this.chamadaRepository = chamadaRepository;
	}
	
	
	public Chamada apply(Chamada chamada) throws ValidacaoException {
		chamada.getAluno().verificaAlunoMatriculado();
		
		var chamadaSalva = chamadaRepository.salvar(chamada);
		return chamadaSalva;
	}
}
