package org.rvchavda.arrays_string;

public class OneAway {

    public boolean isOneAwayAttemptThree(String str1, String str2) {
        if(str1.length()>=str2.length()) {
            System.out.print(str1 +":"+str2+"->");
            return isOneAwayAttemptTwo(str1, str2);
        } else {
            System.out.print(str2 +":"+str1+"->");
            return isOneAwayAttemptTwo(str2, str1);
        }
    }
    public boolean isOneAwayAttemptTwo(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }




        int mismatchCounter = 0;
        int str1_front_idx = 0,str1_tail_idx = str1.length()-1,
                str2_front_idx = 0, str2_tail_idx = str2.length()-1;
        int str1charVisited = 0,str2charVisited = 0;
        while (str1_front_idx < str1_tail_idx || str2_front_idx < str2_tail_idx) {
            char str1_head_char = str1.charAt(str1_front_idx);
            char str2_head_char = str2.charAt(str2_front_idx);

            char str1_tail_char = str1.charAt(str1_tail_idx);
            char str2_tail_char = str2.charAt(str2_tail_idx);
            boolean isNoFrontMatched = str1_head_char != str2_head_char,
                    isNoTailMatched = str1_tail_char != str2_tail_char && str2_tail_idx != str2_front_idx;

            if (isNoFrontMatched && isNoTailMatched) {
//                System.out.println("Head anf Tail both are mismatched");
                return false;
            }
            if (isNoFrontMatched) {
//                System.out.println("Front Mismatch found"+str1_head_char+str2_head_char);
                mismatchCounter++;
                str2_front_idx++;
                if(str1.length() == str2.length()) {
                    str1_front_idx++;
                }
                str1_tail_idx--;
                str2_tail_idx--;
            } else if (isNoTailMatched) {
//                System.out.println("Tail Mismatch found"+str1_tail_char+str2_tail_char);
                mismatchCounter++;
                str2_tail_idx--;
                if(str1.length() == str2.length()) {
                    str1_tail_idx--;
                }
                str1_front_idx++;
                str2_front_idx++;
            } else {
                str1_front_idx++;
                str2_front_idx++;
                str1_tail_idx--;
                str2_tail_idx--;
            }
            str1charVisited+=2;
//            str2charVisited+=2;

            if(mismatchCounter>1) {
//                System.out.println("Second Mismatch found");
                return false;
            }
        }
        if(mismatchCounter + (Math.abs(str1charVisited-str1.length())) > 1) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        OneAway cls = new OneAway();
        System.out.println(cls.isOneAwayAttemptThree("ab","acb"));
        System.out.println(cls.isOneAwayAttemptThree("abcd","abfd"));
        System.out.println(cls.isOneAwayAttemptThree("abcd","abd"));
        System.out.println(cls.isOneAwayAttemptThree("abcd","abced"));
        System.out.println(cls.isOneAwayAttemptThree("abcd","abcefd"));
        System.out.println(cls.isOneAwayAttemptThree("atrd","abd"));
        System.out.println("ple,pate:"+cls.isOneAwayAttemptThree("ple","pate"));
        System.out.println("Foo Bar,Foox Bar:"+cls.isOneAwayAttemptThree("Foo Bar","Foox Bar"));
        System.out.println("Foo Bar,Fox Zar:"+cls.isOneAwayAttemptThree("Foo Bar","Fox Zar"));
        System.out.println("FooBar,Foo Zar:"+cls.isOneAwayAttemptThree("FooBar","Foo Zar"));
        System.out.println("FooBar,FooZXar:"+cls.isOneAwayAttemptThree("FooBar","FooZXar"));
    }
}
