class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int e=nums.length-1;
        int s=0;
        while(s<=e){
            int mid=(s+e)/2;
            if(nums[mid]>0){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        int positive=n-s;
        System.out.println("Positive:"+positive);
        s=0;
        e=nums.length-1;
        while(s<=e){
            int mid=(s+e)/2;
            System.out.println(mid);
            if(nums[mid]<0){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        int negative=e+1;
        System.out.println("Negative:"+negative);
        return Math.max(positive,negative);
    }
}