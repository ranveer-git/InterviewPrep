package org.rvchavda.ctci.arrays_string;

import org.junit.Assert;
import org.junit.Test;

public class StringCompressTest {

    @Test
    public void testStringCompress() {
        StringCompress sc = new StringCompress();
        Assert.assertEquals("A5b3cdea4A2", sc.compress("AAAAAbbbcdeaaaaAA"));
        Assert.assertEquals("A", sc.compress("A"));
        Assert.assertEquals("A2", sc.compress("AA"));
        Assert.assertEquals("INVALID", sc.compress("AAA55B6"));
    }
}
