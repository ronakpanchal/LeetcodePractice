package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	
	
	private class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, clone);
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.add(node);
		while (!q.isEmpty()) {
			UndirectedGraphNode nn = q.poll();
			UndirectedGraphNode cc = map.get(nn);
			List<UndirectedGraphNode> cloneList = new ArrayList<UndirectedGraphNode>();
			List<UndirectedGraphNode> neighbors = nn.neighbors;
			for (UndirectedGraphNode neighbor : neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					cloneList.add(map.get(neighbor));
					q.add(neighbor);
				} else {
					cloneList.add(map.get(neighbor));
				}
			}
			cc.neighbors = cloneList;
		}
		return map.get(node);
	}
}
