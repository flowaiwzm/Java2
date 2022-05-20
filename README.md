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
##### 事件响应原理
1. 一是创建组成界面的各种元素和成分，指定它们的属性和位置关系
2. 二是定义图形用户界面的事件和个界面元素对不同时间的响应，从而实现用户界面与用户的交互功能
##### 事件处理模型的组成
1. 事件源(event source)
2. 事件对象 (event object)
3. 事件监听器 (event listener)
>**Java.awt.event包**定义了Java系统的一组事件监听接口类型，一个监听接口一般声明了一个或多个的抽象方法，再由用户来进行实现。
**这就证明了若需要对木哦个事件进行响应和处理时，程序员必须1.为组件实现规定接口的事件监听器；2.实现接口中所有声明的抽象方法**
列如：
```
<!-- 添加事件监听器 -->
JButton button=new JButton("Press ");   
//(1)为button组件注册事件监听器
button.addActionListener(new ButtonHandler());
<!-- 实现监听器的抽象方法 -->
//实现事件监听接口的类
class ButtonHandler implements ActionListener{
    //(2)实现事件处理方法。
public void actionPerformed(ActionEvent event){   
…//事件处理代码 }
} 
```
---
##### ActionEvent动作事件
>当点击某组件时，该事件被传递给使用组件的addActionListener方法注册的每一个ActionListener对象
>其主要动作有：点击按钮；双击列表的选项；选择菜单项；在文本框中输入回车；
>常用的方法有：string getActionCommand():返回引发事件的动作的命令字符串; string getSource():返回引发该事件的组件对象的引用
##### 窗口事件
>处理窗口事件的抽象方法：
void windowActivated(WindowEvent e) 
void windowClosed(WindowEvent e) 
void windowClosing(WindowEvent e) 
void windowDeactivated(WindowEvent e)
void windowDeiconified(WindowEvent e)
void windowIconified(WindowEvent e)
void windowOpened(WindowEvent e)
##### Java.awt.Container包
>这个包获取当前窗口的内容面板，该方法的方法的返回值是Container类对象`Container contentPane = getContentPane();`
其中的方法包含

|方法原型|说明|
|:---|:---|
|void setBackground(Color bg)|设置容器的背景色，由参数bg指定颜色|
|void setLayout(LayoutManager mgr)|设置容器的布局，参数是布局管理器|
|Component add(Component comp)|往容器中添加一个组件|
|Component add(Component comp, int index)|将指定组件添加到容器中的指定位置上|
|void remove(Component comp)|从容器中移除指定的组件|
|void removeAll()|从容器中移除所有组件|
|void repaint()|重新绘制当前容器|

**简单示例**
```
import java.awt.*;  //Container类和Color类在此包中
import javax.swing.*;
public class ContentPaneDemo extends JFrame {
 public ContentPaneDemo() {
   super("内容面板示例");
   //获得当前窗体的内容面板
   Container contentPane = this.getContentPane();        
   contentPane.setBackground(Color.RED); 
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setSize(300, 200);
   setResizable(false);  //设置窗体不可调整大小
   setVisible(true);
 }
 public static void main(String[] args) {
    ContentPaneDemo cpd = new ContentPaneDemo();
 }
}

```
**Java.awt.color(颜色)/java.awt.Font(字体)**
>构造方法:color(int r,int b,int g) rgb调色
>字体构造方法:Font(string name,int style,int size)
---
##### JComponent类组件的使用

1. JComponent类是除顶层容器外的所有swing组件的父类，其常用的子类有：
2. javax.swing.text.JtextComponent是下面方法的父类
   1. javax.swing.JtextField
   2. Javax.swing.JtextArea
   3. java.swing.JEditorPAne
3. 常用方法：

