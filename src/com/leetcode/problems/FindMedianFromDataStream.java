package com.leetcode.problems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
	
	Queue<Integer> minHeap = new PriorityQueue<Integer>();
    Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    
    
    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) maxHeap.add(num);
        else if (num <= maxHeap.peek()) maxHeap.add(num);
        else minHeap.add(num);
        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
            else minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            double result = minHeap.peek() + maxHeap.peek();
            return (result / 2);
        } 
        else if (minHeap.size() > maxHeap.size()) return minHeap.peek();
        else return maxHeap.peek();
    }

}
