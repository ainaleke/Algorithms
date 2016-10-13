import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> interval_list=new ArrayList<Interval>();
		
		interval_list.add(new Interval(1,3));
		interval_list.add(new Interval(2,6));
		interval_list.add(new Interval(8,10));
		interval_list.add(new Interval(15,18));
		System.out.println(merge(interval_list));
	}
	
    public static List<Interval> merge1(List<Interval> intervals) {
        if(intervals == null || intervals.size()<=1){
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());
        System.out.println(intervals);
        ArrayList<Interval> result= new ArrayList<Interval>();
        Interval prev=new Interval(intervals.get(0).start,intervals.get(0).end);
        for(int i=1; i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(prev.end >= curr.start){
                Interval merged = new Interval (prev.start,Math.max(prev.end,curr.end));
                result.add(merged);
                prev=curr;
            }
            else{
                result.add(prev);
                prev=curr;
                if(i==intervals.size()-1){
                    result.add(curr);    
                }            
            }
        }
        return result;
    }
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
     
        if(intervals==null||intervals.size()==0)
            return result;
     
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start!=i2.start)
                    return i1.start-i2.start;
                else
                    return i1.end-i2.end;
            }
        });
     
        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start>pre.end){
                result.add(pre);
                pre = curr;
            }else{
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);
     
        return result;
    }
}
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        return i1.start - i2.end;
    }   
}
