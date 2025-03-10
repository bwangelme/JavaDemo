package com.bwangel.offer;

import static org.junit.jupiter.api.Assertions.*;

public class KthLargestTest {

    @org.junit.jupiter.api.Test
    void testKthLargest() {
        int[] nums = {4,5,8,2,3};
        KthLargest k = new KthLargest(3, nums);

        int res = k.add(0);
        assertEquals(res, 4);
    }
}
