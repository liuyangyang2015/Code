package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuyangyang
 * @date 2018/12/26 17:24
 * description:
 * <p>
 * 描述：
 * @author liuyangyang
 * @create 2017-11-28 23:29
 **/

/**
 * socket服务器端程序
 */
public class Server {

	public static void main(String[] args) throws Exception {
		//1.创建ServerSocket
		ServerSocket server = new ServerSocket(443);

		System.out.println("服务器已经启动成功....");

		while (true) {
			//2.接收客户端的连接
			Socket socket = server.accept();

			//3.读取本地的test.html文件
			FileInputStream in = new FileInputStream(new File("C:\\Users\\admin\\Desktop\\MUSE 二期\\脚本\\Muse Prod 真实账号 临时使用.md"));

			//http://localhost/  80
			//https://localhost/  443
			InputStream is = socket.getInputStream();
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			String str = new String(bytes);
			System.out.println(str);
			//4.构建数据输出通道
			OutputStream out = socket.getOutputStream();

			//5.发送数据
			byte[] buf = new byte[1024];
			int len = 0;
			String str2 = "HTTP/1.1 200 OK1\n" +
					"Server: Apache/2.2.14 (Win32)\n" +
					"Content-Length: 88\n" +
					"Content-Type: text/html\n" +
					"Connection: keep-alive \n" +
					"\n";
			String str3 = "<html>" +
					"<body>" +
					"<h1>Hello, World!</h1>" +
					"</body>" +
					"</html>";
//			String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
			out.write(str2.getBytes());
			out.write(str3.getBytes());
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			//6.关闭资源
			out.close();
			in.close();
		}

	}

}
