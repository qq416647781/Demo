package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		try {
			int port=8889;
			Socket socket=new Socket("127.0.0.1", port);
			OutputStream outputStream=socket.getOutputStream();
			String message="��ð�!";
			outputStream.write(message.getBytes("UTF-8"));
			socket.shutdownOutput();//ͨ��������ٵķ�������,����ֻ�ܽ�������[�ؼ�].���߶Է������Ѿ��������
			InputStream inputStream = socket.getInputStream();
			StringBuilder sb=new StringBuilder();
			byte[] bytes=new byte[1024];
			int len;
			while((len=inputStream.read(bytes))!=-1){
				sb.append(new String(bytes,0,len,"UTF-8"));
			}
			System.out.println("get:"+sb.toString());
			inputStream.close();
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
