/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgoettert.tickets.interfaces.web.rest.config.auth;

import com.auth0.jwt.JWTSigner;
import com.cgoettert.tickets.application.ClienteService;
import com.cgoettert.tickets.interfaces.web.rest.ControllerSupport;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author cgoettert
 */
@Path("/auth")
public class AuthenticationController extends ControllerSupport {

    @Inject
    private ClienteService clienteService;

    @POST
    @NotSecured
    public Response authenticateUser(AuthenticationCommand login) {

        // Authenticate the user using the credentials provided
        if (!authenticate(login.getUsuario(), login.getSenha())) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(clienteService.getFeed())
                    .build();
        }

        // Issue a token for the user
        String token = issueToken(login.getUsuario());

        getFeedback().feedData("token", token);
        
        // Return the token on the response
        return Response.ok(getFeedback().get()).build();
    }

    private boolean authenticate(final String username, final String password) {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        return clienteService.auth(username, password);
    }

    private String issueToken(final String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        final String secret = "--secret-- not share";
        final long iat = System.currentTimeMillis() / 1000L; // issued at claim 
        final long exp = iat + 900L; // expires claim. In this case the token expires in 900 seconds (15min)

        final JWTSigner signer = new JWTSigner(secret);
        final HashMap<String, Object> claims = new HashMap<>();
        claims.put("iss", username);
        claims.put("exp", exp);
        claims.put("iat", iat);

        final String jwt = signer.sign(claims);

        return jwt;
    }
}
