import java.util.*;
class twentfour{
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
        int count=0;
        int lastmeet=0;
        for(int[] i:meetings){
            if(lastmeet<i[0]){
                count+=i[0]-lastmeet-1;
            }
            lastmeet=lastmeet>i[1]?lastmeet:i[1];
        }
        if(lastmeet<days){
            count+=days-lastmeet;
        }
        return count;
    }
}