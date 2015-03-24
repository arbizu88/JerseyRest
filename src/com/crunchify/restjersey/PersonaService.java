package com.crunchify.restjersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.crunchify.dao.PersonaDAO;
import com.crunchify.entity.Persona;
import com.google.gson.Gson;

@Path("/personas")
public class PersonaService {

	private static final PersonaDAO dao = new PersonaDAO();
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getUserById(@PathParam("id") String id)
			throws JSONException {

		Gson gson = new Gson();
		Persona person = new Persona();

		person = dao.getPersonById(Integer.parseInt(id));

		String json = gson.toJson(person);

		return Response.status(200).entity(json).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPerson(Persona person)
			throws JSONException {

		Gson gson = new Gson();
		
		dao.addPerson(person);

		String json = gson.toJson(person);

		
		return Response.status(200).entity(json).build();
	}

	@PUT @Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updatePerson(Persona person){
		Gson gson = new Gson();
		
		dao.updatePersona(person);
		String json = gson.toJson(person);

		return Response.status(200).entity(json).build();
	}

	public static PersonaDAO getDao() {
		return dao;
	}
}
