class Solution {
    public int maxProduct(int[] nums) {
        int m1=0;
        int m=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int temp=nums[i];
            if(temp>m){
                m1=m;
                m=temp;
            }else{
                if(temp>m1){
                    m1=temp;
                }
            }
        }
        return (m1-1)*(m-1);
    }
}