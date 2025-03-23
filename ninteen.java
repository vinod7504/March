public class ninteen{
    public static void main(String[] args) {
        int[] nums={0,1,1,0,1,1};
        System.out.println(minOperations(nums));
    }
    public static int minOperations(int[] nums) {
        int res=0;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(nums[i]==0){
                nums[i]=1;
                nums[i+1]=nums[i+1]^1;
                nums[i+2]=nums[i+2]^1;
                res++;
            }
        }
        if(nums[n-1]==0 || nums[n-2]==0){
            return -1;
        }
        return res;
    }
}