package fi.kela.vau.nazz.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super("Tietokantapoikkeus");
	}

	
	public DAOException(String viesti) {
		super(viesti);
	}

	public DAOException(Throwable aiheuttaja) {
		super(aiheuttaja);
	}

	public DAOException(String viesti, Throwable aiheuttaja) {
		super(viesti, aiheuttaja);
	}

}
