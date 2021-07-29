package juan.diego.gomez.domain;

import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;

public abstract class Vehicle { // smartdevice

	private Long id;
	private String model;
	private String color;
	private Integer numDoors;
	private Engine engine;
	private Battery battery;
	private Boolean airAconditioner; // WIFI



	protected Vehicle(Long id, String model, String color, Integer numDoors, Engine engine, Battery battery,
			Boolean airAconditioner) {
		super();
		this.id = id;
		this.model = model;
		this.color = color;
		this.numDoors = numDoors;
		this.engine = engine;
		this.battery = battery;
		this.airAconditioner = airAconditioner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getNumDoors() {
		return numDoors;
	}

	public void setNumDoors(Integer numDoors) {
		this.numDoors = numDoors;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}


	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public Boolean getAirAconditioner() {
		return airAconditioner;
	}

	public void setAirAconditioner(Boolean airAconditioner) {
		this.airAconditioner = airAconditioner;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", color=" + color + ", numDoors=" + numDoors + ", engine="
				+ engine + ", battery=" + battery + ", airAconditioner=" + airAconditioner + "]";
	}

}
