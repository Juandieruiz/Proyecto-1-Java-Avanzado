package juan.diego.gomez.domain.pieces;

public class Fuel { // TANQUE DE COMBUSTIBLE CAMERA

	private Long id;
	private Double capacity; // CAPACIDAD TANQUE COMBUSTIBLE megapixels

	public Fuel(Long id, Double capacity) {
		this.id = id;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Fuel [id=" + id + ", capacity=" + capacity + ", getId()=" + getId() + ", getCapacity()=" + getCapacity()
				+ "]";
	}

	

}
