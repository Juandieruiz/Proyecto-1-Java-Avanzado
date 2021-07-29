package juan.diego.gomez.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import juan.diego.gomez.domain.VehicleElectric;
import juan.diego.gomez.domain.pieces.AutoPilot;
import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;

@Service
public class VehicleElectricServiceImpl implements VehicleElectricService {

	/**
	 * Emulates a database with java hashmap
	 */
	protected static final Map<Long, VehicleElectric> vehiclesElectric = new HashMap<>();

	public VehicleElectricServiceImpl() {
		// demo data

		VehicleElectric vehicleElectric1 = new VehicleElectric(1L, "Tesla X", "Black", 2, new Engine(1L, "100Kv", true),
				new Battery(1L, true), true, new AutoPilot(1L, 0.0));

		VehicleElectric vehicleElectric2 = new VehicleElectric(2L, "Tesla X", "Black", 4,
				new Engine(2L, "120Kv", true), new Battery(2L, true), true, new AutoPilot(2L, 0.0));

		VehicleElectric vehicleElectric3 = new VehicleElectric(3L, "Tesla Momentum", "White", 4,
				new Engine(3L, "140Kv", true), new Battery(3L, true), true, new AutoPilot(3L, 0.0));

		vehiclesElectric.put(1L, vehicleElectric1);
		vehiclesElectric.put(2L, vehicleElectric2);
		vehiclesElectric.put(3L, vehicleElectric3);
	}

	@Override
	public Integer count() {
		return vehiclesElectric.keySet().size();
	}

	@Override
	public List<VehicleElectric> findAll() {
		return new ArrayList<>(vehiclesElectric.values());
	}

	@Override
	public VehicleElectric findOne(Long id) {
		return vehiclesElectric.get(id);
	}

	@Override
	public VehicleElectric save(VehicleElectric vehicleElectric) {

		if (vehicleElectric.getId() == null || vehicleElectric.getId() == 0L) // nuevo smartphone
			vehicleElectric.setId(getVehicleElectricId() + 1);

		vehiclesElectric.remove(vehicleElectric.getId()); // en caso de que ya exista lo quita para actualizarlo

		vehiclesElectric.put(vehicleElectric.getId(), vehicleElectric);
		return vehicleElectric;
	}

	protected Long getVehicleElectricId() {
		return Collections
				.max(vehiclesElectric.entrySet(), (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey()))
				.getKey();
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !vehiclesElectric.containsKey(id))
			return false;
		vehiclesElectric.remove(id);
		return true;
	}

	@Override
	public void deleteAll() {
		if (!vehiclesElectric.isEmpty())
			vehiclesElectric.clear();
	}

	@Override
	public VehicleElectric changeState(Long id) {
		VehicleElectric electric = this.findOne(id);
		if (electric == null)
			return null;
		boolean actualStateAirConditioner = electric.getAirAconditioner();
		electric.setAirAconditioner(!actualStateAirConditioner);

		boolean actualStateEngine = electric.getEngine().getStatusEngine();
		electric.getEngine().setStatusEngine(!actualStateEngine);

		boolean actualStateBattery = electric.getBattery().getCapacity();
		electric.getBattery().setCapacity(!actualStateBattery);
		return electric;
	}

	// EJEMPLO DE FIND BY NAME PARA ENCONTRAR UNO POR NOMBRE

	@Override
	public List<VehicleElectric> findByName(String name) {
		List<VehicleElectric> resultsElectric = new ArrayList<>();

		for (VehicleElectric results : vehiclesElectric.values())
			if (results.getModel().equals(name))
				resultsElectric.add(results);

		return resultsElectric;
	}

// NUMDOORS ATENTO CON EL EQUALS Y EL INTEGER

	@Override
	public List<VehicleElectric> findByColor(String color) {
		List<VehicleElectric> resultsElectric = new ArrayList<>();

		for (VehicleElectric results : vehiclesElectric.values())
			if (results.getColor().equals(color))
				resultsElectric.add(results);

		return resultsElectric;

	}
	
	@Override
	public List<VehicleElectric> findBynumDoorsElectrics(Integer numDoors) {
		List<VehicleElectric> resultsElectric = new ArrayList<>();

		for (VehicleElectric results : vehiclesElectric.values())
			if (results.getNumDoors().equals(numDoors))
				resultsElectric.add(results);

		return resultsElectric;

	}
	
	
	
}
