package 实验六.任务一;

 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class test1 {
	public static void main(String args[]) {
		new WindowFlow();
	}
 
}
 
class WindowFlow extends JFrame {
	private static final long serialVersionUID = 1L;
	poSta police = new poSta();
	JTextField txt1 = new JTextField(10);
	JLabel lbl1 = new JLabel("请输入:");
 
	WindowFlow() {
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		add(lbl1);
		add(txt1);
		txt1.addActionListener(police);
 
		setVisible(true);
		setBounds(100, 200, 200, 100);
	}
 
	class poSta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String n = e.getActionCommand();
			switch (Integer.parseInt(n)) {
			case 1:
				lbl1.setText("one");
				break;
			case 2:
				lbl1.setText("two");
				break;
			case 3:
				lbl1.setText("three");
				break;
			case 4:
				lbl1.setText("four");
				break;
			case 5:
				lbl1.setText("five");
				break;
			case 6:
				lbl1.setText("six");
				break;
			case 7:
				lbl1.setText("seven");
				break;
			case 8:
				lbl1.setText("eight");
				break;
			case 9:
				lbl1.setText("nine");
				break;
			default:
				System.out.println("您输入的数字不正确");
			}
		}
	}
} 