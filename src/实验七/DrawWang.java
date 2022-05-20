package 实验七;

import javax.swing.*;import java.awt.*;
public class DrawWang extends JFrame {
    public DrawWang(){
    super("在窗体上绘制一个王字");
}
public void paint(Graphics g){
    g.setColor(Color.red);
    g.drawLine( 10,50,100,50);
    g.drawLine(10,100,100,100);
    g.drawLine( 10,150,100,150);
    g.drawLine(50,50,50,150);
    }
public static void main(String[] args){
DrawWang dw = new DrawWang();dw.setSize(150,200);
dw.setVisible(true);
}
}
