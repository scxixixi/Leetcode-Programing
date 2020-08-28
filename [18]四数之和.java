//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 548 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //和三数之和的想法一样，O(N3)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;

            for (int j = i+1; j < nums.length; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int l = nums.length-1;
                int targetsum = target-nums[i]-nums[j];

                for (int k = j+1; k < nums.length; k++) {
                    if(k>j+1 && nums[k]==nums[k-1]) continue;
                    while(k<l && nums[k]+nums[l]>targetsum) l--;
                    if(k==l) break;
                    if(nums[k]+nums[l]==targetsum){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