|方法名|功能|
|:---|:---|
|void  setText(String t)|设置文本内容|
|String  getText()|获取文本内容|
|boolean  isEdit()|检测文本的可编辑性|
|void  setEditable(boolean b)|设置文本的可编辑性|
|String  getSelectedText()|获取选取文本内容|
|void  select(int selStart,int selEnd)|选取文本内容|
|void  copy()|将选定的内容传输到剪贴板|
|void  cut()|将选定的内容传输到剪贴板，并把文本组件中的内容删除|
1. 文本组件和标签
>创建文本框JTextField类` JTextField　text = new    JTextField(String str); `
  >>JtextField的常用方法

|方法原型|说明|
|:---|:---|
|void setText(String text)|设置文本框中的文本|
|String getText()|获取文本框中的文本|
|void setHorizontalAlignment(int alignment)|设置文本框中文本的对齐方式，可以是JTextField.Left、JTextField.center和JTextField.right|
|void setEditable(boolean b)|设置文本框是否可以编辑|
|void setEnabled(boolean enabled)|设置启用文本框|
|void setVisible(boolean b)|设置文本框是否可见|

**简单示例**
```
import javax.swing.*;
import java.awt.FlowLayout;
public class TxtfdTest extends JFrame 
{
    JTextField txt;           //声明文本框对象
   TxtfdTest()
   {
      setSize(300,200);
      setVisible(true);
      setTitle("创建文本框示例");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //设置窗体为浮动布局
      setLayout(new FlowLayout());  
      //对象实例化
 
     txt=new JTextField(20);
      add(txt);            //将文本框添加到窗体中
      validate();
      //设置文本内容
      txt.setText("重新设置了文本");
   }   
}

public class Example5_9
{
     public static void main(String[] args) 
     {
	new TxtfdTest();
     }
}

```
   >密码框JpasswordField类是JtextField的子类其主要方法：
   ` setEchoChar(char c);(c为回显字符设置密码框的密文字符)`

**简单示例**
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Passwd extends JFrame implements ActionListener
{
   JLabel lb=new JLabel("请输入密码:");
   JPasswordField txt1=new  JPasswordField(25);
   JButton bn=new JButton("确定");
   JTextField txt2=new JTextField(25);
   Passwd()
   {
        setSize(300,200);
        setVisible(true);
        setTitle("密码验证");
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLayout(new FlowLayout());
        add(lb);
        add(txt1);
        txt1.setEchoChar('*');
        add(bn);
        add(txt2);
        validate();
        bn.addActionListener(this);
  }
 public void actionPerformed(ActionEvent e)
 {
      if (txt1.getText().equals("abc"))
	txt2.setText("密码正确!!");
     else
	txt2.setText("密码错误!!");
   }
}

public class  Example5_10
{
     public static void main(String[] args) 
     {
	new Passwd();
     }
}

```
   >文本区JtextArea
   >创建文本框：` JTextArea txt1 = new JTextArea(7,35);后面的数字代表的是行数和列数`
   >主要方法：

**简单示例**
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AreaTest extends JFrame implements ActionListener
{
  JTextArea txt1=new JTextArea(7,35);
  JTextField txt2=new JTextField(35);
  String str="窗外飘起蒙蒙小雨，\n平添一夜寒意，"+ "\n多少的思绪藏在心底,";
       // 轻轻一声叹别离。
 AreaTest()
  {
     setSize(400,200);
     setVisible(true);
     setTitle("文本组件示例");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLayout(new FlowLayout());
     txt1.setText(str);
     add(txt1);
     add(txt2);
     validate();
      txt2.addActionListener(this);
  }
 public void actionPerformed(ActionEvent e)
 {
      String s=txt2.getText();
      txt1.append("\n"+s);
   }
}
public class  Example5_11
{
    public static void main(String[] args) 
    {
          new AreaTest();
    }
}

```
>Jlabel标签类
  >标签是用户只能查看其内容但不能修改的文本组件，一般做说明之用

|方法原型|说明|
|:---|:---|
|void setText(String text)|设置标签上的文本|
|String getText()|获得标签上的文本|
|void setIcon(Icon icon)|设置标签中的图像|
|void setHorizontalAlignment(int alignment)|标签中文本的对齐方式|
|void setToolText(String text)|鼠标的显示文本|

