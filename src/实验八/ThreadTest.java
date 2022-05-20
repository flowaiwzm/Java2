package 实验八;
 
public class ThreadTest {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
 
		TeacherThread teacher=new TeacherThread("teacher");
		Stu1Thread stu1=new Stu1Thread("stu1");
		Stu2Thread stu2=new Stu2Thread("stu2");
		//stu1.start();
		//stu2.start();
		try {
			stu1.sleep(2*1000);
			stu2.sleep(4*1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		teacher.start();
		stu1.start();
		stu2.start();
		
	}
 
	
}
class TeacherThread extends Thread{
	String threadName;
	public TeacherThread(String threadName)
	{	System.out.println("本线程的名字:" + threadName );
		this.threadName=threadName; 
	}
	public void run()
	{
		for(int i=0;i<4;i++)
			System.out.println("teacher:上课");
		
	}
	
}
class Stu1Thread extends Thread{
	String threadName;
	public Stu1Thread(String threadName)
	{	System.out.println("本线程的名字:" + threadName );
		this.threadName=threadName; 
	}
	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		System.out.println("本线程" + threadName+"被唤醒" );
	}
	
}
class Stu2Thread extends Thread{
	String threadName;
	public Stu2Thread(String threadName)
	{	System.out.println("本线程的名字:" + threadName );
		this.threadName=threadName; 
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
		System.out.println("本线程" + threadName+"被唤醒" );
	}
	
}
 
 
