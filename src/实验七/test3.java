package 实验七;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class FontSet extends JFrame implements ItemListener, ActionListener{
	JRadioButton jrbRed = new JRadioButton("红色",true);
	JRadioButton jrbGreen = new JRadioButton("绿色");
	JRadioButton jrbBlue = new JRadioButton("蓝色");		
	private ButtonGroup bg = new ButtonGroup();
	JRadioButton jcb1 = new JRadioButton("加粗");
	JRadioButton jcb2 = new JRadioButton("斜体");	
	JRadioButton jcb3 = new JRadioButton("粗斜体");
	JRadioButton jcb4 = new JRadioButton("普通");	
    private ButtonGroup bz = new ButtonGroup();
	JComboBox listFont1;
	JComboBox listFont2;
	JComboBox listFont3;
	JComboBox listFont4;
	JComboBox listSize;
	JTextArea taDemo;
	JButton btnExit,btnEdit;
	
	public FontSet(){
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = g.getAvailableFontFamilyNames();
		
		Box boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("请选择字体"));
		listFont1 = new JComboBox(fontName);
		boxV1.add(new JScrollPane(listFont1));
		boxV1.add(Box.createVerticalStrut(155));
				
		Box boxV2 = Box.createVerticalBox();
		boxV2.add(new JLabel("请选择字号"));
		String strSize[] = new String[30];
		for(int i=0;i<30;i++){
			strSize[i] = ""+(i+16);
		}
		listSize = new JComboBox(strSize);
		boxV2.add(new JScrollPane(listSize));
        boxV2.add(Box.createVerticalStrut(155));
		
		Box boxV3 = Box.createHorizontalBox();
		boxV3.add(new JLabel("请选择字形"));		
		boxV3.add(jcb1);
		boxV3.add(jcb2);
		boxV3.add(jcb3);
		boxV3.add(jcb4);
        boxV3.add(Box.createHorizontalGlue());
        bz.add(jcb1);
        bz.add(jcb2);
        bz.add(jcb3);
        bz.add(jcb4);
		
		Box boxV4 = Box.createVerticalBox();		
		boxV4.add(new JLabel("请选择字色"));
		boxV4.add(jrbRed);
		boxV4.add(jrbGreen);
		boxV4.add(jrbBlue);
		boxV4.add(Box.createVerticalGlue());
		
		bg.add(jrbRed);
		bg.add(jrbGreen);
		bg.add(jrbBlue);
		
		Box boxH1 = Box.createHorizontalBox();
		boxH1.add(boxV3);
		boxH1.add(Box.createHorizontalStrut(15));
		boxH1.add(boxV4);
        boxH1.add(Box.createHorizontalStrut(15 ));
		
		Box boxH2 = Box.createHorizontalBox();
		taDemo = new JTextArea("这是字体设置的测试文字",5,20);
		boxH2.add(taDemo);
		
		Box boxV5 = Box.createVerticalBox();
		
		btnExit = new JButton("退出");
		btnEdit = new JButton("编辑");
		boxV5.add(btnExit);
		boxV5.add(btnEdit);	
		boxH2.add(boxV5);

		btnExit.addActionListener(this);
		btnEdit.addActionListener(this);

        Box boxH3 = Box.createHorizontalBox();
        boxH3.add(boxV1);
		boxH3.add(Box.createHorizontalStrut(15));
        boxH3.add(boxV2);
		
		Box baseBox = Box.createVerticalBox();
		baseBox.add(boxH1);
		baseBox.add(boxH2);
        baseBox.add(boxH3);
        
		// baseBox.add(boxH2);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(baseBox);
		
		setTitle("字体设置器");
		setBounds(200,200,570,380);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void itemStateChanged(ItemEvent e){		
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btnExit) {
			dispose();
		}
		else if (e.getSource() == btnEdit){
			int style = Font.PLAIN;
			if(jcb1.isSelected()) 
				style |= Font.BOLD;
			if(jcb2.isSelected()) 
				style |= Font.ITALIC;
			
			if(jrbRed.isSelected())
				taDemo.setForeground(Color.RED);
			if(jrbGreen.isSelected())
				taDemo.setForeground(Color.GREEN);
			if(jrbBlue.isSelected())
				taDemo.setForeground(Color.BLUE);
	
			String strFont = (String)listFont1.getSelectedItem();
			Font ft = new Font(strFont,style,listSize.getSelectedIndex()+16);
			taDemo.setFont(ft);
		}
	}
	
	public static void main(String[] args){
		FontSet A = new FontSet();
	}}