**简单实例**
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class LbTest extends JFrame implements ActionListener
 {
   LbTest(String s)
   {  
    setSize(250,250);
    setVisible(true);
    setTitle(s);
    setLayout(new FlowLayout());
    ImageIcon icon1=new ImageIcon("s1.jpg");
    ImageIcon icon2=new ImageIcon("s2.jpg");
    ImageIcon icon3=new ImageIcon("s3.jpg");
    JButton jbtn=new JButton("按钮",icon1); 
    jbtn.setRolloverIcon(icon3);
    JLabel jlb=new JLabel("标签",icon2,SwingConstants. CENTER);
    jlb.setToolTipText("QQ头像");
    add(jbtn);
    add(jlb);
    jbtn.addActionListener(this);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    validate();
    }
 public void actionPerformed(ActionEvent e)
 {  
     JInternalFrame in_window;
     in_window =new JInternalFrame("内部窗体",true,true, true,true);
     in_window.setSize(250,200);
     in_window.setVisible(true);
     add(in_window);
     JTextArea text=new JTextArea(5,15);
     in_window.add(text,BorderLayout.CENTER);
   }
}

public class Example5_12
{ 
      public static void main(String args[])
       {
           LbTest win=new LbTest("有图标的按钮和标签");
       }
}

```
>单选按钮、复选框

![IMG](https://cdn.jsdelivr.net/gh/flowaiwzm/Photo@main/gongconghao20220502105220.png)
>java.swing.ButtonGroup
> 1. 单选按钮斌不具备单选效果，他必须依靠按钮才能到达单选的目的
> 2. ButtonGroup用来提供按钮，将一系列的按钮加入到同一个按钮组中，那么同一个按钮组中的按钮只能有一个被选择
> 3. 构造方法有` ButtonGroup() --创建一个新的按钮组`

按钮组中常用的方法
|方法原型|说明|
|:---|:---|
|void add (AbstractButton button)|将指定按钮添加到按钮中|
|int getButtonCount()|返回按钮组中按钮的数量|
|void remove(AbstractButton button)|将指定按钮从按钮组中删除|
|Enumeration getElement()|返回按钮组中所有的按钮|

>JCheckBox的常用方法
![](https://cdn.jsdelivr.net/gh/flowaiwzm/Photo@main/gongconghao20220502190626.png)
**简单实列**
```
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
class BRTest extends JFrame implements ItemListener,ActionListener
 { 
   JTextField text = new JTextField(15); ; 
   BRTest(String s)
   { 
     setSize(300,200);
     setVisible(true);
     setTitle(s);
     setLayout(new FlowLayout()); 
     // 添加三个复选框 
     JCheckBox cb1 = new JCheckBox("C语言"); 
     cb1.addItemListener(this); 
     add(cb1); 
     JCheckBox cb2 = new JCheckBox("C++语言"); 
     cb2.addItemListener(this); 
     add(cb2); 
     JCheckBox cb3 = new JCheckBox("Java语言"); 
     cb3.addItemListener(this); 
     add(cb3); 
     // 添加三个单选按钮 
     JRadioButton b1 = new JRadioButton("鲜花"); 
     b1.addActionListener(this); 
     add(b1); 
     JRadioButton b2 = new JRadioButton("鼓掌"); 
     b2.addActionListener(this); 
     add(b2); 
     JRadioButton b3 = new JRadioButton("鸡蛋"); 
     b3.addActionListener(this); 
     add(b3); 
       // 定义按钮组,单选按钮只有放到按钮组中才能实现单选功能 
     ButtonGroup bg = new ButtonGroup(); 
     bg.add(b1); 
     bg.add(b2); 
     bg.add(b3); 
     // 添加文本框 
     add(text); 
     validate();
     setDefaultCloseOperation(EXIT_ON_CLOSE);
   } 
   public void itemStateChanged(ItemEvent ie)
   { 
      JCheckBox cb = (JCheckBox)ie.getItem(); 
      text.setText(cb.getText()); 
   } 
   public void actionPerformed(ActionEvent ae)
   { 
      text.setText(ae.getActionCommand()); 
   } 
 }
  //主类
  public class Ex5_13
  {
       public static void main(String[] args) 
       {
	new BRTest("单选按钮和复选框示例");
       }
  }	
