package com.pgrsoft.gestionmultas.services;

import java.util.List;

import com.pgrsoft.gestionmultas.model.Agente;
import com.pgrsoft.gestionmultas.model.Multa;

public interface MultaServices {

	/**
	 * 
	 * Se crea una multa con un nuevo código
	 * 
	 * @param multa
	 * @return
	 */
	public Multa create(Multa multa);
	
	public Multa read(Long codigo);
	
	public void delete(Long codigo);
	
	public List<Multa> getAll();
	public List<Multa> getByAgente(Agente agente);
	
	
}
