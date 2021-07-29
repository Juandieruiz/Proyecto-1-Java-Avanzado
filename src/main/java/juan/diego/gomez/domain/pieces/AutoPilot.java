package juan.diego.gomez.domain.pieces;

public class AutoPilot { // HEALTHMONITOR

	private Long id;
	private Double automaticTime; //sleep and blood

	public AutoPilot(Long id, double automaticTime) {
		super();
		this.id = id;
		this.automaticTime = automaticTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAutomaticTime() {
		return automaticTime;
	}

	public void setAutomaticTime(Double automaticTime) {
		this.automaticTime = automaticTime;
	}

	@Override
	public String toString() {
		return "AutoPilot [id=" + id + ", automaticTime=" + automaticTime + ", getId()=" + getId()
				+ ", getAutomaticTime()=" + getAutomaticTime() + "]";
	}

}
