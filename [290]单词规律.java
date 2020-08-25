//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 185 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] strings = str.split(" ");

        if(patterns.length!=strings.length) return false;

        Map<Character,String> map1 = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if(!map1.containsKey(patterns[i])) map1.put(patterns[i],strings[i]);
            if(!strings[i].equals(map1.get(patterns[i]))) return false;
        }
        Map<String,Character> map2 = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if(!map2.containsKey(strings[i])) map2.put(strings[i],patterns[i]);
            if(patterns[i]!=(map2.get(strings[i]))) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
