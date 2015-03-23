package com.crunchify.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/ftocservice")
public class FtoCService {
	private static final Double fahrenheit = 98.24;

	@GET
	@Produces("application/json")
	public Response convertFtoC() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		calculateFtoC(jsonObject, fahrenheit);

		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n"	+ jsonObject;
		return Response.status(200).entity(result).build();
	}

	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("f") Double f)
			throws JSONException {

		JSONObject jsonObject = new JSONObject();
		calculateFtoC(jsonObject, f);

		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n"	+ jsonObject;
		return Response.status(200).entity(result).build();
	}

	private void calculateFtoC(JSONObject jsonObject, Double f) {
		Double celsius;

		celsius = (f - 32) * 5 / 9;
		jsonObject.put("F value", f);
		jsonObject.put("C value", celsius);
	}

}
