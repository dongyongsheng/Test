package timertest;
import java.util.Timer;


/**
 * Java 中Timer 定时器和定时任务使用
 * @author dys
 *
 */

public class TimerTest {
	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new MyTask(),1000,2000);//在1秒后执行此任务,每次间隔2秒执行一次,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.
		 while(true){//这个是用来停止此任务的,否则就一直循环执行此任务 
			 
			try {
				int in=System.in.read();
				if (in=='s') {
					timer.cancel();//使用这个方法退出任务  
					System.out.println("退出任务....");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
	  
		}

	}
	
	public static class MyTask extends java.util.TimerTask{
		@Override
		public void run() {
			System.out.println("测试。。。。。。");
			
		}		
	}
}
