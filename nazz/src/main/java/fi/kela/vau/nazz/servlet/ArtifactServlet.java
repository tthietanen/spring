package fi.kela.vau.nazz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.kela.vau.nazz.dao.ArtifactDAO;
import fi.kela.vau.nazz.dao.DAOException;
import fi.kela.vau.nazz.data.Artifact;

@WebServlet("/artifacts")
public class ArtifactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArtifactServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Artifact> artifacts;

		try {
			ArtifactDAO artifactDAO = new ArtifactDAO();
			artifacts = artifactDAO.listAll();
		} catch (DAOException e) {
			throw new ServletException(e);
		}

		request.setAttribute("artifacts", artifacts);
		request.getRequestDispatcher("WEB-INF/jsp/artifacts.jsp").forward(
				request, response);
	}

}
