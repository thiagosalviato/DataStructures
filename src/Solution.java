import java.util.*;

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

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            if (set.contains(x)){
                set.remove(x);
            }else {
                set.add(x);
            }
        }
        return set.stream().findFirst().get();
    }


    static final HashMap<String,Integer> dict = new HashMap<String,Integer>(){{
       put("type",0);
       put("color",1);
       put("name",2); // O(1)
    }};
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int indexList = dict.get(ruleKey); //O(1)
        for (List list: items) {  //(n/3)
            if(list.get(indexList).equals(ruleValue))
                count++;
        }
        return count;
    }

    public void reverseString(char[] s) {
        int a_pointer = 0;
        int b_pointer = s.length-1;

        while (a_pointer <= b_pointer){
            char temp = s[a_pointer];
            s[a_pointer] = s[b_pointer];
            s[b_pointer] = temp;

            a_pointer += 1;
            b_pointer -= 1;
        }
    }
}
