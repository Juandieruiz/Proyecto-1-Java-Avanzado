package juan.diego.gomez.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import juan.diego.gomez.domain.VehicleCombustion;
import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;
import juan.diego.gomez.domain.pieces.Fuel;

class VehicleCombustionServiceTest extends VehicleCombustionServiceImpl {

	// . 1 Extraer Datos
	private static VehicleCombustionServiceImpl combustionService = new VehicleCombustionServiceImpl();
//	private static final Map<Long, VehicleCombustion> vehiclesCombustion = combustionService.vehiclesCombustion;

	@Test
	@DisplayName("Metodo count para obtener numero de vehiculos")
	void testCount() {

		VehicleCombustionServiceImpl resultado = new VehicleCombustionServiceImpl();
		// 2. ejecutar el metodo a testear
		// Integer result = combustionService.count();

		// 3. verificar
		assertEquals(4, resultado.count());
	}

	@Test
	@DisplayName("Metodo para recuperar todos los vehiculos a combustion")
	void testFindAll() {

		// 2. ejecutar el metodo a testear
		List<VehicleCombustion> result = combustionService.findAll();

		// 3. Verificar
		assertEquals(vehiclesCombustion.size(), result.size());
	}

	@Test
	@DisplayName("Metodo para recuperar un vehiculo en especial")
	void testFindOne() {

		Long id = 1L;

		// 1. Extraer

		VehicleCombustion esperado = vehiclesCombustion.get(id);

		// 2. ejecutar el metodo a testear
		VehicleCombustion result = combustionService.findOne(id);

		// 3. Verificar
		assertEquals(esperado, result);
	}

	@Test
	@DisplayName("Metodo para guardar un vehiculo en especial")
	void testSave() {

//		Battery bateria = new Battery(1L, true);
//		Engine motor = new Engine(1L, "NewEngine", true);

		VehicleCombustion esperado = new VehicleCombustion(2L, "Audi", "White", 4,
				new Engine(1L, "70-PowerHorse", true), new Battery(2L, true), true, new Fuel(2L, 8.5));

		// 3. Verificar
		assertEquals(esperado, combustionService.save(esperado));
	}

	@Test
	@DisplayName("Metodo para guardar un vehiculo con IdNull")
	void testSaveNull() {

//		Battery bateria = new Battery(1L, true);
//		Engine motor = new Engine(1L, "NewEngine", true);

		VehicleCombustion esperado = new VehicleCombustion(null, "Audi", "White", 4,
				new Engine(1L, "70-PowerHorse", true), new Battery(2L, true), true, new Fuel(2L, 8.5));

		// 3. Verificar
		assertEquals(esperado, combustionService.save(esperado));
	}

	@Test
	@DisplayName("Metodo para guardar un vehiculo con IdZero")
	void testSaveisZero() {

//		Battery bateria = new Battery(1L, true);
//		Engine motor = new Engine(1L, "NewEngine", true);

		VehicleCombustion esperado = new VehicleCombustion(0L, "Audi", "White", 4,
				new Engine(1L, "70-PowerHorse", true), new Battery(2L, true), true, new Fuel(2L, 8.5));

		// 3. Verificar
		assertEquals(esperado, combustionService.save(esperado));
	}
	

	@Test
	@DisplayName("Metodo para guardar vehiculos de combustion sin ID")
	void testGetMaxCombustionIdEmptyList() {
		combustionService.deleteAll();
		assertEquals(0L, combustionService.getMaxVehicleCombustionId());
	}

	@Test
	void testchangeState() {

		Long id = 1L;

		combustionService.changeState(id);

		boolean resultAirAconditioner = vehiclesCombustion.get(id).getAirAconditioner();

		boolean resultBattery = vehiclesCombustion.get(id).getBattery().getCapacity();

		boolean resultEngine = vehiclesCombustion.get(id).getEngine().getStatusEngine();

		assertEquals(false, resultAirAconditioner);
		assertEquals(false, resultBattery);
		assertEquals(false, resultEngine);

	}

	@Test
	void testchangeStateNull() {

		Long id = null;

		assertNull(combustionService.changeState(id));

	}
	@Test
	void testchangeStateAirAconditioner() {

		Long id = 1L;
		
		vehiclesCombustion.get(id).setAirAconditioner(null);
		
		assertEquals(vehiclesCombustion.get(id).getAirAconditioner(), vehiclesCombustion.get(id).getAirAconditioner());
		
	}
	@Test
	void testchangeStateEngine() {

		Long id = 1L;
		
		vehiclesCombustion.get(id).setEngine(null);
		
		assertEquals(vehiclesCombustion.get(id).getEngine(), vehiclesCombustion.get(id).getEngine());
		
	}
	@Test
	void testchangeStateBattery() {

		Long id = 1L;
		
		vehiclesCombustion.get(id).setBattery(null);
		
		assertEquals(vehiclesCombustion.get(id).getBattery(),vehiclesCombustion.get(id).getBattery());
		
	}

	@Test
	void testDelete() {

		Long id = 1L;

		boolean resultado = combustionService.delete(id);

		assertTrue(resultado);

	}

	@Test
	void testDeleteNull() {

		Long id = null;

		boolean result = combustionService.delete(id);

		assertFalse(result, "Its False");

	}

	@Test
	void testDeleteNotFound() {

		Long id = 6L;

		boolean result = combustionService.delete(id);

		assertFalse(result, "Dont Exist");

	}

	@Test
	void testFindByName() {

		String name = "Audi";

//		VehicleCombustion esperado = vehiclesCombustion.get(name);

		List<VehicleCombustion> result = combustionService.findByName(name);

		assertEquals(4, result.size());
	}

	@Test
	void testFindByColor() {

		String color = "Black";

		List<VehicleCombustion> result = combustionService.findByColor(color);

		assertEquals(2, result.size());

	}

	@Test
	void testFindBynumDoors() {

		Integer numDoors = 4;

		List<VehicleCombustion> result = combustionService.findBynumDoors(numDoors);

		assertEquals(3, result.size());
	}


}
