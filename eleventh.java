import java.util.*;

class eleventh {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> hp=new HashMap<>();
        int left=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            char chr=s.charAt(right);
            hp.put(chr,hp.getOrDefault(chr,0)+1);
            while(hp.size()==3){
                char chl=s.charAt(left);
                ans+=(s.length()-right);
                hp.put(chl,hp.get(chl)-1);
                if(hp.get(chl)==0){
                    hp.remove(chl);
                }
                left++;
            }
        }
        return ans;
    }
}