```
下拉列表
>下拉列表通常显示一个可选条目，允许用户在一个下拉列表中选择多个不同条目，用户也可以在文本区内键入选择项。JComBox的构造函数如下：` JComBOx() JComBox(vector v)其中 v是初始选项`  `若要增加选项则使用方法：void addItem(Object obj) (obj 加入下拉列表的对象)`
**创建包括一个下拉列表和一个标签的窗口，标签显示一个图标**
```
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
class CobTest extends JFrame implements ItemListener
{ 
      JLabel jlb; 
      ImageIcon france, germany, italy, japan;
      CobTest(String s)
      { 
         setSize(300,200);
         setVisible(true);
         setTitle(s);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLayout(new FlowLayout()); 
         JComboBox jc = new JComboBox(); 
         jc.addItem("中国"); 
         jc.addItem("俄罗斯"); 
         jc.addItem("韩国"); 
         jc.addItem("联合国"); 
         jc.addItemListener(this); 
         add(jc); 
         jlb = new JLabel(new ImageIcon("中国.jpg")); 
         add(jlb); 
         validate();
    } 
    public void itemStateChanged(ItemEvent ie)
    { 
       String s = (String)ie.getItem().toString(); 
       jlb.setIcon(new ImageIcon(s + ".jpg")); 
    } 
  } 
//主类 
public class Ex5_14
 {
       public static void main(String args[])
       {  
           new CobTest("下拉列表示例");   
       }
 }
```
ItemEvent事件响应
1. 当用户点击复选框(或者单选按钮)使其状态发现变化是就会ItemEvent事件
2. 用addItemListener()方法给复选框或单选按钮组件注册实现ItemListener接口的事件监听器
3. 实现接口中的抽象方法：`void itemStateChanged(ItemEvent event) `
4. ItemEven类的事件对象的方法
   >1. int getStateChange():获取当前复选框（或单选按钮）的状态值。该方法会返回ItemEvent.DESELECTED或者ItemEventSELECTED
   >2. Object getLtem() 得到当前复选框对象(或单选按钮)的引用
#### 列表JList
>列表(JList)组件允许用户从列表中选择一个单选或者选择多个多选对象。Jlist不支持直接滚动条的列表，需要将一个JList加入JScrollPane对象中。
>1. JList的常用构造方法` JList(Object[] listData)`构造一个JList，使其显示指定数组中的元素
JList对象的常用方法
   >1. void setVisibleRowCount(int visibleRowCount)设置不使用滚动条可以在列表中显示的预定行数
   >2. void setListData(Object[] listData) 用object数组设置JList的列表内容
   >3. int getSelectedIndex():返回所选的第一个索引；如果没有选择项，则返回-1
   >4. void setSelectionMode(int selectionMode) 确定允许单选选择还有多项选择模式
        >ListSelectionModel.SINGLE_SELECTION： 一次只能选择一个列表项；
        >ListSelectionModel.SINGLE_INTERVAL_SELECTION： 一次可选择多个连续的列表项；
        >ListSelectionModel.MULTIPLE_INTERVAL_SELECTION（默认设置）对多项列表选择没有限制。
    >5. int[] getSelectedIndices() 返回所选的列表项索引的数组(按升序排列)
    >6. Object getSelectValue() 返回所选的第一个列表项值。如果选择问空，则返回Null
    >7. Object[] getSelectValues()返回所选一组列表值
ListSelectionEvent事件响应
>当用户在JList中选择列表项使将产生ListSelectionEvent事件
实现接口的抽象方法：` void valueChanged(ListSelectionEvent event) `

**卡片选项页面简单实例**

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TtpDemo extends JFrame
{
  TtpDemo()
  {
    super("卡片选项页面示例");
    setSize(300,200);
    setVisible(true);
    JTabbedPane jtp = new JTabbedPane();
    ImageIcon icon1 = new ImageIcon("c1.png");
    ImageIcon icon2 = new ImageIcon("c2.png");
    ImageIcon icon3 = new ImageIcon("c3.png");
    jtp.addTab("城市", icon1, new CitiesPanel(), "城市名称");
    jtp.addTab("文学", icon2, new BookPanel(), "文学书目");
    jtp.addTab("网站", icon3, new NetPanel(), "精选网址");
    getContentPane().add(jtp);
    validate();
    addWindowListener(new WindowAdapter()
    {public void windowClosing(WindowEvent e)
        {System.exit(0);}});
  }
}
class CitiesPanel extends JPanel
{
  CitiesPanel()
  {
     JButton b1 = new JButton("北京");
     JButton b2 = new JButton("上海");
     JButton b3 = new JButton("深圳");
     JButton b4 = new JButton("厦门");
         add(b1);
    add(b2);
    add(b3);
    add(b4);
  }
} 
class BookPanel extends Jpanel  
{
  BookPanel()
  {
    JCheckBox cb1 = new JCheckBox("西游记");
    JCheckBox cb2 = new JCheckBox("三国演义");
    JCheckBox cb3 = new JCheckBox("红楼梦");
    add(cb1);
    add(cb2);
    add(cb3);
  }
}
class NetPanel extends JPanel
{
  NetPanel()
  {
    JComboBox jcb = new JComboBox();
    jcb.addItem("思维论坛");
    jcb.addItem("百度搜索");
    jcb.addItem("Java爱好者");
    add(jcb);
  }
}
public class Example5_15
{
  public static void main(String args[])
    { new TtpDemo();}
}
```
滑杆(JSilder)和进度指示条
>JSlider类的构造方法生成JSLider对象
 >>JSLider():创建范围为0至100，初值为50的水平滚动条
 >>JSlider(int orientation):创建范围为0至100，初值为50的水平或垂直滚动条，利用Horizontal和Vertical
 >>JSlider(int min,int max):创建范围为min至max,初值为min和max平均值的水平滚动条
 >>JSlider(int min,int max,int value)创建范围为min至max，初值为value的水平滚动条
 >>JSlider(int ori,int min,int max,int value)创建范围为min至max，初值为value的水平或垂直滚动条
 >>滚动条产生一个可以控制的事件ChangeEvent。

 **简单实列**
