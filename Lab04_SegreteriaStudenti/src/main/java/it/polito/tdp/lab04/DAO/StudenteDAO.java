package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public List<Studente> getStudenti(int matricola){
		final String sql= "select * from studente where matricola = ?";
		
		List<Studente> studenti = new LinkedList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricolas = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");
				
				System.out.println(matricolas + " " + cognome + " " + nome + " " + CDS);
				
				// Crea un nuovo JAVA Bean Studente
				// Aggiungi il nuovo oggetto Studente alla lista studenti
				Studente s= new Studente(matricolas, cognome, nome, CDS);
				studenti.add(s);
			}

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public List<Corso> getCorsiDelloStudente(int matricola){
		final String sql = "SELECT c.codins, c.crediti, c.nome, c.pd FROM corso AS c, iscrizione AS i WHERE c.codins = i.codins AND i.matricola=?";

		
		List<Corso> corsi= new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins=rs.getString("codins");
				Integer crediti= rs.getInt("crediti");
				String nome= rs.getString("nome");
				Integer pd= rs.getInt("pd");
				
				Corso c= new Corso(codins, crediti, nome, pd);
				corsi.add(c);
				
			}
			conn.close();
			
			return corsi;
			
		}catch(SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
		
	}
		
	
}
