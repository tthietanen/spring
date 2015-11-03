package fi.kela.vau.nazz.data;

public class Artifact {
	private int id;
	private String name;
	private String status;

	public Artifact() {
	}

	public Artifact(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Artifact [id=" + id + " name=" + name + " status=" + status
				+ "]";
	}
}
