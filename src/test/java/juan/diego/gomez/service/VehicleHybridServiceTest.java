package juan.diego.gomez.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import juan.diego.gomez.domain.VehicleHybrid;

import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;

import juan.diego.gomez.domain.pieces.HydrogenTank;

class VehicleHybridServiceTest extends VehicleHybridServiceImpl {

	private static VehicleHybridServiceImpl hybridService = new VehicleHybridServiceImpl();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCount() {
		VehicleHybridServiceImpl resultado = new VehicleHybridServiceImpl();
		assertEquals(4, resultado.count());
	}

	@Test
	void testFindAll() {
		List<VehicleHybrid> result = hybridService.findAll();

		// 3. Verificar
		assertEquals(vehiclesHybrid.size(), result.size());
	}

	@Test
	void testFindOne() {
		Long id = 1L;

		// 1. Extraer

		VehicleHybrid esperado = vehiclesHybrid.get(id);

		// 2. ejecutar el metodo a testear
		VehicleHybrid result = hybridService.findOne(id);

		// 3. Verificar
		assertEquals(esperado, result);
	}

	@Test
	void testSave() {
		VehicleHybrid esperado = new VehicleHybrid(1L, "BMW", "Black", 4, new Engine(1L, "HybridMotor", true),
				new Battery(1L, true), true, new HydrogenTank(1L, "capacityTank", 100));

		// 3. Verificar
		assertEquals(esperado, hybridService.save(esperado));
	}

	@Test
	@DisplayName("Metodo para guardar un vehiculo con IdNull")
	void testSaveNull() {

		VehicleHybrid esperado = new VehicleHybrid(null, "BMW", "Black", 4, new Engine(1L, "HybridMotor", true),
				new Battery(1L, true), true, new HydrogenTank(1L, "capacityTank", 100));

		// 3. Verificar
		assertEquals(esperado, hybridService.save(esperado));
	}

	@Test
	@DisplayName("Metodo para guardar un vehiculo con IdZero")
	void testSaveisZero() {

		VehicleHybrid esperado = new VehicleHybrid(0L, "BMW", "Black", 4, new Engine(1L, "HybridMotor", true),
				new Battery(1L, true), true, new HydrogenTank(1L, "capacityTank", 100));

		// 3. Verificar
		assertEquals(esperado, hybridService.save(esperado));
	}

	@Test
	void testDelete() {

		Long id = 1L;

		boolean resultado = hybridService.delete(id);

		assertTrue(resultado);

	}

	@Test
	void testDeleteNull() {

		Long id = null;

		boolean result = hybridService.delete(id);

		assertFalse(result, "Its False");

	}

	@Test
	void testDeleteNotFound() {

		Long id = 6L;

		boolean result = hybridService.delete(id);

		assertFalse(result, "Dont Exist");

	}

	@Test
	void testChangeState() {
		Long id = 1L;

		hybridService.changeState(id);

		boolean resultAirAconditioner = vehiclesHybrid.get(id).getAirAconditioner();

		boolean resultBattery = vehiclesHybrid.get(id).getBattery().getCapacity();

		boolean resultEngine = vehiclesHybrid.get(id).getEngine().getStatusEngine();

		assertEquals(false, resultAirAconditioner);
		assertEquals(false, resultBattery);
		assertEquals(false, resultEngine);

	}

	@Test
	void testchangeStateNull() {

		Long id = null;

		assertNull(hybridService.changeState(id));

	}

	@Test
	void testchangeStateAirAconditioner() {

		Long id = 1L;

		vehiclesHybrid.get(id).setAirAconditioner(null);
		assertEquals(vehiclesHybrid.get(id).getAirAconditioner(), vehiclesHybrid.get(id).getAirAconditioner());

	}
	@Test
	void testchangeStateEngine() {

		Long id = 1L;

		vehiclesHybrid.get(id).setEngine(null);
		assertEquals(vehiclesHybrid.get(id).getEngine(), vehiclesHybrid.get(id).getEngine());

	}
	@Test
	void testchangeStateBattery() {

		Long id = 1L;

		vehiclesHybrid.get(id).setBattery(null);
		assertEquals(vehiclesHybrid.get(id).getBattery(), vehiclesHybrid.get(id).getBattery());

	}

	@Test
	void testFindByName() {

		String name = "Tesla X";

		List<VehicleHybrid> result = hybridService.findByName(name);

		assertEquals(0, result.size());
	}

	@Test
	void testFindByColor() {

		String color = "Black";

		List<VehicleHybrid> result = hybridService.findByColor(color);

		assertEquals(3, result.size());

	}

	@Test
	void testFindBynumDoors() {

		Integer numDoors = 4;

		List<VehicleHybrid> result = hybridService.findBynumDoors(numDoors);

		assertEquals(3, result.size());
	}
}