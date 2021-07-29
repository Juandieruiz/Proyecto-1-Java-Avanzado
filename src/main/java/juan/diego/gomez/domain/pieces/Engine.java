package juan.diego.gomez.domain.pieces;

public class Engine { // ram

	private Long id;
	private String type;
	private Boolean start = true; // cambiar a false

	public Engine(Long id, String type, Boolean start) {
		super();
		this.id = id;
		this.type = type;
		this.start = start;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getStatusEngine() {
		return start;
	}

	public void setStatusEngine(Boolean start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "Engine [id=" + id + ", type=" + type + ", alimentacion=" + start + ", getId()=" + getId()
				+ ", getType()=" + getType() + ", getStart()=" + getStatusEngine() + "]";
	}

}
