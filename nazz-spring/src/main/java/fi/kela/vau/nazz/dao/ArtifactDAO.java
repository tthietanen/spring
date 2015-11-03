package fi.kela.vau.nazz.dao;

import java.util.List;

import fi.kela.vau.nazz.data.Artifact;

public interface ArtifactDAO {
	public abstract void add(Artifact af);

	public abstract Artifact search(int id);

	public abstract List<Artifact> list();
}
