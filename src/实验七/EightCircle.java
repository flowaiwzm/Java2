package 实验七;

import javax.swing.*;import java.awt.*;
public class EightCircle extends JFrame {
    public EightCircle(){
        super("在窗体上绘制八个同心圆");
    }
    public void paint(Graphics g){
    g.setColor(Color.red);
    g.drawOval(200,200,10,10);g.drawOval(180,180,50,50);g.drawOval(160,160,90,90);g.drawOval(140,140,130,130);g.drawOval(120,120,170,170);g.drawOval(100,100,210,210);g.drawOval(80,80,250,250);g.drawOval(60,60,290,290);
    }
    public static void main(String[] args){
        EightCircle ec = new EightCircle();ec.setSize(500,400);
        ec.setVisible(true);
    }
}
    
