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
    
    
    //code=525ae566579b70579cb7
    public String getToken(String code){
        String url = String.format(
                "https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s",
                CLIENT_ID,
                CLIENTSECRET,
                code);
                
        Client client = ClientBuilder.newClient();
        String result = client.target(url).request().post(null, String.class);
        // access_token=<TOKEN>&scope=%token_type=bearer
        return result.substring(13, result.indexOf("&"));
    }
    
    public JsonObject githubAuth(String token){
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target("https://api.github.com/user");
        return target.request(MediaType.APPLICATION_JSON)
                .header("Authorization","token " + token).get(JsonObject.class);
    }
}
