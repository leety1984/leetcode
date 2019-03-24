/**
 * 476. 数字的补数
 *
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 注意:
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 *
 * 示例 1:
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 *
 * 示例 2:
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 */
public class LeetCode476 {
    /**
     * 计算num有多少位 然后按位异或这些位的1
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int numTemp = num;
        int temp = 0;
        while (numTemp > 0){
            numTemp = numTemp >> 1;
            temp = (temp << 1) | 1;
        }
        return temp ^ num;
    }
}
