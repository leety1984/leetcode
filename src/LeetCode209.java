/**
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int min = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length){
            sum += nums[j];
            while (sum >= s){
                min = min == 0 ? j - i + 1 : Math.min(min, j - i + 1);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        return min;
    }
}
