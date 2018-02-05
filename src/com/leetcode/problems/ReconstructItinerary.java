package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
	
	 private int totalTickets;
	    public List<String> findItinerary(String[][] tickets) {
	        if (tickets == null || tickets.length == 0) return Collections.emptyList();
	        totalTickets = tickets.length;
	        List<String> result = new ArrayList<String>();
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        for (int i = 0;i < tickets.length;i++) {
	            if (!map.containsKey(tickets[i][0])) {
	                map.put(tickets[i][0], new ArrayList<String>());
	            }
	            map.get(tickets[i][0]).add(tickets[i][1]);
	        }
	        for (List<String> list:map.values()) {
	            Collections.sort(list);
	        }
	        result.add("JFK");
	        dfs("JFK", map, result);
	        return result;
	    }
	    
	    void dfs(String source, Map<String, List<String>> map, List<String> result) {
	        if (!map.containsKey(source)) return;
	        List<String> destinations = map.get(source);
	        for (int i = 0;i < destinations.size();i++) {
	            String destination = destinations.get(i);
	            result.add(destination);
	            destinations.remove(i);
	            dfs(destination, map, result);
	            if (result.size() == totalTickets + 1) return;
	            destinations.add(i, destination);
	            result.remove(result.size() - 1);
	        }
	    }

}
