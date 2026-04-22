class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int length=piles.length;
        int low=1,high=Integer.MIN_VALUE,res=-1;
        for(int i:piles){
            high=Math.max(high,i);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(piles,h,mid)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
        
    }

    boolean isValid(int[] nums,int h,int mid){
        int hours=0;
        for(int i:nums){
            hours+=(i+mid-1)/mid;
        }
        return hours<=h;
    }
}
