package br.com.allessandro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

/**
 * Classe base para configurar o Junit/Mockito para o uso nos testes. 
 * 
 * @author allessandroanjos
 *
 */
public class TesteBase {

	private AutoCloseable closeable;
	
	@BeforeEach
	public void openMocks() {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void releaseMocks() throws Exception {
		closeable.close();
	}
}
