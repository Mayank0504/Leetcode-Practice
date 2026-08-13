class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int left=0;
        int maxi=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
            if(h.get(nums[i])>k){
                while(h.get(nums[i])>k){
                    h.put(nums[left], h.get(nums[left]) - 1);
                    left++;
                }
                len=i-left+1;
            }else{
            len++;}
            maxi=Math.max(maxi,len);
        }
        return maxi;
    }
}