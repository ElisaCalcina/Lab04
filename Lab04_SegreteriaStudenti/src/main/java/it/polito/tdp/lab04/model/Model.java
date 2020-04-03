package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	public List<Corso> getTuttiICorsi(){
		CorsoDAO dao= new CorsoDAO();
		return dao.getTuttiICorsi();
	}
	
	public List<Studente> getStudenti(int matricola){
		StudenteDAO dao= new StudenteDAO();
		return dao.getStudenti(matricola);
	}

}
