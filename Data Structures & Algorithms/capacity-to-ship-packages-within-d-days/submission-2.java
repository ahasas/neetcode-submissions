class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity=Integer.MIN_VALUE;
        int maxCapacity=0,res=1;
        for(int i: weights){
            maxCapacity+=i;
            minCapacity=Math.max(minCapacity,i);
        }
        while(minCapacity<=maxCapacity){
            int mid=minCapacity+(maxCapacity-minCapacity)/2;
            if(isValid(weights,days,mid)){
                res=mid;
                maxCapacity=mid-1;
            }
            else{
                minCapacity=mid+1;
            }
        }
        return res;
    }

    boolean isValid(int[] nums, int days,int capacity){
        int dayRequired=1;
        int c=0;
        for(int i: nums){
            if(i+c<=capacity){
                c+=i;
            }
            else{
                dayRequired++;
                c=i;
            }
        }
        return dayRequired<=days;
    }
}