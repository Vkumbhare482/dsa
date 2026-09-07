class MedianFinder {

    PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek())
            left.add(num);
        else
            right.add(num);

        // Balance heaps
        if (left.size() > right.size() + 1)
            right.add(left.poll());

        if (right.size() > left.size())
            left.add(right.poll());
    }

    public double findMedian() {
        if (left.size() > right.size())
            return left.peek();

        return (left.peek() + right.peek()) / 2.0;
    }
}