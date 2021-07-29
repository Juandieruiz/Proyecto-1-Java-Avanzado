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

import juan.diego.gomez.domain.VehicleElectric;
import juan.diego.gomez.service.VehicleElectricService;

@Path("/vehicles/electric")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleElectricController {

	private VehicleElectricService vehicleElectricService;

	public VehicleElectricController(VehicleElectricService vehicleElectricService) {
		this.vehicleElectricService = vehicleElectricService;
	}

//	 GET http://localhost:8080/api/vehicles/electric/

	@GET
	public List<VehicleElectric> findAll() {
		return vehicleElectricService.findAll();
	}

/*	 GET http://localhost:8080/api/vehicles/electric/1
	 GET http://localhost:8080/api/vehicles/electric/2
	 GET http://localhost:8080/api/vehicles/electric/3
	 */ 
	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {
		VehicleElectric electric = vehicleElectricService.findOne(id);
		if (electric == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(electric).build();
	}
	
	
	/* 
	 * GET http://localhost:8080/api/electrico/Tesla X (EJEMPLO)
	 * BUSCAR COCHE POR SU NOMBRE
	 */
	@Path("/name/{name}")
	@GET
	public List<VehicleElectric> findByName(@PathParam("name")String name){
		return vehicleElectricService.findByName(name);
	}
	
	
	/* 
	 * GET http://localhost:8080/api/electrico/Black (EJEMPLO)
	 * BUSCAR COCHE POR SU COLOR
	 */
	@Path("/color/{color}")
	@GET
	public List<VehicleElectric> findByColor(@PathParam("color")String color){
		return vehicleElectricService.findByColor(color);
	}
	
	/* 
	 * GET http://localhost:8080/api/electrico/4 (EJEMPLO)
	 * BUSCAR COCHE POR EL NUMERO DE SUS PUERTAS
	 */
	
	@Path("/numDoors/{numDoors}")
	@GET
	public List<VehicleElectric> findByNumDoorsElectrics(@PathParam("numDoors")Integer numDoors){
		return vehicleElectricService.findBynumDoorsElectrics(numDoors);
	}

	/*
	 * POST START COCHE (PARA CAMBIAR EL ESTADO DEL COCHE
	 * PASO 1 = EJECUTAR GET 
	 * PASO 2 = VOLVER A EJECUTAR GET
	 * PODREMOS VER , COMO SIMULTANEAMENTE NOS DA TRUE O FALSE
	 * HACIENDO REFERENCIA A ENCENDIDO Y APAGADO
	 * https:localhost:8080/vehicles/electric/start/id
	 */
	
	@GET
	@Path("/start/{id}")
	public Response changeState(@PathParam("id") Long id) {

		VehicleElectric electric = vehicleElectricService.changeState(id);

		if (electric != null)
			return Response.ok(electric).build();
		return Response.ok(Response.Status.NOT_FOUND).build();
	}
	
	
	/*
	 * 
	 *    METODOS POST = ACTUALIZACION DE ID
	 *    METODOS PUT = CREACION EN BASE DE NO TENER ID
	 *    METODOS DELETE ID = BORRAR VEHICULO EN BASE DE SU ID
	 *    METODOS DELETEALL = BORRARLOS TODOS
	 */

	@POST
	public Response create(VehicleElectric electric) {
		if (electric.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
			return Response.status(Response.Status.BAD_REQUEST).build();
		VehicleElectric result = vehicleElectricService.save(electric);
		return Response.ok(result).build();
	}

	@PUT
	public Response update(VehicleElectric electric) {
		if (electric.getId() == null || electric.getId() == 0) // si no tiene id quiere decir que es una creación no
																// actualización
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.ok(vehicleElectricService.save(electric)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!vehicleElectricService.delete(id))
			return Response.ok(Response.Status.NOT_FOUND).build();
		return Response.ok(Response.Status.OK).build();
	}

	@DELETE
	public Response deleteAll() {
		vehicleElectricService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}
}
