package main.java.other;

import java.util.Arrays;

/**
 * @author chenguanglei
 * @date 2023/9/25
 */
public class SortArrayMapTest {

    public static class SortArrayMap {

        private Node[] buckets;

        private static final Integer DEFAULT_SIZE = 10;

        public SortArrayMap() {
            buckets = new Node[DEFAULT_SIZE];
        }

        /**
         * 数组大小
         */
        private int size = 0;

        public void add(Long key, String value) {
            checkSize(size + 1);
            Node node = new Node(key, value);
            buckets[size++] = node;
        }

        /**
         * 校验是否需要扩容
         *
         * @param size
         */
        private void checkSize(int size) {
            if (size >= buckets.length) {
                int oldLen = buckets.length;
                int newLen = oldLen + (oldLen >> 1);
                buckets = Arrays.copyOf(buckets, newLen);
            }
        }

        /**
         * 排序
         */
        public void sort() {
            Arrays.sort(buckets, 0, size, (o1, o2) -> {
                if (o1.key > o2.key) {
                    return 1;
                } else {
                    return -1;
                }
            });
        }

        /**
         * 顺时针取出数据
         *
         * @param key
         * @return
         */
        public String firstNodeVal(long key) {
            if (size == 0) {
                return null;
            }
            for (Node bucket : buckets) {
                if (bucket == null) {
                    continue;
                }
                if (bucket.key >= key) {
                    return bucket.value;
                }
            }
            return buckets[0].value;
        }

        private class Node {
            public Long key;
            public String value;

            public Node(Long key, String value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "key=" + key +
                        ", value='" + value + '\'' +
                        '}';
            }
        }
    }

    public static void main(String[] args) {
        SortArrayMap map = new SortArrayMap();
        map.add(100L, "127.0.0.100");
        map.add(10L, "127.0.0.10");
        map.add(8L, "127.0.0.8");
        map.add(1000L, "127.0.0.1000");
        map.sort();

        String val = map.firstNodeVal(101);
        System.out.println(val);
    }

}
