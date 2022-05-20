package 实验八;
/* 模拟银行帐户类 */
class Mbank 
{
  private static int sum=1000;
  public synchronized static void take(int k) 
  {
    int temp=sum;
    temp-=k;
    try{Thread.sleep((int)(1000*Math.random()));}
    catch(InterruptedException e){   }
    sum=temp;
    if(sum<k){
        System.out.println(Thread.currentThread().getName()+"最后取值为："+sum);
        System.exit(0);
    }else{
    System.out.println("剩余于金额:"+sum);}
   }
}
/* 模拟用户取款的线程类 */
class Customer1 extends Thread
{
  public void run()
  {
    for (int i=1;i<=4 ;i++ )
    {
      Mbank.take(150);
      System.out.println("母亲取了150元");
    } 
  }
}
class Customer2 extends Thread
{
  public void run()
  {
    for (int i=1;i<=4 ;i++ )
    {
      Mbank.take(100);
      System.out.println("父亲取了100元");
    } 
  }
}
class Customer3 extends Thread
{
  public void run()
  {
    for (int i=1;i<=4 ;i++ )
    {
      Mbank.take(20);
      System.out.println("儿子取了20元");
    } 
  }
}
/* 调用线程的主类 */
public class test1
{
  public static void main(String[] args) 
  {
    Customer1 c1 = new Customer1();
    Customer2 c2 = new Customer2();
    Customer3 c3 = new Customer3();
    c1.start();
    c2.start();
    c3.start();
  }
}
