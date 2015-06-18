/**
 * 
 */
package com.crunchify.restjersey;

/**
 * @author subhasis
 *
 */
import isi.ecsu.Util.CommonConstant;
import isi.ecsu.view.struct.impl.ViewGenerate;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
 
@Path("/bookservices")
public class BookServices {
 
	@GET
	@Path("{year}")
	public Response getBooks(@PathParam("name") String year,
			@MatrixParam("group") String group,
			@MatrixParam("concept") String concept) {
		
		ViewGenerate vw = new ViewGenerate();
		group = CommonConstant.SubjectCommonURI+group;
		
		//concept = "DL-Concept88";
		//group = "http://www.semanticweb.org/subhasis/ontologies/2014/6/untitled-ontology-15#Business";
		JSONObject js = vw.executeView(concept, group);
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + js;
		return Response.status(200).entity(result).build();
 
		
	}
 
}