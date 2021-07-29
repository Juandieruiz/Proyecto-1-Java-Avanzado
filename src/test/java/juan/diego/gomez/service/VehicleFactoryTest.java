package juan.diego.gomez.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import juan.diego.gomez.domain.Vehicle;
import juan.diego.gomez.domain.VehicleCombustion;
import juan.diego.gomez.domain.VehicleElectric;
import juan.diego.gomez.domain.VehicleHybrid;

 class VehicleFactoryTest {

	@Test
	@DisplayName("Test de creacion de typeCombustion")
	void testCreateByTypeCombustion() {
		Vehicle vehicleCombustion = VehicleFactory.createByType("combustionCar");

		assertNotNull(vehicleCombustion);
		assertTrue(vehicleCombustion instanceof VehicleCombustion);
		assertEquals("Default vehicle1", vehicleCombustion.getModel());
		assertEquals(1L, vehicleCombustion.getId());

	}

	@Test
	@DisplayName("Test de creacion de typeElectric")
	void testCreateByTypeElectric() {
		Vehicle vehicleElectric = VehicleFactory.createByType("electricCar");
		assertNotNull(vehicleElectric);
		assertTrue(vehicleElectric instanceof VehicleElectric);
		assertEquals("Default vehicle2", vehicleElectric.getModel());
		assertEquals(1L, vehicleElectric.getId());

	}

	@Test
	@DisplayName("Test de creacion de typeHybrid")
	void testCreateByTypeHybrid() {
		Vehicle vehicleHybrid = VehicleFactory.createByType("electricHybrid");
		assertNotNull(vehicleHybrid);
		assertTrue(vehicleHybrid instanceof VehicleHybrid);
		assertEquals("Default vehicle3", vehicleHybrid.getModel());
		assertEquals(1L, vehicleHybrid.getId());

	}

	@Test
	@DisplayName("Test que comprueba si lanza una excepcion cuando el tipo no es correcto")
	void testCreateByTypeDefault() {

	Exception exception = assertThrows(IllegalArgumentException.class,() -> VehicleFactory.createByType("volador"));

	assertEquals("No existe tipo de coche ", exception.getMessage());
	}

}
