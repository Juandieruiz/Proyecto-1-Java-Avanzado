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
import juan.diego.gomez.domain.VehicleHybrid;
import juan.diego.gomez.service.VehicleHybridService;

@Path("/vehicles/hybrid")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleHybridController {

	private VehicleHybridService vehicleHybridService;

	public VehicleHybridController(VehicleHybridService vehicleHybridService) {
		this.vehicleHybridService = vehicleHybridService;
	}

//		 GET http://localhost:8080/api/vehicles/hybrid/

	@GET
	public List<VehicleHybrid> findAll() {
		return vehicleHybridService.findAll();
	}

	// GET http://localhost:8080/api/vehicles/hybrid/1
	// GET http://localhost:8080/api/vehicles/hybrid/2
	// GET http://localhost:8080/api/vehicles/hybrid/3

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") Long id) {
		VehicleHybrid hybrid = vehicleHybridService.findOne(id);
		if (hybrid == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(hybrid).build();
	}
	/* 
	 * GET http://localhost:8080/api/electrico/Tesla X (EJEMPLO)
	 * BUSCAR COCHE POR SU NOMBRE
	 */
	@Path("/name/{name}")
	@GET
	public List<VehicleHybrid> findByName(@PathParam("name")String name){
		return vehicleHybridService.findByName(name);
	}
	
	
	/* 
	 * GET http://localhost:8080/api/electrico/Black (EJEMPLO)
	 * BUSCAR COCHE POR SU COLOR
	 */
	@Path("/color/{color}")
	@GET
	public List<VehicleHybrid> findByColor(@PathParam("color")String color){
		return vehicleHybridService.findByColor(color);
	}
	
	/* 
	 * GET http://localhost:8080/api/electrico/4 (EJEMPLO)
	 * BUSCAR COCHE POR EL NUMERO DE SUS PUERTAS
	 */
	
	@Path("/numDoors/{numDoors}")
	@GET
	public List<VehicleHybrid> findByNumDoors(@PathParam("numDoors")Integer numDoors){
		return vehicleHybridService.findBynumDoors(numDoors);
	}
	
	
	/*
	 * POST START COCHE (PARA CAMBIAR EL ESTADO DEL COCHE
	 * PASO 1 = EJECUTAR GET 
	 * PASO 2 = VOLVER A EJECUTAR GET
	 * PODREMOS VER , COMO SIMULTANEAMENTE NOS DA TRUE O FALSE
	 * HACIENDO REFERENCIA A ENCENDIDO Y APAGADO
	 * https:localhost:8080/vehicles/electric/start/id
	 */

	@POST
	public Response create(VehicleHybrid hybrid) {
		if (hybrid.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.ok(vehicleHybridService.save(hybrid)).build();
	}

	/*
	 * 
	 * POST START COCHE (PARA VERIFICAR SI EL COCHE ESTA ENCENDIDO
	 * https:localhost:8080/vehicles/hybrid/start/id
	 */
	@GET
	@Path("/start/{id}")
	public Response changeState(@PathParam("id") Long id) {
		
		VehicleHybrid hybrid = vehicleHybridService.changeState(id);
		
		if (hybrid != null)
				return Response.ok(hybrid).build();
			return Response.ok(Response.Status.NOT_FOUND).build();
			}

	@PUT
	public Response update(VehicleHybrid hybrid) {
		if (hybrid.getId() == null || hybrid.getId() == 0) // si no tiene id quiere decir que es una creación no
															// actualización
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.ok(vehicleHybridService.save(hybrid)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteOne(@PathParam("id") Long id) {
		if (!vehicleHybridService.delete(id))
			return Response.ok(Response.Status.NOT_FOUND).build();
		return Response.ok(Response.Status.OK).build();
	}

	@DELETE
	public Response deleteAll() {
		vehicleHybridService.deleteAll();
		return Response.ok(Response.Status.OK).build();
	}
}
