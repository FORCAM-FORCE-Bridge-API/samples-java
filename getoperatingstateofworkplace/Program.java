package getoperatingstateofworkplace;

import _logic.FORCEBridgeConnector;
import _logic.TokenHandler;
import _model.Token;

public class Program {
	
	public static void main(String[] args) throws Exception {
		String user = "GitHub";
		String password = "GitHub";
		String urlForTokenGeneration = "https://forcebridgehackathon.force.eco:25443/ffauth/oauth2.0/accessToken?client_id=" + user + "&client_secret=" + password + "&grant_type=client_credentials&scope=read%20write";	
		String workplaceNumber = "R_WPL_04"; // YOUR WORKPLACE NUMBER
		String urlToBridgeAPI= "https://forcebridgehackathon.force.eco:24443/ffwebservices/api/v3/";
		
		System.out.println("Welcome to the get current operating state of a workplace example!\n");
		System.out.println("Determine token ...\n");

	    TokenHandler tokenHandler = new TokenHandler(user, password, urlForTokenGeneration);
	    Token token = tokenHandler.GetAccessToken();

	    System.out.println("Token: " + token.access_token + "\n");
	    System.out.println("Determine workplace " + workplaceNumber + "...\n");

	    FORCEBridgeConnector connector = new FORCEBridgeConnector(urlToBridgeAPI, token);
	    var workplace = connector.GetWorkplaceByNumber(workplaceNumber);

	    System.out.println("Workplace: " + workplace.number + " (" + workplace.description + ")");
	    System.out.println("State: " + workplace.operatingState.code + ": " + workplace.operatingState.description + " (Id:" + workplace.operatingState.id + ")");
	}
}
