package 任务实验;

public class 任务五 {
    public static void main(String[] args) {
        {
            int i,j,sum;
            for(i=3;i<=1000;i++)
            {
                sum=1;
              for(j=2;j<i;j++)
              {
                if(i%j==0)
                {
                sum+=j;
                }
              }
              if(sum==i)
              {
              System.out.println("其完数有："+sum);
              }
            
            }
            }
    }
    
}
