package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			Corso c1= new Corso();
			corsi.add(c1);
			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				Corso c= new Corso(codins, numeroCrediti, nome, periodoDidattico);	
				corsi.add(c);
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		final String sql=  "select s.matricola, s.nome, s.cognome, s.CDS " + 
						"from studente as s, iscrizione as i " + 
						"where s.matricola = i.matricola and i.codins = ?";
		
		List<Studente> studenti= new LinkedList<Studente>();
		
		try {
			
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, corso.getCodins()); 
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Studente s= new Studente(rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("CDS"));
				studenti.add(s);
			}
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return studenti;
		
	}
	
	public boolean cercaStudenteCorso(Corso corso, int matricola) {
		final String sql="SELECT matricola FROM iscrizione WHERE matricola =? AND codins=?";
		
		String iscritto="";
		
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setInt(1, matricola);
			st.setString(2, corso.getCodins()); 
			
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				String matricolas= rs.getString("matricola");
				
				iscritto=matricolas;
			}
			
			if(iscritto=="") {
				conn.close();
				return false;
			}else {
				conn.close();
				return true;
			}
		}catch(SQLException e) {
			//throw new RuntimeException(e);
			return false;
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
			// TODO
			// ritorna true se l'iscrizione e' avvenuta con successo
			return false;
	}

}
