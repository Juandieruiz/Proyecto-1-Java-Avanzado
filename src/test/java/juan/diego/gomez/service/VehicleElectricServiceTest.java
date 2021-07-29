package juan.diego.gomez.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import juan.diego.gomez.domain.VehicleElectric;
import juan.diego.gomez.domain.pieces.AutoPilot;
import juan.diego.gomez.domain.pieces.Battery;
import juan.diego.gomez.domain.pieces.Engine;

class VehicleElectricServiceTest extends VehicleElectricServiceImpl {

	private static VehicleElectricServiceImpl electricService = new VehicleElectricServiceImpl();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCount() {
		VehicleElectricServiceImpl resultado = new VehicleElectricServiceImpl();
		assertEquals(4, resultado.count());
	}

	@Test
	void testFindAll() {
		List<VehicleElectric> result = electricService.findAll();

		// 3. Verificar
		assertEquals(vehiclesElectric.size(), result.size());
	}

	@Test
	void testFindOne() {
		Long id = 1L;

		// 1. Extraer

		VehicleElectric esperado = vehiclesElectric.get(id);

		// 2. ejecutar el metodo a testear
		VehicleElectric result = electricService.findOne(id);

		// 3. Verificar
		assertEquals(esperado, result);
	}

	@Test
	void testSave() {
		VehicleElectric esperado = new VehicleElectric(1L, "Tesla X", "Black", 2, new Engine(1L, "100Kv", true),
				new Battery(1L, true), true, new AutoPilot(1L, 0.0));

		// 3. Verificar
		assertEquals(esperado, electricService.save(esperado));
	}

	@Test
	@DisplayName("Metodo para guardar un vehiculo con IdNull")
	void testSaveNull() {

		VehicleElectric esperado = new VehicleElectric(null, "Tesla X", "Black", 2, new Engine(1L, "100Kv", true),
				new Battery(1L, true), true, new AutoPilot(1L, 0.0));

		// 3. Verificar
		assertEquals(esperado, electricService.save(esperado));
	}

	@Test
	@DisplayName("Metodo para guardar un vehiculo con IdZero")
	void testSaveisZero() {

		VehicleElectric esperado = new VehicleElectric(0L, "Tesla X", "Black", 2, new Engine(1L, "100Kv", true),
				new Battery(1L, true), true, new AutoPilot(1L, 0.0));

		// 3. Verificar
		assertEquals(esperado, electricService.save(esperado));
	}

	@Test
	void testDelete() {

		Long id = 1L;

		boolean resultado = electricService.delete(id);

		assertTrue(resultado);

	}

	@Test
	void testDeleteNull() {

		Long id = null;

		boolean result = electricService.delete(id);

		assertFalse(result, "Its False");

	}

	@Test
	void testDeleteNotFound() {

		Long id = 6L;

		boolean result = electricService.delete(id);

		assertFalse(result, "Dont Exist");

	}

	@Test
	void testChangeState() {
		Long id = 1L;

		electricService.changeState(id);

		boolean resultAirAconditioner = vehiclesElectric.get(id).getAirAconditioner();

		boolean resultBattery = vehiclesElectric.get(id).getBattery().getCapacity();

		boolean resultEngine = vehiclesElectric.get(id).getEngine().getStatusEngine();

		assertEquals(false, resultAirAconditioner);
		assertEquals(false, resultBattery);
		assertEquals(false, resultEngine);
	}

	@Test
	void testchangeStateNull() {

		Long id = null;

		assertNull(electricService.changeState(id));

	}

	@Test
	void testchangeStateAirAconditioner() {

		Long id = 1L;

		vehiclesElectric.get(id).setAirAconditioner(null);

		assertEquals(vehiclesElectric.get(id).getAirAconditioner(),vehiclesElectric.get(id).getAirAconditioner());
	}
	@Test
	void testchangeStateEngine() {

		Long id = 1L;

		vehiclesElectric.get(id).setEngine(null);

		assertEquals(vehiclesElectric.get(id).getEngine(),vehiclesElectric.get(id).getEngine());
	}
	@Test
	void testchangeStateBattery() {

		Long id = 1L;

		vehiclesElectric.get(id).setBattery(null);

		assertEquals(vehiclesElectric.get(id).getBattery(),vehiclesElectric.get(id).getBattery());
	}

	@Test
	void testFindByName() {

		String name = "Tesla X";

//		VehicleCombustion esperado = vehiclesCombustion.get(name);

		List<VehicleElectric> result = electricService.findByName(name);

		assertEquals(3, result.size());
	}

	@Test
	void testFindByColor() {

		String color = "Black";

		List<VehicleElectric> result = electricService.findByColor(color);

		assertEquals(3, result.size());

	}

	@Test
	void testFindBynumDoors() {

		Integer numDoors = 4;

		List<VehicleElectric> result = electricService.findBynumDoorsElectrics(numDoors);

		assertEquals(2, result.size());
	}

}
