package br.com.allessandro;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsalvel por salvar o objeto Chamada
 * 
 * @author allessandroanjos
 *
 */
public class ChamadaRepository {

	private List<Chamada> chamadas = new ArrayList<Chamada>();

	public Chamada salvar(Chamada chamada) {
		chamadas.add(chamada);

		return chamada;
	}

}
