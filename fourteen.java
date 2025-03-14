public class fourteen {
    public int maximumCandies(int[] candies, long k) {
        int sum=0;
        for(int i:candies){
            sum+=i;
        }
        if(sum<=k){
            return 0;
        }
        int left=1;
        int right=(int)(sum/k);
        int res=0;
        while(left<=right){
            int mid=(left+right)/2;
            int childcount=0;
            for(int candy:candies){
                childcount+=(candy/mid);
                if(childcount>=k){
                    res=mid;
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return res;
    }
}
