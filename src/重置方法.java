import javax.print.attribute.standard.MediaSize;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class 重置方法 {
  protected static void restart() {
    //遍历数组恢复数组和按钮
    for (int i = 0; i < 按钮设置.ROW; i++) {
      for (int j = 0; j < 按钮设置.COL; j++) {
        //将数组每个数都设为空（0）
        按钮设置.data[i][j] = 0;
        //设置按钮数组每个按钮的背景色
        按钮设置.btns[i][j].setBackground(Color.GRAY);
        //将每个按钮设置为未禁用
        按钮设置.btns[i][j].setEnabled(true);
        //设置按钮文本
        按钮设置.btns[i][j].setText("");
        //重新传入按钮图标
        按钮设置.btns[i][j].setIcon(按钮设置.resizedIcon);
      }
    }
    //将状态栏恢复
    头部布局.unopened = 按钮设置.ROW * 按钮设置.COL;
    头部布局.opened = 0;
    头部布局.计数 = 0;
    头部布局.label1.setText("待开格：" + 头部布局.unopened);
    头部布局.label2.setText("已开格：" + 头部布局.opened);
    //头部图片恢复
    头部布局.bannerBtn.setIcon(头部布局.bannerIcon);
    //重新添加雷
    埋雷方法.addLei();
  }

}