```
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
class P extends JPanel {
  JProgressBar pb = new JProgressBar();
  JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
  public P() {
    setLayout(new GridLayout(2,1));
    add(pb);
sb.setValue(0);
sb.setPaintTicks(true);
sb.setMajorTickSpacing(20);
sb.setMinorTickSpacing(5);
sb.setBorder(new TitledBorder("移动滑杆"));
    pb.setModel(sb.getModel()); 
    pb.setStringPainted(true);
    add(sb);
  }
}
public class Example5_16
{
  public static void main(String args[]) {
     Frame f=new Frame("滑杆和进度指示条");
     f.setSize(300,150);
     f.add(new P());
     f.show();
     f.addWindowListener(new WindowAdapter()
     {public void windowClosing(WindowEvent e)
        {System.exit(0);}});
 }
}
```

JTable表格

|方法名|功能|
|:-------|:-------|
|JTable()|创建一个新的JTable,使用系统默认的Model|
|JTable(int row,int col)|创建具有row行，col列的空表格|
|JTable(object[][]rowData, object[] columnNams)|创建显示二维数组数据表格，且可以显示列的名称,第一个参数是数据，第二个参数是在表格第一行中显示列的名称|
|JTable(TableModel dm ) |创建表格，并设置数据模式|
|JTable(Vector[][] rowData, Vector[] columnNams);|创建以Vector为输入来源的数据表格。第一个参数是数据，第二个参数是在表格第一行中显示列的名称|
|getModel()|获取表格的数据来源对象|

**简单示例**

