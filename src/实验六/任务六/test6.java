package 实验六.任务六;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
 
class mynotepad extends JFrame
{
    File file=null;
   	Color color=Color.red;
   	mynotepad()
   	{
    	initTextContent();
   		initMenu();
   		initAboutDialog();
   	}
   	
   	void initTextContent()
   	{
   		getContentPane().add(new JScrollPane(content)); 
   	}
    
    JTextPane content=new JTextPane(); 
    JFileChooser openfile=new JFileChooser();
    JColorChooser opencolor=new JColorChooser();
    JDialog about=new JDialog(this);
    JMenuBar menu=new JMenuBar();
   	//菜单栏的各个菜单项
	JMenu[] menus=new JMenu[]{new JMenu("文件"),new JMenu("编辑"),new JMenu("工具"), new JMenu("关于")};JMenuItem optionofmenu[][]=new JMenuItem[][]{{new JMenuItem("新建"),new JMenuItem("打开"),new JMenuItem("保存"),new JMenuItem("退出")},{new JMenuItem("复制"),new JMenuItem("剪切"),new JMenuItem("粘贴"),new JMenuItem("颜色")},{new JMenuItem("工具")},{new JMenuItem("关于")}};
   	void initMenu()
    {
      	for(int i=0;i<menus.length;i++)
      	{
      	  	menu.add(menus[i]);
      	  	for(int j=0;j<optionofmenu[i].length;j++)
      	  	{
      	  		menus[i].add(optionofmenu[i][j]);
      	  		optionofmenu[i][j].addActionListener( action );
      	  	}
      	}
      	this.setJMenuBar(menu);
    } 
    
    ActionListener action=new ActionListener()
    {                   //添加事件监听
    	public void actionPerformed(ActionEvent e)
    	{
     		String name = e.getActionCommand();
			JMenuItem MI=(JMenuItem)e.getSource();
			if("新建".equals(name))
			{
				content.setText("");
				file=null;
			}
			else if("打开".equals(name))
			{
            	if(file !=null)
            		openfile.setSelectedFile(file);
                int returnVal=openfile.showOpenDialog(mynotepad.this);
                if(returnVal==JFileChooser.APPROVE_OPTION)
                {
					file=openfile.getSelectedFile();
                    unfold();
                }
 
	     	}
	     	else if("保存".equals(name))
	     	{
	      		if(file!=null) openfile.setSelectedFile(file);
          		int returnVal=openfile.showSaveDialog(mynotepad.this);
                if(returnVal==JFileChooser.APPROVE_OPTION)
                {
                	file=openfile.getSelectedFile();
                  	saving();
                }
           
            }
            else if("退出".equals(name))
            {
            	mynotepad f=new mynotepad();
            	int s=JOptionPane.showConfirmDialog(f,"退出？","退出",JOptionPane.YES_NO_OPTION);
                if(s==JOptionPane.YES_OPTION)
                System.exit(0);
            }
            else if("剪切".equals(name))
            {
           	 	content.cut();
            }
            else if("复制".equals(name))
            { 
            	content.copy();
            }
            else if("粘贴".equals(name))
            {
            	content.paste();
            }
            else if("颜色".equals(name))
            { 
            	color=JColorChooser.showDialog(mynotepad.this,"",color);
                content.setForeground(color);
                 
    		}
    		else if("关于".equals(name))
    		{
              about.setSize(300,150);
     		}
    
   		} 
 	}; 
 	
 	void saving()
 	{
    	try
    	{
        	FileWriter Writef=new FileWriter(file);
        	Writef.write(content.getText());
        	Writef.close();
        }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
 
    }                
  	
  	void unfold()
  	{
    	try
    	{
        	FileReader Readf=new FileReader(file);
         	int len=(int)file.length();
           	char []buffer=new char[len];
          	Readf.read(buffer,0,len);
            Readf.close();
            content.setText(new String(buffer));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
  
  	void initAboutDialog()
  	{
      	about.setLayout(new GridLayout(3,1));
      	about.getContentPane().setBackground(Color.white);
      	about.getContentPane().add(new JLabel("我的记事本程序"));//对话框内容
      	about.getContentPane().add(new JLabel("制作者：Fwx"));
      	about.getContentPane().add(new JLabel("2007年12月"));
      	about.setModal(true);                        //设置对话框前端显示
      	about.setSize(100,100);                        
      	about.setLocation(250,170);                  //设置对话框显示位置
    };
}   
 
public class test6
{
	public static void main(String args[])
	{                          //入口main函数
		mynotepad noted=new mynotepad();
        noted.addWindowListener(new WindowAdapter()
        {
        
        });
        noted.setTitle("我的记事本程序");           //记事本标题
		noted.setSize(640,320);                  //设置记事本大小                       
		noted.setLocation(150,100);              //设置记事本显示位置
	}
}
