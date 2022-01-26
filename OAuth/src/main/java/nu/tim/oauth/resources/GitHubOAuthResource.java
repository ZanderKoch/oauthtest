/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.tim.oauth.resources;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.tim.oauth.beans.GitHubOAuthBean;

/**
 *
 * @author Tim
 */
@Path("")
public class GitHubOAuthResource {
    @EJB
    GitHubOAuthBean gitHubOAuthBean;

    @GET
    @Path("token")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getToken(@QueryParam("code") String code){
        return Response.ok(gitHubOAuthBean.getToken(code)).build();
    }    
    
    
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvents(@QueryParam("token") String token){
        return Response.ok(gitHubOAuthBean.githubAuth(token)).build();
    }
    
    
}
