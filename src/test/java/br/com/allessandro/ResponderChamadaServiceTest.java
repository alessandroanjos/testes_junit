package br.com.allessandro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ResponderChamadaServiceTest extends TesteBase {

	@InjectMocks
	ResponderChamadaService responderChamadaService;

	@Mock
	ChamadaRepository chamadaRepository;
	
	
	Aluno aluno;
	
	Chamada chamada;
	Chamada outraChamada;
	
	@BeforeEach
	void setUp() {
		aluno = new Aluno();
		aluno.setNome("Andressa");
		aluno.setStatusMatricula(true);

		chamada = new Chamada();
		chamada.setAluno(aluno);
		chamada.setPresente(true);
		chamada.setData(LocalDate.now());

		outraChamada = new Chamada();
		outraChamada.setAluno(aluno);
		outraChamada.setPresente(true);
		outraChamada.setData(LocalDate.now());
	}

	@Test
	void shouldSalvarChamada() throws ValidacaoException {

		Mockito.when(chamadaRepository.salvar(chamada)).thenReturn(chamada);

		var resultado = responderChamadaService.apply(chamada);

		// verifica se o metodo chamar está realmente salvando
		verify(chamadaRepository).salvar(chamada);

		assertEquals(resultado.getData(), outraChamada.getData());

	}
	
	@Test
	void shouldVerificarAlunoNaoMatriculado() {
		
		chamada.getAluno().setStatusMatricula(false);
		
		var capturarValidacap = Assertions.assertThrows(ValidacaoException.class, () -> responderChamadaService.apply(chamada));
		
		Assertions.assertEquals("Aluno não matriculado", capturarValidacap.getMessage());	
	}
	
	@Test
	void shouldVerificarDataChamadaInvalida() {
		aluno.setStatusMatricula(false);
		chamada.setAluno(aluno);
		chamada.setData(LocalDate.now().plusDays(1));
		
		var validacao = Assertions.assertThrows(ValidacaoException.class, ()-> responderChamadaService.apply(chamada));
		
		assertNotEquals("Aluno não matriculado", validacao.getMessage());
		
		//Mockito.when(chamadaRepository.salvar(chamada)))
	}
}
