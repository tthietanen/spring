package fi.kela.vau.nazz.data;

public enum Status {
	NEW("new"), OPEN("open"), CLOSED("closed");

	private final String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return getStatus();
	}
}
