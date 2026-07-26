class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        int i=0;
        int n=s.length();
        while(i<n){
            if(h.containsKey(s.charAt(i))){
                h.put(s.charAt(i),h.get(s.charAt(i))+1);
            }else{
                h.put(s.charAt(i),1);
            }
            i++;
        }
        List<Character> arr=new ArrayList<>(h.keySet());
        Collections.sort(arr,(a,b)->h.get(b)-h.get(a));
        StringBuilder ans = new StringBuilder();
        for(char ch:arr){
            int freq=h.get(ch);
            while(freq>0){
                ans.append(ch);
                freq--;
            }
        }
        return ans.toString();
    }
}