import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        List<int[]> arr=new ArrayList<>();
        for(int k1:map.keySet()){
            arr.add(new int[]{k1,map.get(k1)});
        }
        Collections.sort(arr, (a, b) -> b[1] - a[1]);//yeh apne list ko sort krta h  naya h raat le 
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = arr.get(i)[0];
        }
        return ans;
    }
}
