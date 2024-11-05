import javax.swing.*;

public class Win {
  //引入旗子图标
  static ImageIcon winFlageIcon = new ImageIcon("./img/win_flag.png");
  //引入胜利图标
  static ImageIcon win = new ImageIcon("./img/win.png");

  protected static void Win() {
    //定义未开格子总数变量
    int count = 0;
    //遍历btns数组判断btns数组没有被禁用的按钮总数
    for (int i = 0; i < 按钮设置.ROW; i++) {
      for (int j = 0; j < 按钮设置.COL; j++) {
        if (按钮设置.btns[i][j].isEnabled()) count++;
      }
    }
    //如果没有被禁用的按钮总数等于埋雷总数就遍历btns数组,将未被禁用的按钮设置旗子图标，并设置头部图标和弹出提示框
    if (count == 埋雷方法.LEICOUNT) {
      for (int i = 0; i < 按钮设置.ROW; i++) {
        for (int j = 0; j < 按钮设置.COL; j++) {
          //判断每个按钮是否没有被禁用，是则设置图标
          if (按钮设置.btns[i][j].isEnabled()) {
            按钮设置.btns[i][j].setIcon(winFlageIcon);
          }
        }
      }
      //更换头部图片
      头部布局.bannerBtn.setIcon(win);
      //弹出胜利提示框
      JOptionPane.showMessageDialog(SaoLei.frame, "胜利！");
    }
  }
}
