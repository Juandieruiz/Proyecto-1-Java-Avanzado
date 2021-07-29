package juan.diego.gomez.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import juan.diego.gomez.domain.VehicleHybrid;
import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;
import juan.diego.gomez.domain.pieces.HydrogenTank;

import org.springframework.stereotype.Service;

@Service
public class VehicleHybridServiceImpl implements VehicleHybridService {

	/**
	 * Emulates a database with java hashmap
	 */
	protected static final Map<Long, VehicleHybrid> vehiclesHybrid = new HashMap<>();

	public VehicleHybridServiceImpl() {
		// demo data

		VehicleHybrid vehicle1 = new VehicleHybrid(1L, "BMW", "Black", 4, new Engine(1L, "HybridMotor1", true),
				new Battery(1L, true), true, new HydrogenTank(1L, "capacityTank1", 100));

		VehicleHybrid vehicle2 = new VehicleHybrid(1L, "BMW", "Black", 4, new Engine(1L, "HybridMotor2", true),
				new Battery(1L, true), true, new HydrogenTank(1L, "capacityTank2", 100));

		VehicleHybrid vehicle3 = new VehicleHybrid(1L, "BMW", "White", 4, new Engine(1L, "HybridMotor3", true),
				new Battery(1L, true), true, new HydrogenTank(1L, "capacityTank3", 100));

		vehiclesHybrid.put(1L, vehicle1);
		vehiclesHybrid.put(2L, vehicle2);
		vehiclesHybrid.put(3L, vehicle3);
	}

	@Override
	public Integer count() {
		return vehiclesHybrid.keySet().size();
	}

	@Override
	public List<VehicleHybrid> findAll() {
		return new ArrayList<>(vehiclesHybrid.values());
	}

	@Override
	public VehicleHybrid findOne(Long id) {
		return vehiclesHybrid.get(id);
	}

	@Override
	public VehicleHybrid save(VehicleHybrid vehicleHybrid) {

		if (vehicleHybrid.getId() == null || vehicleHybrid.getId() == 0L) // nuevo smartphone
			vehicleHybrid.setId(getMaxVehicleHybridId() + 1);

		vehiclesHybrid.remove(vehicleHybrid.getId()); // en caso de que ya exista lo quita para actualizarlo

		vehiclesHybrid.put(vehicleHybrid.getId(), vehicleHybrid);
		return vehicleHybrid;
	}

	protected Long getMaxVehicleHybridId() {
		return Collections.max(vehiclesHybrid.entrySet(), (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey()))
				.getKey();
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !vehiclesHybrid.containsKey(id))
			return false;
		vehiclesHybrid.remove(id);
		return true;
	}

	@Override
	public void deleteAll() {
		if (!vehiclesHybrid.isEmpty())
			vehiclesHybrid.clear();
	}

	@Override
	public VehicleHybrid changeState(Long id) {
		VehicleHybrid hybrid = this.findOne(id);
		if (hybrid == null)
			return null;
		boolean actualStateAirConditioner = hybrid.getAirAconditioner();
		hybrid.setAirAconditioner(!actualStateAirConditioner);

		boolean actualStateEngine = hybrid.getEngine().getStatusEngine();
		hybrid.getEngine().setStatusEngine(!actualStateEngine);

		boolean actualStateBattery = hybrid.getBattery().getCapacity();
		hybrid.getBattery().setCapacity(!actualStateBattery);
		return hybrid;
	}
	// EJEMPLO DE FIND BY NAME PARA ENCONTRAR UNO POR NOMBRE

	@Override
	public List<VehicleHybrid> findByName(String name) {
		List<VehicleHybrid> resultHybrid = new ArrayList<>();

		for (VehicleHybrid results : vehiclesHybrid.values())
			if (results.getModel().equals(name))
				resultHybrid.add(results);

		return resultHybrid;
	}

	// NUMDOORS ATENTO CON EL EQUALS Y EL INTEGER

	@Override
	public List<VehicleHybrid> findByColor(String color) {
		List<VehicleHybrid> resultHybrid = new ArrayList<>();

		for (VehicleHybrid results : vehiclesHybrid.values())
			if (results.getColor().equals(color))
				resultHybrid.add(results);

		return resultHybrid;

	}

	@Override
	public List<VehicleHybrid> findBynumDoors(Integer numDoors) {
		List<VehicleHybrid> resultHybrid = new ArrayList<>();

		for (VehicleHybrid results : vehiclesHybrid.values())
			if (results.getNumDoors().equals(numDoors))
				resultHybrid.add(results);

		return resultHybrid;

	}

}
