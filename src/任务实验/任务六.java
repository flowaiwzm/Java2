package 任务实验;
import java.util.Scanner;
public class 任务六 {
    public static void main(String[] args) {
        int i=1;
        while(i!=0){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num=sc.nextInt();
        System.out.println("输入的整数为："+num);
        java.util.Random random=new java.util.Random();
        int rn=random.nextInt(100)+1;
        System.out.println("随机生成的数为："+rn);
        if(num>rn)
        {
            System.out.println("输入的整数大于随机生成的整数");
            break;
        }
        else if(num<rn){
            System.out.println("输入的整数小于随机生成的整数");
            break;
        }
        else if(num==rn){
            System.out.println("输入的整数等于随机生成的整数");
            break;
        }
        }
    }
    
}