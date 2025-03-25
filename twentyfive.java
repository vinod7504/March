import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class twentyfive{
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> mergedx = buildingmerge(rectangles,true);
        if(mergedx.size()>=3){
            return true;
        }
        List<int[]> mergedy=buildingmerge(rectangles,false);
        if(mergedy.size()>=3){
            return true;
        }
        return false;
    }
    public static List<int[]> buildingmerge(int[][] rectangle,boolean vertical){
        List<int[]> intervals=new ArrayList<>();
        for(int[] rect:rectangle){
            intervals.add(vertical?new int[]{rect[0],rect[2]}:new int[]{rect[1],rect[3]});
        }
        if(intervals.isEmpty()){
            return new ArrayList<>();
        }
        List<int[]> merged=new ArrayList<>();
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        int[] curr=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            int[] next=intervals.get(i);
            // Overlap
            if(curr[1]>next[0]){
                curr[1]=Math.max(curr[1],next[1]);
            }else{
                merged.add(curr);
                curr=next;
            }}
        merged.add(curr);
        return merged;
    }
}