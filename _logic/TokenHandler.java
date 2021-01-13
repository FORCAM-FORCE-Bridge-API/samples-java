package _logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

import _model.Token;

public class TokenHandler {

	private String _user;
	private String _password;
	private String baseURLForTokenGeneration;
		
	public TokenHandler(String user, String password, String urlForTokenGeneration) {
	
		_user = user;
		_password = password;
		baseURLForTokenGeneration = urlForTokenGeneration;	
	}

	public Token GetAccessToken() throws Exception {
			
		URL urlForTokenGeneration = new URL(baseURLForTokenGeneration);
		HttpURLConnection connection = (HttpURLConnection) urlForTokenGeneration.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		InputStreamReader in = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String jsonString = br.readLine();
		connection.disconnect();
		Gson gson = new Gson();
		Token token = gson.fromJson(jsonString, Token.class);
				
		return token;
	}

}


