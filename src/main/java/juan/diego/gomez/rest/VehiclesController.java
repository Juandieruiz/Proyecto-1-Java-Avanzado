package juan.diego.gomez.rest;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import juan.diego.gomez.service.VehicleFactory;

/**
 * CRUD
 * 
 * RETRIEVE ONE id RETRIEVE ALL
 */
@Component
@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
public class VehiclesController {

	/**
	 * http://localhost:8080/api/vehicles
	 * 
	 * @return
	 */
	@GET
	public Response hello() {
		String mensaje = "Bienvenido, Tenemos los mejores coches!!";
		return Response.ok().entity(mensaje).build();
	}

	/**
	 * http://localhost:8080/api/vehicles/combustion
	 * http://localhost:8080/api/vehicles/electric
	 * http://localhost:8080/api/vehicles/hybrid
	 * 
	 * @param type
	 * @return
	 */
	@GET
	@Path("/{type}")
	public Response createByType(@PathParam("type") String type) {
		
		try {
			return Response
					.ok()
					.entity(VehicleFactory.createByType(type))
					.build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

}
