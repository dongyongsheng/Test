package HuiDiaoHanShu;

public class testHuiDiao {
	public static void main(String[]args){
		/**
		 * new һ��С��
		 */
		Li li = new Li();

		/**
		 * new һ��С��
		 */
		Wang wang = new Wang(li);
		
		/**
		 * С����С������
		 */
		wang.askQuestion("1 + 1 = ?");
	}

}
