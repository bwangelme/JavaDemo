package com.bwangel.offer;

import java.util.Optional;
import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < size) {
            minHeap.offer(val);
        } else {
            Integer heapMin = minHeap.peek();
            if (heapMin != null && val > heapMin ) {
                minHeap.poll();
                minHeap.offer(val);
            }

        }

        return Optional.ofNullable(minHeap.peek()).orElse(0);
    }

}
