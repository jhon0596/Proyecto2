import java.io.IOException;
import java.net.MalformedURLException;

public class ClienteREST {
	public static void main(String[] args) throws IOException {
		GetS dato = new GetS();
		System.out.println(dato.getServerInfo());
		
	}
}