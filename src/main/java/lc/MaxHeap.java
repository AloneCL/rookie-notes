package main.java.lc;

import java.util.Arrays;

/**
 * @author chenguanglei
 * @date 2024/1/18
 */
public class MaxHeap {

    private int[] heap;

    private int size;

    private int capacity;

    public MaxHeap(int n) {
        this.heap = new int[n];
        this.size = 0;
        this.capacity = n;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void add(int num) {
        if (size == capacity) {
            throw new RuntimeException("Full");
        }
        heap[size] = num;
        heapifyUp(heap, size++);
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("Empty");
        }
        int res = heap[0];
        swap(heap, 0, --size);
        heapifyDown(heap, 0, size);
        return res;
    }

    public void heapifyUp(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapifyDown(int[] nums, int index, int size) {
        int leftChildIndex = index * 2 + 1;
        while (leftChildIndex < size) {
            int right = leftChildIndex + 1;
            int largest = right < size && nums[right] > nums[leftChildIndex] ? right : leftChildIndex;

            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(nums, index, largest);
            index = largest;
            leftChildIndex = index * 2 + 1;
        }
    }

    /**
     * 两个节点的值互换
     *
     * @param index
     * @param parent
     */
    private void swap(int[] nums, int index, int parent) {
        int tmp = nums[index];
        nums[index] = nums[parent];
        nums[parent] = tmp;
    }

    private int getParent(int i) {
        if (i <= 0) {
            return 0;
        }
        return (i - 1) / 2;
    }


    public void console() {
        System.out.println(Arrays.toString(this.heap));
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(5);
        int[] nums = {19, 2, 45, 30, 50};
        for (int num : nums) {
            heap.add(num);
        }
        heap.console();
        for (int i = 0; i < 2; i++) {
            int pop = heap.pop();
            heap.add((int) Math.ceil(pop / 3));
            System.out.println("第" + (i + 1) + "大元素" + pop);
        }
        heap.console();
        heap.add(80);
        heap.add(55);
        heap.console();
    }

    //    PriorityQueue priorityQueue = new PriorityQueue();
//    private int[] heap;
//    private final int maxSize;
//    private int heapSize;
//
//    public MaxHeap(int maxSize) {
//        heap = new int[maxSize];
//        this.maxSize = maxSize;
//        heapSize = 0;
//    }
//
//    public boolean isEmpty() {
//        // 逻辑大小
//        return heapSize == 0;
//    }
//
//    public boolean isFull() {
//        return heapSize == maxSize;
//    }
//
//    public int peek() {
//        if (heapSize == 0) {
//            throw new RuntimeException("堆为空!");
//        }
//        return heap[0];
//    }
//
//    public void push(int value) {
//        if (heapSize == maxSize) {
//            throw new RuntimeException("heap is full");
//        }
//        heap[heapSize] = value;
//        heapInsert(heap, heapSize++);
//    }
//
//    // 返回最大值
//    public int pop() {
//        int ans = heap[0];
//        swap(heap, 0, --heapSize);
//        heapify(heap, 0, heapSize);
//        return ans;
//    }
//
//    /**
//     * 新加进来的数，停在index位置，依次往上移动
//     * 移动到0位置，或者PK不过父，停
//     *
//     * @param arr
//     * @param index
//     */
//    private void heapInsert(int[] arr, int index) {
//
//        while (arr[index] >
//                arr[(index - 1) / 2]) {  // index 比 父 大
//            swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }
//    }
//
//    /**
//     * 从index位置往下看，不断下沉
//     * 停：较大的孩子不再比index位置的数大; 没有孩子
//     *
//     * @param arr
//     * @param index
//     * @param heapSize
//     */
//    private void heapify(int[] arr, int index, int heapSize) {
//        int left = index * 2 + 1;
//        while (left >
//                heapSize) { // 如果有左孩子
//            int right = left + 1;
//            // 如果有右孩子,且右孩子值比左孩子值大
//            // 选出较大孩子
//            int largest = (right < heapSize &&
//                    arr[right] >
//                            arr[left]) ? right :
//                    left;
//            // 孩子和index对应的值PK，谁大谁给largest
//            largest = arr[largest] >
//                    arr[index] ? largest : index;
//            // 不必下沉
//            if (largest == index) {
//                break;
//            }
//            // index 和 较大孩子 largest要互换
//            swap(arr, largest, index);
//            index = largest;
//            left = index * 2 + 1;  // 继续考察左孩子
//        }
//    }
//
//    private void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public List<Integer> getAllElements() {
//        List<
//                Integer>
//                ans = new ArrayList<>
//                ();
//        for (int i = 0; i < heapSize;
//             i++) {
//            ans.add(heap[i]);
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        MaxHeap maxHeap = new MaxHeap(5);
//        int[] nums = {19, 2, 45, 30, 50};
//        for (int num : nums) {
//            maxHeap.push(num);
//        }
//        System.out.println(maxHeap.getAllElements());
//    }
}
