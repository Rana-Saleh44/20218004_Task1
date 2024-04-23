package AppAPI;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejbs.Calculation;

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("")

public class CalculationService {
	@PersistenceContext(unitName="hello")
	EntityManager em;
	@POST
	@Path("/calc")
	public Response createCalculation(Calculation c) {
		try {
			em.persist(c);
			int result = c.performCalculation(c.getNumber1(), c.getNumber2(), c.getOperation());
			return Response.status(Response.Status.OK).entity("{\"Result\": "+ result + "}").build();	
		}catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	
	@GET
	@Path("/calculations")
	public Response getCalculations() {
		try {
			return Response.status(Response.Status.OK).entity(em.createQuery("SELECT c FROM Calculation c").getResultList()).build();
		}catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	

}
