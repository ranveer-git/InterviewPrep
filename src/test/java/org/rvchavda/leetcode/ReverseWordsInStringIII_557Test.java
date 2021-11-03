package org.rvchavda.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInStringIII_557Test {
    ReverseWordsInStringIII_557 testClass = new ReverseWordsInStringIII_557();
    @Test
    public void testSingleWord() {
        String single = "Hello";
        Assert.assertEquals("olleH",testClass.reverseWords(single));
    }

    @Test
    public void testEmpty() {
        String single = "";
        Assert.assertEquals("",testClass.reverseWords(single));
    }

    @Test
    public void testSentence() {
        String single = "Hello World! Let's make a better world.";
        Assert.assertEquals("olleH !dlroW s'teL ekam a retteb .dlrow",testClass.reverseWords(single));
    }
}
