import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class 头部布局 {

  //创建图标变量引入标题图片
  static ImageIcon bannerIcon = new ImageIcon("./img/banner.png");
  public static JButton bannerBtn = new JButton(bannerIcon);
  //未开方格
  static int unopened = 按钮设置.ROW * 按钮设置.COL;
  //已开方格
  static int opened = 0;
  //新建计数变量来计算用户游戏时间
  static int 计数 = 0;
  //创建两个JLabel对象用来放在标题图片下方提示用户
  public static JLabel label1 = new JLabel("待开格：" + 头部布局.unopened);
  public static JLabel label2 = new JLabel("已开格：" + 头部布局.opened);

  public static void setHeader() {
    //新建画布并传入井字布局
    JPanel panel = new JPanel(new GridBagLayout());

//    为头部按钮添加监听器，按下头部按钮后调用重置方法
    bannerBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        重置方法.restart();
      }
    });
    //设置不透明
    label1.setOpaque(true);
    //设置背景颜色
    label1.setBackground(Color.white);
    //设置边框（利用BorderFactory创建灰色线性边框）
    label1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

    //设置不透明
    label2.setOpaque(true);
    //设置背景颜色
    label2.setBackground(Color.white);
    //设置边框（利用BorderFactory创建灰色线性边框）
    label2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

    /*
    创建GridBagConstraints类的GridBagConstraints对象对GridBagLayout进行约束
    详解：GridBagConstraints（起始网格位置0列，0行，占据3列，1行，拉伸权重为相同1.0，1.0，设置组件对齐方式为居中，设置组件为水平垂直方向都拉伸，组件内边距为0，组件外部填充为0）
     */
    GridBagConstraints c1 = new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    //向panel添加标题按钮，并用c1进行布局
    panel.add(bannerBtn, c1);
    GridBagConstraints c2 = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
//    向panel内添加label1并用c2进行布局
    panel.add(label1, c2);

    GridBagConstraints c3 = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
//    向panel内添加label1并用c2进行布局
    panel.add(label2, c3);


//    在frame对象的北部添加井字布局
    SaoLei.frame.add(panel, BorderLayout.NORTH);
  }
}
