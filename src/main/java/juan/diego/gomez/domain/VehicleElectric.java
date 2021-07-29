package juan.diego.gomez.domain;

import juan.diego.gomez.domain.pieces.AutoPilot;
import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;

public class VehicleElectric extends Vehicle { // smartwatch

	// NUEVO ATRIBUTO
	private AutoPilot autoPilot;



	// CONSTRUCTOR DE SUPER CLASE
	public VehicleElectric(Long id, String model, String color, Integer numDoors, Engine engine, Battery battery,
			Boolean airAconditioner, AutoPilot autoPilot) {
		super(id, model, color, numDoors, engine, battery, airAconditioner);
		this.autoPilot = autoPilot;
	}

	public AutoPilot getAutoPilot() {
		return autoPilot;
	}

	public void setAutoPilot(AutoPilot autoPilot) {
		this.autoPilot = autoPilot;
	}

	@Override
	public String toString() {
		return "VehicleElectric [autoPilot=" + autoPilot + ", getAutoPilot()=" + getAutoPilot() + ", getId()=" + getId()
				+ ", getModel()=" + getModel() + ", getColor()=" + getColor() + ", getNumDoors()=" + getNumDoors()
				+ ", getEngine()=" + getEngine() + ", getBattery()=" + getBattery() + ", getAirAconditioner()="
				+ getAirAconditioner() + "]";
	}

	

}
