import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 按钮设置 {
  //数据结构
  static int ROW = 20;   //创建20*20的二维数组
  static int COL = 20;
  //创建整型二维数组用来存放是否为类-1为雷，0表示空，1表示周围有1个雷以此类推
  static int[][] data = new int[ROW][COL];
  //定义按钮二维数组使用户可以按下方格
  static JButton[][] btns = new JButton[ROW][COL];
  //将原始图片传入变量
  static ImageIcon guessIcon = new ImageIcon("./img/guess.png");
  // 创建Image类型的变量，通过getImage获取到原始图像
  static Image originalImage = guessIcon.getImage();
  //创建Image类型的变量，通过getScaledInstance调正原始图像，并使用平滑缩放方法
  static Image resizedImage = originalImage.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
  // 将调整大小后的图像转换为ImageIcon赋值给resizedIcon
  static ImageIcon resizedIcon = new ImageIcon(resizedImage);


  //按钮设置方法
  static void setButtons() {
    //新建轻量级容器为con
    Container con = new Container();
    //设置con的布局为网格布局并指定为20行*20列
    con.setLayout(new GridLayout(ROW, COL));
//    遍历con网格布局并添加btns二维数组和按钮
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        //新建按钮并传入问号图片
        JButton btn = new JButton(resizedIcon);
        //为按钮创建监听器
        btn.addActionListener(new MyActionListener());
        //设置图片内边距为0
        btn.setMargin(new Insets(0, 0, 0, 0));
        //设置背景色
        btn.setBackground(Color.GRAY);
        //向con中添加按钮
        con.add(btn);
        //为每个按钮传入图片
        btns[i][j] = btn;
      }
    }
//    将con添加到frame中并在BorderLayout中居中
    SaoLei.frame.add(con, BorderLayout.CENTER);

  }

  //创建按钮监听器类（因以上类为static静态方法无法直接使用监听器）故新建静态内部类
  static class MyActionListener implements ActionListener {
    //按下按钮实现的方法
    public void actionPerformed(ActionEvent e) {
      //获取是哪个按钮触发的时间
      JButton btn = (JButton) e.getSource();
      //进行对btns数组进行循环判断是否为当前按钮触发的事件
      for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COL; j++) {
          if (btn.equals(btns[i][j])) {
            //如果用户打开格子为雷则调用结束方法否则调用联动方法
            if (data[i][j] == 埋雷方法.LEICODE) {

              //调用结束方法
              lose.lose();
            } else {
              //打开格子不为雷则调用联动方法并传入当前格子的位置
              联动开空格.openCell(i, j);
              //每次用户打开格子都进行判断是否为赢
              Win.Win();
            }
            //找到触发事件的按钮就返回，不在循环
            return;
          }
        }
      }
    }
  }

}
