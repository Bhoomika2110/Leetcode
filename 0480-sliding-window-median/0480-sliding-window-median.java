import java.util.*;

class Solution {

    class DualHeap {
        // Max Heap (smaller half)
        PriorityQueue<Integer> small;

        // Min Heap (larger half)
        PriorityQueue<Integer> large;

        // Lazy deletion map
        HashMap<Integer, Integer> delayed;

        int k;
        int smallSize;
        int largeSize;

        public DualHeap(int k) {
            this.k = k;

            small = new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();

            delayed = new HashMap<>();

            smallSize = 0;
            largeSize = 0;
        }

        // Remove delayed elements from heap top
        private void prune(PriorityQueue<Integer> heap) {

            while (!heap.isEmpty()) {

                int num = heap.peek();

                if (delayed.containsKey(num)) {

                    delayed.put(num, delayed.get(num) - 1);

                    if (delayed.get(num) == 0)
                        delayed.remove(num);

                    heap.poll();

                } else {
                    break;
                }
            }
        }

        // Balance both heaps
        private void makeBalance() {

            if (smallSize > largeSize + 1) {

                large.offer(small.poll());

                smallSize--;
                largeSize++;

                prune(small);

            } else if (smallSize < largeSize) {

                small.offer(large.poll());

                smallSize++;
                largeSize--;

                prune(large);
            }
        }

        // Insert new number
        public void insert(int num) {

            if (small.isEmpty() || num <= small.peek()) {

                small.offer(num);
                smallSize++;

            } else {

                large.offer(num);
                largeSize++;
            }

            makeBalance();
        }

        // Erase number using lazy deletion
        public void erase(int num) {

            delayed.put(num,
                    delayed.getOrDefault(num, 0) + 1);

            if (num <= small.peek()) {

                smallSize--;

                if (num == small.peek())
                    prune(small);

            } else {

                largeSize--;

                if (!large.isEmpty() && num == large.peek())
                    prune(large);
            }

            makeBalance();
        }

        // Get median
        public double getMedian() {

            if (k % 2 == 1)
                return small.peek();

            return ((long) small.peek() + (long) large.peek()) / 2.0;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        double[] ans = new double[n - k + 1];

        DualHeap dh = new DualHeap(k);

        // First window
        for (int i = 0; i < k; i++)
            dh.insert(nums[i]);

        ans[0] = dh.getMedian();

        // Slide the window
        for (int i = k; i < n; i++) {

            dh.insert(nums[i]);

            dh.erase(nums[i - k]);

            ans[i - k + 1] = dh.getMedian();
        }

        return ans;
    }
}