package HaeInSung.LearningCurve.dailyCT.August2024;

/*Kth Largest Element in a Stream */

import java.util.PriorityQueue;

public class DQ_0703 {

    private int k;
    private PriorityQueue<Integer> pq;

    /* 원래 class & 생성자 이름은 KthLargest */
    public DQ_0703(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k); // 별다른 Override 등이 없을 때 기본적으로 순차배열
        for (int num : nums) {
            this.pq.offer(num);
            if (this.pq.size() > k) { // 어차피 k번째로 큰 항만 출력해주면 됨
                this.pq.poll();
            }
        }
    }

    // stream에 val을 더해주고 반환하는 건 stream에서 K번째로 큰 element
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek(); // k번째로 큰 항이 제일 말단에 있을 테니(size를 k로 맞춰놓음) 그쪽만 peek를 함
    }

    public static void main(String[] args) {
        DQ_0703 dailyQ = new DQ_0703(3, new int[]{4, 5, 8, 2});
        System.out.println(dailyQ.add(3));
        System.out.println(dailyQ.add(5));
        System.out.println(dailyQ.add(10));
        System.out.println(dailyQ.add(9));
        System.out.println(dailyQ.add(4));
    }
}
