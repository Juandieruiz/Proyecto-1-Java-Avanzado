package juan.diego.gomez.domain.pieces;

public class Battery {
	
	private Long id;
	private boolean capacity; // Voltios
	public Battery(Long id, boolean capacity) {
		this.id = id;
		this.capacity = capacity;
	}
	public Long getId() {
		return id;
	}
	public boolean getCapacity() {
		return capacity;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCapacity(boolean actualStateBattery) {
		this.capacity = actualStateBattery;
	}
	@Override
	public String toString() {
		return "Battery [id=" + id + ", capacity=" + capacity + "]";
	}
	
	

}
