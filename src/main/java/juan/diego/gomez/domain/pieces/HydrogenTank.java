package juan.diego.gomez.domain.pieces;

public class HydrogenTank {
		
	Long id;
	private String type;
	private Integer capacity;
	public HydrogenTank(Long id, String type, Integer capacity) {
		super();
		this.id = id;
		this.type = type;
		this.capacity = capacity;
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "HydrogenTank [id=" + id + ", type=" + type + ", capacity=" + capacity + ", getId()=" + getId()
				+ ", getType()=" + getType() + ", getCapacity()=" + getCapacity() + "]";
	}
	
	
}
