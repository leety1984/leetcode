import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 示例 1:
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 */
public class LeetCode149 {
    /**
     * 暴力法
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        int max = 0;
        for (int i = 0; i < points.length; i++) {
            //和i一样的点
            int totalSame = 1;
            for (int j = i + 1; j < points.length; j++) {
                int total = 0;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    totalSame++;
                } else {
                    total = 1;
                    for (int k = j + 1; k < points.length; k++) {
                        if (isLine(points[i][0], points[i][1], points[k][0], points[k][1], points[j][0], points[j][1])) {
                            total++;
                        }
                    }
                }
                total = total + totalSame;
                if (total > max) {
                    max = total;
                }
            }
        }
        return max;
    }

    private boolean isLine(long x1, long y1, long x2, long y2, long x3, long y3){
        //斜率相等的通分后结果 注意溢出
        return x1*y2 + x2*y3 + x3*y1 - x1*y3 - x2*y1 - x3*y2 == 0;
    }

    public static void main(String[] args) {
        LeetCode149 leetCode149 = new LeetCode149();
//        System.out.println(leetCode149.maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
//        System.out.println(leetCode149.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
//        System.out.println(leetCode149.maxPoints(new int[][]{{40,-23},{9,138},{429,115},{50,-17},
//        {-3,80},{-10,33},{5,-21},{-3,80},{-6,-65},{-18,26},{-6,-65},{5,72},{0,77},
//        {-9,86},{10,-2},{-8,85},{21,130},{18,-6},{-18,26},{-1,-15},{10,-2},{8,69},
//        {-4,63},{0,3},{-4,40},{-7,84},{-8,7},{30,154},{16,-5},{6,90},{18,-6},
//        {5,77},{-4,77},{7,-13},{-1,-45},{16,-5},{-9,86},{-16,11},{-7,84},{1,76},
//        {3,77},{10,67},{1,-37},{-10,-81},{4,-11},{-20,13},{-10,77},{6,-17},
//        {-27,2},{-10,-81},{10,-1},{-9,1},{-8,43},{2,2},{2,-21},{3,82},{8,-1},
//        {10,-1},{-9,1},{-12,42},{16,-5},{-5,-61},{20,-7},{9,-35},{10,6},{12,106},
//        {5,-21},{-5,82},{6,71},{-15,34},{-10,87},{-14,-12},{12,106},{-5,82},
//        {-46,-45},{-4,63},{16,-5},{4,1},{-3,-53},{0,-17},{9,98},{-18,26},{-9,86},
//        {2,77},{-2,-49},{1,76},{-3,-38},{-8,7},{-17,-37},{5,72},{10,-37},{-4,-57},
//        {-3,-53},{3,74},{-3,-11},{-8,7},{1,88},{-12,42},{1,-37},{2,77},{-6,77},
//        {5,72},{-4,-57},{-18,-33},{-12,42},{-9,86},{2,77},{-8,77},{-3,77},{9,-42},
//        {16,41},{-29,-37},{0,-41},{-21,18},{-27,-34},{0,77},{3,74},{-7,-69},
//        {-21,18},{27,146},{-20,13},{21,130},{-6,-65},{14,-4},{0,3},{9,-5},{6,-29},
//        {-2,73},{-1,-15},{1,76},{-4,77},{6,-29}}));
        System.out.println(leetCode149.maxPoints(new int[][]{{40,-23},{9,138},{429,115},{50,-17},
        {-3,80},{-10,33},{5,-21},{-3,80},{-6,-65},{-18,26},{-6,-65},{5,72},{0,77},
        {-9,86},{10,-2}}));
    }
}