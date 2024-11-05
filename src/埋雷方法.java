import java.util.Random;


public class 埋雷方法 {
    //定义雷数
    static int LEICOUNT = 30;//埋雷总数
    //-1为雷
    static int LEICODE = -1;

    static void addLei() {
        //新建随机数
        Random rand = new Random();
        for (int i = 0; i < LEICOUNT; ) {
//      在0-ROW-1之间生成一个随机数
            int r = rand.nextInt(按钮设置.ROW);
            int c = rand.nextInt(按钮设置.COL);
//      如果在两个随机的坐标内没有埋雷即没有-1的值就埋雷
            if (按钮设置.data[r][c] != LEICOUNT) {
                //埋雷
                按钮设置.data[r][c] = LEICODE;
//        埋雷后自加
                i++;
            }
        }
        //计算每个按钮周围雷的数量
        for (int i = 0; i < 按钮设置.ROW; i++) {
            for (int j = 0; j < 按钮设置.btns.length; j++) {
                //判断该格下面是否为雷是则直接跳过本次循环
                if (按钮设置.data[i][j] == LEICODE) {
                    continue;
                }
//        周围雷总和变量
                int c = 0;
                //判断用户按下格的左上方的格字是否为雷
                if (i > 0 && j > 0 && 按钮设置.data[i - 1][j - 1] == LEICODE) c++;
                //上方
                if (i > 0 && 按钮设置.data[i - 1][j] == LEICODE) c++;
                //右上
                if (i > 0 && j < 19 && 按钮设置.data[i - 1][j + 1] == LEICODE) c++;
                //左边
                if (j > 0 && 按钮设置.data[i][j - 1] == LEICODE) c++;
                //右方
                if (j < 19 && 按钮设置.data[i][j + 1] == LEICODE) c++;
                //座下
                if (i < 19 && j > 0 && 按钮设置.data[i + 1][j - 1] == LEICODE) c++;
                //下方
                if (i < 19 && 按钮设置.data[i + 1][j] == LEICODE) c++;
                //右下
                if (i < 19 && j < 19 && 按钮设置.data[i + 1][j + 1] == LEICODE) c++;
                //将该格子附近雷的总和赋值给该格子用于后续使用
                按钮设置.data[i][j] = c;
            }
        }
    }
}