```
class TableDemo extends JFrame
{
  public TableDemo()
  {
    super("员工档案表");
    String[] columnNames = {"姓名", "职务", "电话", "月薪", "婚否"};
    Object[][] data = {
      {"李  强", "经理", "059568790231", new Integer(5000), new Boolean(true)},
      {"吴  虹", "秘书", "059568790232", new Integer(3500), new Boolean(true)},
      {"陈卫东", "主管", "059568790235", new Integer(4500), new Boolean(false)},
      {"欧阳建", "保安", "059568790234", new Integer(2000), new Boolean(true)},
      {"施乐乐", "销售", "059568790237", new Integer(4000), new Boolean(false)}
    };
    JTable table = new JTable(data, columnNames);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    JScrollPane scrollPane = new JScrollPane(table);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
   pack();
   setVisible(true);
  } }

public class Example5_17{
  public static void main(String[] args) {  
     TableDemo frame = new TableDemo();  
} }
```
菜单与对话框
>一个**菜单栏**包含多个菜单，通过JFrame的setMenuBar的方法加入到一个JFrame中。一个菜单栏可以包含多个菜单对象，利用add方法增加菜单对象。**菜单JMenu**也是利用自身的add方法，可以增加菜单项(JmenuItem)或菜单(JMenu)对象；菜单项在菜单中表示一个选项，并可以注册一个动作监听器(ActionListener),以产生动作时间。

