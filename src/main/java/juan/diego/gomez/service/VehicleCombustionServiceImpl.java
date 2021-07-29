package juan.diego.gomez.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import juan.diego.gomez.domain.VehicleCombustion;

import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;
import juan.diego.gomez.domain.pieces.Fuel;

@Service
public class VehicleCombustionServiceImpl implements VehicleCombustionService {

	/**
	 * Emulates a database with java hashmap
	 */
	protected static final Map<Long, VehicleCombustion> vehiclesCombustion = new HashMap<>();

	public VehicleCombustionServiceImpl() {

		// demo data

		VehicleCombustion vehicle1 = new VehicleCombustion(1L, "Audi", "Black", 4,
				new Engine(1L, "80-PowerHorse", true), new Battery(1L, true), true,
				new Fuel(1L, 12.5));

		VehicleCombustion vehicle2 = new VehicleCombustion(2L, "Audi", "White", 4,
				new Engine(1L, "90-PowerHorse", true), new Battery(2L, true), true,
				new Fuel(2L, 8.5));

		VehicleCombustion vehicle3 = new VehicleCombustion(3L, "Audi", "Black", 4,
				new Engine(3L, "100-PowerHorse", true), new Battery(3L, true),

				true, new Fuel(3L, 58.5));

		vehiclesCombustion.put(1L, vehicle1);
		vehiclesCombustion.put(2L, vehicle2);
		vehiclesCombustion.put(3L, vehicle3);
	}

	@Override
	public Integer count() {
		return vehiclesCombustion.keySet().size();
	}

	@Override
	public List<VehicleCombustion> findAll() {
		return new ArrayList<>(vehiclesCombustion.values());
	}

	@Override
	public VehicleCombustion findOne(Long id) {
		return vehiclesCombustion.get(id);
	}

	@Override
	public VehicleCombustion save(VehicleCombustion vehicleCombustion) {

		// asignar un id
		if (vehicleCombustion.getId() == null || vehicleCombustion.getId() == 0L) // nuevo smartphone
			vehicleCombustion.setId(getMaxVehicleCombustionId() + 1); // genera id y lo asigna

		// en caso de actualizar primero lo eliminamos
		vehiclesCombustion.remove(vehicleCombustion.getId()); // en caso de que ya exista lo quita para actualizarlo

		// guarda el Vehiculo de combustion en el mapa
		vehiclesCombustion.put(vehicleCombustion.getId(), vehicleCombustion);
		return vehicleCombustion;
	}

	/**
	 * Devuelve el id más alto del mapa Vehiculos de combustion
	 * 
	 * @return
	 */
	protected Long getMaxVehicleCombustionId() {
		if (vehiclesCombustion.isEmpty())
			return 0L;

		return Collections
				.max(vehiclesCombustion.entrySet(), (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey()))
				.getKey();
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !vehiclesCombustion.containsKey(id))
			return false;
		vehiclesCombustion.remove(id);
		return true;
	}

	@Override
	public void deleteAll() {
		if (!vehiclesCombustion.isEmpty())
			vehiclesCombustion.clear();
	}

	@Override
	public VehicleCombustion changeState(Long id) {
		VehicleCombustion combustionCar = this.findOne(id);
		if (combustionCar == null)
			return null;
		boolean actualStateAirConditioner = combustionCar.getAirAconditioner();
		combustionCar.setAirAconditioner(!actualStateAirConditioner);

		boolean actualStateEngine = combustionCar.getEngine().getStatusEngine();
		combustionCar.getEngine().setStatusEngine(!actualStateEngine);

		boolean actualStateBattery = combustionCar.getBattery().getCapacity();
		combustionCar.getBattery().setCapacity(!actualStateBattery);
		return combustionCar;
	}

	// EJEMPLO DE FIND BY NAME PARA ENCONTRAR UNO POR NOMBRE

	@Override
	public List<VehicleCombustion> findByName(String name) {
		List<VehicleCombustion> resultsCombustion = new ArrayList<>();

		for (VehicleCombustion results : vehiclesCombustion.values())
			if (results.getModel().equals(name))
				resultsCombustion.add(results);

		return resultsCombustion;
	}

	// NUMDOORS ATENTO CON EL EQUALS Y EL INTEGER

	@Override
	public List<VehicleCombustion> findByColor(String color) {
		List<VehicleCombustion> resultsCombustion = new ArrayList<>();

		for (VehicleCombustion results : vehiclesCombustion.values())
			if (results.getColor().equals(color))
				resultsCombustion.add(results);

		return resultsCombustion;

	}

	@Override
	public List<VehicleCombustion> findBynumDoors(Integer numDoors) {
		List<VehicleCombustion> resultsCombustion = new ArrayList<>();

		for (VehicleCombustion results : vehiclesCombustion.values())
			if (results.getNumDoors().equals(numDoors))
				resultsCombustion.add(results);

		return resultsCombustion;

	}

}
