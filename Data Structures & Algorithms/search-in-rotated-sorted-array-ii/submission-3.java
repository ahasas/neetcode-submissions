class Solution {
    public boolean search(int[] nums, int target) {
        int size=nums.length;
        int start=0, end=size-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target)return true;
            if(nums[mid]==nums[start]&&nums[mid]==nums[end]){
                start++;
                end--;
            }
            else if(nums[mid]<=nums[end]){
                if(nums[mid]<target&&nums[end]>=target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }

            else if(nums[mid]>=nums[start]){
                if(nums[mid]>target&&nums[start]<=target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return false;
        
    }
}