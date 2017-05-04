package src;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class ClienteREST {
	public static void main(String[] args) throws IOException {
		GetS dato = new GetS();
		System.out.println(dato.getServerInfo());
		
	}

	public static String Post(String url) throws IOException {
		PostS post = new PostS (url);
		post.add("user", "DJ_bryan");
		post.add("password", "*********");
		String respuesta = post.getRespuesta();
		System.out.println(respuesta);
		return respuesta;
	}
}