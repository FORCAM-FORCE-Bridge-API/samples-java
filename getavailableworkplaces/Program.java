package getavailableworkplaces;

import _logic.FORCEBridgeConnector;
import _logic.TokenHandler;
import _model.Token;

public class Program {
	
	public static void main(String[] args) throws Exception {
		
		String user = "GitHub";
		String password = "GitHub";
		String urlForTokenGeneration = "https://forcebridgehackathon.force.eco:25443/ffauth/oauth2.0/accessToken?client_id=" + user + "&client_secret=" + password + "&grant_type=client_credentials&scope=read%20write";	
		String urlToBridgeAPI= "https://forcebridgehackathon.force.eco:24443/ffwebservices/api/v3/";
		
		System.out.println("Welcome to the get all available workplaces sample!\n");
		System.out.println("Determine token ...\n");
       	
		TokenHandler tokenHandler = new TokenHandler(user, password, urlForTokenGeneration);
        Token token = tokenHandler.GetAccessToken();

        System.out.println("Token: " + token.access_token + "\n");
        System.out.println("Determine workplaces ...\n");

        FORCEBridgeConnector connector = new FORCEBridgeConnector(urlToBridgeAPI, token);
        var workplaces =  connector.GetWorkplaces();
        
        workplaces.forEach(s -> {
        	 System.out.println("Id: "+ s.id + ", " + "Number: " + s.number + ", " + "Description: " + s.description);
        	 });  
     }
 
}

	


