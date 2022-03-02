package 任务实验;

public class 任务三 {
    public static void main(String[] args) {
        int x=0;
        int y=20;
        int z=30;
        System.out.println(x<10 || x<10);
        System.out.println(x>y && y>x);
        System.out.println((x<y+z) && (x+10<=20));
        System.out.println(z-y==x && (y-z)==x);
        System.out.println(x<10 && x>10);
        System.out.println(x>y || y>x);
        System.out.println(!(x<y+z) || !(x+10<=20));
        System.out.println(( !(x==y)) && (x !=y) && (x<y || y<x));
    }
    
}