JMenu相关的构造函数和常用方法
![](https://cdn.jsdelivr.net/gh/flowaiwzm/Photo@main/gongconghao20220503144258.png)
创建步骤：
1. 建立菜单栏对象，并将菜单条对象添加到窗口中
` JMenuBar mbar=new JMenuBar();`
` setMenuBar(mbar);`
2. 创建菜单对象，并将菜单对象添加到菜单栏中
   ` menu1=new JMenu("File");`
   ` menu2=new JMenu("Edit");`
   ` mbar.add(menu1);`
   ` mbar.add(menu2);`
3. 创建菜单项对象，并将菜单项对象添加到相应的菜单中
   `m1=new JMenuItem("new");`
   ` m2=new JMenuItem("open");`
   ` m3=new JMenuItem("Save");`
   ` m4=new JMenuItem("Close");`
   ` menu1.add(m1);`
   ` menu2.add(m2);`
   ` menu3.add(m3);`
   ` menu4.add(m4);`
**简单实列**
```
import javax.swing.*;
import java.awt.event.*;
public class  Example5_19 extends JFrame implements ActionListener
 {  private JMenuItem fileNew = new JMenuItem("新建文件");
    private JMenuItem fileOpen = new JMenuItem("打开文件");
    private JMenuItem fileExit = new JMenuItem("退出");
    private JMenuItem editCut = new JMenuItem("剪切");
    private JMenuItem editCopy = new JMenuItem("复制");
    private JMenuItem editPaste = new JMenuItem("粘贴");
    public  Example5_19()
    {  super("菜单演示程序");
        JMenu file = new JMenu("文件");
        file.add(fileNew); fileNew.setEnabled(false);
        file.add(fileOpen); fileOpen.setEnabled(false);
        file.addSeparator();
        file.add(fileExit);  fileExit.setEnabled(true);
        JMenu edit = new JMenu("编辑"); 
        edit.add(editCut);   
    editCut.setEnabled(false);
    edit.add(editCopy); 
    editCopy.setEnabled(false);
    edit.add(editPaste); editPaste.setEnabled(false);
    JMenuBar bar = new JMenuBar();
    bar.add(file);
    bar.add(edit); 
    setJMenuBar(bar);
    fileExit.addActionListener(this);
    setSize(250,200);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
 public void actionPerformed(ActionEvent e)
 {  
        if(e.getSource() == fileExit)
	       System.exit(0);
		
  }
  public static void main(String args[])
  { 
     Example5_19 f = new  Example5_19();
   }
 }
```
**弹出式菜单实例**
```
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Example5_20 extends JFrame implements ActionListener 
{
  JPopupMenu popup = new JPopupMenu();//实例化
  JTextField txt = new JTextField(10);
  public Example5_20() 
  {
    super("右键弹出式菜单");
    setSize(300,250);
    setVisible(true);
    setLayout(new FlowLayout());
    add(txt);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    JMenuItem m1 = new JMenuItem("菜单项1");
    JMenuItem m2 = new JMenuItem("菜单项2");
    JMenuItem m3 = new JMenuItem("菜单项3");
    JMenuItem m4 = new JMenuItem("菜单项4");
    popup.add(m1);    
    popup.add(m2);	
    popup.add(m3);
    popup.addSeparator();	
    popup.add(m4);	
    m1.addActionListener(this);
    m2.addActionListener(this);
    m3.addActionListener(this);
    m4.addActionListener(this);
    addMouseListener(new MouseAdapter() 
    {
       public void mouseClicked(MouseEvent e)
       {
        if (e.getButton()==MouseEvent.BUTTON3)
        {//弹出右键菜单
           popup.show(e.getComponent(),
	               e.getX(), 
	               e.getY());
        } } });         
      validate();
  }
  public void actionPerformed(ActionEvent e)
  {
    txt.setText(((JMenuItem)e.getSource()).getText());
  }
  public static void main(String args[]) 
  {   new Example5_20();   }
}
```
对话框(JDialog)
>是一个有边框，有标题的独立存在的容器，是从某个窗口弹出的特殊窗口。对话框与JFrame一样，不能被其他容器所包容，但不能作为程序的最顶层的容器，也不能包含菜单.JDialog必须隶属一个Jframe窗口，并由这个JFrame窗口负责弹出，如果父窗口Jframe消失，它也会撤销。
>1. 有模式对话框 2. 无模式对话框
![](https://cdn.jsdelivr.net/gh/flowaiwzm/Photo@main/gongconghao20220503153410.png)
**设计一个本对话框与窗口传递数据的程序实例**
```
/*本示例说明对话框与窗口传递数据*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// 构造窗体类 
class Win extends JFrame  implements ActionListener 
{
    JButton btn1=new JButton("打开对话框");
    JTextArea txt=new JTextArea(5,8);
    Win()
    {
super("对话框与窗体传递消息");
setBounds(50,50,200,200);
setVisible(true);
/*   addWindowListener(new WindowAdapter()
      {
         public void windowClosing (WindowEvent e)
         {
	 System.exit(0);
        }
     } );
*/
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLayout(new BorderLayout());
     add(btn1,"North");add(txt,"Center");
     btn1.addActionListener(this);
     validate();
   }
 public void actionPerformed(ActionEvent e)
 {
     //实例化对话框
    Dia dia=new Dia(this, "传递消息对话框",true);
    dia.setVisible(true);//由于是有模模式的对话框，这时将产生阻塞，直到对话框关闭。
     //取到对话框传递来的消息，放到文本区中
    txt.append(dia.getMessage());
  }
}
//构造对话框类
class Dia extends JDialog implements ActionListener 
{   
JTextField txt=new JTextField(10);
//构造有模模式的对话框
 Dia(JFrame f, String s,boolean b)
 {
         super(f,s,b);
         setSize(300,100);
         setLayout(new FlowLayout());
  add(txt);
  txt.addActionListener(this) ;
  validate();
     }
     public void actionPerformed(ActionEvent e)
     {
        setVisible(false);
     }
    //把对话框的消息传递出去
    public String getMessage()
    {
       return txt.getText();
    }
}
//主类
public class Example5_21
{
     public static void main(String[] args) 
     {
	    new Win();
     }
}
```

**消息对话框实列**

```
/*  消息对话框  */
import javax.swing.*;
public class Example5_22  
{
  public static void main(String args[]) 
  {
     JOptionPane  d_input = new JOptionPane();
     String str = d_input.showInputDialog(null, "1+2=?");
     if (str.equals("3"))
        d_input.showMessageDialog(null, "回答正确。");
     else 
        d_input.showMessageDialog(null, "回答错误!");
        d_input.showConfirmDialog(null, "测试完毕!");
        System.exit(0);     //退出程序; 
  }
```
