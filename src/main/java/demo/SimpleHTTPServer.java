package demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Read more:https://javarevisited.blogspot.com/2015/06/how-to-create-http-server-in-java-serversocket-example.html#ixzz5an2dYGHb
 *
 * @author liuyangyang
 * @date 2018/12/26 19:50
 * description:
 */

public class SimpleHTTPServer {
	public static void main(String args[]) throws IOException {
		ServerSocket server = new ServerSocket(80);
		System.out.println("Listening for connection on port 80 ....");
		while (true) {
			try (Socket socket = server.accept()) {
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[is.available()];
				is.read(bytes);
				String str = new String(bytes);
				System.out.println(str);
				Date today = new Date();
				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
				socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			}
		}
	}


}
