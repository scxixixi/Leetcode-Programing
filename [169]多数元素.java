//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 708 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

//        private Map<Integer, Integer> countNums(int[] nums) {
//            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
//            for (int num : nums) {
//                if (!counts.containsKey(num)) {
//                    counts.put(num, 1);
//                }
//                else {
//                    counts.put(num, counts.get(num)+1);
//                }
//            }
//            return counts;
//        }
//
//        public int majorityElement(int[] nums) {
//            Map<Integer, Integer> counts = countNums(nums);
//
//            Map.Entry<Integer, Integer> majorityEntry = null;
//            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
//                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//                    majorityEntry = entry;
//                }
//            }
//
//            return majorityEntry.getKey();
//        }
        public int majorityElement(int[] nums) {
            return majorityElmentRec(nums,0,nums.length-1);
        }
        private int majorityElmentRec(int[] nums, int l, int h ){
            // 递归出口
            if(l==h){
                return nums[l];
            }
            //数据准备及分解子问题
            int mid = (h-l)/2 + l;
            int left = majorityElmentRec(nums,l,mid);
            int right = majorityElmentRec(nums,mid+1,h);
            //处理小问题
            if(left == right){
                return left;
            }
            int leftCount = countInRange(nums,left,l,h);
            int rightCount = countInRange(nums,right,l,h);

            //返回整理后的结果
            return leftCount>rightCount? left: right;

        }
        private int countInRange(int[] nums, int num, int lo, int hi){
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }
    }



//leetcode submit region end(Prohibit modification and deletion)
