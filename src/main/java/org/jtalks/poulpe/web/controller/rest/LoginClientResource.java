package org.jtalks.poulpe.web.controller.rest;

import org.restlet.ext.jaxb.JaxbRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;

/**
 * @author Guram Savinov
 */
public class LoginClientResource {

    public static void main(String[] args) throws IOException {
        ClientResource client = new ClientResource("http://dev.jtalks.org/poulpe/rest/authenticate");
        client.setEntityBuffering(true);
        Authentication auth = new Authentication();
        Credentials cred = new Credentials("admin");
        cred.setPasswordHash("21232f297a57a5a743894a0e4a801fc3");
        auth.setCredintals(cred);
        JaxbRepresentation<Authentication> request = new JaxbRepresentation<Authentication>(auth);
        request.setFormattedOutput(true);
        Representation response = client.post(auth);
        JaxbRepresentation<Authentication> result = new JaxbRepresentation<Authentication>(response, Authentication.class);
        System.out.println(result.getObject().getStatus());
    }

}
