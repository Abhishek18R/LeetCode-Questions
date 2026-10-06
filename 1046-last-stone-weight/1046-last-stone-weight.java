import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int max = pq.remove();
            int smax = pq.remove();

            int nstone = max - smax;

            if (nstone != 0) {
                pq.add(nstone);
            }
        }

        if (pq.isEmpty()) {
            return 0;
        }

        return pq.remove();
    }
}