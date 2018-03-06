package HuiDiaoHanShu;

/**
 * �����С��
 * @author xiaanming
 * ʵ����һ���ص��ӿ�CallBack���൱��----->����һ
 */
public class Wang implements CallBack {
	/**
	 * С����������
	 * �൱��----->������
	 */
	private Li li; 

	/**
	 * С���Ĺ��췽��������С�������
	 * @param li
	 */
	public Wang(Li li){
		this.li = li;
	}
	
	/**
	 * С��ͨ���������ȥ��С�������
	 * @param question  ����С��Ҫ�ʵ�����,1 + 1 = ?
	 */
	public void askQuestion(final String question){
		//������һ���߳̾����첽��
		new Thread(new Runnable() {
			@Override
			public void run() {
				/**
				 * С������С���еķ�����������ע��ص��ӿ�
				 * ����൱��A�����B�ķ���C
				 */
				try {
					li.executeMessage(Wang.this, question);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}).start();
		
		//С����������ҵ��绰��ȥ�������������ˣ�ڿ��ȥ��
		play();
	}

	public void play(){
		System.out.println("���е��£�Ҫ��æ���Ժ�������");
	}

	/**
	 * С��֪���𰸺���ô˷�������С����������ν��С���Ļص�����
	 */
	@Override
	public void solve(String result) {
		System.out.println("С�����С���Ĵ���--->" + result);
	}
	
}
