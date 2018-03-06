package udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP服务端
 * @author dys
 *
 */
public class UDPServer { 
	public static void main(String[] args)throws IOException{
		String str_send = "你好  啊  的的 的的的的的的的的的的地方    发发发发发发发发的的的!";
		byte[] buf = new byte[1024];
		//服务端在3000端口监听接收到的数据
		DatagramSocket ds = new DatagramSocket(3000);
		//接收从客户端发送过来的数据
		DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
		System.out.println("服务器开启,等待客户端发送数据:......");
		boolean f = true;
		while(f){
			//服务器端接收来自客户端的数据
			ds.receive(dp_receive);
			System.out.println("服务器收到客服端的数据:......");
			String str_receive = new String(dp_receive.getData(),0,str_send.getBytes().length) + 
					"  来自 IP：" + dp_receive.getAddress().getHostAddress() + " 端口:" + dp_receive.getPort();
			System.out.println(str_receive);
			//数据发动到客户端的3000端口
			DatagramPacket dp_send= new DatagramPacket(str_send.getBytes(),str_send.length(),dp_receive.getAddress(),9000);
			ds.send(dp_send);
			//由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
			//所以这里要将dp_receive的内部消息长度重新置为1024
			dp_receive.setLength(1024);
		}
		ds.close();
	}
}

