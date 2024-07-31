package org.rvchavda.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a hred="https://leetcode.com/problems/lru-cache/description/">LRUCache</a>
 * 146. LRU Cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * Constraints:
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
class LRUCache_146 {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> storage = new HashMap<>();

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

    }

    /**
     * Adding Node to head of the list which is most recently used element
     * @param node
     */
    private void add(Node node) {
        node.next = this.head.next;
        node.prev = this.head;

        node.next.prev = node;
        this.head.next = node;

    }

    /**
     * Remove node from anywhere, update prev's next and next's prev link
     */
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(final int key) {
        Node val = storage.get(key);
        if(val == null) {
            return -1;
        }

        remove(val);
        add(val);
        return val.value;
    }

    // Check Capacity
// Check if already contains as no capacity breach if already present
    public void put(int key, int value) {
        Node n = new Node(key, value);
        if(storage.containsKey(key)) {
            remove(storage.get(key));
        }
        add(n);
        storage.put(key, n);

        if(storage.size() > capacity) {
            //System.out.println("Capacity breached, removing"+tail.prev.key);
            // Very important sequence, if storage.remove happens later,then the wrong element will be removed since the pointer is updated first
            storage.remove(tail.prev.key);
            remove(tail.prev);
            //System.out.println("remaining Keys"+storage.keySet());
        }
    }

  public static void main(String[] args) {
    LRUCache_146 cls = new LRUCache_146(5);
    //cls.method();
      String s = "Hello:";
//      s.inde
  }
}
class Node {
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    int key;
    int value;
    Node prev;
    Node next;

}
