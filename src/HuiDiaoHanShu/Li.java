package HuiDiaoHanShu;


/**
 * �������С����
 * @author xiaanming
 *
 */
public class Li {
	/**
	 * �൱��B���в���ΪCallBack callBack��f()---->������
	 * @param callBack  
	 * @param question  С���ʵ�����
	 * @throws InterruptedException 
	 */
	public void executeMessage(CallBack callBack, String question) throws InterruptedException{
		System.out.println("С���ʵ�����--->" + question);
		
		//ģ��С����Լ���������Ҫ�ܳ�ʱ��
		Thread.sleep(1000);
		
		/**
		 * С������Լ�������֮���뵽�˴���2
		 */
		String result = "����2";
		
		/**
		 * ���Ǿʹ�绰����С��������С���еķ���
		 * ����൱��B�෴��������A�ķ���D
		 */
		callBack.solve(result); 

		
		
	}
	
}

