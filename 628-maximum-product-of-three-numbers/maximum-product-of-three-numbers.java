class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int p=nums[0]*nums[1]*nums[nums.length-1];
        int p1=nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1];
        return Math.max(p1,p);
    }
}