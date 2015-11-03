package fi.kela.vau.nazz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.kela.vau.nazz.data.Artifact;

public class ArtifactRowMapper implements RowMapper<Artifact> {

	public Artifact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Artifact af = new Artifact();
		af.setId(rs.getInt("id"));
		af.setName(rs.getString("name"));
		af.setStatus(rs.getString("status"));

		return af;
	}

}
