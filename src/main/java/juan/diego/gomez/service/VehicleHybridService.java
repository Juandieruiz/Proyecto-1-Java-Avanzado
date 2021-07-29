package juan.diego.gomez.service;

import java.util.List;

import juan.diego.gomez.domain.VehicleHybrid;

public interface VehicleHybridService {
	Integer count();
	
	/*
	 *  FILTRO DE ENCUENTRA VEHICULOS POR SU TIPO, TODOS , O UNO POR ID
	 */

	List<VehicleHybrid> findAll();

	VehicleHybrid findOne(Long id);
	
	/*
	 *  FILTRO DE GUARDAR,BORRAR UNO O TODOS LOS VEHICULOS
	 */
	
	VehicleHybrid save(VehicleHybrid vehicleHybrid);

	boolean delete(Long id);

	void deleteAll();
	
	VehicleHybrid changeState(Long id);
	
	/*
	 * FILTROS DE RECUPERACION DE DATOS
	 */
	List<VehicleHybrid> findByName(String name);

	List<VehicleHybrid> findByColor(String color);

	List<VehicleHybrid> findBynumDoors(Integer numDoors);
	
}
