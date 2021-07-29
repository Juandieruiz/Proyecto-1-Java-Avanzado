package juan.diego.gomez.service;

import java.util.List;

import juan.diego.gomez.domain.VehicleCombustion;

public interface VehicleCombustionService {

	Integer count();

	/*
	 * FILTRO DE ENCUENTRA VEHICULOS POR SU TIPO, TODOS , O UNO POR ID
	 */

	List<VehicleCombustion> findAll();

	VehicleCombustion findOne(Long id);

	/*
	 * FILTRO DE GUARDAR,BORRAR UNO O TODOS LOS VEHICULOS
	 */

	VehicleCombustion save(VehicleCombustion vehicleCombustion);

	boolean delete(Long id);

	void deleteAll();

	VehicleCombustion changeState(Long id);

	/*
	 * FILTROS DE RECUPERACION DE DATOS
	 */

	List<VehicleCombustion> findByName(String name);

	List<VehicleCombustion> findByColor(String color);

	List<VehicleCombustion> findBynumDoors(Integer numDoors);

	
}
