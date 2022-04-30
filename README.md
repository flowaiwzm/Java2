# Java图形用户设计
## 知识点集合
> 1. 用户界面一般包含菜单，输入和输出组件，按钮，画板，窗口和对话框等组件
> 2. 用户界面包主要包含awt组件和swing组件
> ![](http://127.0.0.1:5501/images/1.png)
> >swing是AWT的扩展，swing里面的组件都以J开头。且swing中的组件都与awt中的组件具有相同基类（尽量避免同时使用两者）
---
### 窗口容器和组件
##### 1. 窗口容器JFrame类
>概念：Jframe是带有标题，边框的顶层窗体，窗体是一个容器，可在它的内部添加其他组件![](http://127.0.0.1:5501/images/2.png)
>实现代码:
>创建窗体:
` JFrame win = new JFrame(“最简单窗体”);`
>常用方法：
`JFrame(String s);        //创建标题为s的窗体`
`public void setSize(int width,int height)                  //设置宽和高`
`public void setTitle(String title);       //设置标题内容`
`  public void setVisible(boolean v)                  //设置窗口是否可见`
`public void setResizable(boolean b)                  //是否可调大小`
`public void setDefaultCloseOperation(EXIT_ON_CLOSE) //设置关闭窗体，退出程序`
`public void validate()  //使窗体中的组件为可见`
`public void setMenuBar(MenuBar m)        //设置菜单`

**简单示例**

```
    import javax.swing.*;
    class Example5_1 
    {
        public static void main(String[] args) 
        {
            JFrame win=new JFrame("最简单窗体");//实例化Jframe窗口对象
            win.setSize(300,200);//设置窗口大小
            win.setVisible(true);//窗口可见
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
        }
    }
```

---
##### 2. 按钮和事件处理

 > 1. 按钮JButton类
 > 2. 构造方法

 |构造方法|说明|
 |:---|:---|
 |JButton()|创建一个空按钮|
 |JButton(String text)|创建一个带文本的按钮|
 |JButton(Icon icon)|创建一个带图标的按钮|
 |JButton(String text, Icon icon)|创建一个带文本和图标的按钮|
> ![](http://127.0.0.1:5501/images/3.png)
> 3. 处理按钮事件
>>需要用到ActionListener接口
>>接口实现形式：
```
class  ClassName  implements ActionListener 
     {
     　  …
　　　btn.addActionListener(this);
           …
　　   public void actionPerformed(ActionEvent e)
           { 
              …
            }
      }
```
>> 实现处理
` 对象名.addActionListener(ClassName); (className-监视器)`
>> ActionEvent事件响应
>>1. 当用户单击一个按钮时就会引发一个动作事件ActionEvent
>>2. 调用JButton的方法addActionListener接口的事件监听器 

**简单实例**
```
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class BtnIcon extends JFrame implements ActionListener
{
   //创建图标对象
   ImageIcon icon = new ImageIcon("win.jpg");
   JButton jbtn = new JButton("打开新窗体",icon);
   BtnIcon()
   {
      setSize(200,200);
      setVisible(true);	
      setTitle("按钮功能演示");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      add(jbtn);
      validate();
      jbtn.addActionListener(this);
   } 
  public void actionPerformed(ActionEvent e)
  { 
      JFrame newf=new JFrame("新建窗体");
      newf.setSize(150,150);
      newf.setVisible(true);
   }
}

public class Example5_4
 {
     public static void main(String[] args) 
     {
         new BtnIcon();
     }
 }

```
##### 3. 面板容器和界面布局
>创建面板JPanel类对象
>>1. 创建面板对象`Panel myPanel=new Panel();`
>>2. 将面板添加到窗口容器中`add(myPanel);`
>>3. 把组件放置到面板上` myPanel.add(其他组件); `

**简单示例:**
```
import java.awt.*;
import javax.swing.*;
class PanelTest extends JFrame
{  
        Panel panel1=new Panel(); 
        Panel panel2=new Panel();  
        Button button1=new Button("Button1");
        Button button2=new Button("Button2");
        Button button3=new Button("Button3");
        Button button4=new Button("Button4");	
        PanelTest()
        {
           setSize(200,150);
           setVisible(true);
           setTitle("面板容器示例");  
         setDefaultCloseOperation(EXIT_ON_CLOSE);
           setLayout(new FlowLayout());
          //将面板容器加入到窗体
          add(panel1); 
          add(panel2);
          //将其他组件加入到面板容器中
        panel1.add(button1); 
        panel1.add(button2);
        panel2.add(button3); 
        panel2.add(button4);
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.cyan);
        validate();
    }
}

public class Example5_5
{
       public static void main(String[] args) 
       {
	new PanelTest();
       }
}
```
>界面布局策略
>分类：FlowLayout(浮动布局)、BorderLayout(边界布局)、CardLayout(卡片布局)、GridLayout(网格布局)、GridBagLayout()
>1. 浮动布局FlowLayout
>>按照组件的顺序，用add方法将组件从左至右在一行排列，一行放不下时就会自动换行。每行组件均按居中方式进行排列。设计方法为:` setLayout(new FlowLayout()); `
>2. 边界布局BorderLayout
>>将容器划分为North、south 、west、east、center。每个组件用add方法放置在区域当中。中间的区域的空间最大。设置方法： ` setLayout(new BorderLayout()); add("East",   new JButton("东"));`

**简单实列**
```
import java.awt.*;
import javax.swing.*;
class BordTest extends JFrame
{  
    BordTest()
    {
       setSize(300,200);
       setVisible(true);
       setTitle("边界布局示例");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
       //将其他组件加入到窗体
       add("East",   new JButton("东"));
       add("South",  new JButton("南"));
       add("West",   new JButton("西"));
       add("North",  new JButton("北"));
       add("Center", new JButton("中"));
       validate();
    }
}
public class Example5_6
{
   public static void main(String[] args) 
   {
        new BordTest();   
    }
}

```
>3. 网格布局GridLayout
>>GridLayout类以矩阵网格形式对容器中的组件进行布局，容器被分为大小相等的单元格，单元格的大小由最大的构建所决定，用add方法将组件一行一行的从左至右放置到布局的每一个单元格中。设置方法：
` setLayout(new GridLayout(int row, int cols));{(row 行；cols 列)}`

**简单示例：**
```
import java.awt.*;
import javax.swing.*;
class GridTest extends JFrame
{  
   GridTest()
   {
       setSize(300,200);
       setVisible(true);
       setTitle("网格布局示例");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridLayout(3,3));
        for (int i=1;i<=9 ;i++ )
        { 
             add(new JButton("按钮"+i));   }
             validate();
    }
}
public class Example5_7
{
     public static void main(String[] args) 
     {
          new GridTest();
     }
}
```
>4. 卡片布局CardLayout
>> 此布局可以包含多个组件，但实际上某时刻容器只能从这些组件中选出一个来显示。设置方法:
`setLayout(new CardLayout()); `
卡片的顺序由组件对象本身在容器内部的顺序决定。
>>主要方法

|方法|说明|
|:---|:---|
|first(Container parent) |显示容器parent中的第一张卡片|
|next(Container parent) |显示容器parent中的下一张卡片|
|previous(Container parent) |显示容器parent中的前一张卡片|
|last(Container parent) |显示容器parent中的最后一张卡片。|
**简单实列**:
```
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class CardTest extends JFrame implements ActionListener
{  
    JButton btn[] = new JButton[5];
    CardLayout card = new CardLayout();
    Panel p =new Panel();
    CardTest()
    {   
        setSize(300,200);
        setVisible(true);
        setTitle("卡片布局示例");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(p);
        p.setLayout(card);
        for (int i=1;i<=4 ;i++ )
        { 
            btn[i] = new JButton("卡片"+i);
            p.add(btn[i],"卡片标识"+i);
            btn[i].addActionListener(this);	
        }
        validate();
     }
public void actionPerformed(ActionEvent e)
    {
        card.next(p);
    }
}

public class Example5_8
{
       public static void main(String[] args) 
       {
	    new CardTest();
       }
}
```
>5. NULL布局
>>用setLayout(null)可以不用布局，此时可以对组件进行绝对定位。方法：
` public void setBounds(int x,int y,int w,int h)`
>6. 使用JPanel实现复杂布局

**简单示例**
```
public class MainFrame extends JFrame {
 private JTextField txtInput;  //接受输入的文本框
 private JLabel lblMsg;        //显示提示信息的标签
 private JPanel pnlSouth;   //边界布局中，放在南边的面板，用于布局嵌套
 private JButton btnGuess, btnAnew, btnExit;  //三个按钮
 public MainFrame() {
  pnlSouth = new JPanel();                   //创建面板
  pnlSouth.setLayout(new GridLayout(1,3)); //设置面板为1行3列的网格布局
  pnlSouth.add(btnGuess);                    //将三个按钮添加到面板中
  pnlSouth.add(btnAnew);
  pnlSouth.add(btnExit);
  setLayout(new BorderLayout());      //设置窗体为边界布局
  add(txtInput, BorderLayout.NORTH);  //将组件添加到相应位置
  add(lblMsg, BorderLayout.CENTER);
  add(pnlSouth, BorderLayout.SOUTH);  //将面板添加到边界布局的南面
 }
}

```
