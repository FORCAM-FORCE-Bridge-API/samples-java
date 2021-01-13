package _logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import com.google.gson.Gson;

import _model.OperatingStates;
import _model.Token;
import _model.WorkplaceProperties;


public class FORCEBridgeConnector {
	
	private String baseURL;
	private Token token;
	
	public FORCEBridgeConnector(String urlBridgeAPI, Token accessToken) {
	
		baseURL = urlBridgeAPI;
		token = accessToken;
	}

	private void SetTokenHeader(HttpURLConnection connection) throws Exception {

		connection.setRequestProperty("Accept-Language", "en-EN");
		connection.setRequestProperty("accept", "application/json;charset=UTF-8");
		connection.setRequestProperty("Authorization", "Bearer " + token.access_token);
	}
	
	public String ExecuteRESTGET(String method) throws Exception{
		
		URL url = new URL(baseURL + method);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		SetTokenHeader(connection);
		connection.setRequestMethod("GET");
		InputStreamReader in = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String jsonString = br.readLine();
		connection.disconnect();
		return jsonString;
	}
	
	public List<WorkplaceProperties.Properties> GetWorkplaces() throws Exception{
		
		String jsonWorkplaces = ExecuteRESTGET("workplaces");
		Gson gson = new Gson();
		WorkplaceProperties.Root workplaceProperties = gson.fromJson(jsonWorkplaces, WorkplaceProperties.Root.class);
		return workplaceProperties._embedded.workplaces.stream().map(x->x.properties).collect(Collectors.toList());
	}
	
	public WorkplaceProperties.Properties GetWorkplaceByNumber(String workplaceNumber) throws Exception {
		
		String jsonWorkplaces = ExecuteRESTGET("workplaces?workplaceNumber=" + workplaceNumber);
		Gson gson = new Gson();
		WorkplaceProperties.Root workplaceProperties = gson.fromJson(jsonWorkplaces, WorkplaceProperties.Root.class);
		return workplaceProperties._embedded.workplaces.get(0).properties;
	}

	public List<OperatingStates.Properties> GetOperatingStates() throws Exception {
		
		String jsonOperatingStates = ExecuteRESTGET("masterData/operatingStates");
		Gson gson = new Gson();
		OperatingStates.Root operatingStates =  gson.fromJson(jsonOperatingStates, OperatingStates.Root.class); 
		return operatingStates._embedded.operatingStates.stream().map(x->x.properties).collect(Collectors.toList()); 
	}
}