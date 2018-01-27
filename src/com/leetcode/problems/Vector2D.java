package com.leetcode.problems;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	
    private Iterator<List<Integer>> itr;
    private Iterator<Integer> listIterator;

    public Vector2D(List<List<Integer>> vec2d) {
        itr = vec2d.iterator();
        if (itr.hasNext())  listIterator = itr.next().iterator();
    }

    @Override
    public Integer next() {
        return listIterator.next(); 
    }

    @Override
    public boolean hasNext() {
        if (listIterator == null) return false;
        if (!itr.hasNext() && !listIterator.hasNext()) return false;
        if (listIterator.hasNext()) return true;
        while (itr.hasNext()) {
            Iterator<Integer> iterator = itr.next().iterator();
            if (iterator.hasNext()) {
                listIterator = iterator;
                return true;
            }
        }
        return false;
    }

}
