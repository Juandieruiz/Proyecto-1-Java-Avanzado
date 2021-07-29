package juan.diego.gomez.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import juan.diego.gomez.domain.VehicleCombustion;

import juan.diego.gomez.service.VehicleCombustionService;

/**
 * GET http://localhost:8080/api/vehicles/combustion
 */
@Path("/vehicles/combustion")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class VehicleCombustionController {

	private VehicleCombustionService vehicleCombustionService;

	public VehicleCombustionController(VehicleCombustionService vehicleService) {
		this.vehicleCombustionService = vehicleService;
	}

	/**
	 * POSTMAN GET http://localhost:8080/api/vehicle
	 */
	@GET
	public List<VehicleCombustion> findAll() {
		return vehicleCombustionService.findAll();
	}

	/**
	 * POSTMAN GET http://localhost:8080/api/vehicles/combustion/(ID)
	 * 
	 * 
	 * 
	 */
	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Long id) {
		VehicleCombustion combustionCar = vehicleCombustionService.findOne(id);
		if (combustionCar == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(combustionCar).build();
	}

	/*
	 * 
	 * POST START COCHE (PARA VERIFICAR SI EL COCHE ESTA ENCENDIDO
	 * https:localhost:8080/vehicles/electric/start/id
	 * https:localhost:8080/vehicles/combustion/start/id
	 * https:localhost:8080/vehicles/hybrid/start/id
	 */
	@GET
	@Path("/start/{id}")
	public Response changeState(@PathParam("id") Long id) {

		VehicleCombustion combustioncar = vehicleCombustionService.changeState(id);

		if (combustioncar == null)

			return Response.ok(combustioncar).build();
		return Response.ok(Response.Status.NOT_FOUND).build();
	}

	/*
	 * GET http://localhost:8080/api/electrico/Tesla X (EJEMPLO) BUSCAR COCHE POR SU
	 * NOMBRE
	 */
	@Path("/name/{name}")
	@GET
	public List<VehicleCombustion> findByName(@PathParam("name") String name) {
		return vehicleCombustionService.findByName(name);
	}

	/*
	 * GET http://localhost:8080/api/electrico/Black (EJEMPLO) BUSCAR COCHE POR SU
	 * COLOR
	 */
	@Path("/color/{color}")
	@GET
	public List<VehicleCombustion> findByColor(@PathParam("color") String color) {
		return vehicleCombustionService.findByColor(color);
	}

	/*
	 * GET http://localhost:8080/api/electrico/4 (EJEMPLO) BUSCAR COCHE POR EL
	 * NUMERO DE SUS PUERTAS
	 */

	@Path("/numDoors/{numDoors}")
	@GET
	public List<VehicleCombustion> findByNumDoors(@PathParam("numDoors") Integer numDoors) {
		return vehicleCombustionService.findBynumDoors(numDoors);
	}

	/**
	 * POST http://localhost:8080/api/vehicles
	 */
	@POST
	// CREAR NUEVO
	public Response create(VehicleCombustion combustionCar) {
		if (combustionCar.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
			return Response.status(Response.Status.BAD_REQUEST).build();

		VehicleCombustion result = vehicleCombustionService.save(combustionCar);
		return Response.ok(result).build();
	}

	/**
	 * PUT http://localhost:8080/api/vehicles
	 */
	@PUT // ACTUALIZAR
	public Response update(VehicleCombustion combustionCar) {
		if (combustionCar.getId() == null || combustionCar.getId() == 0) // si no tiene id quiere decir que es una
																			// creación no
			// actualización
			return Response.status(Response.Status.BAD_REQUEST).build();

		VehicleCombustion result = vehicleCombustionService.save(combustionCar);
		return Response.ok(result).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!vehicleCombustionService.delete(id))
			return Response.ok(Response.Status.NOT_FOUND).build();
		return Response.ok(Response.Status.OK).build();
	}

	@DELETE
	public Response deleteAll() {
		vehicleCombustionService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}
}