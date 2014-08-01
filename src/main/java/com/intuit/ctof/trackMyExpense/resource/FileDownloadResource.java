package com.intuit.ctof.trackMyExpense.resource;

import javax.ws.rs.*;

import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.MultiPart;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by sn1 on 6/26/14.
 */
@Path("/getData")
public class FileDownloadResource {

    @GET
    @Path("user/{userId}/download")
    @Consumes({"application/json", "application/xml"})
    public Response getDocument(@PathParam("userId") String userId) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(new File(this.getClass().getResource("/files/file.pdf").getFile()));

        MultiPart multiPart = new MultiPart();

        FormDataBodyPart docBodyPart = new FormDataBodyPart("{ tag: {some json stuff}}",
                MediaType.APPLICATION_JSON);

        FormDataBodyPart fdpPdf = new FormDataBodyPart(new ByteArrayInputStream(bytes), MediaType.valueOf("application/pdf"));

        multiPart.bodyPart(docBodyPart);
        multiPart.bodyPart(fdpPdf);

        return Response.ok().entity(multiPart).build();
    }

}
