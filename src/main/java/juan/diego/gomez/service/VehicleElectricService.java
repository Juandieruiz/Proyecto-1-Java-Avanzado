package juan.diego.gomez.service;

import java.util.List;

import juan.diego.gomez.domain.VehicleElectric;

public interface VehicleElectricService {

	Integer count();
	
	/*
	 *  FILTRO DE ENCUENTRA VEHICULOS POR SU TIPO, TODOS , O UNO POR ID
	 */

	List<VehicleElectric> findAll();

	VehicleElectric findOne(Long id);

	/*
	 *  FILTRO DE GUARDAR,BORRAR UNO O TODOS LOS VEHICULOS
	 */
	
	VehicleElectric save(VehicleElectric userElectric);

	boolean delete(Long id);

	void deleteAll();

	VehicleElectric changeState(Long id);
	
	/*
	 * FILTROS DE RECUPERACION DE DATOS
	 */

	List<VehicleElectric> findByName(String name);

	List<VehicleElectric> findByColor(String color);

	List<VehicleElectric> findBynumDoorsElectrics(Integer numDoors);
}
