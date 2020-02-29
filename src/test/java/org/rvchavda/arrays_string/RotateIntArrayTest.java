package org.rvchavda.arrays_string;

import org.junit.Assert;
import org.junit.Test;
import org.rvchavda.RotateIntArray;

public class RotateIntArrayTest {

    @Test
    public void testSuccess(){
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int d = 2;
        Assert.assertArrayEquals(new int[]{3,4,5,6,7,1,2}, RotateIntArray.rotateArr(arr,d));

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        d = 3;
        Assert.assertArrayEquals(new int[]{4,5,6,7,8,9,10,11,12,1,2,3}, RotateIntArray.rotateArr(arr,d));

        arr = new int[]{1, 2, 3};
        d = 3;
        Assert.assertArrayEquals(new int[]{1,2,3}, RotateIntArray.rotateArr(arr,d));
    }
}
