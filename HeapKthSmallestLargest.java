import java.util.PriorityQueue;

class HeapKthSmallestLargest {
    // Function to return kth Smallest element in a given array
    public static int kthSmallest(Integer[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }
    public static int kthLargest(Integer[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }


    // driver's code
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 19};
        int k = 2;
        System.out.println("K'th smallest element is " + kthSmallest(arr, k));
        System.out.print("K'th largest element is " + kthLargest(arr, k));
    }
}

