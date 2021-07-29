package juan.diego.gomez.domain;

import juan.diego.gomez.domain.pieces.Battery;

import juan.diego.gomez.domain.pieces.Engine;
import juan.diego.gomez.domain.pieces.Fuel;

public class VehicleCombustion extends Vehicle { // smartphone

	// atributo propio
	private Fuel fuel; // CAMERA



	// CONSTRUCTOR DE SUPER CLASE

	
	public VehicleCombustion(Long id, String model, String color, Integer numDoors, Engine engine, Battery battery,
			Boolean airAconditioner, Fuel fuel) {
		super(id, model, color, numDoors, engine, battery, airAconditioner);
		this.fuel = fuel;
	}
	

	// GETTER Y SETTERS DE FUEL

	public Fuel getFuel() {
		return fuel;
	}


	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	@Override
	public String toString() {
		return "VehicleCombustion [getId()=" + getId() + ", getModel()=" + getModel() + ", getColor()=" + getColor()
				+ ", getNumDoors()=" + getNumDoors() + ", getEngine()=" + getEngine() + ", getBattery()=" + getBattery()
				+ ", getAirAconditioner()=" + getAirAconditioner() + ", fuel=" + fuel + ", getFuel()=" + getFuel()
				+ "]";
	}

}
