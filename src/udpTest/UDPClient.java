package udpTest;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP�ͻ���
 * @author dys
 *
 */
public class UDPClient {
	private static final int TIMEOUT = 5000;  //���ý������ݵĳ�ʱʱ��
	private static final int MAXNUM = 5;      //�����ط����ݵ�������
	public static void main(String args[])throws IOException{
		String str_send = "��ð���������������������������������!";
		byte[] buf = new byte[1024];
		//�ͻ�����9000�˿ڼ������յ�������
		DatagramSocket ds = new DatagramSocket(9000);
		InetAddress loc = InetAddress.getLocalHost(); 
		//���������������ݵ�DatagramPacketʵ��
		DatagramPacket dp_send= new DatagramPacket(str_send.getBytes(),str_send.getBytes().length,loc,3000);
		//���������������ݵ�DatagramPacketʵ��
		DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
		//���ݷ��򱾵�3000�˿�
		ds.setSoTimeout(TIMEOUT);              //���ý�������ʱ�������ʱ��
		int tries = 0;                         //�ط����ݵĴ���
		boolean receivedResponse = false;     //�Ƿ���յ����ݵı�־λ
		//ֱ�����յ����ݣ������ط������ﵽԤ��ֵ�����˳�ѭ��
		while(!receivedResponse && tries<MAXNUM){
			//��������
			ds.send(dp_send);
			try{
				//���մӷ���˷��ͻ���������
				ds.receive(dp_receive);
				//������յ������ݲ�������Ŀ���ַ�����׳��쳣
				if(!dp_receive.getAddress().equals(loc)){
					throw new IOException("��һ����֪��Դ�������ݰ�...");
				}
				//������յ����ݡ���receivedResponse��־λ��Ϊtrue���Ӷ��˳�ѭ��
				receivedResponse = true;
			}catch(InterruptedIOException e){
				//�����������ʱ������ʱ���ط�������һ���ط��Ĵ���
				tries += 1;
				System.out.println("Time out," + (MAXNUM - tries) + " more tries..." );
			}
		}
		if(receivedResponse){
			//����յ����ݣ����ӡ����
			System.out.println("�ͻ����յ���������ݣ�");
			String str_receive = new String(dp_receive.getData(),0,str_send.getBytes().length) + 
					" ���� IP: " + dp_receive.getAddress().getHostAddress() + " �˿�:" + dp_receive.getPort();
			System.out.println(str_receive);
			//����dp_receive�ڽ���������֮�����ڲ���Ϣ����ֵ���Ϊʵ�ʽ��յ���Ϣ���ֽ�����
			//��������Ҫ��dp_receive���ڲ���Ϣ����������Ϊ1024
			dp_receive.setLength(1024);   
		}else{
			//����ط�MAXNUM�����ݺ���δ��÷��������ͻ��������ݣ����ӡ������Ϣ
			System.out.println("����Ӧ -- ����.");
		}
		ds.close();
	}  
} 