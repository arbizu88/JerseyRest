package com.crunchify.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/personas")
public class PersonaService {

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getUserById(@PathParam("id") String id) throws JSONException {

		
		JSONObject jsonObject = new JSONObject();
				
		return Response.status(200).entity("Test id:").build();
	}
	
}
