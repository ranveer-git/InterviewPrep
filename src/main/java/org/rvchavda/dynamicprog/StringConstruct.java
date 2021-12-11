package org.rvchavda.dynamicprog;

import java.util.HashMap;
import java.util.Map;

public class StringConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("purple", new String[]{"p","ur","ple","pur","le"}));
        System.out.println(canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef"
                , new String[]{"e","ee","eee","eeeeee","eeeeeeee"}, new HashMap<>()));
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
        if("".equals(target)) {
            memo.put(target, true);
            return true;
        }
        if(memo.containsKey(target)) {
            return memo.get(target);
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
