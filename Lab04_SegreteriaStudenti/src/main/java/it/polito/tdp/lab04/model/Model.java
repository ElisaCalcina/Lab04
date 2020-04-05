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
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso){
		CorsoDAO dao= new CorsoDAO();
		return dao.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsiDelloStudente(int matricola){
		StudenteDAO dao= new StudenteDAO();
		return dao.getCorsiDelloStudente(matricola);
	}
	
	public boolean cercaStudenteCorso(Corso corso, int matricola) {
		CorsoDAO dao= new CorsoDAO();
		return dao.cercaStudenteCorso(corso, matricola);
	}

}
