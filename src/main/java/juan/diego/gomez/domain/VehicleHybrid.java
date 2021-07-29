package juan.diego.gomez.domain;

import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;
import juan.diego.gomez.domain.pieces.HydrogenTank;

public class VehicleHybrid extends Vehicle {

	private HydrogenTank hydrogenTank;



	public VehicleHybrid(Long id, String model, String color, Integer numDoors, Engine engine, Battery battery,
			Boolean airAconditioner, HydrogenTank hydrogenTank) {
		super(id, model, color, numDoors, engine, battery, airAconditioner);
this.hydrogenTank = hydrogenTank;
	}

	public HydrogenTank getHydrogenTank() {
		return hydrogenTank;
	}

	public void setHydrogenTank(HydrogenTank hydrogenTank) {
		this.hydrogenTank = hydrogenTank;
	}

	@Override
	public String toString() {
		return "VehicleHybrid [hydrogenTank=" + hydrogenTank + ", getHydrogenTank()=" + getHydrogenTank() + ", getId()="
				+ getId() + ", getModel()=" + getModel() + ", getColor()=" + getColor() + ", getNumDoors()="
				+ getNumDoors() + ", getEngine()=" + getEngine() + ", getBattery()=" + getBattery()
				+ ", getAirAconditioner()=" + getAirAconditioner() + "]";
	}

}
