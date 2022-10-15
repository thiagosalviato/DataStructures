import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap();
        int[] output = new int[2];
        //9 - 2 = 7
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                output[0] = map.get(nums[i]);
                output[1] = i;
                return output;
            }

            map.put(target - nums[i], i);
        }
        return null;
    }

    public boolean isValid(String s) {
        //  ([)]
        Map<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put( ')', '(' );
        map.put( ']', '[' );
        map.put( '}', '{' );

        for(Character c : s.toCharArray()){
            if(map.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == map.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }else {
                stack.add(c);
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}
