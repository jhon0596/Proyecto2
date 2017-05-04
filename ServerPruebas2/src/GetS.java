package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetS {
	private String serverData;
	public String getServerInfo()
	{
		
		try {
	
			URL url = new URL("http://192.168.43.172:9080/ChefAppS/resources/hello/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
	
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				serverData = br.readLine();
				
			}
			
	
			conn.disconnect();
	
		  } catch (MalformedURLException e) {
	
			e.printStackTrace();
	
		  } catch (IOException e) {
	
			e.printStackTrace();
	
		  }
		return serverData;
	}
}

