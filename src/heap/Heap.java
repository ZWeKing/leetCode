package heap;

/**
 * 最小堆的实现
 */
public class Heap {
    Integer[] array = null;
    private int count = 0;


    public Heap(int size) {
        array = new Integer[size];
    }

    public int size() {
        return this.count;
    }
    //删除是自下而上
    public void insert(int value) {

        if (count == 0) {
            array[count] = value;
            count++;
            return;
        }

        int currentIndex = count;
        int parentIndex;

        while (true) {

            int flag = currentIndex % 2;

            if (flag == 0) {
                parentIndex = (currentIndex - 2) / 2;
            } else {
                parentIndex = (currentIndex- 1) / 2;
            }

            if (parentIndex < 0) {
                array[currentIndex] = value;
                break;
            }

            if (array[parentIndex] > value) {
                array[currentIndex] = array[parentIndex];
            } else {
                array[currentIndex] = value;
                break;
            }

            currentIndex = parentIndex;

        }

        count++;
    }
    //删除是自上而下
    public int delete() {
        int topValue = array[0];

        int currentIndex = 0;

        int lastValue = array[count - 1];
        while (true) {
            int leftChildIndex = currentIndex * 2 + 1;
            int rightChildIndex = currentIndex * 2 + 2;

            if (leftChildIndex >= count || rightChildIndex >= count) {
                break;
            }

            if (array[leftChildIndex] < array[rightChildIndex]) {
                if (lastValue < array[leftChildIndex]) {
                    array[currentIndex] = lastValue;
                    break;
                } else {
                    array[currentIndex] = array[leftChildIndex];
                    currentIndex = leftChildIndex;
                }

            } else {

                if (lastValue < array[rightChildIndex]) {
                    array[currentIndex] = lastValue;
                    break;
                } else {
                    array[currentIndex] = array[rightChildIndex];
                    currentIndex = rightChildIndex;
                }


            }
        }
        //删除元素时，需要考虑当前指针不是堆的最后一个元素，此时需要判断当前元素与最后一个元素的大小关系
        array[count-1] = null;

        return topValue;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[10];

        Heap heap = new Heap(10);

        heap.insert(10);
        heap.insert(7);
        heap.insert(2);
        heap.insert(6);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);

        array = heap.array;

        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }

        System.out.println(heap.delete());

        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }

    }
}
