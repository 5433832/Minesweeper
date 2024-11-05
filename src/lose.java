import javax.swing.*;

public class lose {
  //  获取地雷图片
  static ImageIcon bombicon = new ImageIcon("./img/bomb.png");
  //引入失败图片
  static ImageIcon failicon = new ImageIcon("./img/fail.png");

  protected static void lose() {
    //踩到雷后判定为输者
    //用户失败后将头部图片更换为失败图片
    头部布局.bannerBtn.setIcon(failicon);
//    遍历btns数组寻找哪个按钮没有被禁用并且为雷
    for (int i = 0; i < 按钮设置.ROW; i++) {
      for (int j = 0; j < 按钮设置.COL; j++) {
        //如果该按钮没有被禁用并且为雷则传入地雷图片,并设置为禁用
        if (按钮设置.btns[i][j].isEnabled() && 按钮设置.data[i][j] == 埋雷方法.LEICODE) {
          按钮设置.btns[i][j].setEnabled(false);
          //传入地雷图片
          按钮设置.btns[i][j].setIcon(bombicon);
          //设置组件在禁用状态下也显示正常图标
          按钮设置.btns[i][j].setDisabledIcon(bombicon);
        }
      }
    }
//    在父窗口frame中弹出提示框内容为“失败...”
    JOptionPane.showMessageDialog(SaoLei.frame, "你扫到地雷了！\n点击标题图片重新开始");
  }

}
