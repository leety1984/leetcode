/**
 * 264. 丑数 II
 *
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode264 {
    /**
     * 三指针顺序往前算 每次取散值最小 然后指针加1
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) {
                i2++;
            }
            if (min == dp[i3] * 3) {
                i3++;
            }
            if (min == dp[i5] * 5) {
                i5++;
            }
            dp[i] = min;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        LeetCode264 leetCode264 = new LeetCode264();
        System.out.println(leetCode264.nthUglyNumber(10));
    }
}
