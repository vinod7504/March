import java.util.HashMap;

public class seventeen{
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> hp=new HashMap<>();
        for(int i:nums){
            if(hp.containsKey(i)){
         hp.put(i,hp.get(i)+1);
            }else{
                hp.put(i,1);
            }
        }
        for(int i:hp.keySet()){
            if(hp.get(i)%2!=0){
                return false;
            }
        }
        return true;
    }
}