package main.java.other;

import java.util.Arrays;

/**
 * @author chenguanglei
 * @date 2024/1/23
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        MinHeap minHeap = new MinHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            minHeap.push(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.pop();
        }
        return res;
    }

    public static class MinHeap {

        int[] heap;

        int size;

        public MinHeap(int n) {
            heap = new int[n];
            size = 0;
        }

        private void push(int n) {
            heap[size] = n;
            swim(size++);
        }

        private int pop() {
            int res = heap[0];
            swap(0, --size);
            sink(0, size);
            return res;
        }

        private void swim(int i) {
            while (heap[i] < heap[(i - 1) / 2]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        private void sink(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int right = left + 1;
                int smaller = right < size && heap[right] < heap[left] ? right : left;
                if (heap[index] < heap[smaller]) {
                    break;
                }
                swap(index, smaller);
                index = smaller;
                left = index * 2 + 1;
            }
        }

        private void swap(int i, int j) {
            int t = heap[i];
            heap[i] = heap[j];
            heap[j] = t;
        }

        public void console() {
            System.out.println(Arrays.toString(heap));
        }
    }

    public static void main(String[] args) {
        SmallestK maxKelements2530 = new SmallestK();
        int[] nums = {245623986, 825265439, 662379008, 36757440, 54175861, 499499885, 550777192, 370626497, 908769625};
        System.out.println(Arrays.toString(maxKelements2530.smallestK(nums, 3)));
    }
}
