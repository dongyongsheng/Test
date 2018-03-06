package udpTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP�����
 * @author dys
 *
 */
public class UDPServer { 
	public static void main(String[] args)throws IOException{
		String str_send = "���  ��  �ĵ� �ĵĵĵĵĵĵĵĵĵĵط�    �����������������ĵĵ�!";
		byte[] buf = new byte[1024];
		//�������3000�˿ڼ������յ�������
		DatagramSocket ds = new DatagramSocket(3000);
		//���մӿͻ��˷��͹���������
		DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
		System.out.println("����������,�ȴ��ͻ��˷�������:......");
		boolean f = true;
		while(f){
			//�������˽������Կͻ��˵�����
			ds.receive(dp_receive);
			System.out.println("�������յ��ͷ��˵�����:......");
			String str_receive = new String(dp_receive.getData(),0,str_send.getBytes().length) + 
					"  ���� IP��" + dp_receive.getAddress().getHostAddress() + " �˿�:" + dp_receive.getPort();
			System.out.println(str_receive);
			//���ݷ������ͻ��˵�3000�˿�
			DatagramPacket dp_send= new DatagramPacket(str_send.getBytes(),str_send.length(),dp_receive.getAddress(),9000);
			ds.send(dp_send);
			//����dp_receive�ڽ���������֮�����ڲ���Ϣ����ֵ���Ϊʵ�ʽ��յ���Ϣ���ֽ�����
			//��������Ҫ��dp_receive���ڲ���Ϣ����������Ϊ1024
			dp_receive.setLength(1024);
		}
		ds.close();
	}
}

