package lc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P146_LRU_Cache {
    // 1.定义kv Node 2.定义数据结构一个用于定位的map，另一个用于实现LRU的链表 3.定义方法，初始化(队满淘汰用)，读get(考虑没有的情况)，写put（考虑队满，考虑覆盖）
    class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> dict = new HashMap<>();
    private LinkedList<Node> queue = new LinkedList<>();

    public P146_LRU_Cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = dict.get(key);
        if (node == null) {
            return -1;
        }
        queue.remove(node);
        queue.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = dict.get(key);
        if (node != null) {
            node.value = value;
            queue.remove(node);
            queue.addFirst(node);
            return;
        }
        if (queue.size() == capacity) {
            Node deleteNode = queue.removeLast();
            dict.remove(deleteNode.key);
        }
        node = new Node(key, value);
        queue.addFirst(node);
        dict.put(key, node);
    }

}