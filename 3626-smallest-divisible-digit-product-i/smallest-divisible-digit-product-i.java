class Solution {
    public int smallestNumber(int n, int t) {
        // int count=1;
        // int ans=n;
        // int first=n%10;
        // while(n>0){
        //     count=n%10*count;
        //     n=n/10;
        // }
        // first=10-first;
        // int ans1=ans+first;
        // if(count%t==0){
        //     return ans;
        // }
        // else{
        //     int dev=count/t;
        //     int rem=dev*t;
        //     rem=count-rem;
        //     rem=t-rem;
        //     ans=ans+rem;
        // }
        // if(ans1<ans){
        //     return ans1;
        // }
        // return ans;
        while (true) {
            int num = n;
            int product = 1;
            while (num > 0) {
                product *= (num % 10);
                num /= 10;
            }
            if (product % t == 0) {
                return n;
            }
            n++;
        }
    }
}