/**
 * 
 */
package com.crunchify.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * @author arbizu
 *
 */
@Path("/ctofservice")
public class CtoFService {

	private static final Double celsius = 36.8;

	@GET
	@Produces("application/xml")
	public String convertCtoF() {
		Double fahrenheit = calculateCtoF(celsius);

		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}

	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convetCtoFfromInput(@PathParam("c") Double c) {

		Double fahrenheit = calculateCtoF(c);

		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" 	+ fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}

	private Double calculateCtoF(Double celsius) {
		Double fahrenheit;
		fahrenheit = ((celsius * 9) / 5) + 32;
		return fahrenheit;
	}

}
