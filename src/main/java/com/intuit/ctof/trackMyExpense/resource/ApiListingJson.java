package com.intuit.ctof.trackMyExpense.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/api-docs")
@Api("/api-docs")
@Produces({"application/json"})
public class ApiListingJson extends ApiListingResourceJSON {

}