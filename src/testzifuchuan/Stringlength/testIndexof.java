package testzifuchuan.Stringlength;

import java.math.BigDecimal;

import  util.ByteUtil;

/**
 * indexof���÷�
 * @author dys
 *
 */
public class testIndexof {

	public static final String biaoshi="54435020436F6E6E656374204F4B00";
	public static final String start="7EFFFFFFFF";
	public static final String end="7E";

	private void check(String info) {
		System.out.println(info);
	}
	// ¥��ת��
	public static String ACSIIfloor(byte a) {
		String str = "0";
		if (a == 48)
			str = "0";
		else if (a == 49)
			str = "1";
		else if (a == 50)
			str = "2";
		else if (a == 51)
			str = "3";
		else if (a == 52)
			str = "4";
		else if (a == 53)
			str = "5";
		else if (a == 54)
			str = "6";
		else if (a == 55)
			str = "7";
		else if (a == 56)
			str = "8";
		else if (a == 57)
			str = "9";
		else if (a == 32)
			str = "";
		else if (a == 45) {
			str = "-";
		}

		return str;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="1234567890";
		int i=name.indexOf("5");
		String qiege=name.substring(name.indexOf("5") );
		System.out.println("�и�������....:"+qiege);
//		String buildingID = "5110110001";
//		String outParamKey="10202_2202";
//		String sql = "select  * from  electriccurrentdata_" + buildingID + " where  " + "funcid =" + outParamKey.substring(0, outParamKey.indexOf("_"))
//				+ " and sign= " + outParamKey.substring(outParamKey.indexOf("_") + 1) + " order by  receivetime DESC LIMIT 1";
//		System.out.println(sql);
//		
//		String data="0E-8";
//	   double shuju=	new BigDecimal(data).doubleValue();
//		System.out.println(shuju);
//		String sb="54435020436F6E6E656374204F4B007EFFFFFFFF46432D38393230413237303330303634FFFFFFFF190500000000080117091515002304F07E7EFFFFFFFF46432D38393230413237303330303634FFFFFFFF1901000000000D0000139DE5170915150023010C8E7E7EFFFFFFFF46432D38393230413237303330303634FFFFFFFF190500000000080117091515005424417E";
//		System.out.println("7EFFFFFFFF46432D38393230413237303330303634FFFFFFFF190500000000080117091515002304F07E".length());
//		testIndexof xf=new testIndexof();
		
//		StringBuffer sb = new StringBuffer();
//		sb.append("54435020436F6E6E656374204F4B007EFFFFFFFF46432D38393230413237303330303634FFFFFFFF190500000000080117091515002304F07E7EFFFFFFFF46432D38393230413237303330303634FFFFFFFF1901000000000D0000139DE5170915150023010C8E7E7EFFFFFFFF46432D38393230413237303330303634FFFFFFFF190500000000080117091515005424417E");
//		if (sb.indexOf(start)!=-1) {
//			if (sb.toString().indexOf(start) != -1 && sb.toString().indexOf(end) != -1) {
//			//xf.check(sb.substring(sb.toString().indexOf(start), sb.toString().indexOf(end) + 84));
//				 String[] s = sb.toString().split("7EFFFFFFFF");
//				 for (int i=1;i<s.length;i++) {
//					 System.out.println("7EFFFFFFFF"+s[i].toString());
//				}
//				
//		
//		//	sb = new StringBuffer(sb.substring(sb.toString().indexOf(end) + 84));
//			}else {
//				//sb = new StringBuffer(sb.substring(sb.toString().indexOf(end) +84));
//			}
//			}
		
		  int YXParam=1;//���в���
		  int QTParam=2;//��ͣ���� ��������
		  byte[] storeBuff = ByteUtil.hexStringToByteArray("0000302d310020000000000040000000020000000000");
		String YXZT = "0";//����״̬������ֹͣ
		String QTZT = "0";//����������
		String SX = "0";//����
		String XX = "0";//����
		String type = "ֱ��";
		int modbusAddr=2;
		try {
		
			System.out.println("���ܵ������ݣ�"+ByteUtil.convertByteArrayToHexStr(storeBuff));
			// �ж����ͣ�0x00��ֱ�ݣ�0x01�����ݣ�0xFF��ͨѶ�쳣��
			if (storeBuff[0] == 0) {// �ж��Ƿ�ֱ��
				// ʮλ3 ��λ4 ���64��
				String LC = ACSIIfloor(storeBuff[2]) +ACSIIfloor(storeBuff[3]) + ACSIIfloor(storeBuff[4]);
				// ���з��� storeBuff[6]
				// bit 1 ���з�����ʾ (1 �� ����)
				byte g1 = (byte) ((storeBuff[6] & 0x2) >> 1);
				// bit 2 ���з�����ʾ (1 �� ����)
				byte g2 = (byte) ((storeBuff[6] & 0x4) >> 2);
				// ����״̬
				byte g3 = (byte) ((storeBuff[6] & 0x8) >> 3);

				// ����״̬
 				byte g4 = (byte) ((storeBuff[8] & 0x4) >> 2);
 				System.out.println("����״̬   : "+g4);
//				if (g4==1) {
//					System.out.println("����״̬   1����������״̬ ");
//					YXZT = "0";
//				}else {
//					System.out.println("����״̬   0���˳�����״̬  ");
//					YXZT = "1";
//				}
				SX = "0";
				XX = "0";
				if (g1 == 1) {
					SX = "1";
					QTZT = "1";
					XX = "0";
				}
				if (g2 == 1) {
					XX = "1";
					QTZT = "1";
					SX = "0";
				}
				if (g3 == 1) {
					QTZT = "1";
				}
				// ���� bit0 bit1 bit2 bit6 storeBuff[12]
				byte bj0 = (byte) ((storeBuff[12] & 0x1));
				if (bj0 == 1) {
					YXZT = "1";
				}
				byte bj1 = (byte) ((storeBuff[12] & 0x2) >> 1);
				if (bj1 == 1) {
					YXZT = "1";
				}
				byte bj2 = (byte) ((storeBuff[12] & 0x4) >> 2);
				if (bj2 == 1) {
					YXZT = "1";
				}
				byte bj6 = (byte) ((storeBuff[12] & 0x40) >> 6);
				if (bj6 == 1) {
					YXZT = "1";
				}
				System.out.println("ֱ�ݣ�"+modbusAddr+",  ¥�㣺"+LC+"  ,����״̬��"+YXZT+",  ���У�"+SX+",  ����:"+XX+",  ����״̬��"+YXZT);
				
			} else if (storeBuff[0] == 1) {// �ж��Ƿ����
				type = "����";
				// System.out.println(storeBuff[0]+"  "+storeBuff[2]+"  "+storeBuff[4]);
				// bit 1 ���з�����ʾ (1 �� ����)
				byte g1 = (byte) ((storeBuff[2] & 0x4) >> 2);
				// bit 2 ���з�����ʾ (1 �� ����)
				byte g2 = (byte) ((storeBuff[2] & 0x8) >> 3);
				// bit 0 ����״̬
				byte g3 = (byte) (storeBuff[2] & 0x1);
				SX = "0";
				XX = "0";
				if (g1 == 1) {
					SX = "1";
					QTZT = "1";
					XX = "0";
				}
				if (g2 == 1) {
					XX = "1";
					QTZT = "1";
					SX = "0";
				}
				if (g3 == 1) {
					QTZT = "1";
				}
				if ((storeBuff[4] & 0x1) == 1) {// ����״̬
					YXZT = "1";
				} else {
					YXZT = "0";
				}
			 System.out.println("���ݣ�"+modbusAddr+"  ,����״̬��"+YXZT+"  ,���У�"+SX+"  ,����:"+XX+"  ,����״̬��"+YXZT);
				
			} else {
				System.out.println(modbusAddr + "��ͨ�Ŵ���");
				YXZT="1";
			}

//			this.collectionMap.put("QTZT", QTZT);// ���� ֹͣ
//			this.collectionMap.put("YXZT", YXZT);// ���� ����
//			// this.collectionMap.put("SX", SX);
//			// this.collectionMap.put("LC", LC);
//			// this.collectionMap.put("XX", XX);
//			sendMessageByOutParam(YXParam+"_"+modbusAddr, QTZT,true);// ���� ֹͣ
//			sendMessageByOutParam(QTParam+"_"+modbusAddr, YXZT,true);// ���� ����
			System.out.println(YXParam+"_"+modbusAddr+"  ����������:"+ QTZT);
			System.out.println(QTParam+"_"+modbusAddr+"  ����״̬������ֹͣ:"+ YXZT);
			
		} catch (Exception localException) {
			System.out.println ("type:" + type + "," + modbusAddr + "�������ݲɼ��쳣!"+localException.getMessage());
		}
		
		
		
		
 		}
	
	
	
	

}
