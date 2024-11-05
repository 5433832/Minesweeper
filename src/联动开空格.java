import javax.swing.*;
import java.awt.*;

public class 联动开空格 {
  protected static void openCell(int i, int j) {
//    将用户打开格子的位置的按钮赋值给btn
    JButton btn = 按钮设置.btns[i][j];
//    如果按钮状态为false即为已被打开（即已被禁用就直接返回不在执行）
    if (!btn.isEnabled()) return;
    //如果是当前按钮触发的事件则将图标移除
    btn.setIcon(null);
    //按钮禁用
    btn.setEnabled(false);
    //设置不透明
    btn.setOpaque(true);
    //颜色
    btn.setBackground(Color.CYAN);
    //如果当前为值不为零则显示附近雷的数量
    if (按钮设置.data[i][j] != 0) {
      //显示文本为埋雷数组的值
      btn.setText(按钮设置.data[i][j] + "");
    }
    //调用提示增加方法
    addOpenCount();
    //如果用户按下的按钮没有雷就将周围没有埋雷的格子联动打开
    if (按钮设置.data[i][j] == 0) {
      //判断上方是否没有雷
      if (i > 0 && 按钮设置.data[i - 1][j] == 0) openCell(i - 1, j);
      //左边
      if (j > 0 && 按钮设置.data[i][j - 1] == 0) openCell(i, j - 1);
      //右方
      if (j < 19 && 按钮设置.data[i][j + 1] == 0) openCell(i, j + 1);
      //下方
      if (i < 19 && 按钮设置.data[i + 1][j] == 0) openCell(i + 1, j);
    }
  }

  protected static void addOpenCount() {
//    每开一个格子label1增加，label2减少
    头部布局.opened++;
    头部布局.unopened--;
    头部布局.label1.setText("待开格：" + 头部布局.unopened);
    头部布局.label2.setText("已开格：" + 头部布局.opened);
  }
}
