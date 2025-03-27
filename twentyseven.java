import java.util.HashMap;
import java.util.List;

class twentyseven{
    public static int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> hp=new HashMap<>();
        for(int num:nums){
            if(hp.containsKey(num)){
                hp.put(num,hp.get(num)+1);
            }else{
                hp.put(num,1);
            }
        }
        int n=nums.size();
        int ans=0;
        int dominant=0;
        for(int x:hp.keySet()){
            if(hp.get(x)>(n/2)){
                dominant=x;
                ans=hp.get(x);
            }
        }
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            if (leftCount * 2 > (i + 1) && (ans - leftCount) * 2 > (n - i - 1)) {
                return i;
            }
        }
        return -1;
    }
}