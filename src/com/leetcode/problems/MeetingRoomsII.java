package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoomsII {
	
	private class Interval {
		int start;
		int end;
	}
	
	  public int minMeetingRooms(Interval[] intervals) {
	        List<Integer> l1 = new ArrayList<Integer>();
	        List<Integer> l2 = new ArrayList<Integer>();
	        for (Interval interval:intervals) {
	            l1.add(interval.start);
	            l2.add(interval.end);
	        }
	        Collections.sort(l1);
	        Collections.sort(l2);
	        int i = 0;
	        int j = 0;
	        int rooms = 0;
	        int max = 0;
	        while (i < l1.size() && j < l2.size()) {
	            if (l1.get(i) < l2.get(j)) {
	                rooms++;
	                max = Math.max(max, rooms);
	                i++;
	            } else if (l1.get(i) > l2.get(j)) {
	                rooms--;j++;
	            } else {
	                i++;j++;
	            }
	        }
	        return max;
	        
	    }

}
