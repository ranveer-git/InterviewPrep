package org.rvchavda.dynamicprog;

import java.util.HashMap;
import java.util.Map;

public class StringConstruct {
    public static void main(String[] args) {
        try{
            System.out.println(canConstruct("purple", new String[]{"p","ur","ple","pur","le"}));
            System.out.println("Expected:false => Actual:=>"+canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef"
                    , new String[]{"e","ee","eee","eeeeee","eeeeeeee"}, new HashMap<>()));
            System.out.println(countConstruct("purple", new String[]{"p","ur","ple","pur","le"}));//"p","ur","ple"||"pur","ple"||"pur","p","le"||"p","ur","p","le" => 4
            System.out.println("Expected:0 => Actual:=>"+countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef"
                    , new String[]{"e","ee","eee","eeeeee","eeeeeeee"}, new HashMap<>()));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static int countConstruct(String target, String[] wordDictionary) {
        if("".equals(target)) {
            return 1;
        }
        int totalCount = 0;
        for (String word : wordDictionary) {
            if(target.startsWith(word)) {
                String remainder = target.substring(word.length());
                Integer currentCount = countConstruct(remainder, wordDictionary);
                totalCount += currentCount;
            }
        }
        return totalCount;

    }
    public static int countConstructMemo(String target, String[] wordDictionary, Map<String, Integer> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if("".equals(target)) {
            return 1;
        }
        int totalCount = 0;
        for (String word : wordDictionary) {
            if(target.startsWith(word)) {
                String remainder = target.substring(word.length());
                Integer currentCount = countConstructMemo(remainder, wordDictionary, memo);
                totalCount += currentCount;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }
    public static boolean canConstruct(String target, String[] wordDictionary) {
        if("".equals(target)) {
            return true;
        }

        for (String word : wordDictionary) {
            if(target.startsWith(word)) {
                String remainder = target.substring(word.length());
                if(canConstruct(remainder, wordDictionary)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canConstructMemo(String target, String[] wordDictionary, Map<String, Boolean> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if("".equals(target)) {
            memo.put(target, true);
            return true;
        }


        for (String word : wordDictionary) {
            if(target.startsWith(word)) {
                String remainder = target.substring(word.length());
                if(canConstructMemo(remainder, wordDictionary, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }
}
