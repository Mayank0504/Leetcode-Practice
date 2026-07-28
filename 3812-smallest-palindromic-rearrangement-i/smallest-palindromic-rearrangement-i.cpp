class Solution {
public:
    string smallestPalindrome(string s) {
        int n=s.length();
        string ans(n,' ');
        int st=0;
        int e=n-1;
        vector<int> store(32,0);
        for(int i=0;i<n;i++)
        store[s[i]-'a']++;
        if(n%2==0){
            int index=0;
            for(int i=0;i<32;i++){
                while(store[i]>0){
                    char c='a'+i;
                    ans[st++]=c;
                    ans[e--]=c;

                    store[i]-=2;
                }
            }
        }
        else{
            int mid=(st+e)/2;
            int old_ind=-1;
            for(int i=0;i<32;i++){
                if(store[i]%2!=0){
                old_ind=i;
                store[i]--;
                }
            }
            char d='a'+old_ind;
            ans[mid]=d;

             int index=0;
            for(int i=0;i<32;i++){
                while(store[i]>0){
                    char c='a'+i;
                    ans[st++]=c;
                    ans[e--]=c;

                    store[i]-=2;
                }
            }

        }
        return ans;
    }
};