package monkey;

public class eat {
	
	public static int total(int day){

		if(day == 10){
		return 1;
		}
		else{
		day++;
		int sum=(total(day)+1)*2;
		return sum;
		}
	}
	public static int sum(int day) {
		if (day==10) {
			return 1;
		}else {
			day++;
			int count=(total(day)+1)*2;
			return count;
		}
		
	}
//	public static void main(String[] args) {
//		System.out.println("����Ϊ��....:"+sum(1));
//	}
	public static void main(String []args){
		int count=1;
		for(int i=0;i<9;i++)
		{
		//ÿ��Ե�����
		count=(count+1)*2;
		}
		System.out.println("��һ�칲ժ��"+count+"������");
		}
}
