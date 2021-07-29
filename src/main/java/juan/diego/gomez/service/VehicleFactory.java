package juan.diego.gomez.service;

import juan.diego.gomez.domain.Vehicle;

public class VehicleFactory {

	private static final String COMBUSTION = "combustionCar";
	private static final String ELECTRIC = "electricCar";
	private static final String HYBRID = "electricHybrid";

	private VehicleFactory() {
	}

	public static Vehicle createByType(String type) {

		return switch (type) {
		case COMBUSTION -> VehicleFacade.createVehicleCombustion();
		case ELECTRIC -> VehicleFacade.createVehicleElectric();
		case HYBRID -> VehicleFacade.createVehicleHybrid();
		default -> throw new IllegalArgumentException("No existe tipo de coche ");
		};
	}

}