package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService {
	public static void main(String[] args) {
		try {
			int port=8889;
			ServerSocket serverSocket=new ServerSocket(port);
			System.out.println("server将一直等待连接的到来");
			Socket socket=serverSocket.accept();
			//从socket中获得输入流
			InputStream inputStream=socket.getInputStream();
			byte[] bytes=new byte[1024];
			int len;
			StringBuilder sb=new StringBuilder();
			while((len=inputStream.read(bytes))!=-1){
				sb.append(new String(bytes,0,len,"UTF-8"));
			}
			System.out.println("get message from client :"+sb.toString());
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("hello girl".getBytes("UTF-8"));
			
			inputStream.close();
			outputStream.close();
			socket.close();
			serverSocket.close();
		}catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
