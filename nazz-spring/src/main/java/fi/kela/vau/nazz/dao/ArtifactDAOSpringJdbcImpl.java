package fi.kela.vau.nazz.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.kela.vau.nazz.data.Artifact;

@Repository
public class ArtifactDAOSpringJdbcImpl implements ArtifactDAO {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ArtifactDAOSpringJdbcImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ArtifactDAOSpringJdbcImpl(JdbcTemplate jdbcTemplate) {
		LOGGER.info("contructor Enter");
		this.jdbcTemplate = jdbcTemplate;
		LOGGER.info("contructor Exit");
	}

	public void add(Artifact af) {
		String sql = "INSERT INTO artifact(name, status) VALUES(?,?)";
		Object[] params = new Object[] { af.getName(), af.getStatus() };

		LOGGER.debug(sql + " " + af.getName() + " " + af.getStatus());
		jdbcTemplate.update(sql, params);
	}

	public Artifact search(int id) {
		String sql = "SELECT id, name, status FROM artifact WHERE id = ?";
		Object[] params = new Object[] { id };
		RowMapper<Artifact> mapper = new ArtifactRowMapper();

		LOGGER.debug(sql + " " + id);
		Artifact af = jdbcTemplate.queryForObject(sql, params, mapper);
		return af;
	}

	public List<Artifact> list() {
		String sql = "SELECT id, name, status FROM artifact";
		RowMapper<Artifact> mapper = new ArtifactRowMapper();

		LOGGER.debug(sql);
		List<Artifact> afList = jdbcTemplate.query(sql, mapper);

		return afList;
	}
}
