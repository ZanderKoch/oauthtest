/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.tim.oauth.beans;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tim
 */
@Stateless
public class GitHubOAuthBean {
    private final String CLIENT_ID ="c3c2a295d93c6573e753";
    private final String CLIENTSECRET ="24936a6854623f481007ac556dd0ce7dcb0e6c40";
    
    
    public String getToken(String code){

    }
    
    public JsonObject githubAuth(String token){
    }
}
