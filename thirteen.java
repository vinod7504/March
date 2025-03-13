public class thirteen {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int l=0;
        int r=queries.length;
        while(l<=r){
            int m=(l+r)/2;
            int[] diff=new int[n+1];
            for(int i=0;i<m;i++){
                int left=queries[i][0];
                int right=queries[i][1];
                int value=queries[i][2];
                diff[left]+=value;
                if(right+1<n){
                    diff[right+1]-=value;
                }
            }
            for(int i=1;i<n;i++){
                diff[i]+=diff[i-1];
            }
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(nums[i]-diff[i]>0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        if(l<=queries.length){
            return l;
        }
        return -1;
    }
}
