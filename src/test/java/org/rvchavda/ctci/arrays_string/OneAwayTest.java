package org.rvchavda.ctci.arrays_string;


import org.junit.Assert;
import org.junit.Test;

public class OneAwayTest {

    @Test
    public void test() {
        OneAway cls = new OneAway();
        System.out.println("ab,acb:");
        Assert.assertTrue(cls.isOneAwayAttemptThree("ab","acb"));
        System.out.println("abcd,abfd:");
        Assert.assertTrue(cls.isOneAwayAttemptThree("abcd","abfd"));
        System.out.println("abcd,abd:");
        Assert.assertTrue(cls.isOneAwayAttemptThree("abcd","abd"));
        System.out.println("abcd,abced:");
        Assert.assertTrue(cls.isOneAwayAttemptThree("abcd","abced"));
        System.out.println("abcd,abcefd:");
        Assert.assertFalse(cls.isOneAwayAttemptThree("abcd","abcefd"));
        System.out.println("atrd,abd:");
        Assert.assertFalse(cls.isOneAwayAttemptThree("atrd","abd"));
        System.out.println("ple,pate:");
        Assert.assertFalse(cls.isOneAwayAttemptThree("ple","pate"));
        System.out.println("Foo Bar,Foox Bar:");
        Assert.assertTrue(cls.isOneAwayAttemptThree("Foo Bar","Foox Bar"));
        System.out.println("Foo Bar,Foox Zar:");
        Assert.assertFalse(cls.isOneAwayAttemptThree("Foo Bar","Foox Zar"));
        System.out.println("FooBar,Foo Zar:");
        Assert.assertFalse(cls.isOneAwayAttemptThree("FooBar","Foo Zar"));
        System.out.println("FooBar,FooZXar:");
        Assert.assertFalse(cls.isOneAwayAttemptThree("FooBar","FooZXar"));
    }
}
