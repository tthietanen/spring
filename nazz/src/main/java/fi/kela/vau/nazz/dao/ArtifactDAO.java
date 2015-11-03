package fi.kela.vau.nazz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.kela.vau.nazz.data.Artifact;

public class ArtifactDAO {
	/**
	 * Konstruktori lataa tietokantayhteyden ajurin
	 */
	public ArtifactDAO() throws DAOException {
		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
		} catch (Exception e) {
			throw new DAOException("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}

	/**
	 * Avaa tietokantayhteyden
	 * 
	 * @return avatun tietokantayhteyden
	 * @throws Exception
	 *             Mikäli yhteyden avaaminen ei onnistu
	 */
	private Connection avaaYhteys() throws DAOException {

		try {
			return DriverManager.getConnection(DBConnectionProperties
					.getInstance().getProperty("url"), DBConnectionProperties
					.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance()
							.getProperty("password"));
		} catch (Exception e) {
			throw new DAOException("Tietokantayhteyden avaaminen epäonnistui",
					e);
		}
	}

	/**
	 * Sulkee tietokantayhteyden
	 * 
	 * @param yhteys
	 *            Suljettava yhteys
	 */
	private void suljeYhteys(Connection yhteys) throws DAOException {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch (Exception e) {
			throw new DAOException(
					"Tietokantayhteys ei jostain syystä suostu menemään kiinni.",
					e);
		}
	}

	public void lisaa(Artifact af) throws DAOException {

		Connection yhteys = avaaYhteys();

		try {
			String sql = "insert into artifact(name,status) values(?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			lause.setString(1, af.getName());
			lause.setString(2, "new");
			lause.executeUpdate();
			System.out.println("LISÄTTIIN HENKILÖ TIETOKANTAAN: " + af);
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOException(
					"Artifactin lisäämisyritys aiheutti virheen", e);
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}
	}

	public List<Artifact> listAll() throws DAOException {
		ArrayList<Artifact> artifactList = new ArrayList<Artifact>();

		Connection conn = avaaYhteys();
		try {
			String sql = "select id, name, status from artifact";
			Statement selectStmt = conn.createStatement();
			ResultSet rs = selectStmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String status = rs.getString("status");

				Artifact af = new Artifact(name, status);
				af.setId(id);
				artifactList.add(af);
			}

		} catch (Exception e) {
			throw new DAOException("DB access error", e);
		} finally {
			suljeYhteys(conn);
		}

		System.out.println("Artifacts from DB: "
				+ artifactList.toString());

		return artifactList;
	}
}
