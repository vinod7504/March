import java.util.*;

class tenth {
    static HashSet<Character> hs=new HashSet<>();
    public static long countOfSubstrings(String word, int k) {
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        long a=get(word,k);
        long b=get(word,k+1);
        return a-b;
    }
    public static long get(String word,int k){
        int left=0;
        int right=0;
        long ans=0;
        int c=0;
        HashMap<Character,Integer> hp=new HashMap<>();
        while(right<word.length()){
            char chr=word.charAt(right);
            if(hs.contains(chr)){
                hp.put(chr,hp.getOrDefault(chr,0)+1);
            }else{
                c++;
            }
            while(hp.size()==5 && c>=k){
                ans+=(long)(word.length()-right);
                char chl=word.charAt(left);

                if(hs.contains(chl)){
                    if(hp.get(chl)==1){
                        hp.remove(chl);
                    }else{
                        hp.put(chl,hp.get(chl)-1);
                    }
                }else{
                    c--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="aeioqq";
        int k=0;
        System.out.println(countOfSubstrings(s,k));
    }
}