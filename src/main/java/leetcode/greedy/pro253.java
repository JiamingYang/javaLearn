package leetcode.greedy;/**
 * Created by 13577 on 2020/7/7.
 */

/**
 * @ClassName pro253
 * @Description
 * @Author 杨家铭
 * @Date 2020/7/7 12:00
 **/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一系列会议起始和结束时间，求最少需要多少个会议室就可以使这些会议正常召开
 *贪婪算法:
 * 每次开始新会议时，就要看当前有没有空闲会议室，有直接安排
 * 没有就开设一间新的会议室
 */
public class pro253 {

    int minMeetingRooms(Interval[] intervals){
        if(intervals==null||intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Interval> maxHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        maxHeap.offer(intervals[0]);

        for (int i=1;i<intervals.length;i++){
            Interval interval=maxHeap.poll();
            if(interval.end<=intervals[i].start){
                interval.end=intervals[i].end;
            }else {
                maxHeap.offer(intervals[i]);
            }
            maxHeap.offer(interval);
        }
        return maxHeap.size();

    }
}
