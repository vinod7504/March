class eighteen{
    public static int longestNiceSubarray(int[] nums) {
        int left=0;
        int maxlength=1;
        int used=0;
        int n=nums.length;
        for(int right=0;right<n;right++){
            while((used & nums[right])!=0){
                used=used^nums[left];
                left++;
            }
            used=used|nums[right];
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
    public static void main(String[] args) {
        int[] nums={1,3,8,48,10};
        System.out.println(longestNiceSubarray(nums));
    }
}