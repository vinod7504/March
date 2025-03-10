public class eigth {
    public int minimumRecolors(String blocks, int k) {
        int left=0;
        int res=Integer.MAX_VALUE;
        int recolor=0;
        for(int right=0;right<blocks.length();right++){
            if(blocks.charAt(right)=='W'){
                recolor++;
            }
            if(right-left+1==k){
                res=Math.min(res,recolor);
                if(blocks.charAt(left)=='W'){
                    recolor--;
                }
                left++;
            }
        }
        return res;
    }
}
