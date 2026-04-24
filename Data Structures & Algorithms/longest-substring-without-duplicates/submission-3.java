class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)return 0;
        int size=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int left=0,res=0;
        for(int right=0;right<size;right++){
            char c=s.charAt(right);
            while(map.containsKey(c)){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)map.remove(s.charAt(left));
                left++;
            }
            map.put(c,map.getOrDefault(c,0)+1);
            res=Math.max(res,right-left+1);
        }
        return res;
        
    }
}
