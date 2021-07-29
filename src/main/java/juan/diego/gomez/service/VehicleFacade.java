package juan.diego.gomez.service;

import juan.diego.gomez.domain.Vehicle;
import juan.diego.gomez.domain.VehicleCombustion;
import juan.diego.gomez.domain.VehicleElectric;
import juan.diego.gomez.domain.VehicleHybrid;
import juan.diego.gomez.domain.pieces.AutoPilot;
import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;
import juan.diego.gomez.domain.pieces.Fuel;
import juan.diego.gomez.domain.pieces.HydrogenTank;

public class VehicleFacade {

	private VehicleFacade() {
	}
	
	
	//m2 junit
	
	public static Vehicle createVehicleCombustion() {
// pieces vehicles
		Battery battery = new Battery(1L, true);
		Engine engine = new Engine(1L, "70-HorsePower", true);
		// exclusive pieces combustion car
		Fuel fuel = new Fuel(1L, 0.0);

		// EJEMPLO DE COMO HACE LA CREACION DEL VEHICULO
		VehicleCombustion vehicleCombustion = new VehicleCombustion(1L, "Default vehicle1", "Default color1", 4, engine,
				battery, true, fuel);
		vehicleCombustion.getEngine().getStatusEngine();

		return vehicleCombustion;
	}

	public static Vehicle createVehicleElectric() {
		// pieces vehicles
		Battery battery = new Battery(1L,true);
		Engine engine = new Engine(1L, "80-kWh", true);
		// exclusive pieces electric car
		AutoPilot autoPilot = new AutoPilot(1L, 0.0);

		// LINEA RESUMIDA DE COMO SE HACE LA CREACION DEL VEHICULO
		return new VehicleElectric(1L, "Default vehicle2", "Default color2", 4, engine, battery, true, autoPilot);
	}

	public static Vehicle createVehicleHybrid() {
		// pieces vehicles
		Battery battery = new Battery(1L, true);
		Engine engine = new Engine(1L, "70-PowerHour", true);
		// exclusive pieces hybrid car
		HydrogenTank hydrogenTank = new HydrogenTank(1L, "capacity tank", 10);

		return new VehicleHybrid(1L, "Default vehicle3", "Default color3", 4, engine, battery, true, hydrogenTank);
	}
}
