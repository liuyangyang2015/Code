package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author liuyangyang
 * @date 2018/12/26 17:24
 * description:
 */

public class Client
{
	public static void main(String[] args) throws IOException
	{
		Socket socket = new Socket("localhost", 8080);
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while((info=br.readLine())!= null){
			System.out.println("我是客户端，服务器说："+info);
		}
	}
}
