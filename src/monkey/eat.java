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
//		System.out.println("总数为：....:"+sum(1));
//	}
	public static void main(String []args){
		int count=1;
		for(int i=0;i<9;i++)
		{
		//每天吃的桃子
		count=(count+1)*2;
		}
		System.out.println("第一天共摘了"+count+"个桃子");
		}
}
