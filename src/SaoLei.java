import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;

public class SaoLei {
  //新建JFrame对象并使用构造方法对其进行设置
  static JFrame frame = new JFrame();

  //创建构造方法
  public SaoLei() throws IOException {
    frame.setTitle("扫雷");
    frame.setSize(600, 700);
    //是否可改变窗口大小
    frame.setResizable(false);
    //设置点击关闭按钮时同时结束进程
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //设置布局为BorderLayout()
    /*
    BorderLayout()是一种布局管理器用于在容器中按照东、西、南、北和中间的方式排列组件。
    它将容器划分为五个区域，每个区域只能容纳一个组件，并根据指定的位置进行排列。
     */
    frame.setLayout(new BorderLayout());
//  引入设置头部布局的方法
    头部布局.setHeader();
    //添加雷区
    埋雷方法.addLei();
    //引入按钮设置方法进行布局
    按钮设置.setButtons();

    // 获取用户屏幕的尺寸
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    // 计算窗口的左上角坐标，使其居中
    int x = (screenSize.width - frame.getWidth()) / 2;
    int y = (screenSize.height - frame.getHeight()) / 2;
    //设置窗口位置
    frame.setLocation(x, y);
    //将窗口显示
    frame.setVisible(true);
  }


  public static void main(String[] args) throws IOException {
    new SaoLei();


  }
}
