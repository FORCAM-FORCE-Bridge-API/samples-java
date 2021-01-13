package authentication;

import _logic.TokenHandler;
import _model.Token;

public class Program {
	
	public static void main(String[] args) throws Exception {
		
		String user = "GitHub";
		String password = "GitHub";
		String urlToken = "https://forcebridgehackathon.force.eco:25443/ffauth/oauth2.0/accessToken?client_id=" + user + "&client_secret=" + password + "&grant_type=client_credentials&scope=read%20write";
	
		System.out.println("Welcome to the authentication sample!\n");
		System.out.println("Determine token ...\n");
		
		TokenHandler tokenhandler = new TokenHandler(user, password, urlToken);
		Token token = tokenhandler.GetAccessToken();
		
		System.out.println("Result ClientCredentials:");
		System.out.println("-----------------");	
		System.out.println("Token: " + token.access_token);
		System.out.println("Refresh-Token: " + token.refresh_token );
		System.out.println("Token type: " + token.token_type);
		System.out.println("Expires in: " + token.expires_in);
		System.out.println("Scope: " + token.scope);				
	}
}
